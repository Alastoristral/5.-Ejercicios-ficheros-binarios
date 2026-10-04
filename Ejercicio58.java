import java.io.*;
import java.util.Scanner;

public class Ejercicio58 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Día de septiembre: ");
        int dia = sc.nextInt();

        BufferedReader br = new BufferedReader(new FileReader("temperaturas.txt"));
        DataOutputStream out = new DataOutputStream(new FileOutputStream("Septemp.dat"));

        String linea;
        while ((linea = br.readLine()) != null) {
            // Ejemplo de línea: Día 01, Hora 00:00, Temperatura 33°C
            String[] partes = linea.split(", ");
            int d = Integer.parseInt(partes[0].replaceAll("[^0-9]", ""));
            if (d == dia) {
                String h = partes[1].substring(partes[1].indexOf(' ') + 1, partes[1].indexOf(':'));
                out.writeInt(d);
                out.writeInt(Integer.parseInt(h));
                out.writeDouble(Double.parseDouble(partes[2].replaceAll("[^0-9.-]", "")));
            }
        }
        br.close();
        out.close();
    }
}