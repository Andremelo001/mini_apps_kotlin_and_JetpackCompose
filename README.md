# Mini Apps - Kotlin & Jetpack Compose

Coleção de mini aplicativos Android desenvolvidos com **Kotlin** e **Jetpack Compose** para estudo e prática dos conceitos fundamentais dessas tecnologias.

## Sobre o Projeto

Este repositório contém diversos mini apps criados com o objetivo de explorar e dominar os principais conceitos do desenvolvimento Android moderno:

- **Jetpack Compose**: Framework declarativo para UI
- **Kotlin**: Linguagem moderna e concisa
- **Material Design 3**: Princípios de design
- **State Management**: Gerenciamento de estado
- **Layouts**: Row, Column, LazyColumn
- **Modifiers**: Personalização de componentes
- **Interação com APIs**: Consumo de dados externos

---

## Mini Apps

### 1. Noções Básicas Compose
**Pasta:** `ativ_NocoesBasicasCompose/`

**Descrição:**  
Tutorial introdutório ao Jetpack Compose. Aplicativo simples que demonstra os conceitos básicos de composição, exibindo uma imagem e textos informativos sobre Jetpack Compose.

**Conceitos Praticados:**
- Composables básicos (Text, Image, Column)
- Modifiers (padding, fillMaxSize)
- String resources
- Preview

---

### 2. Affirmations
**Pasta:** `Affirmations/`

**Descrição:**  
Aplicativo que exibe uma lista de afirmações motivacionais com imagens correspondentes usando LazyColumn.

**Conceitos Praticados:**
- LazyColumn para listas eficientes
- Cards do Material Design
- Data classes e Data sources
- Image loading com recursos locais
- Edge-to-edge display

---

### 3. Business Card App
**Pasta:** `BusinessCardApp/`

**Descrição:**  
Cartão de visitas digital elegante exibindo informações de contato profissional com ícones do Material Design.

**Conceitos Praticados:**
- Layout complexo com Row e Column
- Material Icons
- Composição de UI estática
- Customização de cores e tipografia
- Alinhamento e espaçamento

---

### 4. Calculadora de IMC
**Pasta:** `CalculadoraIMC/`

**Descrição:**  
Calculadora de Índice de Massa Corporal (IMC) que permite ao usuário inserir peso e altura, calculando o IMC e exibindo a classificação correspondente.

**Conceitos Praticados:**
- TextField e input de dados
- State management com remember/mutableStateOf
- Cálculos e formatação de números
- Validação de entrada
- Feedback visual com classificações

**Classificações:**
- Abaixo de 17: Muito abaixo do peso
- 17 - 18,49: Abaixo do peso
- 18,50 - 24,99: Peso normal
- 25 - 29,99: Acima do peso
- 30 - 34,99: Obesidade I
- 35 - 39,99: Obesidade II (severa)
- Acima de 40: Obesidade III (mórbida)

---

### 5. Dice Roller
**Pasta:** `DiceRoller/`

**Descrição:**  
Simulador de dado que exibe uma imagem do dado e permite ao usuário "rolar" para obter um número aleatório de 1 a 6.

**Conceitos Praticados:**
- State management com remember/mutableStateOf
- Botões e eventos de clique
- Imagens condicionais (when expression)
- Números aleatórios
- Interatividade básica

---

### 6. Lista de Compras
**Pasta:** `ListaDeCompras/`

**Descrição:**  
Aplicativo de lista de compras que permite adicionar, visualizar e remover itens, além de mostrar a contagem total de itens.

**Conceitos Praticados:**
- LazyColumn com lista mutável
- CRUD operations (Create, Read, Delete)
- State management de listas
- TextField para input dinâmico
- Composição de itens de lista
- Contadores e estatísticas

---

### 7. Pokédex App
**Pasta:** `PokedexApp/`

**Descrição:**  
Pokédex interativa que consome a PokéAPI para exibir informações sobre Pokémon, incluindo lista de Pokémon, imagens, tipos, habilidades e detalhes.

**Conceitos Praticados:**
- Consumo de API REST (PokéAPI)
- Requisições HTTP
- Loading de imagens remotas
- Navegação entre telas
- Search/filtro de dados
- Async/await e Coroutines
- JSON parsing

---

### 8. Tip Time
**Pasta:** `TipTime/`

**Descrição:**  
Calculadora de gorjetas que permite ao usuário inserir o valor da conta e calcular automaticamente a gorjeta baseada em uma porcentagem.

**Conceitos Praticados:**
- TextField com validação numérica
- KeyboardOptions e KeyboardType
- Formatação de moeda
- Cálculos em tempo real
- State management
- Layout responsivo

---

## Como Executar os Mini Apps

### Pré-requisitos

- **Android Studio** (versão mais recente recomendada)
- **JDK** 17 ou superior
- **Dispositivo Android** ou **Emulador Android** configurado
- **Gradle** (incluído no projeto)

### Passos para Execução

1. **Clone ou abra o projeto:**
   ```bash
   cd c:\Users\André\mini_apps_kotlin_and_JetpackCompose
   ```

2. **Abra o mini app desejado no Android Studio:**
   - Abra o Android Studio
   - Selecione `File > Open`
   - Navegue até a pasta do mini app desejado (ex: `DiceRoller/`)
   - Clique em `OK`

3. **Sincronize o Gradle:**
   - O Android Studio deve sincronizar automaticamente
   - Ou clique em `File > Sync Project with Gradle Files`

4. **Configure o dispositivo:**
   - Conecte um dispositivo Android via USB (com depuração USB habilitada)
   - Ou inicie um emulador Android pelo AVD Manager

5. **Execute o aplicativo:**
   - Clique no botão `Run` (▶️) ou pressione `Shift + F10`
   - Selecione o dispositivo de destino
   - Aguarde a compilação e instalação

### Execução via Linha de Comando

Para executar usando Gradle Wrapper:

```powershell
# Navegue até a pasta do mini app
cd .\NomeDoApp\

# Execute o app (exemplo: debug build)
.\gradlew installDebug

# Ou compile apenas
.\gradlew assembleDebug
```
