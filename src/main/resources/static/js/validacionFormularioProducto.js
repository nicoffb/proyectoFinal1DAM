document.getElementById("nombre").addEventListener("blur",comprobarNombre);
document.getElementById("descripcion").addEventListener("blur",comprobarDescripcion);
document.getElementById("imgProducto").addEventListener("blur",comprobarImg);
document.getElementById("PrecioSesion").addEventListener("blur",comprobarPrecio);
document.getElementById("EdadMinima").addEventListener("blur",comprobarEdad);
document.getElementById("cc").addEventListener("blur",comprobarSpecs);
document.getElementById("cv").addEventListener("blur",comprobarSpecs);
document.getElementById("kmh").addEventListener("blur",comprobarSpecs);

document.querySelectorAll(".errorForm").forEach(p => p.hidden = true);

function validarFormulario(){
let resultado = false;

resultado = comprobarNombre() &&
      comprobarDescripcion();
     /*  comprobarImg() &&
      comprobarPrecio() &&
      comprobarEdad(); */

return resultado;
}

function comprobarNombre(){
let nombre = formProductos.nombre;
let correcto = nombre.value!="";

if(correcto){
  nombre.nextElementSibling = true;
}else{
  nombre.nextElementSibling.hidden = false;
}

return correcto;
}

function comprobarDescripcion(){
let desc = formProductos.descripcion;
let correcto = desc.value.length >= 25;

if(correcto){
  desc.nextElementSibling.hidden = true;
}else{
  desc.nextElementSibling.hidden = false;
}

return correcto;
}
function comprobarImg(){
let img = formProductos.imgProducto;
let correcto = img.value!="";

if(correcto){
  img.nextElementSibling.hidden = true;
}else{
  img.nextElementSibling.hidden = false;
}

return correcto;
}
function comprobarEdad(){
let edad = formProductos.EdadMinima;
let correcto = edad.value!="" &&  !isNaN(edad.value) && Number.isInteger(+edad.value) && edad.value >= 6;

if(correcto){
  edad.nextElementSibling.hidden = true;
}else{
  edad.nextElementSibling.hidden = false;
}

return correcto;
}
function comprobarPrecio(){
let precio = formProductos.PrecioSesion;
let correcto = precio.value!="" &&  !isNaN(precio.value) && precio.value > 0;

if(correcto){
  precio.nextElementSibling.hidden = true;
}else{
  precio.nextElementSibling.hidden = false;
}

return correcto;
}
function comprobarSpecs(){
let caballos = formProductos.cv;
let cilindrada = formProductos.cc;
let vpunta = formProductos.kmh;
let mensaje = document.getElementById("mensajeSpecs");
let correcto = !isNaN(caballos.value) && caballos.value >= 0 && caballos.value <= 100 &&
      !isNaN(cilindrada.value) && cilindrada.value >= 0 &&
      !isNaN(vpunta.value) && vpunta.value >= 0;

if(correcto){
  mensaje.hidden = true;
}else{
  mensaje.hidden = false;
}

return correcto;
}