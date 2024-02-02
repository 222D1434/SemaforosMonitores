package puenteSobreRio;

public class Main {
    public static void main(String[] args) {
        Puente puente = new Puente();

        Thread cocheNorte1 = new Thread(new Coche(puente), "CocheNorte1");
        Thread cocheNorte2 = new Thread(new Coche(puente), "CocheNorte2");
        Thread cocheSur1 = new Thread(new Coche(puente), "CocheSur1");
        Thread cocheSur2 = new Thread(new Coche(puente), "CocheSur2");

        cocheNorte1.start();
        cocheNorte2.start();
        cocheSur1.start();
        cocheSur2.start();
    }
}