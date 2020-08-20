/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 * Esta clase permitira el correcto tratamiento de los datos y hallar mediante
 * algunos procesos matematicos los distintos valores solicitados por el sistema
 *
 * @author Laura Camacho Zarathe - fecha de creacion: 05/07/2020
 * @version 1.0
 */
public class Alquiler {

    private int numeroRecibo;

    private static int totalAlquileres;

    private double valorAlquiler;

    private final short DIAS_ALQUILER;

    private Cliente cliente;

    private List<Vehiculo> listaVehiculos;

    private Fecha fecha;

    private Hora hora;

    private Recaudo recaudo;

    /**
     * Se crea una variable de tipo double numero y se asigna un numero
     * aleatorio entre el rango de 1 y 1000 utilizando la clase Math y su metodo
     * estatico random. Se instancia el objeto de tipo List a su implementacion
     * ArrayList Se instancia el objeto de tipo clase Recaudo. Se inicializa la
     * constante o variable final con valor numerico 10.
     */
    public Alquiler() {

        this.numeroRecibo = (int) (Math.random() * (1000 + 1));
        this.DIAS_ALQUILER = 10;
    }

    public void setNumeroRecibo(int numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    /**
     * Retorna el contenido del atributo NumeroRecibo de la clase
     *
     * @return Long
     */
    public int getNumeroRecibo() {
        return numeroRecibo;
    }

    public static int getTotalAlquileres() {
        return totalAlquileres;
    }

    public static void setTotalAlquileres(int aTotalAlquileres) {
        totalAlquileres = aTotalAlquileres;
    }

    /**
     * Retorna el contenido del atributo ValorIdentificacion de la clase
     *
     * @return Double
     */
    public double getValorAlquiler() {
        return valorAlquiler;
    }

    /**
     * Retorna el contenido del atributo Cliente de la clase
     *
     * @return Persona
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Modifica o actualiza el atributo Cliente de la clase a partir del dato
     * que recibe en formato texto.
     *
     * @param cliente Cliente
     * @throws Modelo.FormatoEntradaException
     */
    public void setCliente(Cliente cliente) throws FormatoEntradaException {
        
        if(cliente == null){
            System.out.println("entro excepcion cliente");
            throw new FormatoEntradaException(101, "INFORMACION CLIENTE");
        }
        
        this.cliente = cliente;
    }

    /**
     * Retorna el contenido del atributo Fecha de la clase
     *
     * @return Fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * Modifica o actualiza el atributo Fecha de la clase a partir del dato que
     * recibe en formato texto.
     *
     * @param fecha Fecha brindada por el sistema
     * @throws Modelo.FormatoEntradaException
     */
    public void setFecha(Fecha fecha) throws FormatoEntradaException {
        
        if(fecha == null){
            throw new FormatoEntradaException(101, "INFORMACION TIEMPO");
        }
        
        this.fecha = fecha;
    }

    /**
     * * Retorna el contenido del atributo Hora de la clase
     *
     * @return Hora
     */
    public Hora getHora() {
        return hora;
    }

    /**
     * Modifica o actualiza el atributo Hora de la clase a partir del dato que
     * recibe en formato numerico.
     *
     * @param hora Hora brindada por el sistema
     */
    public void setHora(Hora hora) {
        this.hora = hora;
    }

    /**
     * Modifica o actualiza el atributo Recaudo de la clase a partir del dato
     * que recibe en formato numerico.
     *
     * @param recaudo Recaudo
     * @throws Modelo.FormatoEntradaException
     */
    public void setRecaudo(Recaudo recaudo) throws FormatoEntradaException {

        if(recaudo == null){
            throw new FormatoEntradaException(101, "INFORMACION DE RECAUDO");
        }
        this.recaudo = recaudo;
    }

    /**
     * Retorna el contenido del atributo Recaudo de la clase
     *
     * @return Recaudo
     */
    public Recaudo getRecaudo() {
        return this.recaudo;
    }

    /**
     * Retorna el contenido del atributo ListaVehiculos de la clase
     *
     * @return List
     */
    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    /**
     * Modifica o actualiza el atributo ListaVehiculos de la clase a partir del
     * dato que recibe en formato numerico.
     *
     * @param listaVehiculos lista de vehiculos
     * @throws Modelo.FormatoEntradaException
     */
    public void setListaVehiculos(List<Vehiculo> listaVehiculos) throws FormatoEntradaException {
        
        if(listaVehiculos == null){
            throw new FormatoEntradaException(101, "INFORMACION DE VEHICULOS");
        }
        
        this.listaVehiculos = listaVehiculos;
    }

    /**
     * Retorna el contenido del atributo Dias Alquiler de la clase
     *
     * @return short
     */
    public short getDIAS_ALQUILER() {
        return DIAS_ALQUILER;
    }

    /**
     * Compara si el parametro tipoVehiculo es una instancia de la clase auto
     * Asigna: <ul>
     * <li>true: asigna el valor de 78000 a la variable valorAlquiler</li>
     * <li>false: asigna el valor de 100000 a la variable valorAlquiler</li>
     * </ul>
     *
     * @param tipoVehiculo Define tipo de objecto a comparar.
     */
    public void setValorAlquiler(Vehiculo tipoVehiculo) {
        if (tipoVehiculo instanceof TipoAuto) {
            this.valorAlquiler = 78000;
        } else {
            this.valorAlquiler = 100000;
        }
    }

    /**
     * SOBRECARGA DE METODO setValorAlquiler
     *
     * @param valorAlquiler
     */
    public void setValorAlquiler(double valorAlquiler) {
        this.valorAlquiler = valorAlquiler;
    }

    /**
     *compara el valor del alquiler si es igual a 78.000
     * @return <ul>
     * <li>true: valorAlquiler * 0.5</li>
     * <li>false:valorAlquiler * 0.1</li>
     * </ul>
     */
    public double calcularValorSeguro() {
        if (this.valorAlquiler == 78000) {
            return valorAlquiler * .05;
        } else {
            return valorAlquiler * .1;
        }
    }

    @Override
    public String toString() {
        return "Alquiler{" + "numeroRecibo=" + numeroRecibo + ", valorAlquiler=" + valorAlquiler + ", DIAS_ALQUILER=" + DIAS_ALQUILER + ", cliente=" + cliente + ", listaVehiculos=" + listaVehiculos + ", fecha=" + fecha + ", hora=" + hora + ", recaudo=" + recaudo + '}';
    }

}
