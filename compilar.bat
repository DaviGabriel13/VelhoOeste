@echo off
echo ========================================
echo   Compilando Velho Oeste - POO
echo ========================================
echo.

REM Cria o diretório bin se não existir
if not exist "bin" mkdir bin

echo Compilando arquivos Java...
javac -d bin -encoding UTF-8 src/*.java

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo   Compilacao concluida com sucesso!
    echo ========================================
    echo.
    echo Para executar o jogo, use: executar.bat
    echo Ou digite: java -cp bin Main
) else (
    echo.
    echo ========================================
    echo   ERRO na compilacao!
    echo ========================================
    echo.
    echo Verifique se o JDK esta instalado.
)

pause
