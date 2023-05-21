--Activamos la consola de salida para mostrar los resultados de los scripts de PL/SQL
SET SERVEROUTPUT ON;

/*Muestra por pantalla una bienvenida al curso de OpenWebinars*/
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('Bienvenidos al curso de PL/SQL');
END;
/

/*Ejemplo de declaración de variables y constantes*/
/
DECLARE
    vv_producto CONSTANT VARCHAR2(14 CHAR):='Destornillador';
    vn_unidades NUMBER(2);
    vn_precio NUMBER(3,2);
    vd_fecha_entrega DATE;
    vb_oferta BOOLEAN;
BEGIN
    --vv_producto :='Destornillador';
    vn_unidades:=50;
    vn_precio:=2.5;
    vd_fecha_entrega:=SYSDATE;
    vb_oferta:=TRUE;
    DBMS_OUTPUT.PUT_LINE('El producto es: ' || vv_producto);
    DBMS_OUTPUT.PUT_LINE('El número de unidades recibidas es: ' || vn_unidades);
    DBMS_OUTPUT.PUT_LINE('El precio unitario es: ' || vn_precio);
    DBMS_OUTPUT.PUT_LINE('La fecha de entrega es: ' || TO_CHAR(vd_fecha_entrega, 'DD/MM/YYYY'));
    DBMS_OUTPUT.PUT_LINE(CASE WHEN vb_oferta THEN 'Con oferta' ELSE 'Sin oferta' END);
END;
/

/*Prueba de las funciones de control y validación*/
/
DECLARE
    vv_mi_cadena VARCHAR2(20 CHAR):='Cadena de ejemplo';
BEGIN
    vv_mi_cadena := NVL(vv_mi_cadena, 'Cadena vacía');
    DBMS_OUTPUT.PUT_LINE('El valor del la variable es: ' || vv_mi_cadena);
    DBMS_OUTPUT.PUT_LINE('La longitud de la variable es: ' || LENGTH(vv_mi_cadena));
END;
/

/*Funciones típicas con números*/
/
DECLARE
    vn_mi_numero NUMBER(8) := 777.83;
BEGIN
    vn_mi_numero := ROUND(vn_mi_numero);
    DBMS_OUTPUT.PUT_LINE('El valor de la variable es: ' || vn_mi_numero);
END;
/

/*Trabajo con cadenas de caracteres*/
/
DECLARE
    vv_mi_cadena CONSTANT VARCHAR2(50 CHAR) := 'Esta es mi cadena';
    vv_subcadena VARCHAR2(50 CHAR);
    vv_posicion_a NUMBER(2);
    vv_replace VARCHAR2(50 CHAR);
    vv_trim VARCHAR2(50 CHAR);
BEGIN
    vv_subcadena:= SUBSTR(vv_mi_cadena, 6, 5);
    vv_posicion_a:=INSTR(vv_mi_cadena, 'a', 1, 2);
    vv_replace:=REPLACE(vv_mi_cadena, 'a', '$');
    vv_trim:=RTRIM(vv_mi_cadena, 'cadena');
    DBMS_OUTPUT.PUT_LINE('El valor de la subcadena es: ' || vv_mi_cadena);
    DBMS_OUTPUT.PUT_LINE('Posición donde se encuentra la letra: ' || vv_posicion_a);
    DBMS_OUTPUT.PUT_LINE('Cadena en mayúsculas: ' || UPPER(vv_mi_cadena));
    DBMS_OUTPUT.PUT_LINE('Cadena en minúsculas: ' || LOWER(vv_mi_cadena));
    DBMS_OUTPUT.PUT_LINE('Caracteres sustituidos: ' || vv_replace);
    DBMS_OUTPUT.PUT_LINE(LPAD(vv_mi_cadena, 50, '#'));
    DBMS_OUTPUT.PUT_LINE(RPAD(vv_mi_cadena, 50, '#'));
    DBMS_OUTPUT.PUT_LINE(vv_trim);
END;
/

/*Ejemplo de bloques anidados*/
/
DECLARE
    vv_aplicacion VARCHAR2(50 CHAR):='Mi app';
