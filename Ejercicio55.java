import java.io.*;

public class Ejercicio55 {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream("datosbeca.bin"));
        while (in.available() > 0) {
            String nombre = in.readUTF();
            String sexo = in.readUTF();
            int edad = in.readInt();
            int suspensos = in.readInt();
            String residencia = in.readUTF();
            double ingresos = in.readDouble();
            String beca = in.readUTF();

            // Solo los que tienen beca y menos de 2 suspensos
            if (beca.equalsIgnoreCase("SI") && suspensos < 2) {
                double total = 1500;
                if (ingresos <= 12000) total += 500;
                if (edad < 23) total += 200;
                if (suspensos == 0) total += 500;
                else total += 200; // 1 suspenso
                if (residencia.equalsIgnoreCase("NO")) total += 1000;

                System.out.println(nombre + ": " + total + " €");
            }
        }
        in.close();
    }
}