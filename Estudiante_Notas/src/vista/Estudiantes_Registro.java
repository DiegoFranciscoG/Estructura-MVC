/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import Controlador.controlador;
import javax.swing.JOptionPane;
import Controlador.controlador;
import Modelo.Estudiante;
import Conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 *
 * @author diego
 */
public class Estudiantes_Registro extends javax.swing.JFrame {
    private controlador controlador;
    private boolean camposHabilitados = true;       // Botón nuevo
    
    public Estudiantes_Registro() {
        initComponents();
        controlador = new controlador();
        actualizarTabla();
    }
    
    private void actualizarTabla() {
        jTable1.setModel(controlador.obtenerModeloTabla());
    }
    
    private void limpiarCampos() {
        cedulas.setText("");
        nombres.setText("");
        cursos.setText("");
        carreras.setSelectedIndex(0);
        comboSexo.setSelectedIndex(0);
    }
    
    private boolean validarCampos() {
    String cedula = cedulas.getText().trim();
    String nombre = nombres.getText().trim();
    
    if (!controlador.validarCedula(cedula)) {
        JOptionPane.showMessageDialog(this, "Cédula inválida", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    if (!controlador.validarNombre(nombre)) {
        JOptionPane.showMessageDialog(this, "Nombre inválido\nSolo letras y espacios", 
            "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    if (controlador.existeCedula(cedula) && camposHabilitados) {
        JOptionPane.showMessageDialog(this, "Cédula ya registrada", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    return true;
        }
        
    private void habilitarCampos(boolean estado) {
    cedulas.setEnabled(estado);
    nombres.setEnabled(estado);
    cursos.setEnabled(estado);
    carreras.setEnabled(estado);
    comboSexo.setEnabled(estado);
    camposHabilitados = estado;
}
    private void configurarListeners() {
    guardar.addActionListener(e -> {  // Usar guardar (botón existente)
        controlador.guardarEstudiante(obtenerDatosFormulario());
    });
}
    private Estudiante obtenerDatosFormulario() {
    return new Estudiante(
        nombres.getText().trim(),    // Usar nombres (JTextField existente)
        cedulas.getText().trim(),    // Usar cedulas (JTextField existente)
        (String) comboSexo.getSelectedItem(),
        cursos.getText().trim(),
        (String) carreras.getSelectedItem()
    );
}
    
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Nombre = new javax.swing.JLabel();
        nombres = new javax.swing.JTextField();
        Curso = new javax.swing.JLabel();
        cursos = new javax.swing.JTextField();
        cedula = new javax.swing.JLabel();
        cedulas = new javax.swing.JTextField();
        carrera = new javax.swing.JLabel();
        carreras = new javax.swing.JComboBox<>();
        sexo = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        guardar = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Modificar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombre.setText("Nombre:");

        Curso.setText("Curso:");

        cedula.setText("Cedula:");

        carrera.setText("Carreras:");

        carreras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desarrollo de Software", "Base de Datos", "Tributacion", "Entrenamiento Deportivo", "Arquitectura", "Abogado", "Medicina", "Odontologia" }));

        sexo.setText("Sexo:");

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", " " }));

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(carrera, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                .addComponent(Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Curso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nombres)
                                .addComponent(cursos)
                                .addComponent(cedulas, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboSexo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(carreras, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(guardar)
                        .addGap(91, 91, 91)
                        .addComponent(nuevo)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Curso)
                    .addComponent(cursos, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula)
                    .addComponent(cedulas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carrera)
                    .addComponent(carreras, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexo)
                    .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(nuevo))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estudiante", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Curso", "Cedula", "Carrera"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Modificar)
                        .addGap(33, 33, 33)
                        .addComponent(Eliminar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Modificar)
                    .addComponent(Eliminar))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tabla_Estudi", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 21, 510, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
    Estudiante est = obtenerDatosFormulario();
    String error = controlador.validarEstudiante(est);
    
    if (error != null) {
        JOptionPane.showMessageDialog(this, error);
    } else {
        if (controlador.guardarEstudiante(est)) {
            actualizarTabla();
            habilitarCampos(false);
        }
    }
    }//GEN-LAST:event_guardarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
    int fila = jTable1.getSelectedRow();
    if(fila == -1) return;
    
    int confirmar = JOptionPane.showConfirmDialog(this, 
        "¿Está seguro de eliminar este estudiante?", 
        "Confirmar eliminación", 
        JOptionPane.YES_NO_OPTION);
    
    if(confirmar == JOptionPane.YES_OPTION){
        String cedula = jTable1.getValueAt(fila, 0).toString();
        if(controlador.eliminarEstudiante(cedula)){
            JOptionPane.showMessageDialog(this, "Estudiante eliminado");
            actualizarTabla();
        }
    }
    }//GEN-LAST:event_EliminarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
    if (!validarCampos()) return;
    
    if (controlador.existeNombre(nombres  .getText().trim(), cedulas.getText().trim())) {
        JOptionPane.showMessageDialog(this, "Nombre ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    Estudiante est = new Estudiante(
        nombres.getText().trim(),
        cedulas.getText().trim(),
        (String) comboSexo.getSelectedItem(),
        cursos.getText().trim(),
        (String) carreras.getSelectedItem()
    );
    
    if (controlador.guardarEstudiante(est)) {
        JOptionPane.showMessageDialog(this, "Estudiante guardado");
        actualizarTabla();
        habilitarCampos(false);
    }
    }//GEN-LAST:event_ModificarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
    habilitarCampos(true);
    limpiarCampos();
    cedulas.requestFocus();
    }//GEN-LAST:event_nuevoActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Estudiantes_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estudiantes_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estudiantes_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estudiantes_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estudiantes_Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Curso;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Modificar;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel carrera;
    private javax.swing.JComboBox<String> carreras;
    private javax.swing.JLabel cedula;
    private javax.swing.JTextField cedulas;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JTextField cursos;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombres;
    private javax.swing.JButton nuevo;
    private javax.swing.JLabel sexo;
    // End of variables declaration//GEN-END:variables
}
