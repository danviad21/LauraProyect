package controlador;

import Modelo.Alquiler;
import Modelo.Cliente;
import Modelo.Fecha;
import Modelo.FormatoEntradaException;
import Modelo.Hora;
import Modelo.Recaudo;
import Modelo.Reloj;
import Modelo.TipoAuto;
import Modelo.TipoCamioneta;
import Modelo.Vehiculo;
import Persistencia.AlquilerDao;
import Persistencia.ClienteDao;
import Persistencia.VehiculoDao;
import java.awt.Dimension;
import vista.FormularioCliente;
import vista.VistaListaAlquiler;
import vista.FormularioRegistrarAlquiler;
import vista.FormularioVehiculo;
import vista.VistaListaClientes;
import vista.VistaListaVehiculos;
import vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.VistaListaVehiculosJPanel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author odavid
 */
public class Controlador implements ActionListener, FocusListener, Observer {

    private Hora tiempo;
    private Reloj reloj;
    private VehiculoDao vehiculoDao;
    private ClienteDao clienteDao;
    private AlquilerDao alquilerDao;
    private VistaPrincipal principal;
    private FormularioRegistrarAlquiler formularioRegistro;
    private FormularioVehiculo formularioVehiculo;
    private FormularioCliente formularioCliente;
    private VistaListaAlquiler vistaListaAlquiler;
    private VistaListaClientes vistaListaClientes;
    private VistaListaVehiculos vistaListaVehiculos;
    private VistaListaVehiculosJPanel vistaListaVehiculosJPanel;

    public Controlador() {

        if (this.principal == null) {
            this.principal = new VistaPrincipal();
        }
        this.principal.pack();
        this.principal.setVisible(true);
    }

    public void inicializar() {

        this.clienteDao = new ClienteDao();
        this.vehiculoDao = new VehiculoDao();
        this.alquilerDao = new AlquilerDao();
        this.reloj = new Reloj();
        this.reloj.addObserver(this);
        Thread hilo = new Thread(this.reloj);
        hilo.start();
        VistaPrincipal.jMenuItemCliente.addActionListener(this);
        VistaPrincipal.jMenuItemVehiculo.addActionListener(this);
        VistaPrincipal.jMenuItemRegistrar.addActionListener(this);
        VistaPrincipal.jMenuItemListaAlquileres.addActionListener(this);
        VistaPrincipal.jMenuItemListaClientes.addActionListener(this);
        VistaPrincipal.jMenuItemListaVehiculos.addActionListener(this);
        VistaPrincipal.jMenuItemReporteVehiculo.addActionListener(this);
        VistaPrincipal.jMenuItemReporteCliente.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == VistaPrincipal.jMenuItemCliente) {

            abrirVistaFormCliente(null);
        }

        if (e.getSource() == VistaPrincipal.jMenuItemVehiculo) {
            abrirVistaFormVehiculo(null);
        }

        if (e.getSource() == VistaPrincipal.jMenuItemRegistrar) {
            abrirVistaFormRegistro();
        }

        if (e.getSource() == VistaPrincipal.jMenuItemListaAlquileres) {
            abrirVistaListaAlquileres();
        }

        if (e.getSource() == VistaPrincipal.jMenuItemListaClientes) {
            abrirVistaListaClientes();
        }

        if (e.getSource() == VistaPrincipal.jMenuItemListaVehiculos) {
            abrirVistaListaVehiculos();
        }

        if (this.formularioVehiculo != null) {
            if (e.getSource() == this.formularioVehiculo.getjButtonGuardarVehiculo()) {
                guardarRegistroVehiculo();
            } else if (e.getSource() == this.formularioVehiculo.getjRadioButtonTipoAuto()) {
                controlarRadioButtonAuto();

            } else if (e.getSource() == this.formularioVehiculo.getjRadioButtonTipoCamioneta()) {
                controlarRadioButtonCamioneta();

            }
        }

        if (this.formularioCliente != null) {
            if (e.getSource() == this.formularioCliente.getjButtonGuardarCliente()) {
                guardarRegistroCliente();
            }
        }

        if (this.formularioRegistro != null) {
            if (this.vistaListaVehiculosJPanel != null) {
                if (e.getSource() == this.vistaListaVehiculosJPanel.getjButtonAgregarVehiculo()) {
                    agregarVehiculoAlDetalle();

                } else if (e.getSource() == this.vistaListaVehiculosJPanel.getjButtonCerrarVentanaListaV()) {
                    cerrarVentanaListaVehiculoJPanel();
                }
            }

            if (e.getSource() == this.formularioRegistro.getjButtonGuardarAlquiler()) {
                guardarRegistroAlquiler();

            } else if (e.getSource() == this.formularioRegistro.getjButtonAgregarVehiculo()) {
                abrirVistaListaVehiculoJPanelView();
            }

        }

