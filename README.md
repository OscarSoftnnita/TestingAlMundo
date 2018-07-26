# AlMundo
Hola Soy Yaher Carrillo, a continuacion describo las instrucciones, que dan solucion a la problematica 
del ejercicio java planteado en la referencia #AlMundo/Referencias/Ejercicio JAVA actualizado.pdf


#A continuacion explico los elementos del repositorio, los cuales son un plus
para la evaluacion de mi forma de desarrollar y liderar equipos de trabajo con respecto a:

	a.-)Arquitectura de la aplicacion
	b.-)Manejo de recursos.
	c.-)Buenas Practicas.
	d.-)Documentacion Explicita.
	e.-)Alto Acoplamiento
	f.-)Alta Disponibilidad.
	g.-)Escalabilidad.
	
# Recursos				

Pueden observar la construccion de 4 proyectos de integracion, los cuales necesitan para
dar funcionamiento a la solucion de la problematica planteada previamente. Dichos proyectos
presentan la funcionalidad util de :

1.-)AlMundo-Logger:

		Es una aplicacion custom de la utilizacion del log de escrituras para aplicaciones
	se encarga de poder segmentar nuestro log de errores de una forma dinamica, permitiendo 
	la segmentacion de nuestro modulos o aplicativos en pro de acudir de forma agil al log
	necesario segun la problematica, ademas de esto permite la busqueda rapida de nuestros
	procesos debido a que tiene una segmentacion (Nivel mas Bajo) con respecto a nuestro 
	interactores de la aplicacion, es decir, se puede segmentar nuestro log por modulos de
	la aplicacion y se puede indicar inclusive el usuario que origino la falla. 
		Esto permite un rastreo	rapido y agil para la solucion de problemas 
		o estudio de fallas. 
	
		Entrego esto como un plus en pro de dar una solucion manejable y escalable, 
		de tal manera que sea evaluado, la escalabilidad arquitectada para cualquier 
		aplicacion.
		
2.-)AlMundo-Api:

		Aplicacion Spring que delega los servicios que ofrece la aplicacion, segmentada y 
		modular	en pro de escalar a un nivel superior, dando robustes y alto acoplamiento
		para la integracion	de nuevas funcionalidades o inclusive multiples implementaciones
		(misma api, multiples clientes) si asi se requiere.		
		
		Entrego esto como un plus en pro de dar una solucion manejable y escalable, para que
		sea evaluado y se conozca el skill manejado.
	
3.-)AlMundo-Impl:

		Aplicacion Spring + Hibernate (Annotations), que contiene las implementaciones 
		abocadas a las interfaces expuestas por el API. Se puede denotar el uso de multiples
		implementaciones para una misma funcion,el uso de anotaciones y evitar el uso de 
		configuracion XML, contiene pruebas unitarias JUNIT, abocada las reglas
		expuesta en el ejercicio. 
	
4.-)AlMundo-Web:	

	Aplicacion web, construida en pro de plasmar una solucion amigable a la problematica. 
	En la misma se puede denotar el uso de un formulario de autenticacion y otros procesos 
	de seguridad para acceder a la aplicacion, este plus es en pro de evaluar 
	las buenas practicas y manejos de datos que se le da a la informacion ademas
	de evidenciar la arquitectura de la misma.El formulario de bienvenida luego de una 
	autenticacion exitosa, demostrara la solucion de la problematica de forma amigable.

