/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author odavid
 */
public class Cliente extends Persona{
    
    private int idCliente;
    
    public Cliente(){
        
    }
    
    public Cliente(String identificacion, String nombre, String apellido, String telefono, int status, int numeroFactura) {
        super(identificacion, nombre, apellido, telefono, status, numeroFactura);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
    
}
