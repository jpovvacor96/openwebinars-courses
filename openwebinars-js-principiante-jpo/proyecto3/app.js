/**
 * Programa de ejemplo para realizar comparaciones de tipos básicas con ayuda de algunos comandos
 * 
 * @author José Palomino Ochoa
 */

//##################
//LISTA DE VARIABLES
//##################

/**Variable local numérica*/
let num=20;
/**Constante de tipo string*/
const notNumber=2+'Texto de ejemplo';

//######################
//EJECUCIÓN DEL PRORGAMA
//######################

//Comprobaciones de tipos
console.log(typeof num);
console.log(typeof notNumber);
console.log(isNaN(notNumber));
//Operación básica con números
num=123.7125476152;
console.log(num.toFixed(23));