BEGIN
    DECLARE
        --Las variables declaradas en el subbloque son locales
        vv_aplicacion VARCHAR2(50 CHAR):='Subbloque';
    BEGIN
        vv_aplicacion:=vv_aplicacion || ' número 2';
    END;
    DBMS_OUTPUT.PUT_LINE('Contenido de la variable: ' || vv_aplicacion);
END;
/

/*Creación de la tabla de productos*/
/
CREATE TABLE tbProductos(
    nIDProducto NUMBER(3) PRIMARY KEY,
    vDesProducto VARCHAR2(50 CHAR),
    nUnidades NUMBER(4),
    nPrecioUnitario NUMBER(6,2),
    dFechaAlta DATE);
/

/*Insertamos nuevos datos en la tabla*/
/
BEGIN 
    INSERT INTO tbProductos
        VALUES (3, 'Destornillador', 50, 3.25, TO_DATE('05/05/2021', 'DD/MM/YYYY'));
    COMMIT;
END;
/

/*Mostramos el contenido de la tabla*/
/
SELECT * FROM tbProductos;
/ 

/*Actualizamos datos de la tabla*/
/
BEGIN
    UPDATE tbProductos
        SET nPrecioUnitario=3.5
            WHERE nIDProducto=2;
    COMMIT;
END;
/

/*Obtenemos datos de una columna de la tabla*/
/
DECLARE
    vv_producto TBPRODUCTOS.vDesProducto%TYPE;
BEGIN
    SELECT VDESPRODUCTO INTO vv_producto
        FROM TBPRODUCTOS
            WHERE TBPRODUCTOS.NIDPRODUCTO=1;
    DBMS_OUTPUT.PUT_LINE('Descripción del producto: ' || vv_producto);
END;  
/

/*Eliminamos registros de la tabla*/
/ 
BEGIN
    DELETE FROM tbProductos 
        WHERE nIDProducto=1;
    COMMIT;
END;
/

/*Ejemplo de estructuras condicionales IF*/
/
DECLARE
    vn_numero NUMBER(1):=&vn_numero;
BEGIN
    IF vn_numero=1 THEN 
        DBMS_OUTPUT.PUT_LINE('Se cumple la condición ');
    ELSE
        DBMS_OUTPUT.PUT_LINE('No se cumple la condición');
    END IF;
END;
/

/*Ejemplo de utilización de la estructura CASE*/
/
DECLARE
    vn_numero NUMBER(1):=&vn_numero;
BEGIN
    CASE vn_numero
        WHEN 1 THEN DBMS_OUTPUT.PUT_LINE('El número es 1');
        WHEN 2 THEN DBMS_OUTPUT.PUT_LINE('El número es 2');
        ELSE DBMS_OUTPUT.PUT_LINE('Valor no válido');
    END CASE;
END;
/

/*Ejemplo de un buble FOR sencillo*/
/
BEGIN
    FOR i IN 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE('Iteración: ' || i);
    END LOOP;
END;
/

/*Ejemplo de un bucle LOOP sencillo*/
/
DECLARE
    vn_index NUMBER(2):=1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE('Iteración: ' || vn_index);
        EXIT WHEN vn_index=10;
        vn_index:=vn_index+1;
    END LOOP;
END;
/

/*Ejemplo de un bucle WHILE sencillo*/
/
DECLARE
    vn_index NUMBER(2):=1;
BEGIN
    WHILE vn_index<99 LOOP
        vn_index:=vn_index+1;
        DBMS_OUTPUT.PUT_LINE(vn_index);
    END LOOP;
END;
/  

/
CREATE SEQUENCE SEQ_TBPRODUCTOS INCREMENT BY 1 MAXVALUE 999999 
    NOCACHE MINVALUE 1;
/

/
CREATE TABLE tbProductos(
    nIDProducto NUMBER DEFAULT SEQ_TBPRODUCTOS.NEXTVAL PRIMARY KEY,
    vDesProducto VARCHAR2(50 CHAR),
    nUnidades NUMBER(4),
    nPrecioUnitario NUMBER(6,2),
    dFechaAlta DATE);
/

