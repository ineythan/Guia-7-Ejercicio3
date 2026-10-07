package Ejercicio3;
public class Empleado {
    private int numId;
    private String nomWorker;
    private double sueldoVal;

    public Empleado(int numId, String nomWorker, double sueldoVal) {
        this.numId = numId;
        this.nomWorker = nomWorker;
        this.sueldoVal = sueldoVal;
    }

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public String getNomWorker() {
        return nomWorker;
    }

    public void setNomWorker(String nomWorker) {
        this.nomWorker = nomWorker;
    }

    public double getSueldoVal() {
        return sueldoVal;
    }

    public void setSueldoVal(double sueldoVal) {
        this.sueldoVal = sueldoVal;
    }

    @Override
    public String toString() {
        return "numero " + numId + " nombre " + nomWorker.toLowerCase() + " sueldo " + sueldoVal;
    }
}