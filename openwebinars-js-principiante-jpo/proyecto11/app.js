/**
 * Programa en el que se prueba el funcionamiento de las funciones anónimas y las funciones de tipo arrow
 * 
 * @author José Palomino Ochoa
 */

//##################
//LISTA DE VARIABLES
//##################

const MESSAGE='Text example';

//###################
//MÉTODOS Y FUNCIONES
//###################

/**
 * Devuelve un saludo a un usuario con un nombre determinado
 * @param {*} name Nombre del usuario que recibirá el saludo
 * @returns Saludo a un usuario determinado
 */
var sayHello=function(name='world'){
    return `Hello ${name}`;
}

/**
 * Devuelve una despedida a un usuario de un nombre determinado
 * @param {*} name Nombre del usuario que será despedido
 * @returns Despedida a un usuario determinado
 */
var byeBye=(name)=>{
    return `Bye bye ${name}`;
}

/**
 * Devuelve un saludo a un usuario de un nombre determinado
 * @param {*} name Nombre del usuario que recibirá el saludo
 * @returns Saludo a un usuario determinado
 */
var sayHello2=(name) => `Hello ${name}`;

//######################
//EJECUCIÓN DEL PROGRAMA
//######################

console.log(sayHello());
console.log(sayHello('Pepe'));
console.info('Ejemplo de funciones arrow:')
console.info(sayHello2('Cristina'));
console.info(byeBye('Cristina'));