/*Ejemplo de utilización de un cursor con parámetros*/
/
DECLARE
    CURSOR c_productos(p_id TBPRODUCTOS.NIDPRODUCTO%TYPE) IS
        SELECT * FROM TBPRODUCTOS
            WHERE NIDPRODUCTO=p_id;
BEGIN
    FOR r_producto IN c_productos(2) LOOP
    DBMS_OUTPUT.PUT_LINE('ID del producto: ' || r_producto.NIDPRODUCTO);
    DBMS_OUTPUT.PUT_LINE('Descripción del producto: ' || r_producto.VDESPRODUCTO);
    DBMS_OUTPUT.PUT_LINE('Unidades disponibles: ' || r_producto.NUNIDADES);
    DBMS_OUTPUT.PUT_LINE('Precio unitario: ' || r_producto.NPRECIOUNITARIO);
    DBMS_OUTPUT.PUT_LINE('Fecha de alta: ' || TO_CHAR(r_producto.DFECHAALTA, 'DD/MM/YYYY'));
    END LOOP;
END;
/

/*Ejemplo de utilización de un cursor sin parámetros*/
/
DECLARE
    CURSOR c_productos IS
        SELECT * FROM TBPRODUCTOS;
BEGIN
    DBMS_OUTPUT.PUT_LINE('##################################');
    FOR r_producto IN c_productos LOOP
    DBMS_OUTPUT.PUT_LINE('ID del producto: ' || r_producto.NIDPRODUCTO);
    DBMS_OUTPUT.PUT_LINE('Descripción del producto: ' || r_producto.VDESPRODUCTO);
    DBMS_OUTPUT.PUT_LINE('Unidades disponibles: ' || r_producto.NUNIDADES);
    DBMS_OUTPUT.PUT_LINE('Precio unitario: ' || r_producto.NPRECIOUNITARIO);
    DBMS_OUTPUT.PUT_LINE('Fecha de alta: ' || TO_CHAR(r_producto.DFECHAALTA, 'DD/MM/YYYY'));
    DBMS_OUTPUT.PUT_LINE('##################################');
    END LOOP;
END;
/

/*Creación de un pequeño formulario por consola*/
/
DECLARE
    vv_descripcion TBPRODUCTOS.VDESPRODUCTO%TYPE:=&vv_descripcion;
    vn_unidades TBPRODUCTOS.NUNIDADES%TYPE:=&vn_unidades;
    vn_precio TBPRODUCTOS.NPRECIOUNITARIO%TYPE:=&vn_precio;
    vd_fecha TBPRODUCTOS.DFECHAALTA%TYPE:=&vd_fecha;
BEGIN
    INSERT INTO TBPRODUCTOS(VDESPRODUCTO, NUNIDADES, NPRECIOUNITARIO, DFECHAALTA)
        VALUES(vv_descripcion, vn_unidades, vn_precio, vd_fecha);
    DBMS_OUTPUT.PUT_LINE('Nuevo producto añadido correctamente');
END;
/

/
CREATE SEQUENCE SEQ_TBPROVEEDORES INCREMENT BY 1 MAXVALUE 999999 
    NOCACHE MINVALUE 1;
/

/*Creación e inserción de datos de una tabla de proveedores*/
/
CREATE TABLE TBPROVEEDORES(
    NIDPROVEEDOR NUMBER DEFAULT SEQ_TBPROVEEDORES.NEXTVAL PRIMARY KEY,
    VDESPROVEEDOR VARCHAR2(50 CHAR),
    DFECHAALTA DATE);
/

/
INSERT INTO TBPROVEEDORES(VDESPROVEEDOR, DFECHAALTA)
    VALUES('Materiales El Bueno', TO_DATE('01/05/2021', 'DD/MM/YYYY'));
INSERT INTO TBPROVEEDORES(VDESPROVEEDOR, DFECHAALTA)
    VALUES('Almacenes Los Mejores', TO_DATE('07/05/2021', 'DD/MM/YYYY'));
/

/
SELECT * FROM TBPROVEEDORES;
/

