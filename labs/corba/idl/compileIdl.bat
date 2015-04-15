@echo off
REM Generar paquete jar desde una interfaz IDL
REM Luis G. Montané Jiménez 
echo ******************************************************
echo Limpiando archivos compilados anteriormente
set ARCHIVO_JAR=Hola.jar

echo Compilando interfaz IDL
idlj -fall Hola.idl

echo Compilando código java generado por el compilador idl
javac HolaApp/*.java

echo Generar paquete jar......
echo %ARCHIVO_JAR%
IF NOT EXIST %ARCHIVO_JAR% GOTO terminar
del %ARCHIVO_JAR%
:terminar
jar -cf  %ARCHIVO_JAR% HolaApp\*.class

echo Compilación finalizada!!!
echo ******************************************************
pause > nul