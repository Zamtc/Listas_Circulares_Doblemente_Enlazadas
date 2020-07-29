package Aplica;
public class lista {
    private Nodo cabeza;
    private Nodo cola;
    private int tamaño;
    public lista(){
        cabeza=null;
        cola=null;
        tamaño=0;
    }
    public boolean vacio(){
        return(cabeza==null);
    }
     public int getTamaño() {
        return this.tamaño;
    }

    //método insertar al inicio
    public void insertarInicio(int dato){
        Nodo nuevo=new Nodo();
        nuevo.setDato(dato);
        if(!vacio()){
          /*  Nodo aux=cabeza;
            while(aux.getSiguiente()!=cabeza){
              aux=aux.getSiguiente();
            }
                
             aux.setSiguiente(nuevo);
               nuevo.setAnterior(aux);
               nuevo.setSiguiente(cabeza);
               cabeza.setAnterior(nuevo);
               cabeza=nuevo;   */
                
         cabeza.setAnterior(nuevo);
         nuevo.setSiguiente(cabeza);
         nuevo.setAnterior(cola);
         cola.setSiguiente(nuevo);
         cabeza=nuevo;
        }else{
           cabeza=nuevo;
           cola=nuevo;
           cabeza.setAnterior(nuevo);
           cabeza.setSiguiente(nuevo);
        }
        
        tamaño++;
    }
    
    //método mostrar datos
    public void mostrar(){
        if(!vacio()){
            Nodo aux= cabeza;
            
           do{
                System.out.print("<-->"+"["+ aux.getDato()+ "]");
               aux=aux.getSiguiente();
            }while(aux!=cabeza);//realiza al menos una vez las instrucciones
            System.out.println("<-->");
     /*   while (contador < tamaño) {
               System.out.print("[" + aux.getDato() + "] -> ");
               aux = aux.getSiguiente();
               contador++;
           }
         System.out.println("null<-->");*/
        }else{
            System.out.println("La lista esta vacía...");
        }             
    }
    
    //método insertar al final
    public void insertarFinal(int dato){
        Nodo nuevo=new Nodo();
        nuevo.setDato(dato);
       if(!vacio()){

         cola.setSiguiente(nuevo);
         nuevo.setSiguiente(cabeza);
         nuevo.setAnterior(cola);
         cola=nuevo;
         cabeza.setAnterior(cola);
        }else{
           cabeza=nuevo;
           cola=nuevo;
           cabeza.setAnterior(nuevo);
           cabeza.setSiguiente(nuevo);
        }
        
        tamaño++;
    }
    
    //método insertar por posición
    public void insertarxPosicion(int dato,int posicion){
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
 
        if(!vacio()){
                if(posicion==0){
                    cabeza.setAnterior(nuevo);
                    nuevo.setSiguiente(cabeza);
                    nuevo.setAnterior(cola);
                    cola.setSiguiente(nuevo);
                    cabeza = nuevo;
                }
                
                if(posicion!=0 && posicion!=tamaño-1){  
                  Nodo aux=cabeza;
                  int contador=0;
                  while(contador< posicion-1){
                      aux=aux.getSiguiente();
                      contador++;
                  }
            
                  Nodo siguiente=aux.getSiguiente();
                  nuevo.setAnterior(aux);
                  aux.setSiguiente(nuevo);
                  nuevo.setSiguiente(siguiente);
                  siguiente.setAnterior(nuevo);
                }
                
                if(posicion==tamaño-1){
                    cola.setSiguiente(nuevo);
                    nuevo.setSiguiente(cabeza);
                    nuevo.setAnterior(cola);
                    cola = nuevo;
                    cabeza.setAnterior(cola);
                }
                tamaño++;     
        }else{
            System.out.println("La lista está vacía...");
        }
    }
    
    //método insertar por elemento 
    public void insertarxElemento(int dato,int elemento,int pos){
       
        if(!vacio()){
            switch(pos){
                case 1:{// para insertar despues del elemento
                    Nodo nuevo = new Nodo();
                    nuevo.setDato(dato);
                    Nodo aux = cabeza;
                    int contador=0;
                    while(aux.getDato()!=elemento && contador<tamaño){
                        aux=aux.getSiguiente();
                        contador++;
                    }
                    if(contador==0){// el elemento se encuentra en la cabeza
                        Nodo siguiente=cabeza.getSiguiente();
                        cabeza.setSiguiente(nuevo);
                        nuevo.setAnterior(cabeza);
                        nuevo.setSiguiente(siguiente);
                        siguiente.setAnterior(nuevo);        
                    }
                    
                    if(contador!=0 && contador!=tamaño-1){
                        Nodo siguiente = aux.getSiguiente();
                        aux.setSiguiente(nuevo);
                        nuevo.setAnterior(aux);
                        nuevo.setSiguiente(siguiente);
                        siguiente.setAnterior(nuevo);
                        
                    }
                    if(contador==tamaño-1){// si el elemento s eencuentra en la cola
                        cola.setSiguiente(nuevo);
                        nuevo.setSiguiente(cabeza);
                        nuevo.setAnterior(cola);
                        cola = nuevo;
                        cabeza.setAnterior(cola);
                    }
                    tamaño++;
                    break;
            }
                case 2:{// para insertar antes del elemento
                    Nodo nuevo = new Nodo();
                    nuevo.setDato(dato);
                    Nodo aux=cabeza;
                    int contador=0;
                    while(aux.getDato()!=elemento && contador<tamaño ){
                        aux=aux.getSiguiente();
                        contador++;
                    }                    
                    if(contador==0){// si el elemento se enecuentra en la cabeza
                        aux=cola;
                        cola.setSiguiente(nuevo);
                        nuevo.setAnterior(cola);
                        nuevo.setSiguiente(cabeza);
                        cabeza.setAnterior(nuevo);
                        cabeza=nuevo;            
                    }
                    if(contador!=0 && contador!=tamaño-1){
                        Nodo anterior=aux.getAnterior();
                        aux.setAnterior(nuevo);
                        nuevo.setSiguiente(aux);
                        nuevo.setAnterior(anterior);
                        anterior.setSiguiente(nuevo);     
                    }
                    if(contador==tamaño-1){// si el elemento se encuentra en la cola
                        Nodo anterior=cola.getAnterior();
                        cola.setAnterior(nuevo);
                        nuevo.setSiguiente(cola);
                        nuevo.setAnterior(anterior);
                        anterior.setSiguiente(nuevo);
                    }
                    tamaño++;
                    break;
            }     
            } 
             tamaño++;
        }else{
            System.out.println("No hay elementos en la lista...");
        }
    }
    