/*Procedimiento destinado a facilitar la inserción de datos*/
/
DECLARE
    vn_IDProveedor TBPROVEEDORES.NIDPROVEEDOR%TYPE;
    vv_DesProveedor TBPROVEEDORES.VDESPROVEEDOR%TYPE:='Martillos la Romería';
    vd_FechaAlta TBPROVEEDORES.DFECHAALTA%TYPE:=SYSDATE;
    vn_NomProvExiste NUMBER(1);
    ex_NomProvExiste EXCEPTION;
BEGIN
    BEGIN
        SELECT MAX(nIDProveedor)+1 
            INTO vn_IDProveedor FROM TBPROVEEDORES;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            vn_IDProveedor:=1;
    END;
    vv_DesProveedor:=NVL(vv_DesProveedor, 'No definido');
    BEGIN
        SELECT 1 INTO vn_NomProvExiste FROM TBPROVEEDORES
            WHERE vDesProveedor=vv_DesProveedor;
        RAISE ex_NomProvExiste;
    END;
    INSERT INTO tbProveedores (nIDProveedor, vDesProveedor, dFechaAlta)
        VALUES(vn_IDProveedor, vv_DesProveedor, vd_FechaAlta);
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Ya existe un proveedor con el ID que se intenta registrar');
    WHEN ex_NomProvExiste THEN
        DBMS_OUTPUT.PUT_LINE('Ya existe un proveedor con el nombre que desea registrar');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Se ha producido algún error');
END;
/

/*Procedimiento básico de ejemplo*/
/
CREATE OR REPLACE PROCEDURE pr_descripcion(
    pi_n_nidproveedor IN TBPROVEEDORES.NIDPROVEEDOR%TYPE,
    po_v_desproveedor OUT TBPROVEEDORES.VDESPROVEEDOR%TYPE)
IS
BEGIN
    SELECT VDESPROVEEDOR INTO po_v_desproveedor
    FROM TBPROVEEDORES
        WHERE NIDPROVEEDOR=pi_n_nidproveedor;
    po_v_desproveedor:='Ninguno';
END pr_descripcion;
/
 
/
DECLARE
    vv_descripcion TBPROVEEDORES.VDESPROVEEDOR%TYPE;
BEGIN
    pr_descripcion(2, vv_descripcion);
    DBMS_OUTPUT.PUT_LINE(vv_descripcion);
END;
/
DECLARE
    CURSOR c_productos(p_id TBPRODUCTOS.NIDPRODUCTO%TYPE) IS
        SELECT * FROM TBPRODUCTOS
            WHERE NIDPRODUCTO=p_id;
BEGIN
    FOR r_producto IN c_productos(2) LOOP
    DBMS_OUTPUT.PUT_LINE('ID del producto: ' || r_producto.NIDPRODUCTO);
    DBMS_OUTPUT.PUT_LINE('Descripción del producto: ' || r_producto.VDESPRODUCTO);
    DBMS_OUTPUT.PUT_LINE('Unidades disponibles: ' || r_producto.NUNIDADES);
    DBMS_OUTPUT.PUT_LINE('Precio unitario: ' || r_producto.NPRECIOUNITARIO);
    DBMS_OUTPUT.PUT_LINE('Fecha de alta: ' || TO_CHAR(r_producto.DFECHAALTA, 'DD/MM/YYYY'));
    END LOOP;
END;
/

/
CREATE OR REPLACE FUNCTION fn_DameDescripcion
    (pi_n_IdProveedor IN TBPROVEEDORES.NIDPROVEEDOR%TYPE)
    RETURN VARCHAR2 IS
        vv_DesProveedor TBPROVEEDORES.VDESPROVEEDOR%TYPE;
BEGIN
    SELECT TBPROVEEDORES.VDESPROVEEDOR INTO vv_DesProveedor
        FROM TBPROVEEDORES
            WHERE TBPROVEEDORES.NIDPROVEEDOR=pi_n_IdProveedor;
    RETURN vv_DesProveedor;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'Ninguno';
END fn_DameDescripcion;
/

/
DECLARE
    vv_DesProveedor TBPROVEEDORES.VDESPROVEEDOR%TYPE;
    ex_NoRegistros EXCEPTION;
BEGIN
    vv_DesProveedor:=fn_DameDescripcion(1);
    IF (vv_DesProveedor='Ninguno') THEN
        RAISE ex_NoRegistros;
    ELSE
        DBMS_OUTPUT.PUT_LINE(vv_DesProveedor);
    END IF;
