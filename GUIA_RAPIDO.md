# ⚡ Guia Rápido - Velho Oeste

## 🚀 Início Rápido

### Windows
```bash
compilar.bat
executar.bat
```

### Linux/Mac
```bash
chmod +x *.sh
./compilar.sh
./executar.sh
```

---

## 📚 Arquivos Importantes

| Arquivo | Para que serve |
|---------|---------------|
| `README.md` | Visão geral do projeto |
| `CONCEITOS_POO.md` | Explicação detalhada dos conceitos |
| `ROTEIRO_APRESENTACAO.md` | Script para vídeo |
| `INSTALACAO_JAVA.md` | Resolver problemas com JDK |
| `ESTRUTURA_PROJETO.txt` | Mapa visual do projeto |

---

## 🎯 Onde está cada Conceito POO

### 1. Encapsulamento
📂 `src/Arma.java`
- Linhas 10-12: Atributos `private`
- Linhas 24-39: Getters e Setters

### 2. Abstração
📂 `src/Personagem.java`
- Linha 10: `abstract class`
- Linha 56: `abstract int atacar()`

### 3. Herança
📂 `src/Jogador.java` e `src/Pistoleiro.java`
- Linha 11: `extends Personagem`
- Linha 19: `super(...)` chamando construtor pai

### 4. Polimorfismo
📂 `src/Jogador.java` linha 48
📂 `src/Pistoleiro.java` linha 44
- `@Override public int atacar()` - implementações diferentes

### 5. Composição
📂 `src/Jogo.java` linhas 15-19
- `private Jogador jogador`
- `private ArrayList<Pistoleiro> pistoleiros`

---

## 🎮 Como Jogar

1. Digite seu nome
2. Leia a história
3. Clique "INICIAR JORNADA"

**Para cada pistoleiro:**

**FASE 1 - Navegação:**
- Memorize o caminho (10 segundos)
- Digite o caminho usando as setas
- Acerte para encontrar o pistoleiro

**FASE 2 - Duelo:**
- Aguarde o sinal "ATIRE!"
- Pressione ESPAÇO e depois ENTER rapidamente
- Seja mais rápido que o pistoleiro

---

## ⚠️ Problemas Comuns

### "javac não reconhecido"
❌ Problema: JDK não instalado
✅ Solução: Veja `INSTALACAO_JAVA.md`

### "Cannot find symbol"
❌ Problema: Erro de compilação
✅ Solução: Redownload os arquivos

### "Scripts não executam"
❌ Problema: Falta permissão (Linux/Mac)
✅ Solução: `chmod +x *.sh`

---

## 📊 Estrutura Simplificada

```
Personagem (abstrata)
    ├── Jogador (herança)
    └── Pistoleiro (herança)

Jogo (composição)
    ├── contém Jogador
    └── contém Pistoleiros

Arma (encapsulamento)
    └── atributos private + getters/setters
```

---

## 🎥 Para Apresentação

### Ordem sugerida:
1. **Introdução** (1 min) - Apresentar grupo e projeto
2. **Código** (4 min) - Mostrar cada conceito POO
3. **Demo** (3 min) - Jogar ao menos 1 pistoleiro
4. **Conclusão** (1 min) - Recapitular

### Focar em:
- ✅ Mostrar código comentado
- ✅ Explicar POR QUE cada conceito é importante
- ✅ Demonstrar o jogo funcionando
- ✅ Falar com confiança

---

## 📞 Checklist Final

Antes de apresentar:
- [ ] Jogo compila sem erros
- [ ] Jogo executa completamente
- [ ] Testei em outro computador
- [ ] Memorizei os pontos principais
- [ ] Preparei o ambiente de gravação

---

## 💡 Frases-Chave

**Encapsulamento:**
> "Protege os dados com private e controla acesso com getters/setters"

**Abstração:**
> "Define estrutura comum sem implementação completa"

**Herança:**
> "Reutiliza código da classe pai, evitando duplicação"

**Polimorfismo:**
> "Mesmo método, comportamentos diferentes"

**Composição:**
> "Uma classe contém objetos de outras classes"

---

## ⏱️ Comandos Rápidos

```bash
# Compilar
javac -d bin -encoding UTF-8 src/*.java

# Executar
java -cp bin Main

# Verificar Java
java -version
javac -version

# Limpar compilados
rm -rf bin/*  # Linux/Mac
rmdir /s bin  # Windows
```

---

## 🎓 Conceitos em 1 Frase

| Conceito | Definição |
|----------|-----------|
| Encapsulamento | Proteger dados com private + getters/setters |
| Abstração | Classe que serve de molde, não pode ser instanciada |
| Herança | Classe filha recebe atributos/métodos da pai |
| Polimorfismo | Mesmo método, implementações diferentes |
| Composição | Classe contém objetos de outras classes |

---

**Boa sorte! 🤠🔫**
