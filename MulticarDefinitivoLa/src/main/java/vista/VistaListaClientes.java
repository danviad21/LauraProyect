/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author odavid
 */
public class VistaListaClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioCliente
     */
    public VistaListaClientes() {

        initComponents();
        ((BasicInternalFrameUI) super.getUI()).setNorthPane(null);
        super.setBorder(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonEliminarCliente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaClientes = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldClientesRegistrados = new javax.swing.JTextField();
        jButtonEditarCliente = new javax.swing.JButton();
        jButtonNuevoCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximumSize(new java.awt.Dimension(1197, 615));
        setMinimumSize(new java.awt.Dimension(1197, 615));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1197, 615));
        setRequestFocusEnabled(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(8, 8, 50));
        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 246, 246));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CLIENTES REGISTRADOS");
        jLabel1.setMaximumSize(new java.awt.Dimension(244, 19));
        jLabel1.setMinimumSize(new java.awt.Dimension(244, 19));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 19));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 70));

        jButtonEliminarCliente.setBackground(new java.awt.Color(130, 46, 17));
        jButtonEliminarCliente.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jButtonEliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminarCliente.setText("ELIMINAR");
        jButtonEliminarCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonEliminarCliente.setFocusable(false);
        getContentPane().add(jButtonEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 130, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.lightGray), "Lista", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 17))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableListaClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jTableListaClientes.setFont(new java.awt.Font("Noto Sans", 1, 11)); // NOI18N
        jTableListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NO.", "IDENTIFICACION", "NOMBRE", "APELLIDO", "TELEFONO", "ESTATUS", "RECIBOS ASOCIADOS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableListaClientes.setMaximumSize(new java.awt.Dimension(90, 0));
        jTableListaClientes.setShowHorizontalLines(false);
        jTableListaClientes.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTableListaClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1160, 230));

        jLabel15.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jLabel15.setText("CANTIDAD DE CIENTES REGISTRADOS");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, -1, -1));

        jTextFieldClientesRegistrados.setEditable(false);
        jTextFieldClientesRegistrados.setBackground(new java.awt.Color(254, 254, 254));
        jTextFieldClientesRegistrados.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jTextFieldClientesRegistrados.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));
        jPanel1.add(jTextFieldClientesRegistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 290, 190, 37));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 1180, 440));

        jButtonEditarCliente.setBackground(new java.awt.Color(8, 165, 155));
        jButtonEditarCliente.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jButtonEditarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditarCliente.setText("EDITAR");
        jButtonEditarCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonEditarCliente.setFocusable(false);
        getContentPane().add(jButtonEditarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 120, 40));

        jButtonNuevoCliente.setBackground(new java.awt.Color(8, 165, 155));
        jButtonNuevoCliente.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jButtonNuevoCliente.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNuevoCliente.setText("NUEVO");
        jButtonNuevoCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonNuevoCliente.setFocusable(false);
        getContentPane().add(jButtonNuevoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditarCliente;
    private javax.swing.JButton jButtonEliminarCliente;
    private javax.swing.JButton jButtonNuevoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListaClientes;
    private javax.swing.JTextField jTextFieldClientesRegistrados;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getjButtonEditarCliente() {
        return jButtonEditarCliente;
    }

    public void setjButtonEditarCliente(javax.swing.JButton jButtonEditarCliente) {
        this.jButtonEditarCliente = jButtonEditarCliente;
    }

    public javax.swing.JButton getjButtonEliminarCliente() {
        return jButtonEliminarCliente;
    }

    public void setjButtonEliminarCliente(javax.swing.JButton jButtonEliminarCliente) {
        this.jButtonEliminarCliente = jButtonEliminarCliente;
    }

    public javax.swing.JButton getjButtonNuevoCliente() {
        return jButtonNuevoCliente;
    }

    public void setjButtonNuevoCliente(javax.swing.JButton jButtonNuevoCliente) {
        this.jButtonNuevoCliente = jButtonNuevoCliente;
    }

    public javax.swing.JTable getjTableListaClientes() {
        return jTableListaClientes;
    }

    public void setjTableListaClientes(javax.swing.JTable jTableListaClientes) {
        this.jTableListaClientes = jTableListaClientes;
    }

    public javax.swing.JTextField getjTextFieldClientesRegistrados() {
        return jTextFieldClientesRegistrados;
    }

    public void setjTextFieldClientesRegistrados(javax.swing.JTextField jTextFieldClientesRegistrados) {
        this.jTextFieldClientesRegistrados = jTextFieldClientesRegistrados;
    }

}