        if (this.vistaListaVehiculos != null) {
            if (e.getSource() == this.vistaListaVehiculos.getjButtonNuevoVehiculo()) {
                abrirVistaFormVehiculo(null);

            } else if (e.getSource() == this.vistaListaVehiculos.getjButtonEditarVehiculo()) {
                try {
                    int fila = this.vistaListaVehiculos.getjTableListaVehiculos().getSelectedRow();
                    int idVehiculo = Integer.parseInt(this.vistaListaVehiculos.getjTableListaVehiculos().getValueAt(fila, 0).toString());
                    Vehiculo vehiculo;
                    vehiculo = this.vehiculoDao.consultar_un_vehiculo(idVehiculo);
                    abrirVistaFormVehiculo(vehiculo);
                } catch (FormatoEntradaException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (e.getSource() == this.vistaListaVehiculos.getjButtonEliminarVehiculo()) {

                int indice = this.vistaListaVehiculos.getjTableListaVehiculos().getSelectedRow();
                int id = Integer.parseInt(this.vistaListaVehiculos.getjTableListaVehiculos().getValueAt(indice, 0).toString());
                int opcion = JOptionPane.showConfirmDialog(this.vistaListaVehiculos, "ESTA SEGURO DE ELIMINAR EL REGISTRO ?");

                if (opcion == JOptionPane.YES_OPTION) {
                    this.vehiculoDao.eliminar_vehiculo(id);
                    JOptionPane.showMessageDialog(this.vistaListaClientes, "VEHICULO ELIMINADO CON EXITO!");
                    llenarTablaListaVehiculos("", "", "");
                }
            } else if (e.getSource() == this.vistaListaVehiculos.getjButtonEntregado()) {

                int fila = this.vistaListaVehiculos.getjTableListaVehiculos().getSelectedRow();

                if (fila >= 0) {

                    int opcion = JOptionPane.showConfirmDialog(this.vistaListaAlquiler, "ESTA SEGURO DE CONFIRMAR EL VEHICULO\nCOMO ENTREGADO ?");

                    if (opcion == JOptionPane.YES_OPTION) {

                        try {
                            int id_vehiculo = Integer.parseInt(this.vistaListaVehiculos.getjTableListaVehiculos().getValueAt(fila, 0).toString());
                            Vehiculo vehiculo = this.vehiculoDao.consultar_un_vehiculo(id_vehiculo);
                            if (vehiculo.getEstadoVehiculo() == 0 && vehiculo.getNumeroFactura() != 0) {
                                vehiculo.setEstadoVehiculo(3);
                                this.vehiculoDao.actualizar_vehiculo(vehiculo);
                                vehiculo.setEstadoVehiculo(1);
                                vehiculo.setNumeroFactura(0);
                                this.vehiculoDao.crear_vehiculo(vehiculo);
                                llenarTablaListaVehiculos("", "", "");
                                JOptionPane.showMessageDialog(this.vistaListaVehiculos, "CONFIRMADO COMO ENTREGADO");
                            }
                        } catch (FormatoEntradaException ex) {
                            System.out.println(ex);
                        }
                    }
                }

            } else if (e.getSource() == this.vistaListaVehiculos.getjButtonBuscarPor()) {
                System.out.println("entra buscar");
                String p1 = this.vistaListaVehiculos.getjTextFieldPorRecibo().getText();
                String p2 = this.vistaListaVehiculos.getjTextFieldPorDescr().getText();
                String p3 = this.vistaListaVehiculos.getjTextFieldEstatus().getText();
                llenarTablaListaVehiculos(p1, p2, p3);
            }

        }

        if (this.vistaListaClientes != null) {

            if (e.getSource() == this.vistaListaClientes.getjButtonNuevoCliente()) {
                abrirVistaFormCliente(null);

            } else if (e.getSource() == this.vistaListaClientes.getjButtonEditarCliente()) {
                try {
                    int fila = this.vistaListaClientes.getjTableListaClientes().getSelectedRow();
                    int idCliente = Integer.parseInt(this.vistaListaClientes.getjTableListaClientes().getValueAt(fila, 0).toString());
                    Cliente cliente = this.clienteDao.consultar_una_persona(idCliente);
                    abrirVistaFormCliente(cliente);
                } catch (FormatoEntradaException ex) {
                    System.out.println(ex);
                }

            } else if (e.getSource() == this.vistaListaClientes.getjButtonEliminarCliente()) {

                int indice = this.vistaListaClientes.getjTableListaClientes().getSelectedRow();
                int id = Integer.parseInt(this.vistaListaClientes.getjTableListaClientes().getValueAt(indice, 0).toString());
                int opcion = JOptionPane.showConfirmDialog(this.vistaListaClientes, "ESTA SEGURO DE ELIMINAR EL REGISTRO ?");

                if (opcion == JOptionPane.YES_OPTION) {
                    clienteDao.eliminar_cliente(id);
                    JOptionPane.showMessageDialog(this.vistaListaClientes, "CLIENTE ELIMINADO CON EXITO!");
                    llenarTablaClientes();
                }
            }
        }

    }

    @Override
    public void update(Observable arg0, Object tiempo) {

        this.tiempo = (Hora) tiempo;
        VistaPrincipal.jLabelReloj.setText(this.tiempo.toString());
        if (this.formularioRegistro != null) {
            this.formularioRegistro.getjTextFieldFechaEntrega().setText(tiempo.toString());
        }
    }

    private void abrirVistaFormCliente(Cliente cliente) {

        if (this.formularioCliente == null) {
            this.principal.pack();
            this.principal.setLocationRelativeTo(null);
            cerrarTodasLasVentantas();
            this.formularioCliente = new FormularioCliente();
            this.formularioCliente.getjButtonCerrar().addActionListener(this);
            this.formularioCliente.getjButtonGuardarCliente().addActionListener(this);
            centrarjInternalFrame(this.formularioCliente, VistaPrincipal.jDesktopPane);

            if (cliente != null) {
                llenarFormularioCliente(cliente);
            }

            this.formularioCliente.setVisible(true);

            VistaPrincipal.jDesktopPane.add(this.formularioCliente);
        }
    }

    @Override
    public void focusGained(FocusEvent arg0) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == this.formularioRegistro.getjTextFieldIdentificacion()) {
            try {

                if (!formularioRegistro.getjTextFieldIdentificacion().getText().isEmpty()) {

                    Cliente cliente = this.clienteDao.consultar_una_persona(this.formularioRegistro.getjTextFieldIdentificacion().getText());

                    if (cliente == null) {

                        int opcion = JOptionPane.showConfirmDialog(this.formularioRegistro, "CLIENTE NO EXISTE EN LA BASE DE DATOS\n DESEA REGISTRARLO ?");

                        if (opcion == 0) {
                            abrirVistaFormCliente(cliente);
                        }

                    } else {
                        System.out.println("focus else cliente");
                        if (cliente.getNumeroFactura() != 0) {
                            System.out.println("no hay cliente sin alquilres");
                            cliente.setNumeroFactura(0);
                            this.clienteDao.crear_cliente(cliente);
                            cliente = this.clienteDao.consultar_una_persona(cliente.getIdentificacion());
                        }

                        this.formularioRegistro.getjLabelIdCliente().setText(String.valueOf(cliente.getIdCliente()));
                        this.formularioRegistro.getjTextFieldNombreCompleto().setText(cliente.getNombre() + " " + cliente.getApellido());
                        this.formularioRegistro.getjTextFieldTelefono().setText(cliente.getTelefono());
                        this.alquilerDao.getAlquiler().setCliente(cliente);
                    }
                }
            } catch (FormatoEntradaException ex) {
                System.out.println(ex);
            }

        }

    }

    private void abrirVistaFormVehiculo(Vehiculo vehiculo) {
        if (this.formularioVehiculo == null) {
            this.principal.pack();
            this.principal.setLocationRelativeTo(null);
            cerrarTodasLasVentantas();
            this.formularioVehiculo = new FormularioVehiculo();
            this.formularioVehiculo.getjButtonGuardarVehiculo().addActionListener(this);
            this.formularioVehiculo.getjButtonCerrar().addActionListener(this);
            this.formularioVehiculo.getjRadioButtonTipoAuto().addActionListener(this);
            this.formularioVehiculo.getjRadioButtonTipoCamioneta().addActionListener(this);
            centrarjInternalFrame(this.formularioVehiculo, VistaPrincipal.jDesktopPane);

            if (vehiculo != null) {
                llenarVehiculoForm(vehiculo);
            }
            this.formularioVehiculo.setVisible(true);
            VistaPrincipal.jDesktopPane.add(this.formularioVehiculo);
        }
    }

    private void abrirVistaFormRegistro() {
        if (this.formularioRegistro == null) {
            this.principal.pack();
            cerrarTodasLasVentantas();
            this.principal.setLocationRelativeTo(null);
            this.formularioRegistro = new FormularioRegistrarAlquiler();
            this.formularioRegistro.getjButtonAgregarVehiculo().addActionListener(this);
            this.formularioRegistro.getjButtonBuscar().addActionListener(this);
            this.formularioRegistro.getjButtonCerrrar().addActionListener(this);
            this.formularioRegistro.getjButtonGuardarAlquiler().addActionListener(this);
            this.formularioRegistro.getjButtonSalirBusquedad().addActionListener(this);
            this.formularioRegistro.getjTextFieldIdentificacion().addFocusListener(this);
            centrarjInternalFrame(this.formularioRegistro, VistaPrincipal.jDesktopPane);
            this.formularioRegistro.setVisible(true);
            VistaPrincipal.jDesktopPane.add(this.formularioRegistro);
        }
    }

    private void abrirVistaListaVehiculos() {
        if (this.vistaListaVehiculos == null) {
            cerrarTodasLasVentantas();
            this.vistaListaVehiculos = new VistaListaVehiculos();
            this.vistaListaVehiculos.getjButtonNuevoVehiculo().addActionListener(this);
            this.vistaListaVehiculos.getjButtonEditarVehiculo().addActionListener(this);
            this.vistaListaVehiculos.getjButtonEliminarVehiculo().addActionListener(this);
            this.vistaListaVehiculos.getjButtonEntregado().addActionListener(this);
            this.vistaListaVehiculos.getjButtonBuscarPor().addActionListener(this);
            llenarTablaListaVehiculos("", "", "");
            this.principal.setSize(this.vistaListaVehiculos.getSize().width, this.principal.getSize().height);
            VistaPrincipal.jDesktopPane.setSize(this.vistaListaVehiculos.getSize().width, VistaPrincipal.jDesktopPane.getSize().height);
            this.principal.setLocationRelativeTo(null);
            centrarjInternalFrame(this.vistaListaVehiculos, VistaPrincipal.jDesktopPane);
            this.vistaListaVehiculos.setLocation(this.vistaListaVehiculos.getLocation().x, this.vistaListaVehiculos.getLocation().y - 20);
            this.vistaListaVehiculos.setVisible(true);
            VistaPrincipal.jDesktopPane.add((this.vistaListaVehiculos));

        }
    }

    private void abrirVistaListaVehiculoJPanelView() {

        if (this.vistaListaVehiculosJPanel == null) {
            this.vistaListaVehiculosJPanel = new VistaListaVehiculosJPanel();
            llenarTablaListaVehiculos1();
            this.vistaListaVehiculosJPanel.getjButtonAgregarVehiculo().addActionListener(this);
            this.vistaListaVehiculosJPanel.getjButtonCerrarVentanaListaV().addActionListener(this);
            FormularioRegistrarAlquiler.jPanelRg.setVisible(false);
            this.vistaListaVehiculosJPanel.setSize(new Dimension(600, 200));
            FormularioRegistrarAlquiler.jPanelCambioJPanel.setSize(new Dimension(00, 290));
            FormularioRegistrarAlquiler.jPanelCambioJPanel.add(this.vistaListaVehiculosJPanel);
            FormularioRegistrarAlquiler.jPanelCambioJPanel.revalidate();
            FormularioRegistrarAlquiler.jPanelCambioJPanel.repaint();
        }

    }

    private void abrirVistaListaClientes() {
        if (this.vistaListaClientes == null) {
            cerrarTodasLasVentantas();
            this.vistaListaClientes = new VistaListaClientes();
            this.vistaListaClientes.getjButtonNuevoCliente().addActionListener(this);
            this.vistaListaClientes.getjButtonEditarCliente().addActionListener(this);
            this.vistaListaClientes.getjButtonEliminarCliente().addActionListener(this);
            this.vistaListaClientes.getjButtonNuevoCliente().addActionListener(this);
            llenarTablaClientes();
            this.principal.setSize(this.vistaListaClientes.getSize().width, this.principal.getSize().height);
            VistaPrincipal.jDesktopPane.setSize(this.vistaListaClientes.getSize().width, VistaPrincipal.jDesktopPane.getSize().height);
            this.principal.setLocationRelativeTo(null);
            centrarjInternalFrame(this.vistaListaClientes, VistaPrincipal.jDesktopPane);
            this.vistaListaClientes.setLocation(this.vistaListaClientes.getLocation().x, this.vistaListaClientes.getLocation().y - 20);
            this.vistaListaClientes.setVisible(true);
            VistaPrincipal.jDesktopPane.add((this.vistaListaClientes));

        }
    }

    private void abrirVistaListaAlquileres() {
        if (this.vistaListaAlquiler == null) {
            cerrarTodasLasVentantas();
            this.vistaListaAlquiler = new VistaListaAlquiler();
            this.principal.setSize(this.vistaListaAlquiler.getSize().width, this.principal.getSize().height);
            VistaPrincipal.jDesktopPane.setSize(this.vistaListaAlquiler.getSize().width, VistaPrincipal.jDesktopPane.getSize().height);
            this.principal.setLocationRelativeTo(null);
            centrarjInternalFrame(this.vistaListaAlquiler, VistaPrincipal.jDesktopPane);
            this.vistaListaAlquiler.setLocation(this.vistaListaAlquiler.getLocation().x, this.vistaListaAlquiler.getLocation().y - 20);
            this.vistaListaAlquiler.setVisible(true);
            VistaPrincipal.jDesktopPane.add((this.vistaListaAlquiler));

        }
    }

    private void centrarjInternalFrame(JInternalFrame jInternalFrame, JDesktopPane jDesktopPane) {
        int x = (jDesktopPane.getWidth() / 2) - (jInternalFrame.getWidth() / 2);
        int y = jDesktopPane.getHeight() / 2 - jInternalFrame.getHeight() / 2;
        jInternalFrame.setLocation(x, y);
    }

    private void cerrarTodasLasVentantas() {
        if (this.formularioVehiculo != null) {
            this.formularioVehiculo.dispose();
            this.formularioVehiculo = null;
        }

        if (this.formularioCliente != null) {
            this.formularioCliente.dispose();
            this.formularioCliente = null;
        }

        if (this.formularioRegistro != null) {
            this.formularioRegistro.dispose();
            this.formularioRegistro = null;
        }

        if (this.vistaListaAlquiler != null) {
            this.vistaListaAlquiler.dispose();
            this.vistaListaAlquiler = null;
        }

        if (this.vistaListaClientes != null) {
            this.vistaListaClientes.dispose();
            this.vistaListaClientes = null;
        }

        if (this.vistaListaVehiculos != null) {
            this.vistaListaVehiculos.dispose();
            this.vistaListaVehiculos = null;
        }

        if (this.vistaListaVehiculosJPanel != null) {
            this.vistaListaVehiculosJPanel.setVisible(false);
            this.vistaListaVehiculosJPanel = null;
        }
    }

    private void cerrarVentanaListaVehiculoJPanel() {

        this.vistaListaVehiculosJPanel.setVisible(false);
        FormularioRegistrarAlquiler.jPanelRg.setVisible(true);
        this.vistaListaVehiculosJPanel = null;
    }

    /**
     * Verifica si el RadioButton con la descripcion Auto esta seleccionada.
     * Asigna el valor de false al RadioButton con la descripcion Camioneta.
     *
     */
    private void controlarRadioButtonAuto() {
        if (this.formularioVehiculo.getjRadioButtonTipoAuto().isSelected()) {
            this.formularioVehiculo.getjRadioButtonTipoCamioneta().setSelected(false);
        } else {
            this.formularioVehiculo.getjRadioButtonTipoAuto().setSelected(false);
        }
    }

    /**
     * Verifica si el RadioButton con la descripcion Camioneta esta seleccionada
     * Asigna el valor de false al RadioButton con la descripcion Auto
     *
     */
    private void controlarRadioButtonCamioneta() {
        if (this.formularioVehiculo.getjRadioButtonTipoCamioneta().isSelected()) {
            this.formularioVehiculo.getjRadioButtonTipoAuto().setSelected(false);
        } else {
            this.formularioVehiculo.getjRadioButtonTipoCamioneta().setSelected(false);
        }
    }

    private void guardarRegistroCliente() {

        try {
            Cliente cliente = new Cliente();
            String id_cliente = this.formularioCliente.getjTextFieldIdCliente().getText();
            if (!id_cliente.isEmpty()) {
                cliente.setIdCliente(Integer.parseInt(id_cliente));
            }

            cliente.setIdentificacion(this.formularioCliente.getjTextFieldIdentificacion().getText());
            cliente.setNombre(this.formularioCliente.getjTextFieldNombre().getText());
            cliente.setApellidoCliente(this.formularioCliente.getjTextFieldApellido().getText());
            cliente.setTelefonoCliente(this.formularioCliente.getjTextFieldTelefono().getText());
            cliente.setStatus(1);
            if (!id_cliente.isEmpty()) {
                this.clienteDao.actualizar_cliente(cliente);
            } else {
                this.clienteDao.crear_cliente(cliente);
            }

            JOptionPane.showMessageDialog(this.formularioCliente, "CLIENTE REGISTRADO CON EXITO");
            limpiarCamposClienteForm();

            if (this.formularioRegistro != null) {
//            this.registrarAlquilerForm.getjTextField2IDCli().setEditable(false);
//            this.registrarAlquilerForm.getjTextField1NomCli().setEditable(false);
//            this.registrarAlquilerForm.getjTextField3TelCli().setEditable(false);
//            this.registrarAlquilerForm.getjTextField2IDCli().setText(cliente.getIdentificacion());
//            this.registrarAlquilerForm.getjTextField1NomCli().setText(cliente.getNombre());
//            this.registrarAlquilerForm.getjTextField3TelCli().setText(cliente.getTelefono());
//            this.formularioCliente.dispose();
            }
        } catch (FormatoEntradaException ex) {
            JOptionPane.showMessageDialog(this.formularioCliente, ex);
        }

    }

    private void agregarVehiculoAlDetalle() {
        if (this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().getRowCount() > 0) {

            int columna = 0;
            Alquiler alquiler;
            Vehiculo vehiculo;
            DefaultTableModel model = (DefaultTableModel) this.formularioRegistro.getjTableDetalleAlquiler().getModel();
            DefaultTableModel model1 = (DefaultTableModel) this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().getModel();

            int fila = this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().getSelectedRow();
            int fila2 = this.formularioRegistro.getjTableDetalleAlquiler().getRowCount();

            if (fila >= 0) {
                try {
                    int id = Integer.parseInt(model1.getValueAt(fila, 0).toString());
                    alquiler = new Alquiler();
                    vehiculo = this.vehiculoDao.consultar_un_vehiculo(id);
                    vehiculo.setEstadoVehiculo(2);
                    this.vehiculoDao.actualizar_vehiculo(vehiculo);
                    alquiler.setValorAlquiler(vehiculo);
                    alquiler.setRecaudo(new Recaudo());
                    alquiler.getRecaudo().setValorSubtotalRecaudo(alquiler.getDIAS_ALQUILER(), alquiler.calcularValorSeguro(), alquiler.getValorAlquiler());
                    model.addRow(new Object[]{});
                    model.setValueAt(vehiculo.getIdVehiculo(), fila2, columna++);
                    model.setValueAt(vehiculo.getDescripcionVehiculo() + " " + vehiculo.getDescripcionGeneralVehiculo(), fila2, columna++);
                    model.setValueAt(alquiler.getDIAS_ALQUILER(), fila2, columna++);
                    model.setValueAt(alquiler.getValorAlquiler(), fila2, columna++);
                    model.setValueAt(alquiler.calcularValorSeguro(), fila2, columna++);
                    model.setValueAt(alquiler.getRecaudo().getValorSubtotalRecaudo(), fila2, columna);
                    double valor = Double.parseDouble(this.formularioRegistro.getjTextFieldTotalAPagar().getText()) + alquiler.getRecaudo().getValorSubtotalRecaudo();
                    this.formularioRegistro.getjTextFieldTotalAPagar().setText(String.valueOf(valor));
                    model1.removeRow(fila);
                    this.formularioRegistro.getjTableDetalleAlquiler().setModel(model);
                    this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().setModel(model1);
                } catch (FormatoEntradaException ex) {
                    JOptionPane.showMessageDialog(this.formularioRegistro, ex);
                }
            }
        }

    }

    private void actualizarVehiculosClientes(int caso, Cliente cliente, List<Vehiculo> vehiculos, int numeroFactura) {

        try {

            if (cliente != null) {
                if (caso == 1) {
                    cliente.setNumeroFactura(numeroFactura);
                } else {
                    cliente.setNumeroFactura(0);
                }
                this.clienteDao.actualizar_cliente(cliente);
            }

            if (vehiculos != null) {
                for (Vehiculo v : vehiculos) {
                    if (caso == 1) {
                        v.setNumeroFactura(numeroFactura);
                        v.setEstadoVehiculo(0);
                    } else {
                        v.setNumeroFactura(0);
                        v.setEstadoVehiculo(1);
                    }
                    this.vehiculoDao.actualizar_vehiculo(v);
                }
            }
        } catch (FormatoEntradaException ex) {
            System.out.println(ex);
        }
    }

    private void guardarRegistroAlquiler() {

        Cliente cliente = null;
        List<Vehiculo> listaVehiculo = null;
        Recaudo recaudo = null;
        String id_cliente = this.formularioRegistro.getjLabelIdCliente().getText();
        try {

            if (!id_cliente.isEmpty()) {
                cliente = this.clienteDao.consultar_una_persona(Integer.parseInt(id_cliente));
            }
            if (this.formularioRegistro.getjTableDetalleAlquiler().getRowCount() > 0) {
                listaVehiculo = new ArrayList<>();
                Vehiculo vehiculo;
                for (int i = 0; i < this.formularioRegistro.getjTableDetalleAlquiler().getRowCount(); i++) {
                    vehiculo = vehiculoDao.consultar_un_vehiculo(Integer.parseInt(this.formularioRegistro.getjTableDetalleAlquiler().getValueAt(i, 0).toString()));
                    if (vehiculo.getNumeroFactura() != 0) {
                        vehiculo.setEstadoVehiculo(1);
                        vehiculo.setNumeroFactura(0);
                        this.vehiculoDao.crear_vehiculo(vehiculo);
                        vehiculo = this.vehiculoDao.consultar_un_vehiculo_por_placa(vehiculo.getPlacasVehiculo());
                    }

                    listaVehiculo.add(vehiculo);
                    System.out.println("tamanio a guardar vehiculo aluiler: " + listaVehiculo.size());
                }
            }

            if (!this.formularioRegistro.getjTextFieldTotalAPagar().getText().isEmpty()) {
                recaudo = new Recaudo();
                recaudo.setValorTotalRecuado(Double.parseDouble(this.formularioRegistro.getjTextFieldTotalAPagar().getText()));
            }

            this.alquilerDao.getAlquiler().setCliente(cliente);
            this.alquilerDao.getAlquiler().setListaVehiculos(listaVehiculo);
            this.alquilerDao.getAlquiler().setFecha(new Fecha(new Date()));
            this.alquilerDao.getAlquiler().setHora(this.tiempo);
            this.alquilerDao.getAlquiler().setRecaudo(recaudo);

            this.alquilerDao.crear_alquiler(this.alquilerDao.getAlquiler());
            this.formularioRegistro.getjTextFieldNoRecibo().setText(String.valueOf(this.alquilerDao.getAlquiler().getNumeroRecibo()));

            JOptionPane.showMessageDialog(this.formularioRegistro,
                    "Alquiler registrado con Exito\n" + "Numero de Recibo: " + this.alquilerDao.getAlquiler().getNumeroRecibo() + "\n"
                    + this.tiempo.toString());
            actualizarVehiculosClientes(1, cliente, listaVehiculo, this.alquilerDao.getAlquiler().getNumeroRecibo());

            this.alquilerDao.setAlquiler(new Alquiler());
        } catch (FormatoEntradaException ex) {
            actualizarVehiculosClientes(0, cliente, listaVehiculo, 0);
            JOptionPane.showMessageDialog(this.formularioRegistro, ex);
        }

    }

    private void guardarRegistroVehiculo() {

        Vehiculo tipoVehiculo;
        String tipVehiculo;

        try {

            if (this.formularioVehiculo.getjRadioButtonTipoAuto().isSelected()) {
                tipoVehiculo = new TipoAuto();
                tipVehiculo = "Auto";
            } else {
                tipoVehiculo = new TipoCamioneta();
                tipVehiculo = "Camioneta";
            }
            tipoVehiculo.setPlacasVehiculo(this.formularioVehiculo.getjTextFieldPlaca().getText());
            tipoVehiculo.setKilometrajeVehiculo(Double.parseDouble(this.formularioVehiculo.getjTextFieldKilometraje().getText()));
            tipoVehiculo.setDescripcionVehiculo(tipVehiculo);
            tipoVehiculo.setDescripcionGeneralVehiculo(this.formularioVehiculo.getjTextFieldDescripcion().getText());
            tipoVehiculo.setEstadoVehiculo(1);

            String id = this.formularioVehiculo.getjTextFieldIdVehiculo().getText();
            if (id.isEmpty()) {
                this.vehiculoDao.crear_vehiculo(tipoVehiculo);
                JOptionPane.showMessageDialog(this.formularioVehiculo, "VEHICULO REGISTRADO");
            } else {

                tipoVehiculo.setIdVehiculo(Integer.parseInt(id));
                this.vehiculoDao.actualizar_vehiculo(tipoVehiculo);
                JOptionPane.showMessageDialog(this.formularioVehiculo, "VEHICULO ACTUALIZADO");
            }

            limpiarCamposVehiculoForm();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this.formularioVehiculo, "Error 101, generado por,\nExisten campos en blanco\nCampo kilometraje");
        } catch (FormatoEntradaException ex) {
            JOptionPane.showMessageDialog(this.formularioVehiculo, ex);
        }
    }

    private void limpiarCamposClienteForm() {
        this.formularioCliente.getjTextFieldIdCliente().setText("");
        this.formularioCliente.getjTextFieldIdentificacion().setText("");
        this.formularioCliente.getjTextFieldNombre().setText("");
        this.formularioCliente.getjTextFieldApellido().setText("");
        this.formularioCliente.getjTextFieldTelefono().setText("");
    }

    private void limpiarCamposVehiculoForm() {
        this.formularioVehiculo.getjTextFieldIdVehiculo().setText("");
        this.formularioVehiculo.getjTextFieldPlaca().setText("");
        this.formularioVehiculo.getjTextFieldKilometraje().setText("");
        this.formularioVehiculo.getjTextFieldDescripcion().setText("");
        this.formularioVehiculo.getjRadioButtonTipoAuto().setSelected(false);
        this.formularioVehiculo.getjRadioButtonTipoCamioneta().setSelected(false);
    }

    private void limpiarTablaListaClientes() {
        int filas = this.vistaListaClientes.getjTableListaClientes().getRowCount();
        if (filas > 0) {
            for (int i = 0; i < filas; i++) {
                DefaultTableModel model = (DefaultTableModel) this.vistaListaClientes.getjTableListaClientes().getModel();
                model.removeRow(0);
            }
        }
    }

    private void llenarFormularioCliente(Cliente cliente) {
        this.formularioCliente.getjTextFieldIdCliente().setText(String.valueOf(cliente.getIdCliente()));
        this.formularioCliente.getjTextFieldIdentificacion().setText(cliente.getIdentificacion());
        this.formularioCliente.getjTextFieldNombre().setText(cliente.getNombre());
        this.formularioCliente.getjTextFieldApellido().setText(cliente.getApellido());
        this.formularioCliente.getjTextFieldTelefono().setText(cliente.getTelefono());
    }

    private void llenarVehiculoForm(Vehiculo vehiculo) {
        this.formularioVehiculo.getjTextFieldIdVehiculo().setVisible(false);
        this.formularioVehiculo.getjTextFieldIdVehiculo().setText(String.valueOf(vehiculo.getIdVehiculo()));
        this.formularioVehiculo.getjTextFieldPlaca().setText(vehiculo.getPlacasVehiculo());
        this.formularioVehiculo.getjTextFieldKilometraje().setText(String.valueOf(vehiculo.getKilometrajeVehiculo()));
        this.formularioVehiculo.getjTextFieldDescripcion().setText(vehiculo.getDescripcionGeneralVehiculo());

        if (vehiculo.getDescripcionVehiculo().equalsIgnoreCase("Auto")) {
            this.formularioVehiculo.getjRadioButtonTipoAuto().setSelected(true);
            this.formularioVehiculo.getjRadioButtonTipoCamioneta().setSelected(false);
        } else {
            this.formularioVehiculo.getjRadioButtonTipoAuto().setSelected(false);
            this.formularioVehiculo.getjRadioButtonTipoCamioneta().setSelected(true);
        }
    }

    /**
     * Verifica si la lista de tipo Vehiculos no esta vacia. Recorre la lista de
     * tipo Vehiculo y agrega a cada valor en el JTable de la clase
     * DetalleVehiculoView.
     *
     */
    private void llenarTablaListaVehiculos(String p1, String p2, String p3) {

        System.out.println("parametros de busquedad:  " + p1+"  "+p2+ ""+p3+"\n");
        
        List<Vehiculo> listaVehiculos = this.vehiculoDao.consultar_vehiculos();

        if (listaVehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(this.vistaListaVehiculos, "NO SE ENCUENTRAN VEHICULOS DISPONIBLES");
        } else {
            int columna = 0;
            int fila = 0;
            int indice = -1;
            DefaultTableModel model = (DefaultTableModel) this.vistaListaVehiculos.getjTableListaVehiculos().getModel();
            limpiarTablaListaVehiculos();

            this.vistaListaVehiculos.getjTableListaVehiculos().getColumnModel().getColumn(0).setMaxWidth(0);
            this.vistaListaVehiculos.getjTableListaVehiculos().getColumnModel().getColumn(0).setMinWidth(0);
            this.vistaListaVehiculos.getjTableListaVehiculos().getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            this.vistaListaVehiculos.getjTableListaVehiculos().getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

            for (int i = 0; i < listaVehiculos.size(); i++) {

                if (p1.isEmpty() && p2.isEmpty() && p3.isEmpty()) {
                    indice = i;
                } else {
                    if (String.valueOf(listaVehiculos.get(i).getNumeroFactura()).contains(p1)&&!p1.isEmpty()) {
                        indice = i;
                    } else if (listaVehiculos.get(i).getDescripcionVehiculo().contains(p2)&&!p2.isEmpty()) {
                        indice = i;
                        
                    } else if (!p3.isEmpty()) {
                        int var;
                        var =  "Alquilado".contains(p3) ? 0 : "Disponible".contains(p3) ? 1 : "Entregado".contains(p3) ? 3 : -1; 
                        if(!p3.isEmpty() && listaVehiculos.get(i).getEstadoVehiculo() == var){
                            indice = i;
                        }
                    }
                }
                if (indice == i) {
                    model.addRow(new Object[]{});
                    this.vistaListaVehiculos.getjTableListaVehiculos().setValueAt(listaVehiculos.get(indice).getIdVehiculo(), fila, columna++);
                    this.vistaListaVehiculos.getjTableListaVehiculos().setValueAt(indice + 1, fila, columna++);
                    this.vistaListaVehiculos.getjTableListaVehiculos().setValueAt(listaVehiculos.get(indice).getDescripcionVehiculo(), fila, columna++);
                    this.vistaListaVehiculos.getjTableListaVehiculos().setValueAt(listaVehiculos.get(indice).getDescripcionGeneralVehiculo(), fila, columna++);
                    this.vistaListaVehiculos.getjTableListaVehiculos().setValueAt(listaVehiculos.get(indice).getPlacasVehiculo(), fila, columna++);
                    this.vistaListaVehiculos.getjTableListaVehiculos().setValueAt(listaVehiculos.get(indice).getKilometrajeVehiculo(), fila, columna++);
                    this.vistaListaVehiculos.getjTableListaVehiculos().setValueAt(listaVehiculos.get(indice).getEstadoVehiculo() == 1 ? "Disponible"
                            : listaVehiculos.get(i).getEstadoVehiculo() == 3 ? "Entregado" : "Alquilado", fila, columna++);
                    this.vistaListaVehiculos.getjTableListaVehiculos().setValueAt(listaVehiculos.get(indice).getNumeroFactura(), fila++, columna++);
                    columna = 0;
                }
            }
        }
    }

    private void llenarTablaListaVehiculos1() {

        List<Vehiculo> listaVehiculos = this.vehiculoDao.consultar_vehiculos();

        if (listaVehiculos.isEmpty()) {
            JOptionPane.showMessageDialog(this.vistaListaVehiculosJPanel, "NO SE ENCUENTRAN VEHICULOS DISPONIBLES");
        } else {
            int columna = 0;
            int fila = 0;
            DefaultTableModel model = (DefaultTableModel) this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().getModel();
            limpiarTablaListaVehicuos1();

            this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().getColumnModel().getColumn(0).setMaxWidth(0);
            this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().getColumnModel().getColumn(0).setMinWidth(0);
            this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

            for (int i = 0; i < listaVehiculos.size(); i++) {
                if (listaVehiculos.get(i).getEstadoVehiculo() == 1) {
                    model.addRow(new Object[]{});
                    this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().setValueAt(listaVehiculos.get(i).getIdVehiculo(), fila, columna++);
                    this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().setValueAt(listaVehiculos.get(i).getDescripcionVehiculo(), fila, columna++);
                    this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().setValueAt(listaVehiculos.get(i).getDescripcionGeneralVehiculo(), fila, columna++);
                    this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().setValueAt(listaVehiculos.get(i).getKilometrajeVehiculo(), fila, columna++);
                    this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().setValueAt(listaVehiculos.get(i).getPlacasVehiculo(), fila, columna++);
                    this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().setValueAt(listaVehiculos.get(i).getEstadoVehiculo() == 1 ? "Disponible"
                            : listaVehiculos.get(i).getEstadoVehiculo() == 3 ? "Entregado" : "Alquilado", fila++, columna);
                }
                columna = 0;
            }
        }
    }

    private void llenarTablaClientes() {

        List<Cliente> listaClientes = this.clienteDao.consultar_clientes();

        if (listaClientes == null) {
            JOptionPane.showMessageDialog(this.vistaListaClientes, "NO SE ENCUENTRAN CLIENTES DISPONIBLES");
            cerrarTodasLasVentantas();

        } else {
            int columna = 0;
            int fila = 0;

            DefaultTableModel model = (DefaultTableModel) this.vistaListaClientes.getjTableListaClientes().getModel();
            limpiarTablaListaClientes();

            this.vistaListaClientes.getjTableListaClientes().getColumnModel().getColumn(0).setMaxWidth(0);
            this.vistaListaClientes.getjTableListaClientes().getColumnModel().getColumn(0).setMinWidth(0);
            this.vistaListaClientes.getjTableListaClientes().getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            this.vistaListaClientes.getjTableListaClientes().getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

            for (int i = 0; i < listaClientes.size(); i++) {
                model.addRow(new Object[]{});
                this.vistaListaClientes.getjTableListaClientes().setValueAt(listaClientes.get(i).getIdCliente(), fila, columna++);
                this.vistaListaClientes.getjTableListaClientes().setValueAt(i + 1, fila, columna++);
                this.vistaListaClientes.getjTableListaClientes().setValueAt(listaClientes.get(i).getIdentificacion(), fila, columna++);
                this.vistaListaClientes.getjTableListaClientes().setValueAt(listaClientes.get(i).getNombre(), fila, columna++);
                this.vistaListaClientes.getjTableListaClientes().setValueAt(listaClientes.get(i).getApellido(), fila, columna++);
                this.vistaListaClientes.getjTableListaClientes().setValueAt(listaClientes.get(i).getTelefono(), fila, columna++);
                this.vistaListaClientes.getjTableListaClientes().setValueAt(listaClientes.get(i).getStatus() == 1 ? "Activo"
                        : "Inactivo", fila, columna++);
                this.vistaListaClientes.getjTableListaClientes().setValueAt(listaClientes.get(i).getNumeroFactura(), fila, columna++);
                fila++;
                columna = 0;

            }
        }
    }

    private void limpiarTablaListaVehiculos() {
        int filas = this.vistaListaVehiculos.getjTableListaVehiculos().getRowCount();
        if (filas > 0) {
            for (int i = 0; i < filas; i++) {
                DefaultTableModel model = (DefaultTableModel) this.vistaListaVehiculos.getjTableListaVehiculos().getModel();
                model.removeRow(0);
            }
        }
    }

    private void limpiarTablaListaVehicuos1() {
        int filas = this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().getRowCount();
        if (filas > 0) {
            for (int i = 0; i < filas; i++) {
                DefaultTableModel model = (DefaultTableModel) this.vistaListaVehiculosJPanel.getjTableDetalleVehiculo().getModel();
                model.removeRow(0);
            }
        }
    }
}
