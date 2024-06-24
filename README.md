# Literatura
# Challenge-Java

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

El proyecto tiene como objetivo buscar y mostrar información relevante de libros que estén en local o en el sistema de la api de Gutendex, datos como el nombre del libro, el lenguaje, numero de descargas, los autores y sus respectivas fechas de nacimientos y defunciones.

✔️ Proyecto finalizado, enviar bugs encontrados a contactos ✔️

# Funciones de la aplicación

Las funciones de la aplicación son las siguientes:

![Imagen que muestra las opciones del menu de la aplicación](Imagenes\img.PNG)

## 1. Buscar libro por titulo

Esta función permite buscar un libro por su titulo, se buscaran las coincidencias en la base de datos local, si no se encuentra usara la base de datos de Gutendex para mostrar la información del libro, en caso contrario se mostrará un mensaje de error.

Se puede ver como se usa la función en las siguientes imágenes:
![Muestra el uso de la función en el caso de encontrar coincidencias en la base de datos local](Imagenes\img_1.PNG)

Caso en el cual fue necesario usar la api de Gutendex.

![Muestra el uso de la función en el caso de no encontrar coincidencias en la base de datos de Gutendex](Imagenes\img_3.PNG)
![Muestra el uso de la función en el caso de no encontrar coincidencias en la base de datos de Gutendex](Imagenes\img_4.PNG)

Error generado por no encontrar coincidencias en la base de datos de Gutendex

![Muestra el uso de la función en el caso de no encontrar coincidencias en la base de datos local](Imagenes\img_2.PNG)

## 2. Mostrar libros

Se mostraran la totalidad de libros en guardados en la base de datos local, los cuales fueron buscados con anterioridad.

![Se muestra una pequeña parte de los libros guardados en la base de datos](Imagenes\img_5.PNG)

## 3. Mostrar autores

Se mostraran la totalidad de autores en guardados en la base de datos local.

![Se muestra una pequeña parte de los autores guardados en la base de datos](Imagenes\img_6.PNG)

## 4. Mostrar autores por año en el cual seguian vivos

Se buscaran los autores que aun estuvieran vivos para el año ingresado por el usuario, mostrando los autores y sus respectivas fechas de nacimiento y defunción.

![Se muestra una busqueda que genero un resultado de un autor vivo](Imagenes\img_7.PNG)

![Se muestra una busqueda de un años en el cual no se encontraron autores vivos](Imagenes\img_8.PNG)

## 5. Mostrar idiomas

Se muestran los idiomas de los libros guardados en la base de datos local, con el numero de libros que estan en estos idiomas.

![Se muestra la totalidad de idiomas en la base de datos guardadas](Imagenes\img_9.PNG)

## 6. Mostrar los 10 libros mas descargados

Se muestran los 10 libros mas descargados en la base de datos local.

![Se muestra una parte de los 10 libros más buscados](Imagenes/img_10.PNG)

# Tecnologías utilizadas

* Java 17
* Spring boot v 3.2.5
* Postgresql
* Docker (Opcional)

# Requisitos para ser ejecutado

* Tener acceso a internet
* Tener las variables de entorno configuradas para la conexión a la base de datos:
  * DB_URL=jdbc:postgresql://localhost:5432/challenge_literatura?user\=DB_USER&password\=DB_PASSWORD
      * DB_USER debe ser el mismo usuario que el que tenga la base de datos postgresql
      * DB_PASSWORD debe ser la contraseña del usuario de la base de datos postgresql
      * Si se quiere usar otra base de datos sera necesario readaptar el codigo de resources/application.properties para que se puedan usar jpql y derived queries, no existe codigo sql nativo

## Desarollador del proyecto

Juan Pablo Garcia Carballo

Linkedin www.linkedin.com/in/juan-pablo-garcia-095a62283

[Github](https://github.com/juagarciac)  [Correo](mailto:juanpablogarciacarballo@gmail.com)
