@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  unibo.pingpong24 startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and UNIBO_PINGPONG24_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH. 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME% 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\unibo.pingpong24-1.0-plain.jar;%APP_HOME%\lib\kotlinx-coroutines-core-jvm-1.5.1.jar;%APP_HOME%\lib\okhttp-4.9.3.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.9.22.jar;%APP_HOME%\lib\okio-jvm-2.8.0.jar;%APP_HOME%\lib\kotlin-stdlib-1.9.22.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.9.22.jar;%APP_HOME%\lib\californium-proxy2-3.5.0.jar;%APP_HOME%\lib\guava-30.1.1-jre.jar;%APP_HOME%\lib\kotlinx-coroutines-core-1.5.1.pom;%APP_HOME%\lib\javax.websocket-api-1.1.jar;%APP_HOME%\lib\tyrus-standalone-client-1.9.jar;%APP_HOME%\lib\httpclient-4.5.13.jar;%APP_HOME%\lib\org.eclipse.paho.client.mqttv3-1.2.5.jar;%APP_HOME%\lib\json-simple-1.1.1.jar;%APP_HOME%\lib\json-20180130.jar;%APP_HOME%\lib\californium-core-3.5.0.jar;%APP_HOME%\lib\commons-io-2.11.0.jar;%APP_HOME%\lib\unibo.planner23-1.0.jar;%APP_HOME%\lib\aima-core-3.0.0.jar;%APP_HOME%\lib\uniboInterfaces.jar;%APP_HOME%\lib\2p301.jar;%APP_HOME%\lib\unibo.qakactor23-5.0.jar;%APP_HOME%\lib\unibo.basicomm23-1.0.jar;%APP_HOME%\lib\javafx-fxml-11-linux.jar;%APP_HOME%\lib\javafx-web-11-linux.jar;%APP_HOME%\lib\javafx-controls-11-linux.jar;%APP_HOME%\lib\javafx-media-11-linux.jar;%APP_HOME%\lib\javafx-graphics-11-linux.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\checker-qual-3.8.0.jar;%APP_HOME%\lib\error_prone_annotations-2.5.1.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\httpcore-4.4.16.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\junit-4.13.2.jar;%APP_HOME%\lib\element-connector-3.5.0.jar;%APP_HOME%\lib\californium-legal-3.5.0.jar;%APP_HOME%\lib\httpclient5-5.1.4.jar;%APP_HOME%\lib\slf4j-api-1.7.36.jar;%APP_HOME%\lib\httpcore5-h2-5.1.5.jar;%APP_HOME%\lib\httpcore5-5.1.5.jar;%APP_HOME%\lib\javafx-base-11-linux.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\hamcrest-core-2.2.jar;%APP_HOME%\lib\hamcrest-2.2.jar


@rem Execute unibo.pingpong24
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %UNIBO_PINGPONG24_OPTS%  -classpath "%CLASSPATH%" it.unibo.ctxtest.MainCtxtestKt %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable UNIBO_PINGPONG24_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%UNIBO_PINGPONG24_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
