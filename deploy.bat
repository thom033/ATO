@echo off
REM Define variables
set MAVEN_HOME=C:\Program Files\Apache Software Foundation\apache-maven-3.8.8
set TOMCAT_HOME=C:\Program Files\Apache Software Foundation\Tomcat 10.1
set PROJECT_DIR=D:\GitHub\ATO

REM Navigate to the project directory
cd %PROJECT_DIR%

REM Clean and package the project using Maven
%MAVEN_HOME%\bin\mvn clean package

REM Check if the build was successful
if %ERRORLEVEL% NEQ 0 (
    echo Maven build failed. Exiting.
    exit /b %ERRORLEVEL%
)

REM Stop Tomcat
%TOMCAT_HOME%\bin\shutdown.bat

REM Wait for a few seconds to ensure Tomcat has stopped
timeout /t 5 /nobreak

REM Delete the old WAR file and exploded directory from Tomcat webapps
del /q %TOMCAT_HOME%\webapps\your-application.war
rmdir /s /q %TOMCAT_HOME%\webapps\your-application

REM Copy the new WAR file to Tomcat webapps
copy %PROJECT_DIR%\target\your-application.war %TOMCAT_HOME%\webapps\

REM Start Tomcat
%TOMCAT_HOME%\bin\startup.bat

echo Deployment complete.

pause