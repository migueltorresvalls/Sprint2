# Sprint2
1.	Tras ejecutar nuestra aplicación, aparecerá la pantalla inicial. 
![image](https://user-images.githubusercontent.com/97603106/203038529-6a2116a9-c47e-4bdf-894c-222c209ab60f.png)

Ilustración 1 - Pantalla Inicial

2.	Por el momento, únicamente las opciones de “Registrarse” e “Iniciar sesión” tienen la funcionalidad completamente desarrollada. 
Para acceder a nuestra aplicación hay dos opciones: iniciar sesión con un usuario ya creado o registrarse con un nuevo usuario. 
 
Si se decide crear un usuario nuevo, tras hacer click en la opción “Registrarse”, se le redirigirá a la ventana registro, donde debe introducir el usuario, correo y contraseña. Cada usuario tiene un nombre único que no se puede repetir, por lo que si al crear un nuevo usuario se introduce un nombre existente, se le pedirá que elija otro. 
Si por el contrario, el nombre introducido no ha sido usado anteriormente, se iniciará sesión automáticamente en nuestra aplicación con el nuevo usuario. Pantalla perfil: 
![image](https://user-images.githubusercontent.com/97603106/203038649-1d5c6e5e-b90c-4a75-ae31-ce7ebd8f30e3.png)

Ilustración 2 - Perfil-Inicio-Playlist

Actualmente, todos los usuarios tienen la misma configuración, nombre de usuario, playlist, reviews y foto de usuario. 
En la Pantalla perfil tenemos varias opciones. En primer lugar, Inicio, donde por defecto aparece la pantalla Perfil-Inicio-Playlist, con nuestro perfil y playlists.
Si accedemos a cualquier playlist, se nos redirige a la pantalla Perfil-Inicio-Playlist-Descripción, con todas las películas pertenecientes a la playlist (actualmente todas las playlist están vacías). 
![image](https://user-images.githubusercontent.com/97603106/203038679-792c66ea-fd19-4254-9996-1d8f13e69ed6.png)

Ilustración 3 - Perfil-Inicio-Playlist-Descripción

Volvemos a la pantalla anterior haciendo click en el botón “Inicio”. Una vez en Perfil-Inicio, si le damos al botón “Reviews”, nos vamos a la pantalla Perfil-Inicio-Reviews, la cual está todavía sin desarrollar. 
![image](https://user-images.githubusercontent.com/97603106/203038716-580e4aad-abfc-49e1-8e3b-e501a2737062.png)

Ilustración 4 - Perfil-Inicio-Reviews

Dentro de la pantalla perfil, podemos ir también a Perfil-Explorar, donde podemos buscar cualquier película perteneciente a nuestra base de datos (la cual cuenta actualmente con 600 películas y series entre los años 2002 – 2021. 
En Perfil-Explorar, introducimos un nombre de película/serie, o una parte del mismo y aparecerán todas las películas/series/usuarios que contengan el parámetro buscado. Por ejemplo, si buscamos “fa”, este es el resultado: 
 ![image](https://user-images.githubusercontent.com/97603106/203038782-b9c0e379-b94d-464a-b8ad-5d0c3f92ee0d.png)
Ilustración 5 - Perfil-Explorar búsqueda "fa"

También podemos buscar por años introduciendo un año entre 2002 y 2021 (incluidos).
Si le damos a buscar poniendo la barra de buscar en blanco, nos aparecerán todos los usuarios y películas/series que contiene nuestra aplicación (al tener que mostrar más de 600 resultados, tardará más en cargar). 
![image](https://user-images.githubusercontent.com/97603106/203038843-d5066087-a1b3-4432-9593-2b3a13a463fc.png)

Ilustración 6 - Perfil-Explorar búsqueda en blanco

Al lado de cada película/serie tenemos el botón  , con la opción de añadir la película/serie a alguna playlist o hacer una valoración de la misma. Estas funcionalidades todavía no están implementadas. 
![image](https://user-images.githubusercontent.com/97603106/203038893-e77139e1-00a8-43f1-bad0-f89eff086474.png) 

Ilustración 7 - Perfil-Explorar-Opción agregar/valorar búsqueda

Además de Inicio y Perfil, también podemos ir a Añadir playlist, donde se debe introducir un nombre a la playlist y un id numérico asociado. En el futuro, será el propio programa el que se encargue de darle un id numérico único a cada playlist creada. 
 ![image](https://user-images.githubusercontent.com/97603106/203038938-8592cb3b-4be1-4c48-bf18-74643f33404d.png)
 
Ilustración 8 - Perfil-Añadir playlist

La última opción dentro del menú Perfil es la de ir a Perfil-Mensajes y poder chatear con cualquier otro usuario, esta funcionalidad todavía no está desarrollada y es en la que nos centraremos próximamente. 



