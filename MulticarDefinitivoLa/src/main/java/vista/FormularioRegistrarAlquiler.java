/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author odavid
 */
public class FormularioRegistrarAlquiler extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioCliente
     */
    public FormularioRegistrarAlquiler() {
  
        initComponents();
        this.jLabelIdCliente.setVisible(false);
        ((BasicInternalFrameUI)super.getUI()).setNorthPane(null);
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
        jLabel5 = new javax.swing.JLabel();
        jButtonCerrrar = new javax.swing.JButton();
        jTextFieldNoRecibo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalleAlquiler = new javax.swing.JTable();
        jTextFieldTotalAPagar = new javax.swing.JTextField();
        jButtonAgregarVehiculo = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldFechaDevuelta = new javax.swing.JTextField();
        jTextFieldFechaEntrega = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonSalirBusquedad = new javax.swing.JButton();
        jButtonGuardarAlquiler = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jPanelCambioJPanel = new javax.swing.JPanel();
        jPanelRg = new javax.swing.JPanel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldNombreCompleto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldIdentificacion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabelIdCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximumSize(new java.awt.Dimension(610, 630));
        setMinimumSize(new java.awt.Dimension(610, 630));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(610, 630));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(8, 8, 50));
        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 246, 246));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Alquiler");
        jLabel1.setMaximumSize(new java.awt.Dimension(244, 19));
        jLabel1.setMinimumSize(new java.awt.Dimension(244, 19));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 19));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 50));

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 17)); // NOI18N
        jLabel5.setText("Recibo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        jButtonCerrrar.setBackground(new java.awt.Color(130, 46, 17));
        jButtonCerrrar.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jButtonCerrrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCerrrar.setText("Cerrar");
        jButtonCerrrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonCerrrar.setFocusable(false);
        getContentPane().add(jButtonCerrrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 570, 130, 40));

        jTextFieldNoRecibo.setEditable(false);
        jTextFieldNoRecibo.setBackground(new java.awt.Color(254, 254, 254));
        jTextFieldNoRecibo.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jTextFieldNoRecibo.setMaximumSize(new java.awt.Dimension(150, 35));
        jTextFieldNoRecibo.setMinimumSize(new java.awt.Dimension(150, 35));
        jTextFieldNoRecibo.setPreferredSize(new java.awt.Dimension(150, 35));
        getContentPane().add(jTextFieldNoRecibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 120, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.lightGray), "Detalle Alquiler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 17))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableDetalleAlquiler.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jTableDetalleAlquiler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "VEHICULO", "DIAS ALQUILADOS", "VALOR ALQUILER", "SEGURO", "SUBOTOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDetalleAlquiler.setMaximumSize(new java.awt.Dimension(90, 0));
        jTableDetalleAlquiler.setShowHorizontalLines(false);
        jTableDetalleAlquiler.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTableDetalleAlquiler);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 560, 120));

        jTextFieldTotalAPagar.setEditable(false);
        jTextFieldTotalAPagar.setBackground(new java.awt.Color(254, 254, 254));
        jTextFieldTotalAPagar.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jTextFieldTotalAPagar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalAPagar.setText("0");
        jTextFieldTotalAPagar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));
        jPanel1.add(jTextFieldTotalAPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 120, 37));

        jButtonAgregarVehiculo.setBackground(new java.awt.Color(21, 44, 43));
        jButtonAgregarVehiculo.setFont(new java.awt.Font("Noto Sans", 0, 23)); // NOI18N
        jButtonAgregarVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregarVehiculo.setText("+");
        jButtonAgregarVehiculo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAgregarVehiculo.setFocusable(false);
        jPanel1.add(jButtonAgregarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 70, 30));

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jLabel12.setText("Devuelta");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        jTextFieldFechaDevuelta.setEditable(false);
        jTextFieldFechaDevuelta.setBackground(new java.awt.Color(254, 254, 254));
        jTextFieldFechaDevuelta.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jTextFieldFechaDevuelta.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));
        jTextFieldFechaDevuelta.setMaximumSize(new java.awt.Dimension(140, 150));
        jTextFieldFechaDevuelta.setMinimumSize(new java.awt.Dimension(140, 150));
        jTextFieldFechaDevuelta.setPreferredSize(new java.awt.Dimension(140, 150));
        jPanel1.add(jTextFieldFechaDevuelta, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 140, 37));

        jTextFieldFechaEntrega.setEditable(false);
        jTextFieldFechaEntrega.setBackground(new java.awt.Color(254, 254, 254));
        jTextFieldFechaEntrega.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jTextFieldFechaEntrega.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));
        jPanel1.add(jTextFieldFechaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 130, 37));

        jLabel13.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jLabel13.setText("Entrega");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jLabel11.setText("Total");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 590, 260));

        jButtonSalirBusquedad.setBackground(new java.awt.Color(8, 8, 50));
        jButtonSalirBusquedad.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jButtonSalirBusquedad.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalirBusquedad.setText("Cancelar");
        jButtonSalirBusquedad.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonSalirBusquedad.setFocusable(false);
        getContentPane().add(jButtonSalirBusquedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 120, 40));

        jButtonGuardarAlquiler.setBackground(new java.awt.Color(8, 165, 155));
        jButtonGuardarAlquiler.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jButtonGuardarAlquiler.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardarAlquiler.setText("Guardar");
        jButtonGuardarAlquiler.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonGuardarAlquiler.setFocusable(false);
        getContentPane().add(jButtonGuardarAlquiler, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 120, 40));

        jButtonBuscar.setBackground(new java.awt.Color(8, 8, 50));
        jButtonBuscar.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonBuscar.setFocusable(false);
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 40));

        jPanelCambioJPanel.setLayout(new javax.swing.BoxLayout(jPanelCambioJPanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanelRg.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 17))); // NOI18N
        jPanelRg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldTelefono.setEditable(false);
        jTextFieldTelefono.setBackground(new java.awt.Color(254, 254, 254));
        jTextFieldTelefono.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jTextFieldTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));
        jPanelRg.add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 250, 37));

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jLabel9.setText("Telefono");
        jPanelRg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jTextFieldNombreCompleto.setEditable(false);
        jTextFieldNombreCompleto.setBackground(new java.awt.Color(254, 254, 254));
        jTextFieldNombreCompleto.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jTextFieldNombreCompleto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldNombreCompleto.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));
        jPanelRg.add(jTextFieldNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 550, 37));

        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jLabel10.setText("Nombre Completo");
        jPanelRg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jTextFieldIdentificacion.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jTextFieldIdentificacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));
        jPanelRg.add(jTextFieldIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 250, 37));

        jLabel14.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jLabel14.setText("Identificacion");
        jPanelRg.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanelRg.add(jLabelIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 40, 20));

        jPanelCambioJPanel.add(jPanelRg);

        getContentPane().add(jPanelCambioJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 600, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarVehiculo;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCerrrar;
    private javax.swing.JButton jButtonGuardarAlquiler;
    private javax.swing.JButton jButtonSalirBusquedad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelIdCliente;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanelCambioJPanel;
    public static javax.swing.JPanel jPanelRg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDetalleAlquiler;
    private javax.swing.JTextField jTextFieldFechaDevuelta;
    private javax.swing.JTextField jTextFieldFechaEntrega;
    private javax.swing.JTextField jTextFieldIdentificacion;
    private javax.swing.JTextField jTextFieldNoRecibo;
    private javax.swing.JTextField jTextFieldNombreCompleto;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextField jTextFieldTotalAPagar;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getjButtonBuscar() {
        return jButtonBuscar;
    }

    public void setjButtonBuscar(javax.swing.JButton jButtonBuscar) {
        this.jButtonBuscar = jButtonBuscar;
    }

    public javax.swing.JButton getjButtonCerrrar() {
        return jButtonCerrrar;
    }

    public void setjButtonCerrrar(javax.swing.JButton jButtonCerrrar) {
        this.jButtonCerrrar = jButtonCerrrar;
    }

    public javax.swing.JButton getjButtonSalirBusquedad() {
        return jButtonSalirBusquedad;
    }

    public void setjButtonSalirBusquedad(javax.swing.JButton jButtonSalirBusquedad) {
        this.jButtonSalirBusquedad = jButtonSalirBusquedad;
    }

    public javax.swing.JTable getjTableDetalleAlquiler() {
        return jTableDetalleAlquiler;
    }

    public void setjTableDetalleAlquiler(javax.swing.JTable jTableDetalleAlquiler) {
        this.jTableDetalleAlquiler = jTableDetalleAlquiler;
    }

    public JLabel getjLabelIdCliente() {
        return jLabelIdCliente;
    }

    public void setjLabelIdCliente(JLabel jLabelIdCliente) {
        this.jLabelIdCliente = jLabelIdCliente;
    }
    
    

    public javax.swing.JTextField getjTextFieldFechaDevuelta() {
        return jTextFieldFechaDevuelta;
    }

    public void setjTextFieldFechaDevuelta(javax.swing.JTextField jTextFieldFechaDevuelta) {
        this.jTextFieldFechaDevuelta = jTextFieldFechaDevuelta;
    }

    public javax.swing.JTextField getjTextFieldFechaEntrega() {
        return jTextFieldFechaEntrega;
    }

    public void setjTextFieldFechaEntrega(javax.swing.JTextField jTextFieldFechaEntrega) {
        this.jTextFieldFechaEntrega = jTextFieldFechaEntrega;
    }

    public javax.swing.JTextField getjTextFieldIdentificacion() {
        return jTextFieldIdentificacion;
    }

    public void setjTextFieldIdentificacion(javax.swing.JTextField jTextFieldIdentificacion) {
        this.jTextFieldIdentificacion = jTextFieldIdentificacion;
    }

    public javax.swing.JTextField getjTextFieldNoRecibo() {
        return jTextFieldNoRecibo;
    }

    public void setjTextFieldNoRecibo(javax.swing.JTextField jTextFieldNoRecibo) {
        this.jTextFieldNoRecibo = jTextFieldNoRecibo;
    }

    public javax.swing.JTextField getjTextFieldNombreCompleto() {
        return jTextFieldNombreCompleto;
    }

    public void setjTextFieldNombreCompleto(javax.swing.JTextField jTextFieldNombreCompleto) {
        this.jTextFieldNombreCompleto = jTextFieldNombreCompleto;
    }

    public javax.swing.JTextField getjTextFieldTelefono() {
        return jTextFieldTelefono;
    }

    public void setjTextFieldTelefono(javax.swing.JTextField jTextFieldTelefono) {
        this.jTextFieldTelefono = jTextFieldTelefono;
    }

    public javax.swing.JTextField getjTextFieldTotalAPagar() {
        return jTextFieldTotalAPagar;
    }

    public void setjTextFieldTotalAPagar(javax.swing.JTextField jTextFieldTotalAPagar) {
        this.jTextFieldTotalAPagar = jTextFieldTotalAPagar;
    }

    public JButton getjButtonAgregarVehiculo() {
        return jButtonAgregarVehiculo;
    }

    public void setjButtonAgregarVehiculo(JButton jButtonAgregarVehiculo) {
        this.jButtonAgregarVehiculo = jButtonAgregarVehiculo;
    }

    public JButton getjButtonGuardarAlquiler() {
        return jButtonGuardarAlquiler;
    }

    public void setjButtonGuardarAlquiler(JButton jButtonGuardarAlquiler) {
        this.jButtonGuardarAlquiler = jButtonGuardarAlquiler;
    } 
}
