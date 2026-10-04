import java.io.Serializable;

public class Ejercicio583Producto implements Serializable {
    private String nombre;
    private double precio;
    private int stock;

    public Ejercicio583Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String toString() {
        return "Producto: " + nombre + " | Precio: " + precio + " | Stock: " + stock;
    }
}