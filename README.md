# Semáforo

## Tarea 01 PSYP

### Implementar un Semáforo

*Instrucciones

Queremos crear un semáforo que nos asegure que únicamente X hilos pueden acceder concurrentemente a un bloque de código.


*Mejora de nota
 
 Contiene documentación explicando la solución, requisitos, prueba de que funciona
 
 Los valores utilizados son parametrizables en tiempo de ejecución
 
 Se utiliza un framework de pruebas automatizadas (por ejemplo jUnit)
 
Variables propuestas

Número de hilos concurrentes

Número de hilos simultáneos permitidos al acceder al bloque controlado

Tiempo de espera

Tiempo de ejecución del bloque controlado


### Comentarios acerca de la tarea

Realizadas Tres clases.

* La primera clase Raton contiene 10 ratones los cuales se empiezan a alimentar "a la vez" y cada uno de ellos tarda el tiempo que
asignado para comer.

![image](https://github.com/user-attachments/assets/9c0ef409-dd2e-4676-a174-1098eb8f8cda)

* la clase RatonSemaforo creamos un semáforo para que sólo se puedan alimentar 3 ratones a la vez, podemos observar como sólo entran 3
ratones al comedero de cada vez, hasta que un ratón no abandona el comedero, no puede acceder otro, los ratones que no han comido y no están comiendo se
encuentran a la espera de poder usar el "comedero"

![image](https://github.com/user-attachments/assets/a49ce070-4df9-47b0-84fc-5e1bf6748c98)

* La clase RatonSemaforoParametrizado es similar a la anterior salvo que en esta clase podemos decir el número de ratones que queremos tener, la limitación del semáforo y por
último el tiempo que como mucho pueden invertir en comer esos ratones.

![image](https://github.com/user-attachments/assets/99f43751-652e-4862-bc2f-f273aba12acc)

![image](https://github.com/user-attachments/assets/b9f935b5-15a8-4bd8-8cd5-629e222df03e)






## Comentarios
* Como importar o clonar un proyecto desde GitHub