# Instrucciones Despliegue

	
#Se describe a continuacion las instrucciones para la construccion de los paquetes, usos y accesos:

	Nota: Si se desea no hacer uso de un IDE para la construccion de paquetes, puede
			ayudarse con la ejecucion de procesos ".bat" los cuales realizaran 
			la tarea sin necesidad de usar un entorno de desarrollo. Cada proyecto	
			en su ruta principal poseen los archivos: build-clean.bat,build-package.bat,
			build-install.bat. Si desea limpiar el proyecto ejecutar build-clean,
			si desea empaquetar el artefacto ejecutar build-package, si deseaintalar el 
			artefacto en su repositorio configurado ejecutar build-install.

	1.-)Se debe instalar en nuestro S.O la instancia java, versiones 7 o superior 
	(Este proyecto fue basado en Java 8).Si no se tiene el recurso puede obtenerlo
	en AlMundo\Referencias\Instaladores\jdk1.8.0_121  AlMundo\Referencias\Instaladores\jre1.8.0_121.
	De lo contrario no realice la descarga.
		
	2.-)Se debe instalar en nuestro S.O la instancia de apache maven. Para esto tomar en 
		cuenta la configuracion de la variable de entorno y el mapeo adecuado hacia 
		nuestro paquete. Si no se tiene el recurso puede obtenerlo en 
		AlMundo\Referencias\Instaladores\apache-maven-3.3.9.
		De lo contrario no realice la descarga.
		
	3.-)Se debe instalar en nuestro S.O una intancia de Mysql. Si no se
		tiene el recurso puede obtenerlo en AlMundo\Referencias\Instaladores\Mysql.
		De lo contrario no realice la descarga.
		
	4.-) Correr en nuestra instancia de Base de Datos el script alojado en : 
		AlMundo\Referencias\BDD\MYSQL\BASE_CERO_ESQUELETO.sql, leer 
		los doc LEEME.txt si es necesario.
	
	5.-) Correr en nuestra instancia de Base de Datos el script alojado en : 
		AlMundo\Referencias\BDD\MYSQL\BASE_CERO_DATOS.sql,leer 
		los doc LEEME.txt si es necesario.
		
	6.-)Aperturar los proyectos en el IDE de su gusto, y ejecutar las siguientes
		tareas si se desea comprobar el correcto funcionamiento del code y su verificacion:
		
			6.1-)Fijar nuestro repositorio de artefactos en el IDE.
			
			6.2-)Selecccionar nuestro perfil de construccion DE-CA-PROD, 
				Desarrollo, Calidad, Produccion correspondientemente.
				
			6.3-)Ejecutar clean, package, install en ese orden para los 
				siguientes paquetes ordenadamente:
				
				6.3.1.-)AlMundo-Logger.
				6.3.2.-)AlMundo-Api.
				6.3.3.-)AlMundo-Impl.
				6.3.3.-)AlMundo-Web.
				
	7.-) Configurar nuestro gestor de aplicaciones; para este caso se uso un ambiente
		de desarrollo Tomcat.En caso de no poseerlo puede encontrarlo en : 
			AlMundo\Referencias\Instaladores\apache-tomcat-8.0.33.
			
			Puede bien configurar la subida del servidor apuntando directamente 
			al paquete de las siguiente formas:
			
				7.-1) Configurar el archivo \conf\server.xml del tomcat y agregar el 
				directorio y nombre de la aplicacion:
				
	"<Context path="/ALMundo" docBase="<RUTA-DESPLIEGUE>\AlMundo" debug="0">			
		   <Manager className="org.apache.catalina.session.PersistentManager" saveOnRestart="false"/>           
	</Context>"
					
				7.-2) Colocar el paquete generado AlMundo-Web, dentro del directorio de 
					despliegues webapp\AlMundo-Web.war
				
				7.3.-) Notese en el repositorio en la ruta 
					AlMundo\Referencias\Instaladores\apache-tomcat-8.0.33\webapps\ContenidoEstatico
					carpeta necesaria para la buena visualizacion de los recursos esteticos o L&F 
					en pro de que la aplicacion web	no sea un monolito y puede ser escalable en dicho 
					ambito tambien. Es necesario que los recursos visuales
					apunten a dicha carpeta como se muestra en : 
					\AlMundo\Referencias\Anexos\anx004.png, de lo contrario tendras un L&F basico.
	
	8.-) La aplicacion(AlMundo-Web) internamente en sus archivos de propiedades intentara conectarse
			a una base de datos con Nombre: "[almundo]", Usuario :[root], Clave [root].
			Si se desea realizar a otra conexion es necesario alterar los valores de el archivo : 
			hibernate.properties ubicado en 
			#\AlMundo-Web\src\main\resources\application.properties  y empaquetarla nuevamente.
			
	9.-) La aplicacion internamente construira nuestro log de errores segmentados en :
			#C:\\log\\
			Si se desea ver el funcionamiento de esta libreria en otra ruta
			se deben alterar los valores de este archivo de propiedades y empaquetar nuevamente
			el artefacto,de lo contrario el log no funcionara y todo se vera reflejado en el 
			log del gestor de aplicaciones (Tomcat).
			
	10.-)Iniciar el servidor de aplicaciones y aperturar la ruta : 
		http://localhost:8080/ALMundo/index.xhtml, verificar antes:
		
			10.1-) El puerto deseado y el path de la aplicacion, este fue el usado para este ejercicio.
		
	11.-)Una vez arriba la aplicacion se debe visualizar una pagina inicial como se muestra en : 
		\AlMundo\Referencias\Anexos\anx001.png
	
	12.-) Ingresar a la aplicacion con los usuarios de login : [admin],[operador],[supervisor],[director] 
	
	13.-) Clave de acceso registrada para todos: [admin]. Se debe poder mostrar como aparece en: 
		\AlMundo\Referencias\Anexos\anx002.png
	
	
	
