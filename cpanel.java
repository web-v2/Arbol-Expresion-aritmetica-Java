package ArbolTallerFinal;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Samir Vergara Vergara.
 * @author Isaias Calonge Tano.
 * @author Brenda Vega Davila.
 */
public class cpanel {    
    public void exe(){
        String expresion = null;                
        System.out.print("Digite la expresion aritmetica: ");
        try{
            DataInputStream entrada = new DataInputStream(System.in);
            expresion = entrada.readLine();
        }catch (IOException e){            
            e.printStackTrace();
        }
        Arbol ab = new Arbol();
        ab.GenerarArbol(expresion);
        
        System.out.print("\nImprimir datos en preorden: ");
        ab.imprimirPreOrden();
        System.out.print("\nImprimir datos en inorden: ");
        ab.imprimirInOrden();
        System.out.print("\nImprimir datos en postorden: ");
        ab.imprimirPosOrden();

        System.out.println("\n\n-- Arbol de Expresion Aritmetica --\n");
        ab.imprimirArbol();
    }
}
