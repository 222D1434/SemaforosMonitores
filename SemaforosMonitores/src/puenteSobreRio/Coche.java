package puenteSobreRio;

class Coche implements Runnable {
    private Puente puente;

    public Coche(Puente puente) {
        this.puente = puente;
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().contains("Norte")) {
            puente.cruzarPuenteDesdeNorte();
        } else {
            puente.cruzarPuenteDesdeSur();
        }

        // Realiza otras operaciones si es necesario

        puente.salirDelPuente();
    }
}