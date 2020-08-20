/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *
 * @autor Laura Camacho Zarathe - fecha de creacion: 05/07/2020
 * @version 1.0
 *
 */
/**
 *
 * Esta clase abstracta contiene toda la informacion de los distintos tipos de
 * vehiculos que el alquiler ofrece, sumamente importante al momento de heredar
 * correctamete toda la informacion que se guarda en esta clase.
 */
public abstract class Vehiculo {

    /**
     *
     * Contiene informacion de cada atributo de cada vehiculo, genera una
     * instancia a partir de los datos que recibe correspondientes a los
     * parametros: Identificacion del vehiculo, descripcion general, kilometraje
     * placas del vehiculo y su estado actual que se refiere a si esta
     * disponible o por el contrario ya fue alquilado.
     *
     */
    private int idVehiculo;
    private String descripcionGeneralVehiculo;
    private String descripcionVehiculo;
    private double kilometrajeVehiculo;
    private String placasVehiculo;
    private int estadoVehiculo;
    private int numeroFactura;
    /**
     *
     */
    public Vehiculo() {
        this.idVehiculo = 0;
        this.estadoVehiculo = 1;
    }

    /**
     * Retorna el contenido del atributo IdVehiculo de la clase
     *
     * @return Long
     */
    public int getIdVehiculo() {
        return this.idVehiculo;
    }

    /**
     * setVehiculo asigna a la variable el valor del parametro
     *
     * @param idVehiculo Identificador por cada objecto vehiculo
     * @throws Modelo.FormatoEntradaException
     */
    
    public void setIdVehiculo(int idVehiculo) throws FormatoEntradaException {
        this.idVehiculo = idVehiculo;
    }

    /**
     * Retorna el contenido del atributo DescripcionGeneral de la clase
     *
     * @return String
     */
    public String getDescripcionGeneralVehiculo() {
        return this.descripcionGeneralVehiculo;
    }

    /**
     * setDescripcionGeneral asigna a la variable el valor del parametro
     *
     * @param descripcionGeneralVehiculo Define el tipo de vehiculo
     * @throws Modelo.FormatoEntradaException
     */
    
    public void setDescripcionGeneralVehiculo(String descripcionGeneralVehiculo) throws FormatoEntradaException {
        if(descripcionGeneralVehiculo.isEmpty()){
            throw new FormatoEntradaException(101, "Descripcion General Vehiculo");
        }
        
        this.descripcionGeneralVehiculo = descripcionGeneralVehiculo;
    }

    /**
     * Retorna el contenido del atributo DescripcionVehiculo de la clase
     *
     * @return String
     */
    public String getDescripcionVehiculo() {
        return descripcionVehiculo;
    }

    /**
     * Modifica o actualiza el atributo DescripcionVehiculo de la clase a partir
     * del dato que recibe en formato texto.
     *
     * @param descripcionVehiculo Se le permite al usuario hacer una breve
     * descripcion del vehiculo que le gustaria alquilar
     * @throws Modelo.FormatoEntradaException
     */
    public void setDescripcionVehiculo(String descripcionVehiculo) throws FormatoEntradaException {
        
        if(descripcionVehiculo.isEmpty()){
            throw new FormatoEntradaException(101, "Descripcion Vehiculo");
        }
        
        this.descripcionVehiculo = descripcionVehiculo;
    }

    /**
     * Retorna el contenido del atributo KilometrajeVehiculo de la clase
     *
     * @return Double
     */
    public double getKilometrajeVehiculo() {
        return kilometrajeVehiculo;
    }

    /**
     * Modifica o actualiza el atributo KilometrajeVehiculo de la clase a partir
     * del dato que recibe en formato numerico.
     *
     * @param kilometrajeVehiculo Kilometraje del auto que esta en proceso de
     * alquiler
     * @throws Modelo.FormatoEntradaException
     */
    
    public void setKilometrajeVehiculo(double kilometrajeVehiculo) throws FormatoEntradaException {
        
        String kilometraje = String.valueOf(kilometrajeVehiculo);
        
        if(String.valueOf(kilometraje).isEmpty()){
            throw new FormatoEntradaException(101, "Kilometraje Vehiculo");
        }
        
        Pattern ppat = Pattern.compile ("[a-zA-Z]");
        Matcher mat = ppat.matcher (kilometraje);
        
        if(mat.find()){
            throw new FormatoEntradaException(103, "Kilometraje Vehiculo");
        }
        
        this.kilometrajeVehiculo = kilometrajeVehiculo;
    }

    /**
     * Retorna el contenido del atributo PlacasVehiculo de la clase
     *
     * @return String
     */
    public String getPlacasVehiculo() {
        return placasVehiculo;
    }

    /**
     * Modifica o actualiza el atributo PlacasVehiculo de la clase a partir del
     * dato que recibe en formato texto - numerico.
     *
     * @param placasVehiculo Placas del vehiculo el cual esta en proceso de
     * alquiler
     * @throws Modelo.FormatoEntradaException
     */
    
    public void setPlacasVehiculo(String placasVehiculo) throws FormatoEntradaException {
        if(String.valueOf(placasVehiculo).isEmpty()){
            throw new FormatoEntradaException(101, "Placa Vehicul");
        }
        
        Pattern ppat = Pattern.compile ("[a-zA-Z]{3}[0-9]{3}");
        Matcher mat = ppat.matcher (placasVehiculo);
        
        if(!mat.find()){
            throw new FormatoEntradaException(104, "Placa Vehiculo");
        }
        
        this.placasVehiculo = placasVehiculo;
    }
    /**
     * Retorna el contenido del atributo EstadoVehiculo de la clase
     *
     * @return Int
     */
    public int getEstadoVehiculo() {
        return estadoVehiculo;
    }

    /**
     * Modifica o actualiza el atributo EstadoVehiculo de la clase a partir del
     * dato que recibe en formato numerico.
     *
     * @param estadoVehiculo Permite conocer el estado del vehiculo, el cual
     * directamente se refiere a si esta libre o por el contrario ya esta
     * alquilado.
     */
    public void setEstadoVehiculo(int estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }
    
    
    @Override
    public String toString() {
        return idVehiculo + "," + descripcionVehiculo + "," + descripcionGeneralVehiculo + "," + kilometrajeVehiculo + "," + placasVehiculo + "," + estadoVehiculo+"\n";
    }
}
