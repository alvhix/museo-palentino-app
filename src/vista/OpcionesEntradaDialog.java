/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Cliente;
import modelo.Entrada;
import controlador.SistemaMuseo;
import disenno.ImagenFondo;
import javax.swing.table.DefaultTableModel;
import excepciones.FechaException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Álvaro
 */
public class OpcionesEntradaDialog extends javax.swing.JDialog {

    // ********* Atributos *********
    private Cliente c;
    private Entrada e;
    private SistemaMuseo sm;

    DefaultTableModel modelo;
    String cabecera[] = {"Fecha", "Hora", "¿Guiada?", "Precio"};

    /**
     * Creates new form OpcionesEntradaDialog
     *
     * @param parent
     * @param modal
     * @param c
     */
    public OpcionesEntradaDialog(MenuUsuarioFrame parent, boolean modal, Cliente c) {
        this.c = c;
        initComponents();
        componentesIniciales();
    }

    private OpcionesEntradaDialog(MenuUsuarioFrame menuUsuarioFrame, boolean b) {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btReservar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        setTitle("Opciones de Entradas");
        setIconImage(getIconImage());
        setResizable(false);

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre: ");
        jPanel1.add(jLabel1);

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel8);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DNI: ");
        jPanel1.add(jLabel2);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel9);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Teléfono: ");
        jPanel1.add(jLabel3);

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel10);

        jPanel2.setOpaque(false);

        btReservar.setBackground(new java.awt.Color(255, 255, 255));
        btReservar.setText("Reservar");
        btReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReservarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Hora", "¿Guiada?", "Nº Guia", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(btReservar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel5.setOpaque(false);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jDateChooser1.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 132;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 13, 10);
        jPanel6.add(jDateChooser1, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de la reserva");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        jPanel6.add(jLabel5, gridBagConstraints);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "10:00", "12:00", "14:00", "16:00", "18:00" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 13, 0);
        jPanel7.add(jComboBox1, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hora de la reserva");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        jPanel7.add(jLabel6, gridBagConstraints);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("¿Visita guiada?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        jPanel4.add(jLabel4, gridBagConstraints);

        jCheckBox1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Con guía");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 20, 7, 0);
        jPanel4.add(jCheckBox1, gridBagConstraints);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("RESERVA DE ENTRADAS");
        jPanel8.add(jLabel7, new java.awt.GridBagConstraints());

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Precio de la entrada:");
        jPanel9.add(jLabel11, new java.awt.GridBagConstraints());

        jPanel11.setOpaque(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel11, new java.awt.GridBagConstraints());

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 204, 0));
        jPanel9.add(jLabel12, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        this.dispose(); // Oculta el jframe
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here: 
        if (jCheckBox1.isSelected()) {
            siGuiada();
        } else {
            noGuiada();
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void btReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReservarActionPerformed
        try {
            // TODO add your handling code here:
            reservarEntrada();
        } catch (FechaException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btReservarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(OpcionesEntradaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcionesEntradaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcionesEntradaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcionesEntradaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                OpcionesEntradaDialog dialog = new OpcionesEntradaDialog(new MenuUsuarioFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReservar;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    // ############################# COMPONENTES INICIALES #############################
    private void componentesIniciales() {
        conexionBD();
        imagenFondo();
        datosReserva();
        cargarEntradas();
        mostrarTabla();
    }

    // ############################# CARGA DE ENTRADAS #############################
    public void cargarEntradas() {
        c.cargarEntradas(sm.cargarEntradasCliente(c.getIdCliente()));
    }

    // ############################# TABLA #############################
    // Muestra las reservas hechas por el usuario (en blanco si no ha hecho reservas)
    public void mostrarTabla() {
        // Carga las entradas directamente de la base de datos
        modelo = new DefaultTableModel(c.tablaEntradas(), cabecera);
        jTable1.setModel(modelo);
    }

// ############################# RESERVA DE ENTRADA #############################
    public void reservarEntrada() throws FechaException {
        if (jDateChooser1.getDate() != null) { // Si el calendario está sin rellenar
            // Crea nueva entrada
            e = new Entrada();
            // Setea la fecha de la reserva
            e.setFecha(jDateChooser1.getDate());
            // Setea si la entrada es guiada
            e.setEsGuiada(jCheckBox1.isSelected());
            // Setea la hora
            int comboBox = jComboBox1.getSelectedIndex();
            String[] horario = {"8:00", "10:00", "12:00", "14:00", "16:00", "18:00"};
            e.setHora(horario[comboBox]);
            e.setPrecio(getPrecioEntrada());

            // Reserva la entrada pasando como parámetros el cliente
            sm.reservarEntrada(e, c);
            mostrarTabla();
        } else {

            throw new FechaException();

        }
        jDateChooser1.setDate(null); // Restablece el calendario
        jComboBox1.setSelectedIndex(0); // Restablece el selector de hora a la default
    }

    // ############################# DATOS RESERVA DE ENTRADA #############################
    // Obtiene los datos del cliente para mostrarlos en la cabecera
    private void datosReserva() {
        jLabel8.setText(c.getNombre());
        jLabel9.setText(c.getDNI());
        jLabel10.setText(String.valueOf(c.getTelefono()));
        setPrecioEntradaNormal();
    }

    // ############################# PRECIO ENTRADA #############################
    private void setPrecioEntradaNormal() {
        float precio = sm.devolverPrecioEntrada();
        jLabel12.setText(String.valueOf(String.format("%.2f €", precio)));
    }

    private void setPrecioEntradaGuiada() {
        float precio = sm.devolverPrecioEntrada();
        float suplemento = sm.devolverPrecioSuplemento();
        float total = precio + suplemento;
        jLabel12.setText(String.valueOf(String.format("%.2f €", total)));
    }

    private float getPrecioEntrada() {
        float precioEntrada;
        if (e.getEsGuiada()) {
            precioEntrada = sm.devolverPrecioEntrada() + sm.devolverPrecioSuplemento();
        } else {
            precioEntrada = sm.devolverPrecioEntrada();
        }
        return precioEntrada;
    }

    private void siGuiada() {
        float suplemento = sm.devolverPrecioSuplemento();
        JOptionPane.showMessageDialog(null, "La entrada guiada lleva un suplemento "
                + "de " + suplemento + "€", "Atención", JOptionPane.INFORMATION_MESSAGE);
        setPrecioEntradaGuiada();
    }

    private void noGuiada() {
        setPrecioEntradaNormal();
    }

    // ############################# IMÁGENES #############################
    private void imagenFondo() {
        try {
            ImagenFondo fondo = new ImagenFondo(ImageIO.read(new File("src/recursos/imagenes/fondos/fondoSecundario.png")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("recursos/imagenes/iconos/iconoMuseoApp.png"));
        return retValue;
    }

    // ############################# CONEXIÓN BASE DE DATOS #############################
    private void conexionBD() {
        try {
            sm = new SistemaMuseo();
        } catch (SQLException ex) {
            System.out.println("Error de conexión con la Base de Datos.");
        }
    }
}
