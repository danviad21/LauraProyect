/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.FormatoEntradaException;
import Modelo.TipoAuto;
import Modelo.TipoCamioneta;
import Modelo.Vehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura Zarathe
 */
public class VehiculoDao {

    private final String CREAR_NUEVO_VEHICULO = "INSERT INTO vehiculo"
            + " (descripcion_vehiculo, placa_vehiculo, kilometraje_vehiculo,"
            + "status_vehiculo,numero_factura, tipo_vehiculo) values (?,?,?,?,?,?)";
    private final String ACTUALIZAR_VEHICULO = "UPDATE vehiculo "
            + "SET descripcion_vehiculo = ?, placa_vehiculo = ?, "
            + "kilometraje_vehiculo = ?,status_vehiculo = ?, numero_factura = ?,"
            + "tipo_vehiculo = ? WHERE id_vehiculo = ?";
    private final String CONSULTAR_TODO = "SELECT * FROM vehiculo";
    private final String CONSULTAR_POR_ID_VEHICULO = "SELECT * FROM vehiculo WHERE id_vehiculo = ?";
    private final String CONSULTAR_VEHICULOS_POR_NUMERO_FACTURA = "SELECT * FROM vehiculo WHERE numero_factura = ?";
    private final String CONSULTAR_POR_PLACA_VEHICULO = "SELECT * FROM vehiculo WHERE placa_vehiculo LIKE ?";
    private final String ELIMINAR_VEHICULO = "DELETE FROM vehiculo WHERE id_vehiculo = ?";

    public void crear_vehiculo(Vehiculo vehiculo) throws FormatoEntradaException {
        try {
            int numeroParamtro = 1;
            PreparedStatement ps = Conexion.getConexion().prepareCall(CREAR_NUEVO_VEHICULO);
            ps.setString(numeroParamtro++, vehiculo.getDescripcionGeneralVehiculo());
            ps.setString(numeroParamtro++, vehiculo.getPlacasVehiculo());
            ps.setDouble(numeroParamtro++, vehiculo.getKilometrajeVehiculo());
            ps.setInt(numeroParamtro++, vehiculo.getEstadoVehiculo());
            ps.setInt(numeroParamtro++, vehiculo.getNumeroFactura() <= 0 ? 0 : vehiculo.getNumeroFactura());
            ps.setInt(numeroParamtro++, vehiculo.getDescripcionVehiculo().equalsIgnoreCase("Auto") ? 1 : 2);
            ps.execute();
        } catch (SQLException ex) {
            throw new FormatoEntradaException(ex.getErrorCode(), "Error al Insertar\nNuevo Vehiculo a la Base de datos\n" + ex.getMessage());
        } finally {
            Conexion.cerrarConexion();
        }
    }

    public void actualizar_vehiculo(Vehiculo vehiculo) throws FormatoEntradaException {

        try {
            int numeroParamtro = 1;
            PreparedStatement ps = Conexion.getConexion().prepareCall(ACTUALIZAR_VEHICULO);
            ps.setString(numeroParamtro++, vehiculo.getDescripcionGeneralVehiculo());
            ps.setString(numeroParamtro++, vehiculo.getPlacasVehiculo());
            ps.setDouble(numeroParamtro++, vehiculo.getKilometrajeVehiculo());
            ps.setInt(numeroParamtro++, vehiculo.getEstadoVehiculo());
            ps.setInt(numeroParamtro++, vehiculo.getNumeroFactura());
            ps.setInt(numeroParamtro++, vehiculo.getDescripcionVehiculo().equals("Auto") ? 1 : 2);
            ps.setLong(numeroParamtro, vehiculo.getIdVehiculo());
            ps.execute();
        } catch (SQLException ex) {
            throw new FormatoEntradaException(ex.getErrorCode(), "Error al Actualizar\nVehiculo en la base de datos\n" + ex.getMessage());
        } finally {
            Conexion.cerrarConexion();
        }
    }

    public void eliminar_vehiculo(int id) {

        try {

            PreparedStatement ps = Conexion.getConexion().prepareCall(ELIMINAR_VEHICULO);
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar Vehiculo en la base de datos: " + ex);
        } finally {
            Conexion.cerrarConexion();
        }
    }

    public Vehiculo consultar_un_vehiculo(int id) throws FormatoEntradaException {

        try {
            Vehiculo vehiculoTemp = null;
            PreparedStatement ps = Conexion.getConexion().prepareCall(CONSULTAR_POR_ID_VEHICULO);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            int indice = 1;
            while (rs.next()) {

                if (rs.getInt(6) == 1) {
                    vehiculoTemp = new TipoAuto();
                } else {
                    vehiculoTemp = new TipoCamioneta();
                }

                vehiculoTemp.setIdVehiculo(rs.getInt(indice++));
                vehiculoTemp.setDescripcionGeneralVehiculo(rs.getString(indice++));
                vehiculoTemp.setPlacasVehiculo(rs.getString(indice++));
                vehiculoTemp.setKilometrajeVehiculo(rs.getDouble(indice++));
                vehiculoTemp.setEstadoVehiculo(rs.getInt(indice++));
                vehiculoTemp.setDescripcionVehiculo(rs.getInt(indice++) == 1 ? "Auto" : "Camioneta");
                vehiculoTemp.setNumeroFactura(rs.getInt(indice++));
                if (vehiculoTemp.getNumeroFactura() == 0) {
                    return vehiculoTemp;
                }
                indice = 1;
            }
            return vehiculoTemp;
        } catch (SQLException ex) {
            throw new FormatoEntradaException(ex.getErrorCode(), ex.getMessage());
        } finally {
            Conexion.cerrarConexion();
        }
    }