    //método eliminar inicio
    public void eliminarInicio(){
        if(!vacio()){
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(cola);
            cola.setSiguiente(cabeza);
            tamaño--;
        }else{
            System.out.println("La lista está vacía...");
        }
    }
    
    //método eliminar final
     public void eliminarFinal(){
        if(!vacio()){
            cola = cola.getAnterior();
            cola.setSiguiente(cabeza);
            cabeza.setAnterior(cola);
            tamaño--;
        }else{
            System.out.println("La lista está vacía...");
        }
    }
     
     // método eliminar por posición
     public void eliminarxPosicion(int posicion){
 
         if(!vacio()){
             if (posicion == 0) {
               eliminarInicio();
           }
             if (posicion != 0 && posicion != tamaño-1) {
               int contador=0;
               Nodo aux = cabeza;
               while (contador < posicion ) {
                   aux = aux.getSiguiente();
                   contador++;
               }
               Nodo siguiente=aux.getSiguiente();
               aux=aux.getAnterior();
               aux.setSiguiente(siguiente);
               siguiente.setAnterior(aux);
               tamaño--;
           }
              if (posicion == tamaño - 1) {
               eliminarFinal();
           }
         }else{
             System.out.println("La lista está vacía...");
         }
     }
     
     // método eliminar elemento en especifico
     public void eliminarElemento(int elemento){
         if(!vacio()){
           
            Nodo aux= cabeza;
            while(aux.getDato()!=elemento){
                aux=aux.getSiguiente();
            }
            if(aux==cabeza){
                eliminarInicio();
            }
            if(aux!=cabeza && aux!= cola){
                
                Nodo anterior = aux.getAnterior();
                Nodo siguiente = aux.getSiguiente();
                anterior.setSiguiente(siguiente);
                siguiente.setAnterior(anterior);
           
            }
            if(aux==cola){
                eliminarFinal();
            }
             tamaño--;
         }else{
             System.out.println("La lista está vacía...");
         }
     }
     
     // método buscar elemento por posición
     public void buscarxPosicion(int posicion){
            if(!vacio()){ 
            if(posicion==0){
                System.out.println("La posición "+posicion+" le pertenece al elemento "+cabeza.getDato());
           }
            if(posicion!=0 && posicion<tamaño-1){
            int contador=0;
            Nodo aux= cabeza;
            while (contador < posicion ) {
                aux = aux.getSiguiente();   
                contador++;
            }
            System.out.println("La posición "+posicion+" le pertenece al elemento "+aux.getDato());
            }
            if(posicion==tamaño-1){
               System.out.println("La posición "+posicion+" le pertenece al elemento "+cola.getDato());
           }
            }
            else{
                System.out.println("La lista está vacía...");
            }
             }
     
     //método para buscar un elemento 
     public void buscarElemento(int elemento){
         
         if(!vacio()){
             Nodo aux= cabeza;
             int contador=0;
            while(aux.getDato()!=elemento && contador<tamaño){
                        aux=aux.getSiguiente();
                        contador++;
                    }
             System.out.println("Se encontro el elemento "+aux.getDato()+" en la posición "+contador);
        }else{
            System.out.println("La lista está vacía...");
        }
         }
     
     public boolean buscar(int valor){
         Nodo aux=cabeza;
         boolean encontrado=false;
         if(cabeza.getDato()==valor){
             encontrado=true;
         }
         else{
         while(aux.getSiguiente()!=cabeza && encontrado!=true){
              aux=aux.getSiguiente();
              if(valor==aux.getDato()){
                 encontrado=true;
             }
         }
         }
        return encontrado;
     }
     
     //método para modificar un elemento por un nuevo valor
     public void modificarElemento(int elemento,int valor){
        if(!vacio()){
            Nodo aux= cabeza;
            while(aux.getDato()!=elemento){
                aux=aux.getSiguiente();
            }
            aux.setDato(valor);
            
        }else{
            System.out.println("La lista está vacía...");
        }
        
    }
     
}
