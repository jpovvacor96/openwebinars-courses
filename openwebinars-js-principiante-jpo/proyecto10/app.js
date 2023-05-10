/**
 * Programa que pone en práctica el funcionamiento básico de las funciones en Javascript
 * 
 * @author José Palomino Ochoa
 */

//###################
//MÉTODOS Y FUNCIONES
//###################

/**
 * Suma dos números y muestra el resultado por consola
 * @param {*} a Primer sumando 
 * @param {*} b Segundo sumando
 */
function add(a, b){
    console.info(a+b);
}

/**
 * Devuelve una cadena de caracteres que contiene el saludo a un usuario de un nombre determinado
 * @param {*} name Nombre del usuario que se desea saludar
 * @returns Saludo al usuario
 */
function sayHello(name='world'){
    return `Hello ${name}!`;
}

//######################
//EJECUCIÓN DEL PROGRAMA
//######################

console.info(sayHello('Pepe'));
console.info('Suma de 2 y 5:');
add(2,5);
console.info('Suma de 20 y 50:');
add(20,50);
console.info('Suma de 3 y 5:');
add(3,5);
console.info('Función de saludo por defecto:');
sayHello();
console.info('Función de saludo con nombre:');
sayHello('Pepe');
