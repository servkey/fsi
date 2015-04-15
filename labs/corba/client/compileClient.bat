@echo off
REM Compilar cliente CORBA I 
REM Luis G. Montané Jiménez 
echo ******************************************************
echo Limpiando archivos compilados anteriormente
SET CLASSPATH=%CLASSPATH%;../idl/Hola.jar
SET ARCHIVO_JAR=Hola.jar

IF NOT EXIST *.class GOTO terminar
del *.class

:terminar
echo Compilando clases del cliente!!!
javac *.java
echo Finalizando compilación del cliente!!!
pause > nul