# Explicacion solucion			

	Construccion:
		Ambito: JAVA
		IDE: Intell JIdea.
		FrameWorks: Spring, Jsf.
		Control de Versiones : GitHub.
		Control de Paquetes : Maven.
		BDD: Mysql.

	Solucion a problematica, descrita en puntos:
	
	1.-) Enfocarse en el bean AdminCallBean.Java, el mismo
		es el encargado de dar accionar a las tareas basicas como
		
		1.1.-)Emular Nuevas Llamadas
		1.2.-)Recargar eventos para su visualizacion.
		1.3.-)Visualizar el comportamiento de los hilos.
	
	2.-) Enfocarse en metodo [asignarLlamada] del Bean AdminCallBean.java.
		Es quien invoca al distpacher (CallDispatcher.Java) de llamadas, el cual genera,
		activa, administra, pausa y cancela los hilos asociados a llamadas.
		Para este caso el metodo le indica al despachador, la generacion de una 
		nueva llamada y delega la funcionalidad al hilo para su atencion.
		
	3.-)Clase CallDispatcher.java, enfocar la construccion orientada a la escalabilidad
		y segmentacion de procesos para la generacion de hilos a traves de procesos que
		deben ser sobreescritos para ser usado a demanada. Procesos:
			3.1-)Init().
			3.2-)procesar().
			3.3-)getSegundosPausa().
		En cada proceso se visualizan procesos de inicializacion de recursos
		de procesamiento o ejecucion de las tareas que se necesiten; no necesariamente
		la elaboracion o busqueda de una llamada, puede ser usado para otros procesos.
		Ademas de esto tiene los procesos de negocio extras encapsulados en la misma clase:
			3.4.-)Pausar el Hilo.
			3.5.-)Detener el hilo.
	4.-) El tiempo de actualizacion o "dormir" el hilo se dejo en un minuto para efecto
		 de pruebas rapidas, las instrucciones indican una aleatoriedad de 1 a 5 minutos
		 segun el ejercicio, este valor se puede alterar y la solucion se adaptaria.
	5.-) Se puede chequear en "procesar()" el uso de procesos de negocio. Invocando
		 tareas al servicio de negocio SalasLlamadasServices.Java. El servicio
		 mencionado previamente aboca al negocio de la solucion orientado a objetos,
		 el mismo nos proporciona las tareas de :
			5.1.-)Buscar operadores,asesores,directores disponibles.
			5.2.-)Actualizar sus datos de ocupacion para llamadas entrantes.
			5.3.-)Sincronizacion en la atencion de llamadas, para evitar entradas multiples.
	6.-)Como reglas de la aplicacion alternas al negocio se puede ver plasmadas las siguientes:
		6.1.-)Las llamadas "entrantes" son puestas en espera hasta la liberacion de un empleado 
			para su atencion.
		6.2.-)Las llamadas entrantes que intentes mas de 3 veces ;este valor puede ser parametrizable;
			seran canceladas por no ser atendidas.
		6.3.-)Las llamadas puedes ser canceladas por el el usuario conectado, lo que desencadena
			la destruccion del hilo.
	7.-) Se abstrae o encapsula el funcionamiento de los hilos a traves de la clase 
		ThreadRootListener.java. En pro de hacer atomico el desarrollo y adaptable a 
		cualquier solucion que se aboque al uso de hilos. Respetando los procesos de:
		creacion, detencio, destruccion, pausa del hilo a ejecutar.
	8.-) La generacion de una nueva llamada, genera la construccion de un hilo
		autogestionable si la misma no es atendida; estos procesos pueden ser parametrizables.
	
	9.-) El uso de hilos para soluciones de este estilo en ambientes robustos,
		requieren de soporte en cuanto a infraestructura para el funcionamiento
		correcto de la solucion.
		
	10.-) Cualquier proceso que requiera de tareas paralelas, pueden usar la implementacion 
		de ThreadRootListener.java como se hizo para esta solucion.
		
	11.-) Test de pruebas Unitarias en CallDispatcherTest.java

# Mejoras de la solucion					

	1.-) Cambiar el proceso de actualizacion visual, evitar que se haga con el boton "recargar".
		1.1-) Propuesta: Uso de bases de datos en tiempo real, que activen 
			la ejecucion de los servicios a trave de un Ambiente Node.Js que contengan los 
			cliente de consumo por ejemplo.Pueden ser Firebase, Parse, entre otros.
			
	2.-) Semantica en espanglish. Mejora
	
	3.-) Sincronizacion de hilos, para labores conjuntas en los procesos de negocio.
	
	4.-) Scripts de creacion para otros motores de BDD en pro de que la configuracion	
		 hibernate se adapte a cualquier motor.
		 
	5.-) Pruebas automatizadas para evitar pruebas recursivas.
			
			
			