import java.io.*;
import java.util.Scanner;

public class Ejercicio54 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de becarios: ");
        int n = Integer.parseInt(sc.nextLine());

        DataOutputStream out = new DataOutputStream(new FileOutputStream("datosbeca.bin", true));
        for (int i = 1; i <= n; i++) {
            System.out.println("Becario " + i);
            System.out.print("Nombre y apellido: ");
            out.writeUTF(sc.nextLine());
            System.out.print("Sexo (H-M): ");
            out.writeUTF(sc.nextLine());
            System.out.print("Edad (20-60): ");
            out.writeInt(Integer.parseInt(sc.nextLine()));
            System.out.print("Suspensos (0-4): ");
            out.writeInt(Integer.parseInt(sc.nextLine()));
            System.out.print("Residencia familiar (SI/NO): ");
            out.writeUTF(sc.nextLine());
            System.out.print("Ingresos anuales: ");
            out.writeDouble(Double.parseDouble(sc.nextLine()));
            System.out.print("Tiene beca (SI/NO): ");
            out.writeUTF(sc.nextLine());
        }
        out.close();

        DataInputStream in = new DataInputStream(new FileInputStream("datosbeca.bin"));
        while (in.available() > 0) {
            System.out.println(in.readUTF() + " | " + in.readUTF() + " | " + in.readInt() + " | "
                    + in.readInt() + " | " + in.readUTF() + " | " + in.readDouble() + " | " + in.readUTF());
        }
        in.close();
    }
}