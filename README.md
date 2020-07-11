# Board - Seguridad en Websockets y web
### Autor: Carlos Andrés Ramírez Torres
### Fecha: Viernes, 10 de Julio del 2020
##### LOC/h: 2019/16 = 126.18 LOC/h

## Board

Consiste en una aplicacion web que permite a multiples usuarios participar en un tablero en el cual pueden dibujar.

* **Login**: Para la implementacion del proyecto se utiliza un login en el cual se encuentran registrados dos usuarios de los cuales se hablara a continuacion en la seccion de uso.

## Link de heroku para dibujar.

[https://boardfinal.herokuapp.com/bb2.html](https://boardfinal.herokuapp.com/bb2.html)

## Uso 

Para el desarrollo del proyecto se utilizo

* **Maven** como una herramienta para la construccion y gestion del mismo.
* **Java** el codigo fue desarrollado con el lenguaje de programación.
* **Spring** framework utilizado.
* **Desarrollo web**: React y Js.
* **P5Js**: Libreria que facilita el desarrollo del producto, otorgando metodos para la implementacion de objetos (figuras) que son utilizados en el proyecto.
* **Redis**: Motor de base de datos en el cual se almacenaran los tickets de sessiones respectivas.

Utilizar `mvn package` para la generacion del fichero .jar con los .class compilados.

![Texto alternativo](https://github.com/CAndresRa/board-final/blob/master/imgReadme/package.png)

Una vez realizado el `mvn package` el codigo estara listo para ser utilizado bajo la siguiente estructura.

Debido a que es un proyecto que utiliza como framework **Spring**, la manera de ejecutarlo en conjunto a **Maven** es mediante el siguiente comando en terminal.
 
`mvn spring-boot:run`

por ejemplo y dando como resultado observe que subrayado se encuentra la configuracion hacia redis:

![Texto alternativo](https://github.com/CAndresRa/board-final/blob/master/imgReadme/spring.png)

Una vez se ingrese al sitio se encontrara con la siguiente vista.

![Texto alternativo]()

Para el ingreso existen dos usuarios.

* Usuario uno:
Usuario: **user**
Contraseña: **1234**

* Usuario dos:
Usuario: **user2**
Contraseña: **1234**


## Diagrama

* Aplicación 

![Texto alternativo](https://github.com/CAndresRa/board-final/blob/master/imgReadme/diagram.png)

La aplicacion inicia cuando un **cliente** ingresa, este cliente valida su cuenta mediante un login que encuentra en el browser, una vez inicia la **session** solicita al controlador **DrawingServiceController** un ticket que se validara una vez se genere la instancia en el **websocket** de la clase **BBEndPoint**, la session se almacena en el motor de base de datos **Redis** para que ante cualquier eventualidad del servidor evite una caida por parte del cliente debidamente autenticado, adicionalmente para el funcionamiento de los componentes se realizaron las configuraciones pertinentes que se encuentran en las clases **WebSecuritySocket**, **BBConfigurator** y **MvcConfig**.

## Pruebas de aceptacion

A continuacion se presenta un ejemplo del funcionamiento del proyecto:

![Texto alternativo](https://github.com/CAndresRa/board-final/blob/master/imgReadme/testWorking.png)

Cabe aclarar que:
* Localmente mediante otro ciente que tenia acceso a la misma direccion pero que no contaba con autenticacion, se le denegaba el uso del aplicativo, sin embargo debido al despliegue este no cuenta con imagenes correspondientes.
* Ante una caida del servidor y con ayuda de redis la session no obliga al usuario a volver a autenticarse.


