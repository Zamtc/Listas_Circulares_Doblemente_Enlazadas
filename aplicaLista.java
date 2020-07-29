package Aplica;

import java.util.Scanner;

public class aplicaLista {
    static Scanner teclado = new Scanner(System.in);
    static lista lista = new lista();
    public static void main(String[] args) {
        menu();
    }
    
    static void menu() {
        int opcion;

        do {
            System.out.println("\n\nMenú de Opciones");
            System.out.println("======================");
            System.out.println("[1] Insertar al Inicio");
            System.out.println("[2] Insertar al final");
            System.out.println("[3] Mostrar Datos");
            System.out.println("[4] Mostrar tamaño");
            System.out.println("[5] Insertar por Posición");
            System.out.println("[6] Insertar por Elemento");
            System.out.println("[7] Eliminar Inicio");
            System.out.println("[8] Eliminar Final");
            System.out.println("[9] Eliminar por Posición");
            System.out.println("[10] Eliminar por Elemento");
            System.out.println("[11] Buscar por Posición");
            System.out.println("[12] Buscar por Elemento");
            System.out.println("[13] Modificar Elemento");
            System.out.println("========================");
            System.out.println("[0] Salir del sistema");

            System.out.print("Ingrese una Opción : ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1: 
                    inicio();
                    break;
                case 2:
                    ultimo();
                    break;
                case 3:
                    lista.mostrar();
                    break;
                case 4:
                    System.out.println("El tamaño de la lista es de : "+lista.getTamaño()+ " Elementos");
                    break;    
                case 5:
                    xposicion();
                    break;
                case 6:
                    xelemento();
                    break;    
                case 7:
                    lista.eliminarInicio();
                    System.out.println("Elemento eliminado con éxito!!!");
                    break;
                case 8:
                    lista.eliminarFinal();
                    System.out.println("Elemento eliminado con éxito!!!");
                    break;
                case 9:
                    eliminarPosicion();
                    break; 
                case 10:
                    eliminarElemento();
                    break;
                case 11:
                    buscarxPosicion();
                    break;
                case 12:
                    buscarxElemento();
                    break;
                case 13:
                    modificar();
                    break;
                case 0:
                    System.exit(0);
                    break;
                    default:System.out.println("Ingrese opcion valida ");
            }

        } while (opcion != 0);
    }
    static void inicio(){
        System.out.println("Ingrese un elemento: ");
        int dato=teclado.nextInt();
        lista.insertarInicio(dato);
        System.out.println("Elemento añadido al inicio con éxito!!!");
    }
    static void ultimo(){
        System.out.println("Ingrese un elemento: ");
        int dato=teclado.nextInt();
        lista.insertarFinal(dato);
        System.out.println("Elemento añadido al final con éxito!!!");
    }
    static void xposicion(){
        System.out.println("Ingrese la posición: ");
        int pos=teclado.nextInt();
        if(pos<=lista.getTamaño()){
        System.out.println("Ingrese el elemento: ");
        int dato=teclado.nextInt();
        lista.insertarxPosicion(dato, pos);
        System.out.println("Elemento añadido en la posición "+pos+ " con éxito!!!");
        }else{
            System.out.println("La posición no es válida");
        }
    }
    static void xelemento(){
        System.out.println("Ingrese el elemento: ");
        int elemento=teclado.nextInt();
        
        if(lista.buscar(elemento)==true){
        System.out.println("Seleccione en que posición desea insertar el nuevo valor");
        System.out.println("1. Despues del elemento digitado");
        System.out.println("2. Antes del elemento digitado");
        int pos=teclado.nextInt();
        System.out.println("Ingrese un nuevo elemento: ");
        int dato=teclado.nextInt();
        lista.insertarxElemento(dato, elemento, pos);
        System.out.println("El elemento "+ dato + " ha sido añadido con éxito!!!");
        }else{
            System.out.println("El elemento no ha sido encontrado en la lista");
        }
    }
     static void eliminarPosicion(){
        System.out.println("Ingrese la posición: ");
        int pos=teclado.nextInt();
        if(pos<lista.getTamaño()){
        lista.eliminarxPosicion(pos);
        System.out.println("El elemento en la posición "+pos+ " ha sido eliminado con éxito!!!");
        }else{
            System.out.println("La posición no es válida");
        }
    }
     static void eliminarElemento(){
         
         System.out.println("Ingrese el elemento que desea eliminar: ");
         int elemento=teclado.nextInt();
         if(lista.buscar(elemento)==true){
         lista.eliminarElemento(elemento);
         System.out.println("El elemento "+ elemento + " ha sido eliminado con éxito!!!");
         }else{
             System.out.println("El elemento no existe");
         }
     }
     static void buscarxPosicion(){
         System.out.println("Ingrese la posición que desea buscar: ");
         int pos=teclado.nextInt();
         if(pos<lista.getTamaño()){
         lista.buscarxPosicion(pos);
         }else{
             System.out.println("La posición no existe");
         }
     }
      static void buscarxElemento(){
          
         System.out.println("Ingrese el elemento que desea buscar: ");
         int elemento=teclado.nextInt();
         if(lista.buscar(elemento)==true){
             lista.buscarElemento(elemento);
         } else{
             System.out.println("El elemento no se encuentra en la lista");
         }  
      }
      static void modificar(){
         System.out.println("Ingrese el elemento que desea cambiar: ");
         int elemento1=teclado.nextInt();
         if(lista.buscar(elemento1)==true){
         System.out.println("Ingrese el nuevo valor del elemento: ");
         int valor=teclado.nextInt();
         System.out.println("Elemento modificado con éxito!! ");
         lista.modificarElemento(elemento1, valor);
         }else{
             System.out.println("El elemento no se encuentra en la lista");
         }
      }
}
