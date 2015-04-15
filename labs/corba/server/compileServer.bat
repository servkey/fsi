@echo off
REM Compilar servidor CORBA
REM Luis G. Montané Jiménez 
echo ******************************************************
echo Limpiando archivos compilados anteriormente
SET CLASSPATH=%CLASSPATH%;../idl/Hola.jar;../../Recursos/ConexionMiniFramework/frameworkmini.jar;

SET ARCHIVO_JAR=Hola.jar
IF NOT EXIST *.class GOTO terminar
del *.class

:terminar
echo Compilando clases del servidor!!!
javac *.java
echo Finalizando compilación del servidor!!!

pause > nul