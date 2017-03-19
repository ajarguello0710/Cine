
package cine_final;
import java.util.Scanner;

/**
 *
 * @author Anggy Arguello
 */
public class Cine_Final {
     //Objeto de la clase Scanner
    Scanner leer = new Scanner(System.in);
    //Guarda la cantidad de filas
    private int filas;
    //Guarda la cantidad de columnas
    private int columnas;
    //Guarda total filas generales
    private int generales;
    //Guarda total filas ejecutivas
    private int ejecutivas;
    //Guarda total filas vip
    private int vip;
    //Contador de la cantidad de clientes
    private int contadorClientes;
    //Vector del objeto silla
    private Silla silla[][];
    //Constructor

    public Cine_Final() {
        configurarCine();
        llenarSilla();
        imprimirSilla();
        menu();
    }
    
    
    /**
     * Metodo que solicita filas y columnas del cinema
     */
    public void configurarCine(){
        System.out.print("Ingrese filas: ");
        filas = leer.nextInt();
        System.out.print("Ingrese Columnas: ");
        columnas = leer.nextInt();
        solicitarTipoSilla();
        this.silla = new Silla[filas][columnas];
    }
    /**
     * Metodo que define la cantidad de filas que tiene el cine segun el tipo
     */
    public void solicitarTipoSilla(){
        int numeroFilas = filas;
        System.out.print("Ingrese filas generales: ");
        generales = leer.nextInt();
        numeroFilas -= generales;
        if(numeroFilas > 0 ){
            System.out.print("Ingrese filas ejecutivas: ");
            ejecutivas = leer.nextInt();
            numeroFilas -= ejecutivas;
            if( numeroFilas > 0 )
                vip = numeroFilas;
        }
        System.out.println(generales +" " + ejecutivas +" " + vip);
        validarTipo();
        if(ejecutivas != 0){
            ejecutivas = ejecutivas + generales;
            if(vip != 0)
                vip = vip + ejecutivas;
        }
        else{
            if(vip != 0)
                vip = vip + generales;
        }
        System.out.println(generales +" " + ejecutivas +" " + vip);
    }
    /**
     * Metodo que valida si la cantidad ingesada por tipo sobrepasa la cantidad de filas
     */
    public void validarTipo(){
        if(generales > filas){
            generales = filas;
        }
        else if(ejecutivas > filas - generales){
            ejecutivas = filas - generales;
        }
        System.out.println(generales +" " + ejecutivas +" " + vip);
    }
    /**
     * Metodo que determina los argumentos del objeto silla
     */
    public void llenarSilla(){
        int contador = 1;
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                if(i < generales){
                    this.silla[i][j] = new Silla(contador, "General", 5000, null);
                }
                else if(i < ejecutivas){
                    this.silla[i][j] = new Silla(contador, "Ejecutiva", 7000, null);
                }
                else if(i < vip){
                    this.silla[i][j] = new Silla(contador, "VIP", 10000, null);
                }
                contador++;
            }
        }
    }
    /**
     * Metodo que imprime la sala de cine
     */
    public void imprimirSilla(){ 
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                if(silla[i][j].getNumero() < 10){
                    System.out.print(silla[i][j].getNumero()+"  ");
                }
                else{
                    System.out.print(silla[i][j].getNumero()+" ");
                }   
            }
            System.out.println("");
        }
    }
    /**
     * Metodo que imprime el menu de opciones
     */
    public void menu(){
        short opcion = 0; 
        while(contadorClientes <= filas * columnas && opcion != 2){
            System.out.print("1- Ingrese usuario. \n2- Rendicion cuentas.\n");
            System.out.print("Opcion: ");
            opcion = leer.nextShort();
            switch(opcion){
                case 1:
                    if(contadorClientes < filas * columnas){
                        solicitarCliente();
                        contadorClientes++;
                    }
                    else{
                        System.out.println("¡SALA LLENA!");
                    }
                    break;
                case 2:
                    calculoRendicionCuentas();
                    break;
                
            }
        }
    }
    /**
     * Metodo que solicita los datos del cliente
     */
    public void solicitarCliente(){
        System.out.println("Datos usuario: ");
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();
        leer.nextLine();
        System.out.print("Identificación: ");
        String identificacion = leer.nextLine();
        System.out.print("Edad: ");
        int edad = leer.nextInt();
        System.out.print("Genero 1- MASCULINO 2- FEMENINO:");
        byte generos = leer.nextByte();
        short opcion = escogerTipoSilla();
        buscarSilla(opcion);
        if(generos == 1){
            Cliente cliente = new Cliente(nombre, edad, Genero.MASCULINO, identificacion);
            escogerSilla(cliente);
        }
        if (generos == 2){
            Cliente cliente = new Cliente(nombre, edad, Genero.FEMENINO, identificacion);
            escogerSilla(cliente);
        }
    }
    /**
     * Metodo que define un cliente a cada silla 
     * @param cliente 
     */
    public void escogerSilla(Cliente cliente){
        boolean validar = false; 
        while(!validar){
            validar = true;
            System.out.print("Numero de silla: ");
            short silla = leer.nextShort();
            for(int i = 0; i < filas; i++){
                for(int j = 0; j < columnas; j++){
                    if(this.silla[i][j].getNumero() == silla ){
                        if(this.silla[i][j].getCliente() == null){
                            this.silla[i][j].setCliente(cliente);
                        }
                        else{
                            System.out.println("Silla ocupada");
                            validar = false;
                        }
                    }
                }
            } 
        }
        
    }
    /**
     * Metodo que selecciona el tipo de fila que quiere el cliente
     * @return opcion
     */
    public short escogerTipoSilla(){
        short opcion;    
        if(generales != 0){
            System.out.println("1- Generales");
        }
        if(ejecutivas != 0){
            System.out.println("2- Ejecutivas");
        }
        if(vip != 0){
            System.out.println("3- VIP");
        }
        System.out.print("Opcion: ");
        opcion = leer.nextShort();
        return opcion;
        
    }
    /**
     * Metodo que direcciona a los metodos de impresiÃ³n de las filas
     * @param opcion 
     */
    public void buscarSilla(short opcion){
        if(opcion == 1){
            buscarGenerales();
        }
        if(opcion == 2){
            buscarEjecutivas();
        }
        if(opcion == 3){
            buscarVip();
        }
        
    }
    /**
     * Metodo que imprime las filas generales
     */
    public void buscarGenerales(){
        for(int i = 0; i < generales; i++){
                for(int j = 0; j < columnas; j++){
                    if(silla[i][j].getTipo() == "General" && silla[i][j].getCliente() == null){
                        System.out.print(silla[i][j].getNumero()+" ");
                    }
                }
                System.out.println("");
            }
    }
    /**
     * Metodo que imprime las filas ejecutivas
     */
    
    public void buscarEjecutivas(){
        for(int i = 0; i < ejecutivas ; i++){
                for(int j = 0; j < columnas; j++ ){
                    if(silla[i][j].getTipo() == "Ejecutiva" && silla[i][j].getCliente() == null){
                        System.out.print(silla[i][j].getNumero()+" ");
                    }
                }
                System.out.println("");
            }
    }
    /**
     * Metodo que imprime las filas VIP
     */
    
    public void buscarVip(){
        for(int i = 0 ; i < vip; i++){
                for(int j = 0; j < columnas; j++){
                    if(silla[i][j].getTipo() == "VIP" && silla[i][j].getCliente() == null){
                        System.out.print(silla[i][j].getNumero()+" ");
                    }
                }
                System.out.println("");
            }
    }
    /**
     * Metodo que calcula el promedio de personas que ingresaron a la sala, promedio de Hombres, mujeres, niÃ±os
     */
    public void calculoRendicionCuentas(){
        short contadorMujeres = 0, contadorHombres = 0, contadorNiños = 0;
        double dineroRecaudado = 0;
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                if(silla[i][j].getCliente() != null) {
                    if(silla[i][j].getCliente().getGenero() == Genero.MASCULINO && silla[i][j].getCliente().getEdad() > 15){
                        contadorHombres++;
                        dineroRecaudado += silla[i][j].getValor();
                    }
                    else if((silla[i][j].getCliente().getGenero()) == Genero.FEMENINO && silla[i][j].getCliente().getEdad() > 15){
                        contadorMujeres++;
                        dineroRecaudado += silla[i][j].getValor();
                    }
                    else if(silla[i][j].getCliente().getEdad() < 15){
                        contadorNiños++;
                        dineroRecaudado += (silla[i][j].getValor() / 2);
                    }                
                }
            }
        }
        double porcentajeSillas = (contadorClientes*100) / (filas * columnas);
        imprimirRendicionCuentas(contadorMujeres, contadorHombres, contadorNiños, dineroRecaudado, porcentajeSillas);
    }
    /**
     * Metodo que imprime los resultados de los promedios
     * @param contadorMujeres
     * @param contadorHombres
     * @param contadorNiños
     * @param dineroRecaudado
     * @param porcentajeSillas 
     */
    public void imprimirRendicionCuentas(short contadorMujeres, short contadorHombres, short contadorNiños, double dineroRecaudado, double porcentajeSillas){
        Pelicula pelicula = new Pelicula("La Bella y La Bestia", "Drama-Romance-Musical", "123 Minutos");
        pelicula.imprimirPelicula();
        imprimirSilla();
        System.out.println("Rendicion de cuentas del dia:");
        System.out.println("Total Mujeres: "+ contadorMujeres);
        System.out.println("Total Hombres: "+ contadorHombres);
        System.out.println("Total Niños: "+ contadorNiños);
        System.out.println("Total Recaudado: "+ dineroRecaudado);
        System.out.println("Porcentaje sillas ocupadas: "+ porcentajeSillas+ "%");
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cine_Final cine_final = new Cine_Final();
    }
    
}