EXCEPTION
    WHEN ex_NoRegistros THEN
        DBMS_OUTPUT.PUT_LINE('No hay proveedores con dicho ID');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Ha ocurrido un error');
END;
/

/
CREATE TABLE tbLogProveedores(
    nIDProveedor_OLD NUMBER,
    nIDProveedor_NEW NUMBER,
    vDesProveedor_OLD VARCHAR2(50 CHAR),
    vDesProveedor_NEW VARCHAR2(50 CHAR),
    dFechaAlta_OLD DATE,
    dFechaAlta_NEW DATE,
    dFechaRegistro DATE,
    vAccion VARCHAR2(50 CHAR));
/

/
CREATE TABLE tbProductos(
    nIDProducto NUMBER DEFAULT SEQ_TBPRODUCTOS.NEXTVAL PRIMARY KEY,
    vDesProducto VARCHAR2(50 CHAR),
    nUnidades NUMBER(4),
    nPrecioUnitario NUMBER(6,2),
    dFechaAlta DATE);
/

/
CREATE OR REPLACE TRIGGER tr_log_proveedores
AFTER INSERT OR UPDATE OR DELETE ON TBPROVEEDORES
FOR EACH ROW
DECLARE
    vv_accion VARCHAR2(50 CHAR);
BEGIN
    CASE 
        WHEN INSERTING THEN vv_accion:='INSERT';
        WHEN UPDATING THEN vv_accion:='UPDATE';
        WHEN DELETING THEN vv_accion:='DELETE';
    END CASE;
    INSERT INTO TBLOGPROVEEDORES
        (nIDProveedor_OLD, nIDProveedor_NEW, vDesProveedor_OLD, vDesProveedor_NEW,
        dFechaAlta_OLD, dFechaAlta_NEW, dFechaRegistro, vAccion)
            VALUES(:OLD.nIDProveedor, :NEW.nIDProveedor, :OLD.vDesProveedor, :NEW.vDesProveedor,
                :OLD.dFechaAlta, :NEW.dFechaAlta, SYSDATE, vv_accion);
END tr_log_proveedores;
/

/*Ejemplo de creación de registros y de tipos especiales*/
/
DECLARE
    TYPE t_registro IS RECORD(
    v_producto VARCHAR2(20),
    n_unidades NUMBER(3),
    d_fechaAlta DATE);
    vtr_producto t_registro;
    vr_proveedores TBPROVEEDORES%ROWTYPE;
BEGIN
    vtr_producto.v_producto:='Martillo';
    vtr_producto.n_unidades:=10;
    vtr_producto.d_fechaAlta:=SYSDATE;
    DBMS_OUTPUT.PUT_LINE('Nombre del producto: ' || vtr_producto.v_producto);
    DBMS_OUTPUT.PUT_LINE('Unidades disponibles: ' || vtr_producto.n_unidades);
    DBMS_OUTPUT.PUT_LINE('Fecha de alta en el sistema: ' || TO_CHAR(vtr_producto.d_fechaAlta, 'DD/MM/YYYY'));
    SELECT * INTO vr_proveedores 
        FROM TBPROVEEDORES WHERE NIDPROVEEDOR=2;
    DBMS_OUTPUT.PUT_LINE('ID del proveedor: ' || vr_proveedores.nIDproveedor);
    DBMS_OUTPUT.PUT_LINE('Descripción del proveedor: ' || vr_proveedores.VDESPROVEEDOR);
    DBMS_OUTPUT.PUT_LINE('Fecha de alta: ' || TO_CHAR(vr_proveedores.dfechaAlta, 'DD/MM/YYYY'));
END;
/ 

/*TRABAJO CON COLECCIONES*/

/*Ejemplo de trabajo con varrays*/
/
DECLARE 
    TYPE ttab_ty_nombre IS VARRAY(5) OF VARCHAR2(20 CHAR);
    --Inicializamos el varray, pero esta vez sin elementos, aunque podríamos especificarlos
    vttab_ty_nombre ttab_ty_nombre :=ttab_ty_nombre();
