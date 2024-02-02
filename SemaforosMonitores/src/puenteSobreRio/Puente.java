package puenteSobreRio;

import java.util.concurrent.locks.*;

class Puente {
    private int cochesEnPuente = 0;
    private Lock lock = new ReentrantLock();
    private Condition esperaNorte = lock.newCondition();
    private Condition esperaSur = lock.newCondition();

    public void cruzarPuenteDesdeNorte() {
        lock.lock();
        try {
            while (cochesEnPuente > 0) {
                esperaNorte.await();
            }
            cochesEnPuente++;
            System.out.println(Thread.currentThread().getName() + " cruzando el puente desde el norte");
            esperaSur.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void cruzarPuenteDesdeSur() {
        lock.lock();
        try {
            while (cochesEnPuente > 0) {
                esperaSur.await();
            }
            cochesEnPuente++;
            System.out.println(Thread.currentThread().getName() + " cruzando el puente desde el sur");
            esperaNorte.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void salirDelPuente() {
        lock.lock();
        try {
            cochesEnPuente--;
            System.out.println(Thread.currentThread().getName() + " ha salido del puente");
        } finally {
            lock.unlock();
        }
    }
}
