Echo "Iniciando EMPAQUETADO Almundo-Web"
call mvn -Dmaven.home=C:\infovisual-desarrollo\herramientas-desarrollo\apache-maven-3.3.9 -s C:\Users\ycarrillo\Desktop\Herramientas\Personal\Documentacion\AlMundo\Repositorio\AlMundo\AlMundo-Web\settings-almundo.xml package -f pom.xml -P envConfig-DE
Echo "EMPAQUETADO FinalizadO"





