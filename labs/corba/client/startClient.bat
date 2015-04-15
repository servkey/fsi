@echo off
REM Iniciar el cliente
REM Luis G. Montané Jiménez 

SET CLASSPATH=%CLASSPATH%;../idl/Hola.jar
echo ********************************************************
java ClientTest -ORBInitialPort 2000 -ORBInitialHost localhost
pause > nul