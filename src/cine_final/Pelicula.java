package cine_final;

/**
 *  Clase que guarda la informacion de la pelicula
 * @author Anggy Arguello - Holmes Ayala
 */
class Pelicula {
    //Guarda el nombre de la pelicula
    private String nombre;
    //Guarda el genero(tipo) de pelicula
    private String genero;
    //Guarda la duracion de la pelicula(Minutos)
    private String duracion;
    //Constructor
    public Pelicula(String nombre, String genero, String duracion) {
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
    }
    /**
     * Imprime los datos de la pelicula
     */
    public void imprimirPelicula(){
        
        System.out.println("___________________________");
        System.out.println("  "+nombre+ " ");
        System.out.println(" " + genero + " ");
        System.out.println(" " + duracion + " ");
        System.out.println("___________________________");
    }    
    /**
     * Metodo que obtiene el nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo que modifica el nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo que obtiene el genero 
     * @return genero
     */
    public String getGenero() {
        return genero;
    }
    /**
     * Metodo que modifica el genero
     * @param genero 
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    /**
     * Metodo que obtiene la duracion
     * @return 
     */
    public String getDuracion() {
        return duracion;
    }
    /**
     * Metodo que modifica la duracion
     * @param duracion 
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}

