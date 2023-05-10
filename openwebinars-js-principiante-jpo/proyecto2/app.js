/**
 * Programa de ejemplo para aprender los tipos de variables que existe en Javascript
 * 
 * @author José Palomino Ochoa
 */ 

//##################
//LISTA DE VARIABLES
//##################

/**Variable global de ejemplo*/
var variable1='Variable global';
/**Variable local de ejemplo*/
let variable2='Variable local';
/**Constante de ejemplo*/ 
const constante1='Constante creada';

//###################
//MÉTODOS Y FUNCIONES
//###################

/**
 * Función que saluda al usuario por pantalla de forma agradable
 */
function saludar(){
    console.info('Invocada la función de saludo');
    alert('Hola amigo, ¿qué tal todo?');
    console.info('Cierre de la función de saludo');
}

//######################
//EJECUCIÓN DEL PROGRAMA
//######################

alert('Hemos creado varias variables');
alert(variable1);
alert(variable2);
alert(constante1);
console.info('Creadas todas las variables');
console.warn('Alerta: no puede modificarse el valor de la constante 1');
saludar();
var variable3=variable1+variable2;
console.warn('Alerta: recuerde que las dos variables son cadenas de caracteres');
alert(variable3);

