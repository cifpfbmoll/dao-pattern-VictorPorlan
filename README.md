# DAO pattern quarkus
La nueva tarea de este sprint es replicar el DAO pattern 
usando MariaDB dockerizado y volviendo a usar un modulo repository como haciamos antes 
del active-record-pattern, pero ahora este repo será el que implemente Panache

## Novedades de las espadas

He añadido una función que no puse en el active-record-pattern de afilado de espadas que actualiza el estado 
de la variable "afilada" a true, y una función de atacar que la cambia a false.
Lo he hecho más que nada para probar a actualizar partametros en la base de datos de entidades que ya existian dentro de esta, ya que hasta ahora
solo habiamos creado o eliminado entidades, pero no las habiamos actualizado.
Puedes probar esta función en los endpoints:
<br>
<br>
*/espadas/afilar/{nombre}*
<br>
*/espadas/atacar/{nombre}*
<br>
<br>
## Docker MariaDB
Usa este comando para generar un contenedor de MariaDB con las variables 
de entorno necesarias para conectarla a la API Rest.

```
docker run -ti --rm -e MYSQL_ROOT_PASSWORD=developer -e MYSQL_USER=developer -e MYSQL_PASSWORD=developer -e MYSQL_DATABASE=espadas -p 3000:3306 mariadb:latest
```

## Usar la API
Acto seguido ejecuta este comando para iniciar la API en modo desarrollo en el puerto 8080 de tu localhost
```
.\mvnw compile quarkus:dev
```
## Testing
Los casos tests están preparados para un despliegue automático en contenedores docker. Usa alguno de estos comandos para ejecutarlos todos o solo un modulo en especifico.
```
.\mvnw -Dtest="EspadaResourceTest" test
```
```
.\mvnw -Dtest="EspadaServiceTest" test
```
```
.\mvnw test
```
He añadido una función de afilado de espadas que actualiza el estado de la variable "afilada" a true, y una función de atacar que la cambia a false.
Lo he hecho más que nada para probar a actualizar partametros en la base de datos de entidades que ya existian dentro de esta, ya que hasta ahora
solo habiamos creado o eliminado entidades, pero no las habiamos actualizado.


Soy consciente de que el repo tenia tematica de frutas originalmente, pero como me estoy leyendo [Berserk](https://es.wikipedia.org/wiki/Berserk_(manga)),
escrito por Kentaro Miura (DEP), y el prota es famoso por su caracteristica espada Dragonslayer 
decidí usar esta temática.

# getting-started project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/getting-started-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Provided examples

### RESTEasy JAX-RS example

REST is easy peasy with this Hello World RESTEasy resource.

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
