/**
 * Programa en el que se ponen a prueba los principales métodos básicos para el trabajo con cadenas de caracteres
 * 
 * @author José Palomino Ochoa
 */

//##################
//LISTA DE VARIABLES
//##################

/**Cadena de caracteres que representa el nombre del usuario*/
const name='José';
/**Texto de ejemplo de tipo Loren Ipsum*/
var exampleText='Maiores torquatos agatur st';
/**Otro texto de ejemplo*/
const otherText='  aksjfhkajbf  askhf asjf   lskdhalksdn doasjdkj asjlaskfh';

//######################
//EJECUCIÓN DEL PROGRAMA
//######################

console.info('Hello '+'World');
console.info(`Hello ${name}!`);
//Longitud de una cadena de caracteres
console.info(`La longitud de tu nombre es la siguiente: ${name.length}`);
console.info(`Texto de ejemplo creado de forma aleatoria: ${exampleText}`);
//Ver si una cadena de caracteres incluye otra
console.info(`El texto de ejemplo incluye la letra u: ${exampleText.includes('u')}`);
//Obtener subcadenas de una cadena de caracteres
console.info(`Vamos a cortar tu nombre: ${name.slice(2,3)}`);
//Reemplazar caracteres por otros dentro de una cadena
console.info('Del texto de ejemplo vamos a reemplazar todas las vocales por la e');
console.info(`Texto original: ${exampleText}`);
exampleText=exampleText.replace('a','e');
console.info(`Texto modificado: ${exampleText}`);
console.info(`Texto original sin aplicar trim: ${otherText}`);
//Eliminación de espacios en blanco iniciales y finales
console.info(`Texto original aplicando trim: ${otherText.trim()}`);
//Creación de un array de cadenas de caracteres utilizando como separador la letra a
console.info(`Texto original aplicando split: ${otherText.split('a')}`);
