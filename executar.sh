#!/bin/bash

echo "========================================"
echo "  Velho Oeste - Busca por Vingança"
echo "========================================"
echo ""

# Verifica se a pasta bin existe
if [ ! -d "bin" ]; then
    echo "ERRO: Arquivos não compilados!"
    echo "Execute primeiro: ./compilar.sh"
    echo ""
    exit 1
fi

echo "Iniciando o jogo..."
echo ""
java -cp bin Main
