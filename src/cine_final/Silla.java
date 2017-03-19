package cine_final;


/**
 *  Clase que guarda los parametros de la silla
 * @author Anggy Arguello - Holmes Ayala
 */
public class Silla {
    //Guarda el numero de la silla
    private int numero;
    //Guarda el tipo de la silla
    private String tipo;
    //Guarda ek precio de la silla
    private int valor;
    //Guarda los parametros del cliente
    private Cliente cliente;
    //Constructor
    public Silla(int numero, String tipo, int valor, Cliente cliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.valor = valor;
        this.cliente = cliente;
    }
    /**
     * Metodo que obtiene el numero de silla
     * @return numero
     */
    public int getNumero() {
        return numero;
    }
    /**
     * Metodo que modifica el numero de silla
     * @param numero 
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     * Metodo que obtiene el tipo de silla (Gen, Eje, Vip)
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Metodo que modifica el tipo de silla (Gen, Eje, Vip)
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Metodo que obtiene el precio de la silla segÃºn tipo
     * @return valor
     */
    public int getValor() {
        return valor;
    }
    /**
     * Metodo que modifica el precio de la silla segun tipo
     * @param valor 
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
    /**
     * Metodo que obtiene el cliente
     * @return cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * Metodo que modifica al cliente 
     * @param cliente 
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
