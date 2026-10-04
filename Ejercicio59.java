import java.io.*;

public class Ejercicio59 {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream("Septemp.dat"));

        double max = -1000, min = 1000, suma = 0;
        int horaMax = 0, horaMin = 0, cantidad = 0;

        while (in.available() > 0) {
            int dia = in.readInt();
            int hora = in.readInt();
            double temp = in.readDouble();

            if (temp > max) {
                max = temp;
                horaMax = hora;
            }
            if (temp < min) {
                min = temp;
                horaMin = hora;
            }
            suma += temp;
            cantidad++;
        }
        in.close();

        System.out.println("Temperatura máxima: " + max + " (hora más calurosa: " + horaMax + ":00)");
        System.out.println("Temperatura mínima: " + min + " (hora más fría: " + horaMin + ":00)");
        System.out.println("Temperatura media: " + suma / cantidad);
    }
}