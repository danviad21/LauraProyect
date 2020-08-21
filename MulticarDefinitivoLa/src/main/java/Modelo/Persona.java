/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase permitira generar una instancia de tipo Persona con los datos:
 * Identificacion, nombre y telefono.
 *
 * @author Laura Camacho Zarathe - fecha de creacion: 05/07/2020
 * @version 1.0
 */

public abstract class  Persona {

    private String identificacion;
    private String nombre;
    private String apellido;
    private String telefono;
    private int status;
    private int numeroFactura;

    /**
     * Constructor parametrico el cual genera una instancia a partir de los
     * datos que recibe correspondientes a los parametros identificacion, nombre
     * y telefono
     */
    
    public Persona(){
        
    }
    
    public Persona(String identificacion, String nombre, String apellido, String telefono, int status, int numeroFactura) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.status = status;
        this.numeroFactura = numeroFactura;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Modifica o actualiza el atributo Identificacion de la clase a partir del
     * dato que recibe en formato texto.
     *
     * @param identificacion
     * @throws Modelo.FormatoEntradaException
     */
    public void setIdentificacion(String identificacion) throws FormatoEntradaException {

        if (identificacion.isEmpty()) {
            throw new FormatoEntradaException(101, "Identificacion");
        }

        Pattern ppat = Pattern.compile("[a-zA-Z]");
        Matcher mat = ppat.matcher(identificacion);

        if (mat.find()) {
            throw new FormatoEntradaException(103, "Identificacion");
        }

        this.identificacion = identificacion;
    }

    /**
     * Retorna el contenido del atributo Nombre de la clase
     *
     * @return String
     *
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica o actualiza el atributo Nombre de la clase a partir del dato que
     * recibe en formato texto.
     *
     * @param nombre Nombre completo
     * @throws Modelo.FormatoEntradaException
     */
    public void setNombre(String nombre) throws FormatoEntradaException {

        if (nombre.isEmpty()) {
            throw new FormatoEntradaException(101, "Nombre");
        }

        Pattern ppat = Pattern.compile("[0-9]");
        Matcher mat = ppat.matcher(nombre);

        if (mat.find()) {
            throw new FormatoEntradaException(102, "Nombre Cliente");
        }

        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellidoCliente(String apellido) throws FormatoEntradaException {

        if (apellido.isEmpty()) {
            throw new FormatoEntradaException(101, "Apellido Cliente");
        }

        Pattern ppat = Pattern.compile("[0-9]");
        Matcher mat = ppat.matcher(apellido);

        if (mat.find()) {
            throw new FormatoEntradaException(102, "Apellido Cliente");
        }

        this.apellido = apellido;
    }

    /**
     * Retorna el contenido del atributo Telefono de la clase
     *
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Modifica o actualiza el atributo Telefono de la clase a partir del dato
     * que recibe en formato texto.
     *
     * @param telefono
     * @throws Modelo.FormatoEntradaException
     */
    public void setTelefonoCliente(String telefono) throws FormatoEntradaException {
        if (telefono.isEmpty()) {
            throw new FormatoEntradaException(101, "Telefono Cliente");
        }

        Pattern ppat = Pattern.compile("[a-zA-Z]");
        Matcher mat = ppat.matcher(telefono);

        if (mat.find()) {
            throw new FormatoEntradaException(103, "Telefono Cliente");
        }
        this.telefono = telefono;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /*@Override
    public String toString() {
        return identificacionCliente + "," + nombreCliente + "," + telefonoCliente + "\n";
    }*/
    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    @Override
    public String toString() {
        return "Identificacion " + identificacion + "\nNombre " + nombre + " " + apellido + "\nTelefono " + telefono;
    }

}
