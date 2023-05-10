/**
 * En una cena de amigos os llega la cuenta y queréis dividir entre todos. ¿Cuánto os toca pagar a cada uno?
 * El total a pagar son 102 euros y estamos 6 personas
 * 
 * @author José Palomino Ochoa
 */

//##################
//LISTA DE VARIABLES
//##################

/**Total de dinero a pagar en total*/
const TOTAL=102;
/**Cantidad de comensales*/
const PEOPLE=6;
/**Dinero que debe pagar cada uno de los comensales*/
const TOTAL_BY_PERSON=102/6;

//######################
//EJECUCIÓN DEL PROGRAMA
//######################
alert('Debes pagar la cantidad siguiente:');
alert(TOTAL_BY_PERSON);