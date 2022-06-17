# proyectoFinal
Solo los admin pueden entrar y ver la casilla de ADMINISTRACIÓN en el index. Solo los usuarios registrados pueden añadir al carrito.


ADMINS:         nico  Contraseña: 1234
                  admin admin

USUARIOS:
user 1234



Se pueden modificar parametros de ventas y las propias lineas de venta de forma retroactiva de las ventas ya realizadas.
No se pueden añadir nuevas ventas con sus respectivas lineas de venta, aunque haya carrito, no hay checkout.



No se puede borrar los productos ni las ventas metidas con el importsql (las 3 primeras) . Hay anotaciones de intentos de que saliera un mensaje de error cuando esto pasara, al igual que métodos que estaba creando para recoger la condición de los 3 primeros ids. Por el resto he configurado Spring Tool para que empiece a asignar los id por 500. El botón de borrar varios no he terminado de implementarlo
