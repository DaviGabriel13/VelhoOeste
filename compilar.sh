#!/bin/bash

echo "========================================"
echo "  Compilando Velho Oeste - POO"
echo "========================================"
echo ""

# Cria o diretório bin se não existir
mkdir -p bin

echo "Compilando arquivos Java..."
javac -d bin -encoding UTF-8 src/*.java

if [ $? -eq 0 ]; then
    echo ""
    echo "========================================"
    echo "  Compilação concluída com sucesso!"
    echo "========================================"
    echo ""
    echo "Para executar o jogo, use: ./executar.sh"
    echo "Ou digite: java -cp bin Main"
else
    echo ""
    echo "========================================"
    echo "  ERRO na compilação!"
    echo "========================================"
    echo ""
    echo "Verifique se o JDK está instalado."
fi
