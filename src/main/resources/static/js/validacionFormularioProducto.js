document.getElementById("nombre").addEventListener("blur",comprobarNombre);
document.getElementById("descripcion").addEventListener("blur",comprobarDescripcion);
let formProductos = document.forms[0];

document.querySelectorAll(".errorForm").forEach(p => p.hidden = true);

function validarFormulario(){
let resultado = false;

resultado = comprobarNombre() &&
      comprobarDescripcion() &&
      comprobarPrecio(); 

return resultado;
}

function comprobarNombre(){
let nombre = formProductos.nombre;
let correcto = nombre.value!="";

if(correcto){
  nombre.nextElementSibling.hidden = true;
}else{
  nombre.nextElementSibling.hidden = false;
}

return correcto;
}

function comprobarDescripcion(){
let desc = formProductos.descripcion;
let correcto = desc.value.length >= 12;

if(correcto){
  desc.nextElementSibling.hidden = true;
}else{
  desc.nextElementSibling.hidden = false;
}



return correcto;
}



function comprobarPrecio(){
let precio = formProductos.pvp;
let correcto = precio.value!="" &&  !isNaN(precio.value) && precio.value > 0;

if(correcto){
  precio.nextElementSibling.hidden = true;
}else{
  precio.nextElementSibling.hidden = false;
}

return correcto;
}








