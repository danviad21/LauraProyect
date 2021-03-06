/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.FormatoEntradaException;
import Modelo.Vehiculo;
import Persistencia.VehiculoDao;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author odavid
 */
public class VistaPrincipal extends javax.swing.JFrame {


    /**
     * Creates new form NewJFrame
     */
    public VistaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane(){

            Image img = new ImageIcon("src/main/java/Imagenes/backgroundt1.jpeg").getImage();

            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                grphcs.drawImage(img, 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(685, 660);
            }

        };
        jPanel1 = new javax.swing.JPanel();
        jLabelReloj = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCliente = new javax.swing.JMenu();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItemVehiculo = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItemRegistrar = new javax.swing.JMenuItem();
        jMenuListaAlquileres = new javax.swing.JMenu();
        jMenuItemListaAlquileres = new javax.swing.JMenuItem();
        jMenuItemListaClientes = new javax.swing.JMenuItem();
        jMenuItemListaVehiculos = new javax.swing.JMenuItem();
        jMenuReporteCliente = new javax.swing.JMenu();
        jMenuItemReporteCliente = new javax.swing.JMenuItem();
        jMenuItemReporteVehiculo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 775));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 775));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jDesktopPane.setMaximumSize(new java.awt.Dimension(685, 1200));
        jDesktopPane.setMinimumSize(new java.awt.Dimension(685, 660));
        jDesktopPane.setPreferredSize(new java.awt.Dimension(685, 660));
        getContentPane().add(jDesktopPane, java.awt.BorderLayout.CENTER);
        jDesktopPane.repaint();

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 35));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabelReloj.setBackground(new java.awt.Color(251, 251, 251));
        jLabelReloj.setFont(new java.awt.Font("Noto Sans", 1, 17)); // NOI18N
        jLabelReloj.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelReloj.setMaximumSize(new java.awt.Dimension(1200, 35));
        jLabelReloj.setMinimumSize(new java.awt.Dimension(700, 35));
        jLabelReloj.setOpaque(true);
        jLabelReloj.setPreferredSize(new java.awt.Dimension(700, 35));
        jPanel1.add(jLabelReloj);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jMenuBar1.setForeground(new java.awt.Color(248, 252, 253));
        jMenuBar1.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(480, 40));

        jMenuCliente.setText("Catalogo");
        jMenuCliente.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N

        jMenuItemCliente.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jMenuItemCliente.setText("Cliente");
        jMenuCliente.add(jMenuItemCliente);

        jMenuItemVehiculo.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jMenuItemVehiculo.setText("Vehiculo");
        jMenuCliente.add(jMenuItemVehiculo);

        jMenuBar1.add(jMenuCliente);

        jMenu10.setBackground(new java.awt.Color(251, 253, 254));
        jMenu10.setText("Alquiler");
        jMenu10.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N

        jMenuItemRegistrar.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jMenuItemRegistrar.setText("Registrar");
        jMenu10.add(jMenuItemRegistrar);

        jMenuBar1.add(jMenu10);

        jMenuListaAlquileres.setText("Todos Los Registro");
        jMenuListaAlquileres.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N

        jMenuItemListaAlquileres.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jMenuItemListaAlquileres.setText("Lista Alquileres");
        jMenuListaAlquileres.add(jMenuItemListaAlquileres);

        jMenuItemListaClientes.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jMenuItemListaClientes.setText("Lista Clientes");
        jMenuListaAlquileres.add(jMenuItemListaClientes);

        jMenuItemListaVehiculos.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jMenuItemListaVehiculos.setText("Vehiculos");
        jMenuListaAlquileres.add(jMenuItemListaVehiculos);

        jMenuBar1.add(jMenuListaAlquileres);

        jMenuReporteCliente.setText("Reportes");
        jMenuReporteCliente.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N

        jMenuItemReporteCliente.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jMenuItemReporteCliente.setText("Clientes");
        jMenuReporteCliente.add(jMenuItemReporteCliente);

        jMenuItemReporteVehiculo.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jMenuItemReporteVehiculo.setText("Vehiculos");
        jMenuReporteCliente.add(jMenuItemReporteVehiculo);

        jMenuBar1.add(jMenuReporteCliente);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        VehiculoDao vehiculoDao = new VehiculoDao();
        List<Vehiculo> listaVehiculo = vehiculoDao.consultar_vehiculos();
        listaVehiculo.stream().filter(vehiculo -> (vehiculo.getEstadoVehiculo() ==2)).forEachOrdered(vehiculo -> {
            try {
                vehiculo.setEstadoVehiculo(1);
                vehiculoDao.actualizar_vehiculo(vehiculo);
            } catch (FormatoEntradaException ex) {
                System.out.println(ex);
            }
        });
    }//GEN-LAST:event_formWindowClosing

    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDesktopPane;
    public static javax.swing.JLabel jLabelReloj;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCliente;
    public static javax.swing.JMenuItem jMenuItemCliente;
    public static javax.swing.JMenuItem jMenuItemListaAlquileres;
    public static javax.swing.JMenuItem jMenuItemListaClientes;
    public static javax.swing.JMenuItem jMenuItemListaVehiculos;
    public static javax.swing.JMenuItem jMenuItemRegistrar;
    public static javax.swing.JMenuItem jMenuItemReporteCliente;
    public static javax.swing.JMenuItem jMenuItemReporteVehiculo;
    public static javax.swing.JMenuItem jMenuItemVehiculo;
    private javax.swing.JMenu jMenuListaAlquileres;
    private javax.swing.JMenu jMenuReporteCliente;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
