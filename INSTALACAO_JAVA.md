# 📦 Guia de Instalação do Java JDK

## ⚠️ Problema Comum

Se ao tentar compilar aparecer o erro:
```
'javac' não é reconhecido como comando
```

Isso significa que o **JDK (Java Development Kit)** não está instalado ou não está no PATH do sistema.

---

## ✅ Solução: Instalar o JDK

### Opção 1: Oracle JDK (Recomendado para Iniciantes)

1. **Baixar o JDK**
   - Acesse: https://www.oracle.com/java/technologies/downloads/
   - Escolha a versão mais recente (JDK 17 ou superior é ideal)
   - Baixe o instalador para Windows (arquivo `.exe`)

2. **Instalar**
   - Execute o instalador
   - Siga as instruções (Next → Next → Finish)
   - **IMPORTANTE**: Anote o caminho de instalação (geralmente `C:\Program Files\Java\jdk-XX`)

3. **Configurar o PATH** (Windows)
   
   **Passo a passo:**
   
   a) Pressione `Win + Pause` ou clique com botão direito em "Este Computador" → Propriedades
   
   b) Clique em "Configurações avançadas do sistema"
   
   c) Clique em "Variáveis de Ambiente"
   
   d) Na seção "Variáveis do sistema", procure `Path` e clique em "Editar"
   
   e) Clique em "Novo" e adicione:
   ```
   C:\Program Files\Java\jdk-17\bin
   ```
   (Ajuste o caminho conforme sua instalação)
   
   f) Clique em "OK" em todas as janelas
   
   g) **IMPORTANTE**: Feche e abra novamente o terminal/prompt

4. **Verificar**
   ```bash
   java -version
   javac -version
   ```
   
   Ambos devem exibir a versão instalada.

---

### Opção 2: OpenJDK (Gratuito e Open Source)

1. **Baixar**
   - Acesse: https://adoptium.net/
   - Baixe o instalador para Windows
   - Escolha a versão LTS mais recente (ex: JDK 17 ou 21)

2. **Instalar**
   - Execute o instalador
   - **MARQUE** a opção "Add to PATH" durante a instalação
   - Conclua a instalação

3. **Verificar**
   ```bash
   java -version
   javac -version
   ```

---

## 🔧 Verificação Rápida

Abra um novo terminal/prompt e digite:

```bash
javac -version
```

Se aparecer algo como:
```
javac 17.0.x
```

✅ **Está tudo certo!** Pode compilar o projeto.

Se ainda aparecer erro:
```
'javac' não é reconhecido
```

❌ O PATH não foi configurado corretamente. Refaça o passo 3 da instalação.

---

## 🚀 Após Instalar o JDK

### Windows:
1. Abra o Prompt de Comando **em uma nova janela**
2. Navegue até a pasta do projeto:
   ```
   cd C:\Users\joaol\OneDrive\Desktop\velhooeste
   ```
3. Execute:
   ```
   compilar.bat
   ```

### Linux/Mac:
1. Abra o Terminal
2. Navegue até a pasta do projeto:
   ```
   cd /caminho/para/velhooeste
   ```
3. Dê permissão de execução:
   ```
   chmod +x compilar.sh executar.sh
   ```
4. Execute:
   ```
   ./compilar.sh
   ```

---

## 📋 Resumo de Comandos

```bash
# Verificar se o Java está instalado
java -version

# Verificar se o compilador está instalado
javac -version

# Compilar manualmente (se os scripts não funcionarem)
javac -d bin -encoding UTF-8 src/*.java

# Executar o jogo
java -cp bin Main
```

---

## 🆘 Problemas Comuns

### 1. "java works but javac doesn't"
**Causa**: Apenas o JRE (Java Runtime) está instalado, não o JDK.
**Solução**: Instale o JDK completo.

### 2. "Cannot find symbol" ao compilar
**Causa**: Erro de sintaxe no código ou arquivo corrompido.
**Solução**: Redownload os arquivos do projeto.

### 3. Scripts .sh não executam no Linux/Mac
**Causa**: Falta permissão de execução.
**Solução**: 
```bash
chmod +x compilar.sh executar.sh
```

### 4. Erro de encoding
**Causa**: Caracteres especiais (acentos) não reconhecidos.
**Solução**: Já está incluído `-encoding UTF-8` nos scripts.

---

## ✨ Pronto!

Após seguir estes passos, você conseguirá:
- ✅ Compilar o projeto
- ✅ Executar o jogo
- ✅ Fazer modificações no código
- ✅ Apresentar sem problemas

**Boa sorte no projeto! 🎓🤠**
