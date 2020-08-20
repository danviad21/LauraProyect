/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Esta clase permitira el correcto tratamiento de los datos y almacenamiento de
 * ciertos resultados que han sido hallados mediante procedimientos matematicos
 *
 * @author Laura Camacho Zarathe - fecha de creacion: 05/07/2020
 * @version 1.0
 */
public class Recaudo {

    private double valorSubtotalRecaudo;
    private double valorTotalRecuado;

    /**
     *
     */
    public Recaudo() {

    }
    
    public Recaudo(double valorSubtotalRecaudo){
        this.valorSubtotalRecaudo = valorSubtotalRecaudo;
    }

    /**
     * Retorna el contenido del atributo ValorSubtotalRecaudo de la clase
     *
     * @return double
     */
    public double getValorSubtotalRecaudo() {
        return valorSubtotalRecaudo;
    }

    /**
     *
     * @param diasAlquiler Los dias que se le alquilan un vehiculo a un cliente
     * @param valorSeguro Depende del tipo de vehiculo que se alquila
     * @param valorAlquiler Depende del tipo de vehiculo que se alquila
     *
     */
    public void setValorSubtotalRecaudo(int diasAlquiler, double valorSeguro, double valorAlquiler) {
        this.valorSubtotalRecaudo = this.valorSubtotalRecaudo = (diasAlquiler * valorAlquiler) + valorSeguro;
    }

    /**
     * Retorna el contenido del atributo ValorTotalRecaudo de la clase
     *
     * @return double
     */
    public double getValorTotalRecuado() {
        return valorTotalRecuado;
    }

    /**
     * Modifica o actualiza el atributo ValorTotalRecaudo de la clase a partir
     * del dato que recibe en formato numerico.
     *
     * @param valorTotalRecuado Mediante una serie de procesos matematicos se
     * conoce el valor total de los recaudado en el alquiler
     */
    public void setValorTotalRecuado(double valorTotalRecuado) {
        this.valorTotalRecuado = valorTotalRecuado;
    }
    
    public void setValorTotalRecuado() {
        System.out.println("subtotal: "+valorSubtotalRecaudo);
        this.valorTotalRecuado = this.valorTotalRecuado + valorSubtotalRecaudo;
    }

    @Override
    public String toString() {
        return "Recaudo{" + "valorSubtotalRecaudo=" + valorSubtotalRecaudo + ", valorTotalRecuado=" + valorTotalRecuado + '}';
    }
    
    
}
