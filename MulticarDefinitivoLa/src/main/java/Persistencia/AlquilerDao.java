/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Alquiler;
import Modelo.Cliente;
import Modelo.Fecha;
import Modelo.FormatoEntradaException;
import Modelo.Hora;
import Modelo.Recaudo;
import Modelo.TipoAuto;
import Modelo.TipoCamioneta;
import Modelo.Vehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura Zarathe
 */
public class AlquilerDao {

    private final String CREAR_NUEVO_ALQUILER = "INSERT INTO alquiler"
            + " (numero_recibo,nombre_cliente, tipo_vehiculo, vehiculo,"
            + " dias_alquilados, precio_alquiler, seguro, fecha_entrega,"
            + "hora_entrega,fecha_devuelta,hora_devuelta,total_pagar)"
            + " values (?,?,?,?,?,?,?,?,?,?,?,?)";

    private final String ACTUALIZAR_ALQUILER = "";

    private final String CONSULTAR_TODO = "select distinct a.numero_recibo,"
            + " a.dias_alquilados, a.precio_alquiler, a.seguro,a.fecha_entrega,"
            + "a.hora_entrega, a.fecha_devuelta, a.hora_entrega, a.total_pagar,"
            + " c.id_cliente, v.id_vehiculo from alquiler a inner join cliente c"
            + " on(a.numero_recibo = c.numero_factura) inner join vehiculo v"
            + " on(a.numero_recibo = v.numero_factura)\n"
            + " order by 1 asc;";

    private final String CONSULTAR_POR_ID_ALQUILER = "SELECT * FROM alquiler WHERE recibo_alquiler = ?";

    private final String ELIMINAR_ALQUILER = "DELETE FROM alquiler WHERE recibo_alquiler = ?";

    private Alquiler alquiler;

    public AlquilerDao() {
        this.alquiler = new Alquiler();
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public void crear_alquiler(Alquiler alquiler) throws FormatoEntradaException {
        try {
            int i = 0;

            PreparedStatement ps = Conexion.getConexion().prepareCall(this.CREAR_NUEVO_ALQUILER);

            while (i < alquiler.getListaVehiculos().size()) {
                int numeroParamtro = 1;
                ps.setInt(numeroParamtro++, alquiler.getNumeroRecibo());
                ps.setString(numeroParamtro++, alquiler.getCliente().getNombre());
                ps.setString(numeroParamtro++, alquiler.getListaVehiculos().get(i).getDescripcionVehiculo());
                ps.setString(numeroParamtro++, alquiler.getListaVehiculos().get(i).getDescripcionGeneralVehiculo());
                ps.setInt(numeroParamtro++, alquiler.getDIAS_ALQUILER());
                ps.setDouble(numeroParamtro++, alquiler.getValorAlquiler());
                ps.setDouble(numeroParamtro++, alquiler.calcularValorSeguro());
                ps.setDate(numeroParamtro++, new java.sql.Date(alquiler.getFecha().getFechaEntrega().getTime()));
                ps.setTime(numeroParamtro++, new Time(alquiler.getHora().getHora(), alquiler.getHora().getMinutos(), alquiler.getHora().getSegundos()));
                ps.setDate(numeroParamtro++, new java.sql.Date(alquiler.getFecha().getFechaDevuelta().getTime()));
                ps.setTime(numeroParamtro++, new Time(alquiler.getHora().getHora(), alquiler.getHora().getMinutos(), alquiler.getHora().getSegundos()));
                ps.setDouble(numeroParamtro++, alquiler.getRecaudo().getValorTotalRecuado());
                ps.execute();
                i++;
            }
        } catch (SQLException ex) {
            throw new FormatoEntradaException(ex.getErrorCode(), ex.getMessage());
        }

    }

    public void consultar_todos_alquileres() throws FormatoEntradaException {
/*
        try {
            int i = 0;
            List<Alquiler> listaAlquiler = new ArrayList<>();
            Alquiler alquiler;
            Vehiculo vehiculo;
            Cliente cliente;
            Recaudo recuado;
            Fecha fecha;
            Hora hora;
            
             a.numero_recibo,"
            + " a.dias_alquilados, a.precio_alquiler, a.seguro,a.fecha_entrega,"
            + "a.hora_entrega, a.fecha_devuelta, a.hora_entrega, a.total_pagar,"
            + " c.id_cliente, v.id_vehiculo 

            PreparedStatement ps = Conexion.getConexion().prepareCall(this.CONSULTAR_TODO);
            ResultSet rs = ps.executeQuery();
            int indiceCambio=-1;
            int indice =1;
            while (rs.next()) {

                if(indiceCambio !=rs.getInt(indice)){
                    alquiler = new Alquiler();
                    alquiler.setNumeroRecibo(indice++);
                    alquiler.setValorAlquiler(indice++);
                    indice++;
                    fecha = new Fecha(rs.getDate(indice++));
                    Time time = rs.getTime(indice++);
                    time.g
                    hora = new Hora();
                    
                }


                cliente = new Cliente();
                cliente.setNombre("");
                vehiculo = new TipoAuto();
                vehiculo = new TipoCamioneta();
                vehiculo.setDescripcionVehiculo("");
                vehiculo.setDescripcionGeneralVehiculo("");
                recuado = new Recaudo();
//               fecha = new Fecha();
                hora = new Hora();
            }
            return listaAlquiler;

        } catch (SQLException ex) {
            throw new FormatoEntradaException(ex.getErrorCode(), ex.getMessage());
        }
        */
    }

    public void eliminar_alquiler(Long id) {

        try {

            PreparedStatement ps = Conexion.getConexion().prepareCall(ELIMINAR_ALQUILER);
            ps.setLong(1, id);
            ps.execute();
            Alquiler.setTotalAlquileres(Alquiler.getTotalAlquileres() - 1);
        } catch (SQLException ex) {
            System.out.println("Error al eliminar Alquiler en la base de datos: " + ex);
        } finally {
            Conexion.cerrarConexion();
        }
    }
}
