package problemaRecursos;

public class Main {
    public static void main(String[] args) {
        Recurso recurso = new Recurso(5); // Cambia el valor según tus necesidades

        Thread proceso1 = new Thread(new Proceso(recurso));
        Thread proceso2 = new Thread(new Proceso(recurso));

        proceso1.start();
        proceso2.start();
    }
}
