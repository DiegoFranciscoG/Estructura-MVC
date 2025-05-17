/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/estudiantes_notas";
    private static final String USER = "root";
    private static final String PASSWORD = "12345"; // Tu contraseña real

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estudiantes_notas","root", "12345");
            JOptionPane.showMessageDialog(null, "¡Conexión exitosa!");
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public static void cerrar(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
}