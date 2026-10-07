package Ejercicio3;

import java.io.*;
import java.util.*;

public class EmpleadoModelo {
    private String rutaArchivo;
    private ArrayList<Empleado> listaEmp;

    public EmpleadoModelo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.listaEmp = new ArrayList<Empleado>();
    }

    public ArrayList<Empleado> leerEmpleados() {
        listaEmp.clear();
        File arch = new File(rutaArchivo);
        if (!arch.exists()) {
            return listaEmp;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(arch))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] partes = linea.split(",");
                    if (partes.length == 3) {
                        int num = Integer.parseInt(partes[0].trim());
                        String nom = partes[1].trim();
                        double sueldo = Double.parseDouble(partes[2].trim());
                        listaEmp.add(new Empleado(num, nom, sueldo));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("se capturo una exepcion al intentar leer el archvo");
        } catch (NumberFormatException e) {
            System.out.println("se ha capturado un error en la conversion numerica");
        }
        return listaEmp;
    }

    public boolean agregarEmpleado(Empleado empNuevo) {
        for (int i = 0; i < listaEmp.size(); i++) {
            if (listaEmp.get(i).getNumId() == empNuevo.getNumId()) {
                System.out.println("el numero de empelado ya existe");
                return false;
            }
        }
        listaEmp.add(empNuevo);
        return persistirArchivo();
    }

    public Empleado buscarEmpleado(int numBuscar) {
        for (int i = 0; i < listaEmp.size(); i++) {
            if (listaEmp.get(i).getNumId() == numBuscar) {
                return listaEmp.get(i);
            }
        }
        return null;
    }

    public boolean eliminarEmpleado(int numBorrar) {
        Empleado objetivo = null;
        for (int i = 0; i < listaEmp.size(); i++) {
            if (listaEmp.get(i).getNumId() == numBorrar) {
                objetivo = listaEmp.get(i);
                break;
            }
        }
        if (objetivo != null) {
            listaEmp.remove(objetivo);
            return persistirArchivo();
        }
        return false;
    }

    private boolean persistirArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (int i = 0; i < listaEmp.size(); i++) {
                Empleado e = listaEmp.get(i);
                pw.println(e.getNumId() + "," + e.getNomWorker() + "," + e.getSueldoVal());
            }
            return true;
        } catch (IOException e) {
            System.out.println("error en escritura de archivo");
            return false;
        }
    }

    public ArrayList<Empleado> getListaEmp() {
        return listaEmp;
    }
}