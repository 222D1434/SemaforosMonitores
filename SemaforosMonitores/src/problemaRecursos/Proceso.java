package problemaRecursos;

class Proceso implements Runnable {
    private Recurso recurso;

    public Proceso(Recurso recurso) {
        this.recurso = recurso;
    }

    @Override
    public void run() {
        recurso.reserva(2); // Cambia el valor según tus necesidades
        // Realiza otras operaciones si es necesario
        recurso.libera(2); // Cambia el valor según tus necesidades
    }
}