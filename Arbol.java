package ArbolTallerFinal;
/**
 *
 * @author Samir Vergara Vergara.
 * @author Isaias Calonge Tano.
 * @author Brenda Vega Davila.
 */
import java.util.Stack;

public class Arbol {

    /* Atributos */
    private Nodo raiz;
    private String expresion;

    /* Contructores */
    public Arbol() {
        raiz = null;
        expresion = null;
    }

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    /* Setters y Getters */
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    /* Funciones */
    public Nodo addNodo(char caracter) {
        Nodo nodo = new Nodo();
        nodo.setValor(caracter);
        nodo.setHojaDerecha(null);
        nodo.setHojaIzquierda(null);
        return nodo;
    }

    public void GenerarArbol(String cadena) {        
        cadena = "(" + cadena;
        cadena += ")";
        this.expresion = cadena;
        this.raiz = GenerarArbol();
    }
    
    public Nodo GenerarArbol() {
        String cadena = this.expresion;
        Stack<Nodo> stN = new Stack<>();
        Stack<Character> stC = new Stack<>();
        Nodo temp, temp1, temp2;

        int[] p = new int[123];
        p['+'] = p['-'] = 1;
        p['/'] = p['*'] = 2;
        p['^'] = 3;
        p[')'] = 0;

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '(') {
                stC.add(cadena.charAt(i));
            }
            else if (Character.isDigit(cadena.charAt(i))) {
                temp = addNodo(cadena.charAt(i));
                stN.add(temp);
            } else if (p[cadena.charAt(i)] > 0) {
                while (!stC.isEmpty() && stC.peek() != '(' && ((cadena.charAt(i) != '^' && p[stC.peek()] >= p[cadena.charAt(i)]) || (cadena.charAt(i) == '^' && p[stC.peek()] > p[cadena.charAt(i)]))) {
                    temp = addNodo(stC.peek());
                    stC.pop();
                    temp1 = stN.peek();
                    stN.pop();
                    temp2 = stN.peek();
                    stN.pop();
                    temp.setHojaIzquierda(temp2);
                    temp.setHojaDerecha(temp1);
                    stN.add(temp);
                }
            stC.push(cadena.charAt(i));
            } else if (cadena.charAt(i) == ')') {
                while (!stC.isEmpty() && stC.peek() != '(') {
                    temp = addNodo(stC.peek());
                    stC.pop();
                    temp1 = stN.peek();
                    stN.pop();
                    temp2 = stN.peek();
                    stN.pop();
                    temp.setHojaIzquierda(temp2);
                    temp.setHojaDerecha(temp1);
                    stN.add(temp);
                }
                stC.pop();
            }
        }
        temp = stN.peek();
        return temp;
    }

    public void imprimirPreOrden() {
        imprimirPreOrden(this.raiz);
    }

    private void imprimirPreOrden(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.getValor() + " ");
            imprimirPreOrden(raiz.getHojaIzquierda());
            imprimirPreOrden(raiz.getHojaDerecha());
        }
    }

    public void imprimirInOrden() {
        imprimirInOrden(this.raiz);
    }

    private void imprimirInOrden(Nodo raiz) {
        if (raiz != null) {
            imprimirInOrden(raiz.getHojaIzquierda());
            System.out.print(raiz.getValor() + " ");
            imprimirInOrden(raiz.getHojaDerecha());
        }
    }

    public void imprimirPosOrden() {
        imprimirPosOrden(this.raiz);
    }

    private void imprimirPosOrden(Nodo raiz) {
        if (raiz != null) {
            imprimirPosOrden(raiz.getHojaIzquierda());
            imprimirPosOrden(raiz.getHojaDerecha());
            System.out.print(raiz.getValor() + " ");
        }
    }

    private void recorrerPreOrden(StringBuilder sb, Nodo node) {
        if (node != null) {
            sb.append(node.getValor());
            sb.append("\n");
            recorrerPreOrden(sb, node.getHojaIzquierda());
            recorrerPreOrden(sb, node.getHojaDerecha());
        }
    }

    private void recorrerPosOrden(StringBuilder sb, Nodo node) {
        if (node != null) {
            recorrerPosOrden(sb, node.getHojaIzquierda());
            recorrerPosOrden(sb, node.getHojaDerecha());
            sb.append(node.getValor());
            sb.append("\n");
        }
    }

    public void imprimirArbol() {
        imprimirArbol(this.raiz);
    }

    private void imprimirArbol(Nodo raiz) {
        imprimirArbol(raiz, 0);
    }

    private void imprimirArbol(Nodo raiz, int separador) {
        int espacios = 3;    
        if (raiz == null) {return;}
        separador += espacios;
        imprimirArbol(raiz.getHojaDerecha(), separador);
        System.out.print("\n");
        for (int i = espacios; i < separador; i++) {
            System.out.print(" . ");
        }
        System.out.print(raiz.getValor() + "\n");
        imprimirArbol(raiz.getHojaIzquierda(), separador);
    }       
    
}
