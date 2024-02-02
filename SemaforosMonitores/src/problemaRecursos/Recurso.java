package problemaRecursos;

import java.util.concurrent.Semaphore;

class Recurso {
    private Semaphore semaforo;
    private int unidades;

    public Recurso(int k) {
        semaforo = new Semaphore(k, true);
        unidades = k;
    }

    public void reserva(int r) {
        try {
            semaforo.acquire(r);
            unidades -= r;
            System.out.println(Thread.currentThread().getName() + " ha reservado " + r + " unidades. Unidades restantes: " + unidades);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void libera(int l) {
        semaforo.release(l);
        unidades += l;
        System.out.println(Thread.currentThread().getName() + " ha liberado " + l + " unidades. Unidades restantes: " + unidades);
    }
}