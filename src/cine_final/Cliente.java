
package cine_final;

/** Clase cliente que guarda la información del mismo
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class Cliente {
    //Guarda el nombre del cliente
    private String Nombre;
    //Guarda la edad del cliente
    private int edad;
    //Guarda el genero del cliente
    private Genero genero;
    //Guarda la identificacion del cliente
    private String identificacion;
    //Constructor
    public Cliente(String Nombre, int edad, Genero genero, String identificacion) {
        this.Nombre = Nombre;
        this.edad = edad;
        this.genero = genero;
        this.identificacion = identificacion;
    }
    /**
     * Metodo que obtiene el nombre
     * @return nombre
     */
    public String getNombre() {
        return Nombre;
    }
    /**
     * Metodo que modifica el nombre
     * @param Nombre 
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    /**
     * Metodo que obtiene la edad
     * @return edad 
     */
    public int getEdad() {
        return edad;
    }
    /**
     * Metodo que modifica la edad
     * @param edad 
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /**
     *Metodo que obtiene el genero
     * @return genero
     */
    public Genero getGenero() {
        return genero;
    }
    /**
     * Metodo que modifica el genero
     * @param genero 
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    /**
     * Metodo que obtiene la identificacion
     * @return identificacion 
     */
    public String getIdentificacion() {
        return identificacion;
    }
    /**
     * Metodo que modifica la identificacion
     * @param identificacion 
     */

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}