    public List<Vehiculo> consultarVehiculoPorFactura(int id) throws FormatoEntradaException {

        try {
            List<Vehiculo> listaVehiculo = new ArrayList<>();
            Vehiculo vehiculoTemp;
            PreparedStatement ps = Conexion.getConexion().prepareCall(this.CONSULTAR_VEHICULOS_POR_NUMERO_FACTURA);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            int indice = 1;
            while (rs.next()) {
                if (rs.getInt(6) == 1) {
                    vehiculoTemp = new TipoAuto();
                } else {
                    vehiculoTemp = new TipoCamioneta();
                }

                vehiculoTemp.setIdVehiculo(rs.getInt(indice++));
                vehiculoTemp.setDescripcionGeneralVehiculo(rs.getString(indice++));
                vehiculoTemp.setPlacasVehiculo(rs.getString(indice++));
                vehiculoTemp.setKilometrajeVehiculo(rs.getDouble(indice++));
                vehiculoTemp.setEstadoVehiculo(rs.getInt(indice++));
                vehiculoTemp.setDescripcionVehiculo(rs.getInt(indice++) == 1 ? "Auto" : "Camioneta");
                vehiculoTemp.setNumeroFactura(rs.getInt(indice++));
                listaVehiculo.add(vehiculoTemp);
                indice = 1;
            }
            return listaVehiculo;
        } catch (SQLException ex) {
            throw new FormatoEntradaException(ex.getErrorCode(), ex.getMessage());
        } finally {
            Conexion.cerrarConexion();
        }
    }

    public Vehiculo consultar_un_vehiculo_por_placa(String placa) throws FormatoEntradaException {

        try {
            Vehiculo vehiculoTemp = null;
            PreparedStatement ps = Conexion.getConexion().prepareCall(CONSULTAR_POR_PLACA_VEHICULO);
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            int indice = 1;
            while (rs.next()) {

                if (rs.getInt(6) == 1) {
                    vehiculoTemp = new TipoAuto();
                } else {
                    vehiculoTemp = new TipoCamioneta();
                }

                vehiculoTemp.setIdVehiculo(rs.getInt(indice++));
                vehiculoTemp.setDescripcionGeneralVehiculo(rs.getString(indice++));
                vehiculoTemp.setPlacasVehiculo(rs.getString(indice++));
                vehiculoTemp.setKilometrajeVehiculo(rs.getDouble(indice++));
                vehiculoTemp.setEstadoVehiculo(rs.getInt(indice++));
                vehiculoTemp.setDescripcionVehiculo(rs.getInt(indice++) == 1 ? "Auto" : "Camioneta");
                vehiculoTemp.setNumeroFactura(rs.getInt(indice++));
                if (vehiculoTemp.getNumeroFactura() == 0) {
                    return vehiculoTemp;
                }
                indice = 1;
            }
            return vehiculoTemp;
        } catch (SQLException ex) {
            throw new FormatoEntradaException(ex.getErrorCode(), ex.getMessage());
        } finally {
            Conexion.cerrarConexion();
        }
    }

    public List<Vehiculo> consultar_vehiculos() {//YA QUEDO

        try {
            List<Vehiculo> listaVehiculoTemporal = new ArrayList();
            PreparedStatement ps = Conexion.getConexion().prepareCall(CONSULTAR_TODO);
            ResultSet rs = ps.executeQuery();
            int indice = 1;

            while (rs.next()) {
                Vehiculo vehiculoTemp;

                if (rs.getInt(6) == 1) {
                    vehiculoTemp = new TipoAuto();
                } else {
                    vehiculoTemp = new TipoCamioneta();
                }

                vehiculoTemp.setIdVehiculo(rs.getInt(indice++));
                vehiculoTemp.setDescripcionGeneralVehiculo(rs.getString(indice++));
                vehiculoTemp.setPlacasVehiculo(rs.getString(indice++));
                vehiculoTemp.setKilometrajeVehiculo(rs.getDouble(indice++));
                vehiculoTemp.setEstadoVehiculo(rs.getInt(indice++));
                vehiculoTemp.setDescripcionVehiculo(rs.getInt(indice++) == 1 ? "Auto" : "Camioneta");
                vehiculoTemp.setNumeroFactura(rs.getInt(indice++));
                listaVehiculoTemporal.add(vehiculoTemp);
                indice = 1;
            }
            return listaVehiculoTemporal;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        } catch (FormatoEntradaException ex) {
            System.out.println(ex);
            return null;
        } finally {
            Conexion.cerrarConexion();
        }
    }
}
