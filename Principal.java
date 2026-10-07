package Ejercicio3;

import java.io.*;

public class Principal {
    public static void main(String[] args) {
        File archInicial = new File("empleados.txt");
        if (!archInicial.exists()) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(archInicial))) {
                pw.println("101,kristel jazmin,2800.5");
                pw.println("102,miri fiorela,3100.0");
                pw.println("103,nahaydi nyevm,2950.0");
            } catch (IOException e) {
                System.out.println("error en escritura de archivo inicial");
            }
        }

        EmpleadoModelo modelo = new EmpleadoModelo("empleados.txt");
        EmpleadoVista vista = new EmpleadoVista();
        EmpleadoControlador controlador = new EmpleadoControlador(modelo, vista);

        controlador.iniciar();
    }
}