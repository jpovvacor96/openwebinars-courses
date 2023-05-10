/**
 * Quiero irme de viaje, ¿puedo hacerlo?
 */

//##################
//LISTA DE VARIABLES
//##################

/**Precio del vuelo en avión*/
const FLIGHT=100;
/**Precio de la estancia en el hotel*/
const HOTEL=50;
/**Precio del tour por la ciudad*/
const TOUR=30;
/**Precio total del viaje*/
const TOTAL=FLIGHT+HOTEL+TOUR;
/**Presupuesto disponible */
const BUDGET=180;

//######################
//EJECUCIÓN DEL PROGRAMA
//######################

//Lógica aplicando bucles normales
if (BUDGET>TOTAL){
    console.info('Sí, me voy de viaje');
}
else if(BUDGET===TOTAL){
    console.warn('Puedes irte, pero el presupuesto es muy ajustado');
}
else{
    console.error('No, tengo que seguir ahorrando');
}

//Lógica aplicando el operador ternario
const RESULT=BUDGET>TOTAL
    ? console.log('Sí, me voy de viaje')
    : console.log('No, tengo que seguir ahorrando');