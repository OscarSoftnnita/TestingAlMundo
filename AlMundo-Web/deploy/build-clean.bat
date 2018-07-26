Echo "Iniciando Limpieza Almundo-Web"

Echo "Asignando Maven_Homen"
call mvn -Dmaven.home=C:\infovisual-desarrollo\herramientas-desarrollo\apache-maven-3.3.9 -s C:\Users\ycarrillo\Desktop\Herramientas\Personal\Documentacion\AlMundo\Repositorio\AlMundo\AlMundo-Web\settings-almundo.xml clean -f pom.xml -P envConfig-DE
Echo "Limpiando Almundo-web"





