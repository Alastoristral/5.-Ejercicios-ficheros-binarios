import java.io.*;
import java.util.Scanner;

public class Ejercicio56 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de personas: ");
        int n = Integer.parseInt(sc.nextLine());

        DataOutputStream out = new DataOutputStream(new FileOutputStream("datospersonas.dat"));
        for (int i = 1; i <= n; i++) {
            System.out.println("Persona " + i);
            System.out.print("Nombre: ");
            out.writeUTF(sc.nextLine());
            System.out.print("Apellidos: ");
            out.writeUTF(sc.nextLine());
            System.out.print("Edad: ");
            out.writeInt(Integer.parseInt(sc.nextLine()));
            System.out.print("Teléfono: ");
            out.writeUTF(sc.nextLine());
            System.out.print("Email: ");
            out.writeUTF(sc.nextLine());
            System.out.print("Ciudad: ");
            out.writeUTF(sc.nextLine());
            System.out.print("Nacionalidad: ");
            out.writeUTF(sc.nextLine());
            System.out.print("Profesión: ");
            out.writeUTF(sc.nextLine());
        }
        out.close();

        DataInputStream in = new DataInputStream(new FileInputStream("datospersonas.dat"));
        while (in.available() > 0) {
            System.out.println(in.readUTF() + " | " + in.readUTF() + " | " + in.readInt() + " | "
                    + in.readUTF() + " | " + in.readUTF() + " | " + in.readUTF() + " | "
                    + in.readUTF() + " | " + in.readUTF());
        }
        in.close();
    }
}