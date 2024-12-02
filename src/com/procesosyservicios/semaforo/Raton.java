package com.procesosyservicios.semaforo;

public class Raton implements Runnable {

    private String nombre;
    private int tiempoAlimentacion;

    public Raton(String nombre, int tiempoAlimentacion) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer() {

        try {
            System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);
            Thread.sleep(tiempoAlimentacion * 1000);
            System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Raton raton1 = new Raton("Ratón 1", 4);
        Raton raton2 = new Raton("Ratón 2", 8);
        Raton raton3 = new Raton("Ratón 3", 3);
        Raton raton4 = new Raton("Ratón 4", 6);
        Raton raton5 = new Raton("Ratón 5", 4);
        Raton raton6 = new Raton("Ratón 6", 9);
        Raton raton7 = new Raton("Ratón 7", 2);
        Raton raton8 = new Raton("Ratón 8", 7);
        Raton raton9 = new Raton("Ratón 9", 10);
        Raton raton10 = new Raton("Ratón 10", 2);
        
        new Thread(raton1).start();
        new Thread(raton2).start();
        new Thread(raton3).start();
        new Thread(raton4).start();
        new Thread(raton5).start();
        new Thread(raton6).start();
        new Thread(raton7).start();
        new Thread(raton8).start();
        new Thread(raton9).start();
        new Thread(raton10).start();
        
    }

    @Override
    public void run() {
        this.comer();
    }

}
