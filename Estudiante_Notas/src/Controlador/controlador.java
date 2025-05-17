/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Estudiante;
import Conexion.conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.Estudiante;
import Conexion.conexion;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class controlador{
    
    public boolean validarCedula(String cedula) {
    if (cedula.length() != 10 || !cedula.matches("\\d+")) return false;
    
    int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
    int total = 0;
    
    for (int i = 0; i < 9; i++) {
        int valor = Character.getNumericValue(cedula.charAt(i)) * coeficientes[i];
        total += (valor > 9) ? valor - 9 : valor;
    }
    
    int verificador = (total % 10 == 0) ? 0 : 10 - (total % 10);
    return verificador == Character.getNumericValue(cedula.charAt(9));
}
    public boolean validarNombre(String nombre) {
    return nombre.matches("^[a-zA-Z\\sáéíóúÁÉÍÓÚñÑ]{2,50}$");
}

    public boolean existeCedula(String cedula) {
        Connection conn = conexion.conectar();
        if (conn == null) return false;
        
        try (PreparedStatement stmt = conn.prepareStatement("SELECT cedula FROM estudiantes WHERE cedula = ?")) {
            stmt.setString(1, cedula);
            return stmt.executeQuery().next();
        } catch (SQLException e) {
            return false;
        } finally {
            conexion.cerrar(conn);
        }
    }

    public String validarEstudiante(Estudiante est) {
    if (!validarCedula(est.getCedula())) return "Cédula inválida";
    if (!est.getNombre().matches("^[A-Za-zÁÉÍÓÚñÑ ]+$")) return "Nombre no válido";
    return null;
}

    public boolean existeNombre(String nombre, String cedulaActual) {
    Connection conn = conexion.conectar();
    try (PreparedStatement stmt = conn.prepareStatement(
            "SELECT COUNT(*) FROM estudiantes WHERE LOWER(nombre) = LOWER(?) AND cedula != ?")) {
        stmt.setString(1, nombre);
        stmt.setString(2, cedulaActual);
        ResultSet rs = stmt.executeQuery();
        return rs.next() && rs.getInt(1) > 0;
    } catch (SQLException e) {
        return false;
    } finally {
        conexion.cerrar(conn);
    }
}

    public boolean guardarEstudiante(Estudiante estudiante) {
        Connection conn = conexion.conectar();
        if (conn == null) return false;
        
        String sql = "INSERT INTO estudiantes (cedula, nombre, sexo, curso, carrera) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estudiante.getCedula());
            stmt.setString(2, estudiante.getNombre());
            stmt.setString(3, estudiante.getSexo());
            stmt.setString(4, estudiante.getCurso());
            stmt.setString(5, estudiante.getCarrera());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            conexion.cerrar(conn);
        }
    }

    public DefaultTableModel obtenerModeloTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cédula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Sexo");
        modelo.addColumn("Curso");
        modelo.addColumn("Carrera");
        
        Connection conn = conexion.conectar();
        if (conn == null) return modelo;
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM estudiantes")) {
            
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getString("sexo"),
                    rs.getString("curso"),
                    rs.getString("carrera")
                });
            }
        } catch (SQLException e) {
        } finally {
            conexion.cerrar(conn);
        }
        return modelo;
    }
    
    public boolean actualizarEstudiante(Estudiante estudiante) {
    Connection conn = conexion.conectar();
    String sql = "UPDATE estudiantes SET nombre = ?, curso = ? WHERE cedula = ?";
    
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, estudiante.getNombre());
        stmt.setString(2, estudiante.getCurso());
        stmt.setString(3, estudiante.getCedula());
        
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        return false;
    } finally {
        conexion.cerrar(conn);
    }
}

    public boolean eliminarEstudiante(String cedula) {
        Connection conn = conexion.conectar();
        if (conn == null) return false;
        
        String sql = "DELETE FROM estudiantes WHERE cedula = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            conexion.cerrar(conn);
        }
    }
}