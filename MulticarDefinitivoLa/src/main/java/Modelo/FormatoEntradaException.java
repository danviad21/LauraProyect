/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Laura Camacho Zarathe
 */
public class FormatoEntradaException extends Exception {

    private int nro;
    private String mgs;

    public FormatoEntradaException(){
        
    }
        
    
    /**
     * public FormatoEntradaException(int nro, String mgs) { this.nro = nro;
     * this.mgs = mgs; }
     *
     * @param nro
     * @param nombreCampo
     *
     *
     */
    public FormatoEntradaException(int nro, String nombreCampo) {
        this.nro = nro;
        switch (nro) {
            case 101:
                this.mgs = "Existen campos en blanco..." + "\nCampo " + nombreCampo;
                break;
            case 102:
                this.mgs = "Se debe ingresar solo letras..." + "\nCampo " + nombreCampo;
                break;
            case 103:
                this.mgs = "Se debe ingresar solo numeros..." + "\nCampo " + nombreCampo;
                break;
            case 104:
                this.mgs = "Se debe de ingresar 3 letras y 3 numeros" +"\nCampo "+nombreCampo;
                break;
            default:
                this.mgs = nombreCampo;
                break;
        }
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getMgs() {
        return mgs;
    }

    public void setMgs(String mgs) {
        this.mgs = mgs;
    }

    @Override
    public String toString() {
        return "Error: " + nro + ", generado por " + "\n" + mgs;
    }
}
