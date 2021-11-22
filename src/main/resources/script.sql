BEGIN;

DROP TABLE IF EXISTS public.areas CASCADE;
DROP SEQUENCE IF EXISTS sq_areas_id;
CREATE SEQUENCE sq_areas_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.areas
(
    id bigint default nextval('sq_areas_id'),
    area varchar(100),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.cargos CASCADE;
DROP SEQUENCE IF EXISTS sq_cargos_id;
CREATE SEQUENCE sq_cargos_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.cargos
(
    id bigint default nextval('sq_cargos_id'),
    cargo varchar(100),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.categoria CASCADE;
DROP SEQUENCE IF EXISTS sq_categoria_id;
CREATE SEQUENCE sq_categoria_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.categoria
(
    id bigint default nextval('sq_categoria_id'),
    categoria varchar(30),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.ciudades CASCADE;
DROP SEQUENCE IF EXISTS sq_ciudades_id;
CREATE SEQUENCE sq_ciudades_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.ciudades
(
    id bigint default nextval('sq_ciudades_id'),
    ciudad varchar(60),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.correos CASCADE;
DROP SEQUENCE IF EXISTS sq_correos_id;
CREATE SEQUENCE sq_correos_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.correos
(
    id bigint default nextval('sq_correos_id'),
    correo varchar(150),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.direcciones CASCADE;
DROP SEQUENCE IF EXISTS sq_direcciones_id;
CREATE SEQUENCE sq_direcciones_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.direcciones
(
    id bigint default nextval('sq_direcciones_id'),
    direccion varchar(100),
    pais bigint,
    provincia bigint,
    ciudad bigint,
    referencia varchar(100),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.empleados CASCADE;
DROP SEQUENCE IF EXISTS sq_empleados_id;
CREATE SEQUENCE sq_empleados_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.empleados
(
    id bigint default nextval('sq_empleados_id'),
    cargo bigint,
    area bigint,
    sueldo money,
    fecha_ingreso date,
    comentario varchar(200),
    fecha_nacimiento date,
    persona bigint,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.estado_civil CASCADE;
DROP SEQUENCE IF EXISTS sq_estado_civil_id;
CREATE SEQUENCE sq_estado_civil_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.estado_civil
(
    id bigint default nextval('sq_estado_civil_id'),
    estado varchar(30),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.inventario CASCADE;
CREATE TABLE public.inventario
(
    codigo varchar(10),
    producto varchar(100),
    referencia varchar(100),
    marca bigint,
    unidad_medida bigint,
    costo money,
    precio money,
    activo boolean,
    categoria bigint,
    sucursal varchar(10),
    PRIMARY KEY (codigo)
);

DROP TABLE IF EXISTS public.inventario_proveedores CASCADE;
CREATE TABLE public.inventario_proveedores
(
    inventario_codigo varchar(10),
    proveedores_id bigint
);

DROP TABLE IF EXISTS public.marca CASCADE;
DROP SEQUENCE IF EXISTS sq_marca_id;
CREATE SEQUENCE sq_marca_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.marca
(
    id bigint default nextval('sq_marca_id'),
    marca varchar,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.pais CASCADE;
DROP SEQUENCE IF EXISTS sq_pais_id;
CREATE SEQUENCE sq_pais_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.pais
(
    id bigint default nextval('sq_pais_id'),
    pais varchar(100),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.pais_provincia CASCADE;
CREATE TABLE public.pais_provincia
(
    pais_id bigint,
    provincia_id bigint
);

DROP TABLE IF EXISTS public.persona CASCADE;
DROP SEQUENCE IF EXISTS sq_persona_id;
CREATE SEQUENCE sq_persona_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.persona
(
    id bigint default nextval('sq_persona_id'),
    nombre varchar(150),
    apellido varchar(150),
    direccion bigint,
    cedula varchar(10),
    sexo bigint,
    path_foto varchar(200),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.persona_correos CASCADE;
CREATE TABLE public.persona_correos
(
    persona_id bigint,
    correos_id bigint
);

DROP TABLE IF EXISTS public.persona_telefonos CASCADE;
CREATE TABLE public.persona_telefonos
(
    persona_id bigint,
    telefonos_id bigint
);

DROP TABLE IF EXISTS public.proveedores CASCADE;
DROP SEQUENCE IF EXISTS sq_proveedores_id;
CREATE SEQUENCE sq_proveedores_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.proveedores
(
    id bigint default nextval('sq_proveedores_id'),
    razon_social varchar(20),
    ruc varchar(14),
    observacion varchar(200),
    contacto bigint,
    direccion bigint,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.proveedores_persona CASCADE;
CREATE TABLE public.proveedores_persona
(
    proveedores_id bigint,
    persona_id bigint
);

DROP TABLE IF EXISTS public.provincia CASCADE;
DROP SEQUENCE IF EXISTS sq_provincia_id;
CREATE SEQUENCE sq_provincia_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.provincia
(
    id bigint default nextval('sq_provincia_id'),
    provincia varchar(60),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.provincia_ciudades CASCADE;
CREATE TABLE public.provincia_ciudades
(
    provincia_id bigint,
    ciudades_id bigint
);

DROP TABLE IF EXISTS public.recursos CASCADE;
DROP SEQUENCE IF EXISTS sq_recursos_id;
CREATE SEQUENCE sq_recursos_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.recursos
(
    id bigint default nextval('sq_recursos_id'),
    recurso varchar(100),
    estado_recurso varchar(50),
    estado boolean,
    costo money,
    tipo bigint,
    PRIMARY KEY (id)
);

COMMENT ON TABLE public.recursos
    IS 'recursos de la empresa';

COMMENT ON COLUMN public.recursos.estado_recurso
    IS 'en que estado se encuentra este recurso asignado';

DROP TABLE IF EXISTS public.sexo CASCADE;
DROP SEQUENCE IF EXISTS sq_sexo_id;
CREATE SEQUENCE sq_sexo_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.sexo
(
    id bigint default nextval('sq_sexo_id'),
    sexo varchar(20),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.sucursal CASCADE;
CREATE TABLE public.sucursal
(
    id varchar(10),
    sucursal varchar(40),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.telefonos CASCADE;
DROP SEQUENCE IF EXISTS sq_telefonos_id;
CREATE SEQUENCE sq_telefonos_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.telefonos
(
    id bigint default nextval('sq_telefonos_id'),
    extension varchar(5),
    telefono varchar(10),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.unidad_medida CASCADE;
DROP SEQUENCE IF EXISTS sq_unidad_medida_id;
CREATE SEQUENCE sq_unidad_medida_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.unidad_medida
(
    id bigint default nextval('sq_unidad_medida_id'),
    simbolo varchar(5),
    medida varchar(15),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.usuarios CASCADE;
DROP SEQUENCE IF EXISTS sq_usuarios_id;
CREATE SEQUENCE sq_usuarios_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.usuarios
(
    id bigint default nextval('sq_usuarios_id'),
    usuario varchar(50),
    clave varchar(30),
    autorizado boolean,
    activo boolean,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.directorios CASCADE;
DROP SEQUENCE IF EXISTS sq_directorios_id;
CREATE SEQUENCE sq_directorios_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.directorios
(
    id bigint default nextval('sq_directorios_id'),
    directorio varchar(60),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.archivos CASCADE;
DROP SEQUENCE IF EXISTS sq_archivos_id;
CREATE SEQUENCE sq_archivos_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.archivos
(
    id bigint default nextval('sq_archivos_id'),
    archivo varchar(200),
    ubicacion_fisica varchar(200),
	descripcion	varchar(200),
	nota varchar(200),
	fecha_creacion date,
	fecha_subida date,
	importancia bigint,
	area bigint,
	tipo_documento bigint,
	directorio bigint,
	estado boolean,
    PRIMARY KEY (id)
);
ALTER TABLE public.archivos
    ADD FOREIGN KEY (directorio)
    REFERENCES public.directorios (id)
    NOT VALID;

DROP TABLE IF EXISTS public.recursos_empleados CASCADE;
CREATE TABLE public.recursos_empleados
(
    recursos_id bigint,
    empleados_id bigint
);

DROP TABLE IF EXISTS public.tipo_recurso CASCADE;
DROP SEQUENCE IF EXISTS sq_tipo_recurso_id;
CREATE SEQUENCE sq_tipo_recurso_id
	minvalue 1
	maxvalue 2147483647
	increment by 1;
CREATE TABLE public.tipo_recurso
(
    id bigint default nextval('sq_tipo_recurso_id'),
    stock bigint,
    tipo varchar(50),
    PRIMARY KEY (id)
);

ALTER TABLE public.direcciones
    ADD FOREIGN KEY (ciudad)
    REFERENCES public.ciudades (id)
    NOT VALID;


ALTER TABLE public.direcciones
    ADD FOREIGN KEY (pais)
    REFERENCES public.pais (id)
    NOT VALID;


ALTER TABLE public.direcciones
    ADD FOREIGN KEY (provincia)
    REFERENCES public.provincia (id)
    NOT VALID;


ALTER TABLE public.empleados
    ADD FOREIGN KEY (area)
    REFERENCES public.areas (id)
    NOT VALID;


ALTER TABLE public.empleados
    ADD FOREIGN KEY (cargo)
    REFERENCES public.cargos (id)
    NOT VALID;


ALTER TABLE public.empleados
    ADD FOREIGN KEY (persona)
    REFERENCES public.persona (id)
    NOT VALID;


ALTER TABLE public.inventario
    ADD FOREIGN KEY (categoria)
    REFERENCES public.categoria (id)
    NOT VALID;


ALTER TABLE public.inventario
    ADD FOREIGN KEY (marca)
    REFERENCES public.marca (id)
    NOT VALID;


ALTER TABLE public.inventario
    ADD FOREIGN KEY (sucursal)
    REFERENCES public.sucursal (id)
    NOT VALID;


ALTER TABLE public.inventario
    ADD FOREIGN KEY (unidad_medida)
    REFERENCES public.unidad_medida (id)
    NOT VALID;


ALTER TABLE public.inventario_proveedores
    ADD FOREIGN KEY (inventario_codigo)
    REFERENCES public.inventario (codigo)
    NOT VALID;


ALTER TABLE public.inventario_proveedores
    ADD FOREIGN KEY (proveedores_id)
    REFERENCES public.proveedores (id)
    NOT VALID;


ALTER TABLE public.pais_provincia
    ADD FOREIGN KEY (pais_id)
    REFERENCES public.pais (id)
    NOT VALID;


ALTER TABLE public.pais_provincia
    ADD FOREIGN KEY (provincia_id)
    REFERENCES public.provincia (id)
    NOT VALID;


ALTER TABLE public.persona
    ADD FOREIGN KEY (direccion)
    REFERENCES public.direcciones (id)
    NOT VALID;


ALTER TABLE public.persona
    ADD FOREIGN KEY (sexo)
    REFERENCES public.sexo (id)
    NOT VALID;


ALTER TABLE public.persona_correos
    ADD FOREIGN KEY (correos_id)
    REFERENCES public.correos (id)
    NOT VALID;


ALTER TABLE public.persona_correos
    ADD FOREIGN KEY (persona_id)
    REFERENCES public.persona (id)
    NOT VALID;


ALTER TABLE public.persona_telefonos
    ADD FOREIGN KEY (persona_id)
    REFERENCES public.persona (id)
    NOT VALID;


ALTER TABLE public.persona_telefonos
    ADD FOREIGN KEY (telefonos_id)
    REFERENCES public.telefonos (id)
    NOT VALID;


ALTER TABLE public.proveedores
    ADD FOREIGN KEY (direccion)
    REFERENCES public.direcciones (id)
    NOT VALID;


ALTER TABLE public.proveedores_persona
    ADD FOREIGN KEY (persona_id)
    REFERENCES public.persona (id)
    NOT VALID;


ALTER TABLE public.proveedores_persona
    ADD FOREIGN KEY (proveedores_id)
    REFERENCES public.proveedores (id)
    NOT VALID;


ALTER TABLE public.provincia_ciudades
    ADD FOREIGN KEY (ciudades_id)
    REFERENCES public.ciudades (id)
    NOT VALID;


ALTER TABLE public.provincia_ciudades
    ADD FOREIGN KEY (provincia_id)
    REFERENCES public.provincia (id)
    NOT VALID;


ALTER TABLE public.recursos_empleados
    ADD FOREIGN KEY (recursos_id)
    REFERENCES public.recursos (id)
    NOT VALID;


ALTER TABLE public.recursos_empleados
    ADD FOREIGN KEY (empleados_id)
    REFERENCES public.empleados (id)
    NOT VALID;


ALTER TABLE public.recursos
    ADD FOREIGN KEY (tipo)
    REFERENCES public.tipo_recurso (id)
    NOT VALID;

END;

------------------------------------------
------- TRIGGERS
------------------------------------------
/*CREATE OR REPLACE FUNCTION insert_marca() RETURNS TRIGGER 
LANGUAGE plpgsql
AS $$
DECLARE
	usuario varchar(20) := USER;
BEGIN
	INSERT INTO audit_marca values(usuario,new.marca);
	RETURN NEW;
END; $$

CREATE TRIGGER aud_marca AFTER INSERT ON marca
for each row
execute procedure insert_marca();

insert into marca (marca) values ('NIKE');
select * from marca;
select * from audit_marca;*/
------------------------------------------
------- AÑADIR USUARIOS
------------------------------------------
/*
INSERT INTO USUARIOS (usuario,clave,autorizado,activo)
VALUES ('DANY','DANY123',true,true);

SELECT * FROM USUARIOS;
*/
