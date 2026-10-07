package Ejercicio3;
import java.util.*;

public class EmpleadoVista {
    private Scanner teclado;

    public EmpleadoVista() {
        this.teclado = new Scanner(System.in);
    }

    public void desplegarMenu() {
        System.out.println();
        System.out.println("gestion de personal");
        System.out.println("1 listar empelados registrados");
        System.out.println("2 agregar un nuevo trbajador");
        System.out.println("3 buscar trbajador por numero");
        System.out.println("4 borrar trbajador por numero");
        System.out.println("5 salir del pograma");
        System.out.print("elija una opsion ");
    }

    public int capturarOpcion() {
        try {
            int opc = Integer.parseInt(teclado.nextLine());
            return opc;
        } catch (NumberFormatException e) {
            System.out.println("se capturo una exepcion de opcion no valida");
            return -1;
        }
    }

    public Empleado pedirNuevoEmpleado() {
        try {
            System.out.print("ingrese el numero del trbajador ");
            int num = Integer.parseInt(teclado.nextLine());
            System.out.print("ingrese nombre del trbajador ");
            String nom = teclado.nextLine();
            System.out.print("ingrese sueldo ");
            double sueldo = Double.parseDouble(teclado.nextLine());
            return new Empleado(num, nom, sueldo);
        } catch (NumberFormatException e) {
            System.out.println("hubo un error al ingresar los numeros");
            return null;
        }
    }

    public int pedirNumeroConsulta() {
        try {
            System.out.print("ingrese el numero a procesar ");
            return Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("se capturo un problema con el numero ingresado");
            return -1;
        }
    }

    public void mostrarListado(ArrayList<Empleado> lista) {
        if (lista.isEmpty()) {
            System.out.println("no hay empelados en el archvo");
            return;
        }
        System.out.println("lista de personal");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public void mostrarDetalle(Empleado e) {
        if (e != null) {
            System.out.println("trbajador encontrado");
            System.out.println(e);
        } else {
            System.out.println("el empelado no fue encontrado en el archvo");
        }
    }

    public void avisarResultado(boolean exito, String accion) {
        if (exito) {
            System.out.println("operacion " + accion + " ejecutada con exito");
        } else {
            System.out.println("hubo un error al realizar la accion de " + accion);
        }
    }

    public void avisarSalida() {
        System.out.println("saliendo del pograma");
    }
}