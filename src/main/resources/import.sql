-- primer se ponen los productos y ventas, y luego las lineas de ventas para seguir el orden de creacion--

--ademas la fecha está mal y los nombres también, los cuales se pueden ver en sts--
--las url de las imagenes pueden ser globales



--PRODUCTOS
insert into producto (nombre, descripcion, imagen, pvp, descuento, id)values ('God of War','Siéntete como un dios en está épica aventura en la que te sumergiras de lleno en la cultura y mitología nórdica','https://d1x7zurbps6occ.cloudfront.net/product/xlarge/756271-203321.jpg',29.99,50.00,1);
insert into producto (nombre, descripcion, imagen, pvp, descuento, id)values ('Jedi The Fallen Order','Embárcate con tu sable láser en una historia digna de la mítica saga de Star Wars','https://static.wikia.nocookie.net/esstarwars/images/5/57/Fallen-Order-Box-Art.jpg/revision/latest?cb=20191020063836',16.99,30.00,2);
insert into producto (nombre, descripcion, imagen, pvp, descuento, id)values ('The Legend of Zelda','Link despierta tras un profundo sueño de 100 años en un misterioso templo en el reino de Hyrule; junto a él, deberemos descubrir su pasado mientras escuchamos una voz que nos incita a enfrentarnos a un malvado ser que provocó el llamado cataclismo: Ganon.','https://www.zelda.com/breath-of-the-wild/assets/media/wallpapers/tablet-1.jpg',59.99,0,3);


--VENTAS--
insert into venta (precio_total, fecha_compra ,id) values (50.97, '19-05-22',22);
insert into venta (precio_total, fecha_compra ,id) values (89.98, '19-05-22',58);
insert into venta (precio_total, fecha_compra ,id) values (50.97, '19-05-22',77);

--LINEAVENTAS--
insert into linea_venta(videojuego_id,cantidad,precio_unitario,venta_id,id)values (3,1,59.99,22,1);
insert into linea_venta(videojuego_id,cantidad,precio_unitario,venta_id,id)values (1,1,29.99,58,2);
insert into linea_venta(videojuego_id,cantidad,precio_unitario,venta_id,id)values (3,1,59.99,58,2);
insert into linea_venta(videojuego_id,cantidad,precio_unitario,venta_id,id)values (2,3,16.99,77,3);


