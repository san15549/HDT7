package hdt7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Carlo David Sanchinelli
 * @version 02.10.16
 */
public class HDT7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Bienvenida al Sistema.
        Scanner teclado = new Scanner(System.in);
        System.out.println("'BIENVENIDO AL CONSTRUCTOR DE ARBOLES DE HUFFMAN'");
        System.out.println("Ingrese el mensaje a codificar:");
        String mensaje = teclado.nextLine();
        
        //Se crea el arbol y establecen las frecuencias de los caracteres.
        HeapTree arbol = new HeapTree();
        char[] mensaje_array = mensaje.toCharArray();
        int cantidad = mensaje_array.length;
        ArrayList<Character> caracteres = arbol.caracteres(mensaje_array, cantidad);
        ArrayList<Integer> frecuencias = arbol.frecuencias(mensaje_array,cantidad);
        
        //Prueba de frecuencias.
        System.out.println("Frecuencias:");
        for (int i = 0; i < caracteres.size(); i++) {
            System.out.print(caracteres.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < frecuencias.size(); i++) {
            System.out.print(frecuencias.get(i) + " ");
        }
        
        //Llenar arbol.
        boolean ciclo = true;
        while(ciclo == true){
            int mayor = 0;
            for (int i = 0; i < frecuencias.size(); i++){
                if(frecuencias.get(i) > mayor){
                    mayor = i;
                }
            }
            Object[] dato = new Object[2];
            dato[0] = caracteres.get(mayor);
            dato[1] = frecuencias.get(mayor);
            caracteres.remove(mayor);
            frecuencias.remove(mayor);
            arbol.tree.add(dato);
            if(frecuencias.isEmpty()){
                ciclo = false;
            }
        }
        //Solicitar decodificar mensaje.
        System.out.println();
        System.out.println("Ingrese el mensaje a decodificar:");
        String mensaje2 = teclado.nextLine();
        //Convierte texto a cadena de numeros.
        char[] mensaje2_array = mensaje2.toCharArray();
        int[] ints = new int[mensaje2_array.length];
        for (int i=0; i < mensaje2_array.length; i++){
            ints[i] = Character.digit(mensaje2_array[i], 10);
        }
        
        //Recorrer arbol con codigo.
        int k = 0;
        for (int i = 0; i < ints.length-1; i++){
            if(ints[i]==0){
                k= (2*k)+1;
            }
            if(ints[i]==1){
                k= (2*k)+2;
            }
        }
        Object[] respuesta = (Object[]) arbol.tree.get(k);
        System.out.println(respuesta[0] + " ");
    }
}
