import java.io.*;
import java.util.Scanner;

public class Ejercicio52 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de vehículos: ");
        int n = Integer.parseInt(sc.nextLine());

        DataOutputStream out = new DataOutputStream(new FileOutputStream("vehiculos.bin", true));
        for (int i = 1; i <= n; i++) {
            System.out.println("Vehículo " + i);
            System.out.print("Matrícula: ");
            out.writeUTF(sc.nextLine());
            System.out.print("Marca: ");
            out.writeUTF(sc.nextLine());
            System.out.print("Tamaño del depósito: ");
            out.writeDouble(Double.parseDouble(sc.nextLine()));
            System.out.print("Modelo: ");
            out.writeUTF(sc.nextLine());
        }
        out.close();

        DataInputStream in = new DataInputStream(new FileInputStream("vehiculos.bin"));
        while (in.available() > 0) {
            String matricula = in.readUTF();
            String marca = in.readUTF();
            double deposito = in.readDouble();
            String modelo = in.readUTF();
            System.out.println(matricula + " - " + marca + " - " + deposito + " - " + modelo);
        }
        in.close();
    }
}