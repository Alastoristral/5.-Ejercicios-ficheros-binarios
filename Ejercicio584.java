import java.io.*;

public class Ejercicio584 {
    public static void main(String[] args) {
        try {
            // Guardar los tres objetos
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("productos.bin"));
            out.writeObject(new Ejercicio583Producto("Teclado", 25.5, 40));
            out.writeObject(new Ejercicio583Producto("Ratón", 12.99, 80));
            out.writeObject(new Ejercicio583Producto("Monitor", 150.0, 15));
            out.close();

            // Recuperar los tres objetos
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("productos.bin"));
            for (int i = 0; i < 3; i++) {
                Ejercicio583Producto p = (Ejercicio583Producto) in.readObject();
                System.out.println(p);
            }
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}