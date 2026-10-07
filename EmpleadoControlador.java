package Ejercicio3;

import java.util.*;

public class EmpleadoControlador {
    private EmpleadoModelo modelo;
    private EmpleadoVista vista;

    public EmpleadoControlador(EmpleadoModelo modelo, EmpleadoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        System.out.println("cargando registros del archvo");
        ArrayList<Empleado> cargados = modelo.leerEmpleados();
        vista.mostrarListado(cargados);

        boolean continuar = true;
        while (continuar) {
            vista.desplegarMenu();
            int opcion = vista.capturarOpcion();
            switch (opcion) {
                case 1:
                    vista.mostrarListado(modelo.getListaEmp());
                    break;
                case 2:
                    Empleado nuevo = vista.pedirNuevoEmpleado();
                    if (nuevo != null) {
                        boolean ok = modelo.agregarEmpleado(nuevo);
                        vista.avisarResultado(ok, "guardar");
                    }
                    break;
                case 3:
                    int numBuscado = vista.pedirNumeroConsulta();
                    if (numBuscado != -1) {
                        Empleado hallado = modelo.buscarEmpleado(numBuscado);
                        vista.mostrarDetalle(hallado);
                    }
                    break;
                case 4:
                    int numBorrar = vista.pedirNumeroConsulta();
                    if (numBorrar != -1) {
                        boolean borrado = modelo.eliminarEmpleado(numBorrar);
                        vista.avisarResultado(borrado, "eliminar");
                    }
                    break;
                case 5:
                    continuar = false;
                    vista.avisarSalida();
                    break;
                default:
                    System.out.println("opsion no valida intente de nuevo");
                    break;
            }
        }
    }
}