package com.procesosyservicios.semaforo;

import java.util.concurrent.Semaphore;

public class RatonSemaforoParametrizado implements Runnable {

    private String nombre;
    private int tiempoAlimentacion;
    private Semaphore semaforo; // Controla el número máximo de ratones simultáneos

    // Constructor
    public RatonSemaforoParametrizado(String nombre, int tiempoAlimentacion, Semaphore semaforo) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
        this.semaforo = semaforo; // Asignar el semáforo
    }

    // Método que simula la alimentación del ratón
    public void comer() {
        try {
            System.out.printf("El %s está intentando acceder al comedero%n", nombre);

            // Intentar adquirir un permiso del semáforo
            semaforo.acquire();

            // Simula la alimentación
            System.out.printf("El %s ha comenzado a alimentarse%n", nombre);
            Thread.sleep(tiempoAlimentacion * 1000); // Tiempo simulado de alimentación
            System.out.printf("El %s ha terminado de alimentarse%n", nombre);
        } catch (InterruptedException ex) {
            System.err.printf("El %s fue interrumpido%n", nombre);
            Thread.currentThread().interrupt();
        } finally {
            // Liberar el permiso del semáforo
            semaforo.release();
            System.out.printf("El %s dejó el comedero%n", nombre);
        }
    }

    @Override
    public void run() {
        this.comer();
    }

    // Método principal
    public static void main(String[] args) {
        
        args = new String[]{"6", "2", "8"};
        
        if (args.length < 3) {
            System.out.println("Uso: java RatonSemaforoParametrizado <numRatones> <ratonesSimultaneos> <tiempoMaxAlimentacion>");
            System.exit(1);
        }

        // Parámetros configurables a través de línea de comandos
        int numRatones = Integer.parseInt(args[0]); // Total de ratones
        int maxSimultaneos = Integer.parseInt(args[1]); // Máximo de ratones simultáneos
        int tiempoMaxAlimentacion = Integer.parseInt(args[2]); // Tiempo máximo de alimentación (segundos)

        // Inicializar semáforo
        Semaphore semaforo = new Semaphore(maxSimultaneos);

        // Crear y ejecutar ratones
        Thread[] hilos = new Thread[numRatones];
        for (int i = 0; i < numRatones; i++) {
            int tiempoAlimentacion = (int) (Math.random() * tiempoMaxAlimentacion) + 1;
            hilos[i] = new Thread(new RatonSemaforoParametrizado("Ratón " + (i + 1), tiempoAlimentacion, semaforo));
            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Todos los ratones han terminado de alimentarse.");
    }
}