import java.io.*;
import java.util.Scanner;

public class Ejercicio53 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DataOutputStream out = new DataOutputStream(new FileOutputStream("datosbeca.bin"));

        System.out.print("Nombre y apellido: ");
        out.writeUTF(sc.nextLine());
        System.out.print("Sexo (H-M): ");
        out.writeUTF(sc.nextLine());
        System.out.print("Edad (20-60): ");
        out.writeInt(Integer.parseInt(sc.nextLine()));
        System.out.print("Suspensos del curso anterior (0-4): ");
        out.writeInt(Integer.parseInt(sc.nextLine()));
        System.out.print("Residencia familiar (SI/NO): ");
        out.writeUTF(sc.nextLine());
        System.out.print("Ingresos anuales de la familia: ");
        out.writeDouble(Double.parseDouble(sc.nextLine()));
        System.out.print("Tiene beca (SI/NO): ");
        out.writeUTF(sc.nextLine());

        out.close();
    }
}