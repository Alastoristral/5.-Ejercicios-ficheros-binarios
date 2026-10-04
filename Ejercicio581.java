import java.io.*;

public class Ejercicio581 {
    public static void main(String[] args) {
        try {
            // Escribir
            DataOutputStream out = new DataOutputStream(new FileOutputStream("numeros.bin"));
            for (int i = 1; i <= 50; i++) {
                out.writeInt(i);
            }
            out.close();

            // Leer
            DataInputStream in = new DataInputStream(new FileInputStream("numeros.bin"));
            try {
                while (true) {
                    System.out.println(in.readInt());
                }
            } catch (EOFException e) {
                // Fin del fichero
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}