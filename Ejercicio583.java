import java.io.*;

public class Ejercicio583 {
    public static void main(String[] args) {
        try {
            // Guardar el objeto
            Ejercicio583Producto p = new Ejercicio583Producto("Teclado", 25.5, 40);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("producto.bin"));
            out.writeObject(p);
            out.close();

            // Recuperar el objeto
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("producto.bin"));
            Ejercicio583Producto leido = (Ejercicio583Producto) in.readObject();
            in.close();

            System.out.println(leido);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}