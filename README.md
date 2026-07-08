# Automação Web com Java e Selenium

## 📌 Descrição

Este projeto demonstra uma automação web utilizando **Java** e **Selenium WebDriver**.

A aplicação abre o navegador Google Chrome, acessa o portal **GE Globo**, realiza diversas validações na página e encerra o navegador automaticamente.

O objetivo do projeto é demonstrar conceitos de automação de testes web, servindo como material de estudo e portfólio para QA.

---

## 🚀 Funcionalidades

A automação executa as seguintes ações:

* Inicializa o navegador Google Chrome;
* Acessa o site do GE Globo;
* Maximiza a janela do navegador;
* Aguarda o carregamento da página utilizando **WebDriverWait**;
* Valida o título da página;
* Verifica se a URL está correta;
* Pesquisa uma palavra específica no conteúdo da página;
* Conta a quantidade de links existentes;
* Conta a quantidade de imagens carregadas;
* Lista todos os títulos (`<h2>`) encontrados;
* Verifica a existência de botões na página;
* Realiza um scroll até o final da página;
* Fecha completamente o navegador.

---

## 🛠 Tecnologias utilizadas

* Java
* Selenium WebDriver
* ChromeDriver
* Maven
* IntelliJ IDEA

---

## 📂 Estrutura do projeto

```text
src
└── main
  └── java
    └── webautomation
      ├── GEAutomation.java
      └── Main.java
```

Cada classe possui uma única responsabilidade, facilitando a organização, manutenção e reutilização do código.

---

## ▶️ Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/pedroaugustopg/java-selenium-web-automation
```

### 2. Abra o projeto

Importe o projeto em sua IDE de preferência (IntelliJ IDEA, Eclipse ou VS Code).

### 3. Configure o ChromeDriver

Atualize o caminho do ChromeDriver conforme sua máquina.

Exemplo:

```java
System.setProperty(
    "webdriver.chrome.driver",
    "C:\\BrowserDrivers\\chromedriver.exe");
```

### 4. Execute

Execute a classe:

```
Main.java
```

---

## 📋 Validações realizadas

| Validação        | Descrição                                            |
| ---------------- | ---------------------------------------------------- |
| Acesso ao site   | Abre o portal GE Globo                               |
| Título da página | Obtém e exibe o título da página                     |
| URL              | Verifica se a URL contém o trecho esperado           |
| Palavra-chave    | Procura uma palavra específica no conteúdo da página |
| Links            | Conta todos os links disponíveis                     |
| Imagens          | Conta todas as imagens carregadas                    |
| Títulos (`<h2>`) | Lista os títulos encontrados                         |
| Botões           | Verifica a quantidade de botões presentes            |
| Scroll           | Navega até o final da página                         |

---

## 💡 Boas práticas aplicadas

* Separação de responsabilidades em classes distintas;
* Utilização de métodos específicos para cada ação;
* Uso de `WebDriverWait` para sincronização da automação;
* Encerramento correto do navegador com `driver.quit()`;
* Código organizado e modular;
* Estrutura preparada para futuras evoluções.

---

## 👨‍💻 Objetivo

Este projeto foi desenvolvido com fins de estudo para aprimorar conhecimentos em automação de testes web utilizando Java e Selenium, aplicando conceitos de organização 
de código e boas práticas amplamente utilizadas em projetos de QA.
