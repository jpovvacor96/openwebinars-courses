/**
 * Nos piden que incluyamos en el texto de la próxima newsletter unas variabels dinámicas que vienen dadas por el usuario
 * Nombre: Cristina
 * Videojuego: Link Awakening
 * Descuento: 20%
 * 
 * @author José Palomino Ochoa
 */

//##################
//LISTA DE VARIABLES
//##################

/**Nombre del cliente */
const NAME='Cristina';
/**Nombre del videjouego */
const GAME='Link Awakening';
/**Descuento aplicado*/
const DISCOUNT=20;
/**Texto de la newsletter */
const NEWSLETTER= `Hola, ${NAME}. Como regalo de bienvenida al club de gamers, queremos ofrecerte un descuento del 
    ${DISCOUNT}% en el próximo lanzamiento de tu interés, el juego ${GAME}. ¡Que lo disfrutes!`; 

//######################
//EJECUCIÓN DEL PROGRAMA
//######################

//Mostramos la newsletter por pantalla
document.querySelector('.newsletter-text').innerHTML=NEWSLETTER;