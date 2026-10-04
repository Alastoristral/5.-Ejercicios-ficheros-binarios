import java.io.*;
import java.util.Scanner;

public class Ejercicio51 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cantidad de números: ");
        int n = sc.nextInt();
        System.out.print("Mínimo: ");
        int min = sc.nextInt();
        System.out.print("Máximo: ");
        int max = sc.nextInt();

        DataOutputStream out = new DataOutputStream(new FileOutputStream("num_aleat.bin", true));
        for (int i = 0; i < n; i++) {
            out.writeInt((int) (Math.random() * (max - min + 1)) + min);
        }
        out.close();

        DataInputStream in = new DataInputStream(new FileInputStream("num_aleat.bin"));
        while (in.available() > 0) {
            System.out.println(in.readInt());
        }
        in.close();
    }
}