/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 */
package Modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Esta clase permite de manera optima tomar la informacion del sistema, la cual
 * mediante Calendar nos permitira manipular la informacion del tiempo el cual
 * es un dato fundamental para el correcto funcionamiento.
 *
 * @author Laura Camacho Zarathe - fecha de creacion: 05/07/2020
 * @version 1.0
 */
public class Fecha {

    private Date fechaEntrega;
    private Date fechaDevuelta;

    /**
     * Se utiliza la clase Calendar que permite manipular informacion del tiempo
     * Se obtiene la instancia del objeto Calendar Se utiliza el metodo setTime
     * y se envia el parametro
     *
     * @param date Se espefician los dias que se quieren sumar a la fecha
     * obtenida Se asigna el valor resultante a la variable fechaDevuelta
     *
     */
    public Fecha(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, +10);

        this.fechaEntrega = date;
        this.fechaDevuelta = calendar.getTime();
    }

    /**
     * Retorna el contenido del atributo FechaEntrega de la clase
     *
     * @return Date
     */
    public Date getFechaEntrega() {
        return this.fechaEntrega;
    }

    /**
     * Modifica o actualiza el atributo FechaEntrega de la clase a partir del
     * dato que recibe en formato texto - numerico gracias al sistema.
     *
     * @param fechaEntrega Fecha en la que le entregara el vehiculo al cliente
     * @throws Modelo.FormatoEntradaException
     */
    public void setFechaEntrega(Date fechaEntrega) throws FormatoEntradaException {
        if (fechaEntrega == null) {
            throw new FormatoEntradaException(101, "INFORMACION TIEMPO");
        }
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * Retorna el contenido del atributo FechaDevuelta de la clase
     *
     * @return Date
     */
    public Date getFechaDevuelta() {
        return this.fechaDevuelta;
    }

    /**
     * Modifica o actualiza el atributo FechaDevuelta de la clase a partir del
     * dato que recibe en formato texto - numerico brindado por el sistema.
     *
     * @param fechaDevuelta Fecha en la cual el usuario tendra que regresar el
     * vehiculo, es un numero de dias ya asignados por el sistema
     * @throws Modelo.FormatoEntradaException
     */
    public void setFechaDevuelta(Date fechaDevuelta) throws FormatoEntradaException {
        if (fechaDevuelta == null) {
            throw new FormatoEntradaException(101, "INFORMACION TIEMPO");
        }
        this.fechaDevuelta = fechaDevuelta;
    }

    /**
     *
     * @return El valor de la variable FechaEntrega aplicando un formato
     * Utilizando la clase SimpleDateFormat y la expresion dd-MM-yyyy
     *
     */
    public String convertirFechaEntregaString() {
//        return new SimpleDateFormat("dd-MM-yyyy").format(this.fechaEntrega);
        return new SimpleDateFormat("dd-MM-yyyy").format(this.fechaEntrega);
    }

    /**
     *
     * @return El valor de la variable FechaDevuelta aplicando un formato
     * Utilizando la clase SimpleDateFormat y la expresion dd-MM-yyyy
     *
     */
    public String convertirFechaDevueltaString() {
//        return new SimpleDateFormat("dd-MM-yyyy").format(this.fechaEntrega);
        return new SimpleDateFormat("dd-MM-yyyy").format(this.fechaDevuelta);
    }
}
