package hdt7;

import java.util.ArrayList;

/**
 * @author Carlo David Sanchinelli
 * @version 02.10.16
 */
public class HeapTree{
    
    ArrayList tree;
    
    public HeapTree(){
        tree = new ArrayList();
    }
    
    public ArrayList caracteres(char[] array,int cantidad){
        ArrayList lista = new ArrayList();
        for(int i=0;i<cantidad;i++){
            lista.add(array[i]);
        }
        for(int i=0;i<cantidad;i++){
            boolean salir = false;
            while(salir == false){
                Object valor = lista.get(i);
                if(lista.indexOf(valor) == lista.lastIndexOf(valor)){
                    salir = true;
                }
                else{
                    lista.remove(lista.lastIndexOf(valor));
                    cantidad--;
                }
            }
        }
        return lista;
    }
    
    public ArrayList frecuencias(char[] array,int cantidad){
        
        ArrayList lista = new ArrayList();
        for(int i=0;i<cantidad;i++){
            lista.add(array[i]);
        }
        ArrayList frecuencias = new ArrayList();
        for(int i=0;i<cantidad;i++){
            int num = 1;
            boolean salir = false;
            while(salir == false){
                Object valor = lista.get(i);
                if(lista.indexOf(valor) == lista.lastIndexOf(valor)){
                    frecuencias.add(i, num);
                    salir = true;
                }
                else{
                    num++;
                    lista.remove(lista.lastIndexOf(valor));
                    cantidad--;
                }
            }
        }
        return frecuencias;
    }
}
