import java.io.*;
import java.util.Scanner;

public class Ejercicio582 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Escribir
            DataOutputStream out = new DataOutputStream(new FileOutputStream("alumnos.bin"));
            for (int i = 1; i <= 5; i++) {
                System.out.print("Nombre del alumno " + i + ": ");
                String nombre = sc.nextLine();
                System.out.print("Nota media: ");
                double nota = sc.nextDouble();
                sc.nextLine(); // limpiar el intro
                out.writeUTF(nombre);
                out.writeDouble(nota);
            }
            out.close();

            // Leer (mismo orden en que se escribió)
            DataInputStream in = new DataInputStream(new FileInputStream("alumnos.bin"));
            for (int i = 1; i <= 5; i++) {
                String nombre = in.readUTF();
                double nota = in.readDouble();
                System.out.println(nombre + " - " + nota);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}