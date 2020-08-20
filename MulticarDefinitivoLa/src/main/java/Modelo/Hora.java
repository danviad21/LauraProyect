/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Esta clase permite de manera optima tomar la informacion del sistema, la cual
 * mediante Calendar nos permitira manipular la informacion del tiempo el cual
 * es un dato fundamental para el correcto funcionamiento. Puede complementarse
 * con la clase Fecha.
 *
 * @author Laura Camacho Zarathe - fecha de creacion: 05/07/2020
 * @version 1.0
 */
public class Hora {

    private int hora;
    private int minutos;
    private int segundos;
    
    public Hora(){
        
    }
    
    public Hora(int hora, int minuto, int segudo){
        this.hora = hora;
        this.minutos = minuto;
        this.segundos = segudo;
    }
    
    
    
    
    
//    private Date horaEntrega;
//    private Date horaDevuelta;
//
//    /**
//     *
//     * @param date
//     */
//    public Hora(Date date) {
//        System.out.println("fecha modelo: "+date);
//        this.horaEntrega = date;
//        this.horaDevuelta = date;
//    }
//
//    /**
//     * Retorna el contenido del atributo HoraEntrega de la clase
//     *
//     * @return Date
//     */
//    public Date getHoraEntrega() {
//        return horaEntrega;
//    }
//
//    /**
//     * Modifica o actualiza el atributo HoraEntrega de la clase a partir del
//     * dato que recibe en formato texto - numerico por medio del sistema.
//     *
//     * @param horaEntrega Hora exacta en la cual el usuario recibe el vehiculo
//     * @throws Modelo.FormatoEntradaException
//     */
//    public void setHoraEntrega(Date horaEntrega) throws FormatoEntradaException {
//        if (horaEntrega == null) {
//            throw new FormatoEntradaException(101, "INFORMACION HORA");
//        }
//        this.horaEntrega = horaEntrega;
//    }
//
//    /**
//     * Retorna el contenido del atributo HoraDevuelta de la clase
//     *
//     * @return Date
//     */
//    public Date getHoraDevuelta() {
//        return horaDevuelta;
//    }
//
//    /**
//     * Modifica o actualiza el atributo HoraDevuelta de la clase a partir del
//     * dato que recibe en formato texto - numerico por medio del sistema.
//     *
//     * @param horaDevuelta Hora exacta en la cual el usuario debe devolver el
//     * vehiculo alquilado previamente.
//     * @throws Modelo.FormatoEntradaException
//     */
//    public void setHoraDevuelta(Date horaDevuelta) throws FormatoEntradaException {
//        if (horaDevuelta == null) {
//            throw new FormatoEntradaException(101, "INFORMACION TIEMPO");
//        }
//
//        this.horaDevuelta = horaDevuelta;
//    }
//
//    /**
//     *
//     * @return El valor de la variable HoraEntrega aplicando un formato
//     * Utilizando la clase SimpleDateFormat y la expresion HH:mm:ss
//     *
//     */
//    public String convertirHoraEntregaString() {
//        return new SimpleDateFormat("hh:mm:ss").format(this.horaEntrega);
//    }
//
//    /**
//     *
//     * @return El valor de la variable HoraDevuelta aplicando un formato
//     * Utilizando la clase SimpleDateFormat y la expresion HH:mm:ss
//     *
//     */
//    public String convertirHoraDevueltaString() {
//        return new SimpleDateFormat("hh:mm:ss").format(this.horaDevuelta);
//    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public String toString() {
        return "Hora:  "+hora + ": " + this.minutos + ":" + this.segundos + " HRS     ";
    }
    
    

}
