package ArbolTallerFinal;
/**
 *
 * @author Samir Vergara Vergara.
 * @author Isaias Calonge Tano.
 * @author Brenda Vega Davila.
 */
public class Nodo {
/* Declaraciones de variables */
    private char valor;
    private Nodo hojaIzquierda,hojaDerecha, nodoPadre;
     
    /* Constructores */
    public Nodo(char valor) {
        this.valor = valor;
        this.hojaIzquierda = null;
        this.hojaDerecha = null;
    }
        
    public Nodo() {        
        this.hojaIzquierda = null;
        this.hojaDerecha = null;
    } 
    /* Setters y Getters */
    public void setValor(char valor) {
        this.valor = valor;
    }
 
    public char getValor() {
        return valor;
    }
 
    public Nodo getHojaIzquierda() {
        return hojaIzquierda;
    }
 
    public void setHojaIzquierda(Nodo hojaIzquierda) {
        this.hojaIzquierda = hojaIzquierda;
    }
 
    public Nodo getHojaDerecha() {
        return hojaDerecha;
    }
 
    public void setHojaDerecha(Nodo hojaDerecha) {
        this.hojaDerecha = hojaDerecha;
    }   

    public Nodo getNodoPadre() {
        return nodoPadre;
    }

    public void setNodoPadre(Nodo nodoPadre) {
        this.nodoPadre = nodoPadre;
    }
    
    
}
