/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Cliente;
import Modelo.FormatoEntradaException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura Zarathe
 */
public class ClienteDao {

    private final String CREAR_NUEVO_CLIENTE = "INSERT INTO cliente"
            + " (identificacion_cliente, nombre_cliente, apellido_cliente,"
            + " telefono_cliente, status_cliente,numero_factura) values (?,?,?,?,?,?)";

    private final String ACTUALIZAR_CLIENTE = "UPDATE cliente SET identificacion_cliente = ?, nombre_cliente = ?, apellido_cliente = ?, telefono_cliente =?, numero_factura =? WHERE id_cliente = ?";
    private final String CONSULTAR_TODO = "SELECT * FROM cliente";
    private final String CONSULTAR_POR_ID_PERSONA = "SELECT * FROM cliente WHERE id_cliente = ?";
    private final String CONSULTAR_POR_IDENTIFICACION_PERSONA = "SELECT * FROM cliente WHERE identificacion_cliente LIKE ?";
    private final String ELIMINAR_CLIENTE = "DELETE FROM cliente WHERE id_cliente = ?";

    public ClienteDao() {

    }

    public void crear_cliente(Cliente cliente) throws FormatoEntradaException {
        try {
            int numeroParamtro = 1;
            PreparedStatement ps = Conexion.getConexion().prepareCall(CREAR_NUEVO_CLIENTE);
            ps.setString(numeroParamtro++, cliente.getIdentificacion());
            ps.setString(numeroParamtro++, cliente.getNombre());
            ps.setString(numeroParamtro++, cliente.getApellido());
            ps.setString(numeroParamtro++, cliente.getTelefono());
            ps.setInt(numeroParamtro++, cliente.getStatus());

            if (cliente.getNumeroFactura() < 0) {
                ps.setString(numeroParamtro, null);
            } else {
                ps.setInt(numeroParamtro, cliente.getNumeroFactura());
            }
            ps.execute();
        } catch (SQLException ex) {
            throw new FormatoEntradaException(ex.getErrorCode(), ex.getMessage());
        } finally {
            Conexion.cerrarConexion();
        }
    }

    public void actualizar_cliente(Cliente cliente) throws FormatoEntradaException {

        try {
            int numeroParamtro = 1;
            PreparedStatement ps = Conexion.getConexion().prepareCall(ACTUALIZAR_CLIENTE);
            ps.setString(numeroParamtro++, cliente.getIdentificacion());
            ps.setString(numeroParamtro++, cliente.getNombre());
            ps.setString(numeroParamtro++, cliente.getApellido());
            ps.setString(numeroParamtro++, cliente.getTelefono());
            ps.setInt(numeroParamtro++, cliente.getNumeroFactura());
            ps.setInt(numeroParamtro++, cliente.getIdCliente());
            ps.execute();
        } catch (SQLException ex) {
            throw new FormatoEntradaException(ex.getErrorCode(), ex.getMessage());
        }

    }

    public void eliminar_cliente(int id) {

        try {

            PreparedStatement ps = Conexion.getConexion().prepareCall(ELIMINAR_CLIENTE);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar Cliente en la base de datos: " + ex);
        } finally {
            Conexion.cerrarConexion();
        }
    }

    public Cliente consultar_una_persona(int id) throws FormatoEntradaException {

        try {

            Cliente clienteTemp = new Cliente();
            PreparedStatement ps = Conexion.getConexion().prepareCall(CONSULTAR_POR_ID_PERSONA);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            int indice = 1;
            while (rs.next()) {
                clienteTemp = new Cliente();
                clienteTemp.setIdCliente(rs.getInt(indice++));
                clienteTemp.setIdentificacion(rs.getString(indice++));
                clienteTemp.setNombre(rs.getString(indice++));
                clienteTemp.setApellidoCliente(rs.getString(indice++));
                clienteTemp.setTelefonoCliente(rs.getString(indice++));
                clienteTemp.setStatus(rs.getInt(indice++));
                clienteTemp.setNumeroFactura(rs.getInt(indice));
                if(clienteTemp.getNumeroFactura() ==0){
                    return clienteTemp;
                }
                indice=1;
            }
            return clienteTemp;
        } catch (SQLException ex){
            throw new FormatoEntradaException(ex.getErrorCode(),ex.getMessage());
        } finally {
            Conexion.cerrarConexion();
        }
    }

    public Cliente consultar_una_persona(String identificacion) throws FormatoEntradaException {

        try {
            Cliente clienteTemp = null;
            PreparedStatement ps = Conexion.getConexion().prepareCall(CONSULTAR_POR_IDENTIFICACION_PERSONA);
            ps.setString(1, identificacion);
            ResultSet rs = ps.executeQuery();
            int indice = 1;
            while (rs.next()) {
                clienteTemp = new Cliente();
                clienteTemp.setIdCliente(rs.getInt(indice++));
                clienteTemp.setIdentificacion(rs.getString(indice++));
                clienteTemp.setNombre(rs.getString(indice++));
                clienteTemp.setApellidoCliente(rs.getString(indice++));
                clienteTemp.setTelefonoCliente(rs.getString(indice++));
                clienteTemp.setStatus(rs.getInt(indice++));                
                clienteTemp.setNumeroFactura(rs.getInt(indice));
                if(clienteTemp.getNumeroFactura() ==0){
                    return clienteTemp;
                }
                indice=1;
            }
            return clienteTemp;
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new FormatoEntradaException(ex.getErrorCode(), ex.getMessage());
        }finally{
            Conexion.cerrarConexion();
        }

    }

    public List<Cliente> consultar_clientes() {

        try {
            List<Cliente> listaClientesTemporal = new ArrayList();
            PreparedStatement ps = Conexion.getConexion().prepareCall(CONSULTAR_TODO);
            ResultSet rs = ps.executeQuery();
            int indice = 1;

            while (rs.next()) {
                Cliente clienteTemp = new Cliente();
                clienteTemp.setIdCliente(rs.getInt(indice++));
                clienteTemp.setIdentificacion(rs.getString(indice++));
                clienteTemp.setNombre(rs.getString(indice++));
                clienteTemp.setApellidoCliente(rs.getString(indice++));
                clienteTemp.setTelefonoCliente(rs.getString(indice++));
                clienteTemp.setStatus(rs.getInt(indice++));
                listaClientesTemporal.add(clienteTemp);
                indice = 1;
            }
            return listaClientesTemporal;
        } catch (SQLException | FormatoEntradaException ex) {
            System.out.println(ex);
            return null;
        } finally {
            Conexion.cerrarConexion();
        }
    }
}
