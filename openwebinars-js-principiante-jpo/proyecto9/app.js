 /**
  * Mostrar una información al usuario diferente en función de si se encuentra conectado o no
  * 
  * @author José Palomino Ochoa
  */

 //##################
 //LISTA DE VARIABLES
 //##################

 /**Booleano que indica si el usuario está registrado en el sistema*/
 const USER_LOGGED=true;
 /**Texto que se incluirá en el texto*/
 const BLOCK_TEXT=document.querySelector('.block-text');
 
 //######################
 //EJECUCIÓN DEL PROGRAMA
 //######################
 
 //Cambiamos el contenido del párrafo dependiendo de la condición lógica
 if (USER_LOGGED){
    BLOCK_TEXT.innerHTML='Haz click aquí para ver el contenido';
 }
 else{
    BLOCK_TEXT.innerHTML='Debes registrarte para leer este artículo';
 }