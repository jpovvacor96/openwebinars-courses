/**
 * En un carrito de la compra el usuario ha elegido diferentes productos que debes sumar. Por ser su primera compra deberás
 * aplicar al total un 10% de descuento
 * 
 * @author José Palomino Ochoa
 */

//##################
//LISTA DE VARIABLES
//##################

/**Precio del móvil*/
const PRICE_MOBILE=300;
/**Precio de los auriculares*/
const PRICE_HEADPHONES=30;
/**Precio de la funda del móvil*/
const PRICE_CASE=10;
/**Descuento aplicado*/
const DISCOUNT=10;
/**Total de dinero a pagar sin aplicar el descuento*/
const TOTAL=PRICE_MOBILE+PRICE_HEADPHONES+PRICE_CASE;
/**Total dinero a pagar con descuento*/
const SUBTOTAL=TOTAL*DISCOUNT/100;

//######################
//EJECUCIÓN DEL PROGRAMA
//######################

//Mostramos al usuario el dinero que debe pagar con el descuento aplicado
console.info('Inicio del programa')
alert('El precio que debe pagar es el siguiente:');
alert(SUBTOTAL);
console.log('Final del programa');

