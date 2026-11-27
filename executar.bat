@echo off
echo ========================================
echo   Velho Oeste - Busca por Vinganca
echo ========================================
echo.

REM Verifica se a pasta bin existe
if not exist "bin" (
    echo ERRO: Arquivos nao compilados!
    echo Execute primeiro: compilar.bat
    echo.
    pause
    exit
)

echo Iniciando o jogo...
echo.
java -cp bin Main

pause
