REM the script allows to call ant with required options and additional parameters specified.
setlocal

set TMP=D:\temp

set M2_HOME=d:\environment\common\apache-maven-3.3.9\
set PATH=%PATH%;%M2_HOME%\bin

set JAVA_HOME=d:\environment\common\jdk8\
set PATH=%PATH%;%ANT_HOME%\bin

call mvn clean package
endlocal