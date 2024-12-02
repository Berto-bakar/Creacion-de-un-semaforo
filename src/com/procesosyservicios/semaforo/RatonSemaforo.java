package com.procesosyservicios.semaforo;

import java.util.concurrent.Semaphore;

public class RatonSemaforo implements Runnable {

    private String nombre;
    private int tiempoAlimentacion;
    private static final Semaphore semaforo = new Semaphore(3); // Permitir 3 ratones simultáneamente

    public RatonSemaforo(String nombre, int tiempoAlimentacion) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer() {
        try {
            System.out.printf("El ratón %s está intentando acceder al comedero%n", nombre);

            // Intentar adquirir un permiso del semáforo
            semaforo.acquire();

            // Una vez obtenido el permiso, comienza a comer
            System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);
            Thread.sleep(tiempoAlimentacion * 1000);
            System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre);

        } catch (InterruptedException ex) {
            System.err.printf("El ratón %s fue interrumpido%n", nombre);
            Thread.currentThread().interrupt();
        } finally {
            // Liberar el permiso del semáforo
            semaforo.release();
            System.out.printf("El ratón %s dejó el comedero%n", nombre);
        }
    }

    public static void main(String[] args) {
        
        RatonSemaforo raton1 = new RatonSemaforo("Ratón 1", 4);
        RatonSemaforo raton2 = new RatonSemaforo("Ratón 2", 8);
        RatonSemaforo raton3 = new RatonSemaforo("Ratón 3", 3);
        RatonSemaforo raton4 = new RatonSemaforo("Ratón 4", 6);
        RatonSemaforo raton5 = new RatonSemaforo("Ratón 5", 4);
        RatonSemaforo raton6 = new RatonSemaforo("Ratón 6", 9);
        RatonSemaforo raton7 = new RatonSemaforo("Ratón 7", 2);
        RatonSemaforo raton8 = new RatonSemaforo("Ratón 8", 7);
        RatonSemaforo raton9 = new RatonSemaforo("Ratón 9", 10);
        RatonSemaforo raton10 = new RatonSemaforo("Ratón 10", 2);
        
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
