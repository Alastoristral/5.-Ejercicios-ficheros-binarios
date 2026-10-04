import java.io.*;

public class Ejercicio510 {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream("nominas.bin"));
        DataOutputStream out = new DataOutputStream(new FileOutputStream("temporal.bin"));
        int eliminados = 0;

        while (in.available() > 0) {
            String nombre = in.readUTF();
            int dias = in.readInt();
            double nomina = in.readDouble();

            if (dias > 10) {
                eliminados++;          // no se copia: se elimina
            } else {
                if (dias == 0) nomina = nomina * 1.05;
                else if (dias >= 4) nomina = nomina * 0.90;
                // entre 1 y 3 días: igual
                out.writeUTF(nombre);
                out.writeInt(dias);
                out.writeDouble(nomina);
            }
        }
        in.close();
        out.close();

        // Sustituir el fichero original por el actualizado
        new File("nominas.bin").delete();
        new File("temporal.bin").renameTo(new File("nominas.bin"));

        // Mostrar el fichero actualizado
        in = new DataInputStream(new FileInputStream("nominas.bin"));
        while (in.available() > 0) {
            System.out.println(in.readUTF() + " | " + in.readInt() + " | " + in.readDouble());
        }
        in.close();

        System.out.println("Empleados dados de baja: " + eliminados);
    }
}