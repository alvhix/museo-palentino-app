# MuseoPalentinoApp

Programa de un museo realizado como proyecto final de 1º DAW para el módulo de programación

## Empezando
Este proyecto se trata de una aplicación de un museo al que tienen acceso los clientes, guías y administradores. La funcionalidad para los clientes es la de poder reservar entradas para poder acceder a una determinada exposición en nuestro supuesto museo ficticio. Por otro lado, los guías podrán visualizar los datos de los clientes a los que guiará en la exposición. Por último, los administradores, podrán visualizar todas las reservas realizadas por los clientes y administrar las exposiciones y las obras.

### Prerrequisitos

Para poder ejecutar el programa debe usar el IDE NetBeans o IntelliJ IDEA y como JDK el Java SE 8 o superiores
```
NetBeans + JDK 8
IntelliJ + JDK 12
```

### Instalación

1. Clone el repositorio desde GitHub a su equipo local.
El proyecto incluye 3 librerías para poder funcionar correctamente que son descargadas al clonar el repositorio.
* MYSQLDriver
* JCalendar
* AbsoluteLayout
(El IDE debe reconocer automáticamente las 3 librerías, en caso de no ser así, importa manualmente las 3 librerías incluidas en la carpeta /lib/ y añádelas a tu proyecto local)

2. Importe la base de datos en su servidor local para que la aplicación funcione. La base de datos se encuentra en el directorio /db/museopalentinoapp.sql

3. Asegúrese de que dispone del JDK instalado en su equipo para poder ejecutar la aplicación:
Hay 2 archivos .JAR disponibles:
* **Versión 52.0 (Java SE 8)** - se encuentra en la carpeta /dist/MuseoPalentinoApp.jar
* **Versión 56.0 (Java SE 12)** - se encuentra en la carpeta /out/artifacts/MuseoPalentinoApp_jar/MuseoPalentinoApp.jar
Para poder arrancar la aplicación debe ejecutar uno de estos dos archivos. **Recuerde que para que la aplicación funcione debe tener instalado en su equipo la versión JDK 8 o superior**

## Autores

* **Víctor** - [VicBoss11](https://github.com/VicBoss11)
* **Álvaro** - [Alvhix](https://github.com/Alvhix)
* **Guillermo** - [PonceDeNeon](https://github.com/PonceDeNeon)

## Licencia

MuseoPalentinoApp is licensed under the

**GNU General Public License v3.0**

Permissions of this strong copyleft license are conditioned on making available complete source code of licensed works and modifications, which include larger works using a licensed work, under the same license. Copyright and license notices must be preserved.

## Planes de ampliación

* Optimización de la aplicación
* Mejoras en la plataforma de pago de las entradas
* Mejoras visuales en el menú de administrador
* etc...