BEGIN
    --Obtenemos el límite máximo de registros
    DBMS_OUTPUT.PUT_LINE('Número máximo de registros: ' || vttab_ty_nombre.LIMIT);
    --Obtenemos el número de registros que contiene el varray
    DBMS_OUTPUT.PUT_LINE('Número de registros contenidos: ' || vttab_ty_nombre.COUNT);
    --Rellenamos el varray
    FOR i IN 1..vttab_ty_nombre.LIMIT LOOP
        vttab_ty_nombre.EXTEND;
        vttab_ty_nombre(i):='Valor: ' || TO_CHAR(i);
    END LOOP;
    --Mostramos por pantalla los registros de la colección
    FOR i IN 1..vttab_ty_nombre.LAST LOOP
        DBMS_OUTPUT.PUT_LINE(vttab_ty_nombre(i));
    END LOOP;
    --Obtenemos el número de registros que contiene el varray
    DBMS_OUTPUT.PUT_LINE('Número de registros contenidos: ' || vttab_ty_nombre.COUNT);
END;
/

/*Ejemplo de utilización de tablas anidadas*/
/
DECLARE
    TYPE ttab_ty_nombre IS TABLE OF VARCHAR2(20 CHAR);
    vttab_ty_nombre ttab_ty_nombre:=ttab_ty_nombre(NULL, NULL, NULL);
BEGIN
    DBMS_OUTPUT.PUT_LINE('Número de registros: ' || vttab_ty_nombre.COUNT);
    DBMS_OUTPUT.PUT_LINE('Procediendo al llenado de elementos...');
    FOR i IN vttab_ty_nombre.FIRST..vttab_ty_nombre.LAST LOOP
        vttab_ty_nombre(i):='Prueba: ' || TO_CHAR(i);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Número de registros después del llenado: ' || vttab_ty_nombre.COUNT);
    FOR i IN vttab_ty_nombre.FIRST..vttab_ty_nombre.LAST LOOP
        DBMS_OUTPUT.PUT_LINE(vttab_ty_nombre(i));
    END LOOP;
END;
/

/*Ejemplo de utilización de vectores asociativos*/
/
DECLARE
    --Declaración de los vectores asociativos
    TYPE ttab_ty_nombre IS TABLE OF VARCHAR2(20) INDEX BY VARCHAR(2);
    vttab_ty_nombre ttab_ty_nombre;
    v_indice VARCHAR2(2);
BEGIN
    DBMS_OUTPUT.PUT_LINE('Número de registros del vector: ' || vttab_ty_nombre.COUNT);
    --Procedemos al llenado del vector
    vttab_ty_nombre('ES'):='España';
    vttab_ty_nombre('AR'):='Argentina';
    vttab_ty_nombre('ME'):='Mexico';
    vttab_ty_nombre('CO'):='Colombia';
    v_indice:=vttab_ty_nombre.FIRST;
    DBMS_OUTPUT.PUT_LINE('Número de registros después del rellenado: ' || vttab_ty_nombre.COUNT);
    --Mostramos los elementos recorriendo el vector: los índices se ordenan alfabéticamente
    WHILE v_indice IS NOT NULL LOOP
        DBMS_OUTPUT.PUT_LINE(v_indice || ' --> ' || vttab_ty_nombre(v_indice));
        v_indice:=vttab_ty_nombre.NEXT(v_indice);
    END LOOP;
END;
/

/
DECLARE
    vv_producto VARCHAR2(20 CHAR);
BEGIN
    vv_producto:='Destornillador';
    BEGIN
        vv_producto:='Martillo';
    END;
    DBMS_OUTPUT.PUT_LINE(vv_producto);
END;
/

/
declare
    vr_productos tbProductos%rowtype;
begin
    select *
      into vr_productos
      from tbproductos
     where nidproducto = 1;
    
    dbms_output.put_line('El producto es ' || vr_productos.vdesproducto 
                            || ' con ID ' || vr_productos.nidproducto 
                            || ' - ' || vr_productos.nunidades 
                            || ' unidades a un precio unitario de ' || vr_productos.npreciounitario || ' € ' 
                            || ' con fecha de alta ' || to_char(vr_productos.dfechaalta, 'dd/mm/yyyy'));
