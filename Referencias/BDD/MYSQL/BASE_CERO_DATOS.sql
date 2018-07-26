/*BASE CERO Datos ALMUNDO MYSQL
@author Yaher Carrillo
@Date-Create 25/07/2018
@Date-last-change 25/07/2018
@Desciption:
Elementos iniciales de las tablas maestro.
EJECUTAR COMO SE MUESTRA A CONTINUACION*/

/*Se toma la base de datos*/
use almundo;




/*Se crea el perfil administrador*/
INSERT INTO `almundo_perfiles` (`NOMBRE_PERFIL`, `ADMINISTRADOR`, `HABILITADO`) VALUES ('ADMINISTRADOR', '1', '1');

/* Se agrega el parametro de administracion de clientes*/

INSERT INTO `almundo`.`almundo_parametros` (`ID_PARAMETRO`, `DESCRIPCION`, `VALOR`, `TIPO_DATO`, `NOMBRE`, `GRUPO`) VALUES ('1', 'Parametro que define el servicio a prestar', 'SERVICIO_ALMUNDO', 'string', 'SERVICIO_CLIENTE', 'Administracion');

/* Se crea el usuario adminitrador */
INSERT INTO `almundo`.`almundo_usuarios` (`ID_USUARIO`, `LOGIN`, `CLAVE`, `NOMBRE_USUARIO`, `APELLIDO_USUARIO`, `FECHA_REGISTRO`, `FECHA_ULTIMA_VIS`, `HABILITADO`) VALUES ('24', 'admin', '$2a$10$NaEtoblGlFnueVKz32HcYOuh.FUfg3/IbH9IVY0wRoe.lZFy8bAcK', 'Administrador', 'Adminsitrador', '2018-07-13', '2018-07-13', '1');

INSERT INTO `almundo`.`almundo_usuarios` (`ID_USUARIO`, `LOGIN`, `CLAVE`, `NOMBRE_USUARIO`, `APELLIDO_USUARIO`, `FECHA_REGISTRO`, `FECHA_ULTIMA_VIS`, `HABILITADO`) VALUES ('25', 'operador', '$2a$10$NaEtoblGlFnueVKz32HcYOuh.FUfg3/IbH9IVY0wRoe.lZFy8bAcK', 'operador', 'operador', '2018-07-13', '2018-07-13', '1');
INSERT INTO `almundo`.`almundo_usuarios` (`ID_USUARIO`, `LOGIN`, `CLAVE`, `NOMBRE_USUARIO`, `APELLIDO_USUARIO`, `FECHA_REGISTRO`, `FECHA_ULTIMA_VIS`, `HABILITADO`) VALUES ('26', 'supervisor', '$2a$10$NaEtoblGlFnueVKz32HcYOuh.FUfg3/IbH9IVY0wRoe.lZFy8bAcK', 'supervisor', 'supervisor', '2018-07-13', '2018-07-13', '1');
INSERT INTO `almundo`.`almundo_usuarios` (`ID_USUARIO`, `LOGIN`, `CLAVE`, `NOMBRE_USUARIO`, `APELLIDO_USUARIO`, `FECHA_REGISTRO`, `FECHA_ULTIMA_VIS`, `HABILITADO`) VALUES ('27', 'director', '$2a$10$NaEtoblGlFnueVKz32HcYOuh.FUfg3/IbH9IVY0wRoe.lZFy8bAcK', 'director', 'director', '2018-07-13', '2018-07-13', '1');

/* Se asocia el usuario administrador a su perfil de acceso*/

INSERT INTO `almundo`.`almundo_usuario_perfil` (`ID_USUARIO_PERFIL`, `ID_USUARIO`, `ID_PERFIL`, `HABILITADO`) VALUES ('10', '24', '1', '1');
INSERT INTO `almundo`.`almundo_usuario_perfil` (`ID_USUARIO_PERFIL`, `ID_USUARIO`, `ID_PERFIL`, `HABILITADO`) VALUES ('11', '25', '1', '1');
INSERT INTO `almundo`.`almundo_usuario_perfil` (`ID_USUARIO_PERFIL`, `ID_USUARIO`, `ID_PERFIL`, `HABILITADO`) VALUES ('12', '26', '1', '1');
INSERT INTO `almundo`.`almundo_usuario_perfil` (`ID_USUARIO_PERFIL`, `ID_USUARIO`, `ID_PERFIL`, `HABILITADO`) VALUES ('13', '27', '1', '1');

/*Se confirman las transacciones*/
commit;