Práctica CORBA
Luis G. Montané Jiménez


Requerimientos:
	JDK, configuración de variables de entorno para el comando javac, java, idlj, etc. (PATH,CLASS_PATH)

**Desde consola CMD***
Pasos para compilación:
	
	Dentro de la carpeta "/idl" compilar la interfaz idl con el comando:
		compileIdl.bat
	Dentro de la carpeta "/server" compilar el servidor con el comando:
		compileServer.bat
	Dentro de la carpeta  "/client" compilar el cliente con el comando:
		compileClient.bat

Pasos para ejecución:
	1) Dentro de la carpeta "/server" iniciar el servicio para corba con:
		startService.bat
	
	
	2) Para la ejecución del servidor, en la carpeta"/server" lanzar el comando:
		startServer.bat
	 	*Para el siguiente paso necesitará abrir otra consola y ubicarse en la carpeta "client".

	3) Dentro de la carpeta cliente probar la ejecución con:
		startClient.bat