end;
/

/
CREATE OR REPLACE FUNCTION fn_get_fecha_actual RETURN VARCHAR IS
BEGIN
RETURN TO_CHAR(SYSDATE, 'dd/mm/yyyy');
END fn_get_fecha_actual;
/

/
DECLARE
    vv_fecha_actual VARCHAR(10 CHAR);
BEGIN
    vv_fecha_actual := fn_get_fecha_actual;
    DBMS_OUTPUT.PUT_LINE('La fecha actual es ' || vv_fecha_actual);
END;
/

/
DECLARE 
    -- Creamos el tipo
    TYPE ttab_ty_nombre IS VARRAY(5) OF VARCHAR2(20 CHAR);
    -- Declaramos una variable del tipo creado
    vttab_ty_nombre ttab_ty_nombre := ttab_ty_nombre();
    
BEGIN

    dbms_output.put_line('El número máximo de registros en el vector es: '  || vttab_ty_nombre.LIMIT);
    dbms_output.put_line('El número de registros en el vector es: '  || vttab_ty_nombre.COUNT);
    
    FOR i IN 1 .. vttab_ty_nombre.LIMIT LOOP
        vttab_ty_nombre(i) := 'Prueba' || TO_CHAR(i);
    END LOOP;
    
    IF vttab_ty_nombre.COUNT > 0 THEN 
        FOR i IN vttab_ty_nombre.FIRST .. vttab_ty_nombre.LAST LOOP 
            dbms_output.put_line('El ID del registro es: ' || vttab_ty_nombre(i));
        END LOOP;
    END IF;
    
    dbms_output.put_line('El número de registros en el vector es: '  || vttab_ty_nombre.COUNT);
    
END;
/
select * from tbproductos;
/
declare
	cursor c_productos is
		select *
		from tbproductos; 
		
begin
	for r_producto in c_productos loop
		if r_producto.nidproducto = 1 then 
			update tbproductos 
			   set nunidades = nunidades + 10
			 where nidproducto = r_producto.nidproducto;
			if sql%rowcount > 0 then 
			    commit;
			    dbms_output.put_line('Se ha actualizado el prodcuto con ID ' || r_producto.nidproducto || ' con ' || r_producto.nunidades || ' unidades.');
			else 
			    dbms_output.put_line('No se ha actualizado ningun registro.');
			end if;
		end if;
	end loop;
	
exception
	when others then 
	    dbms_output.put_line('Se ha producido un error.');
end;
/

/
DECLARE 
    -- Creamos el tipo
    TYPE ttab_ty_nombre IS TABLE OF TBPRODUCTOS%ROWTYPE;
    -- Declaramos una variable del tipo creado
    vttab_ty_nombre ttab_ty_nombre;
    
BEGIN

    SELECT *
    BULK COLLECT INTO vttab_ty_nombre
    FROM tbProductos;

    dbms_output.put_line('El número de registros es: '  || vttab_ty_nombre.COUNT);

    IF vttab_ty_nombre.COUNT > 0 THEN 
        FOR i IN vttab_ty_nombre.FIRST .. vttab_ty_nombre.LAST LOOP
            
            dbms_output.put_line('El ID del producto es: ' || vttab_ty_nombre(i).NIDPRODUCTO);
            dbms_output.put_line('El producto es: ' || vttab_ty_nombre(i).VDESPRODUCTO);
            --dbms_output.put_line('El ID del proveedor es: ' || vttab_ty_nombre(i).NIDPROVEEDOR);
            dbms_output.put_line('Tenemos ' || vttab_ty_nombre(i).NUNIDADES || ' unidades del producto');
            dbms_output.put_line('Su precio unitario ' || vttab_ty_nombre(i).NPRECIOUNITARIO || ' €');
            dbms_output.put_line('Se dio de alta el ' || TO_CHAR(vttab_ty_nombre(i).DFECHAALTA, 'DD/MM/YYYY'));
            dbms_output.put_line('------------------------------------------------------------------');
            
        END LOOP;
        
    ELSE 
        dbms_output.put_line('No se han recuperado productos de la tienda');
        
    END IF;

END;
/



