import java.io.*;

public class Ejercicio57 {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream("muchosdatos.bin"));
        DataOutputStream menores = new DataOutputStream(new FileOutputStream("menores.dat"));
        DataOutputStream adultos = new DataOutputStream(new FileOutputStream("adultos.dat"));
        DataOutputStream mayores = new DataOutputStream(new FileOutputStream("mayores.dat"));

        while (in.available() > 0) {
            String nombre = in.readUTF();
            String apellidos = in.readUTF();
            int edad = in.readInt();
            String telefono = in.readUTF();
            String email = in.readUTF();
            String ciudad = in.readUTF();
            String nacionalidad = in.readUTF();
            String profesion = in.readUTF();

            DataOutputStream destino;
            if (edad < 18) destino = menores;
            else if (edad <= 65) destino = adultos;
            else destino = mayores;

            destino.writeUTF(nombre);
            destino.writeUTF(apellidos);
            destino.writeInt(edad);
            destino.writeUTF(telefono);
            destino.writeUTF(email);
            destino.writeUTF(ciudad);
            destino.writeUTF(nacionalidad);
            destino.writeUTF(profesion);
        }
        in.close();
        menores.close();
        adultos.close();
        mayores.close();

        mostrar("menores.dat");
        mostrar("adultos.dat");
        mostrar("mayores.dat");
    }

    static void mostrar(String fichero) throws IOException {
        System.out.println("--- " + fichero + " ---");
        DataInputStream in = new DataInputStream(new FileInputStream(fichero));
        while (in.available() > 0) {
            System.out.println(in.readUTF() + " | " + in.readUTF() + " | " + in.readInt() + " | "
                    + in.readUTF() + " | " + in.readUTF() + " | " + in.readUTF() + " | "
                    + in.readUTF() + " | " + in.readUTF());
        }
        in.close();
    }
}