Ótima observação! Vou atualizar o **README.md** para incluir a menção ao uso do `mysql-connector-j-9.1.0.jar` como dependência para a conexão com o banco de dados MySQL.

### Atualização no README.md


# Sistema de Gerenciamento de Autores 📚

Este projeto foi desenvolvido como parte das aulas do **1000Devs Turma 4**, ministradas pelo professor **Rogério** da **Mesttra**. O objetivo foi criar uma aplicação em Java conectada ao banco de dados MySQL para realizar operações CRUD (Create, Read, Update, Delete).

---

## 🚀 Funcionalidades

- **Criar Conexão com o Banco de Dados**: Estabelece conexão segura com um banco de dados MySQL.
- **Consultar Autores**:
  - Listar todos os autores cadastrados.
  - Consultar um autor específico pelo ID.
- **Adicionar Autor**: Insere novos autores no banco de dados.
- **Atualizar Autor**: Atualiza as informações de um autor específico.
- **Deletar Autor**: Remove um autor do banco de dados pelo ID.

---

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem principal para a lógica da aplicação.
- **MySQL**: Banco de dados relacional para armazenamento de informações.
- **JDBC**: API para conexão e manipulação do banco de dados.
- **mysql-connector-j-9.1.0.jar**: Driver JDBC para conexão ao banco de dados MySQL.
- **Eclipse/IntelliJ**: IDEs recomendadas para o desenvolvimento.

---

## ⚙️ Configuração do Projeto

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:
- **Java JDK** (versão 8 ou superior).
- **MySQL** (com banco de dados `biblioteca` e tabela `autor`).
- Uma IDE como **Eclipse** ou **IntelliJ**.
- **mysql-connector-j-9.1.0.jar**: Baixe o arquivo [aqui](https://dev.mysql.com/downloads/connector/j/) e adicione-o ao seu projeto.

### Estrutura da Tabela `autor`

Crie a tabela `autor` no MySQL com a seguinte estrutura:
```sql
CREATE TABLE autor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    nacionalidade VARCHAR(50) NOT NULL
);
```

### Configuração do Banco de Dados

No código, ajuste os parâmetros de conexão conforme necessário:
```java
String url = "jdbc:mysql://localhost:3306/biblioteca";
String usuario = "root";
String senha = "sua_senha_aqui";
```

### Clonando o Repositório

```bash
git clone https://github.com/ViniciusBorgesdeAraujo/Java-MySQL
cd Java-MySQL
```

---

## 📝 Uso do Sistema

### Executar o Projeto

1. **Adicionar Dependência do MySQL Connector**:
   - Certifique-se de que o arquivo `mysql-connector-j-9.1.0.jar` está configurado no classpath do projeto.
   - Em IDEs como IntelliJ ou Eclipse, você pode adicionar o arquivo em:  
     **Project Structure > Libraries > Add JARs**.

2. **Abrir na IDE**: Importe o projeto e execute o arquivo `App.java`.

3. **Escolher Operações**: No método `main`, ative as funções desejadas, como:
   - `consultar()`
   - `inserir("Nome", "Nacionalidade")`
   - `atualizar(id, "Novo Nome", "Nova Nacionalidade")`
   - `deleter(id)`

### Exemplos de Operações

#### Inserir um novo autor
```java
inserir("Carla", "Brasileira");
```

#### Atualizar autor pelo ID
```java
atualizar(3, "Carlos Silva", "Portuguesa");
```

#### Deletar autor pelo ID
```java
deleter(5);
```

#### Consultar todos os autores
```java
consultar();
```

---

## 🖥️ Exemplo de Saída no Console

**Exemplo de Consulta:**
```
ID: 1, Nome: Ana Souza, Nacionalidade: Brasileira
ID: 2, Nome: Carlos Ribeiro, Nacionalidade: Portuguesa
ID: 3, Nome: João Silva, Nacionalidade: Brasileira
```

---

## 🤝 Contribuição

Sinta-se à vontade para abrir issues ou enviar pull requests.

---

## 📜 Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

---

Feito com 💻 e 📚 durante as aulas do **1000Devs Turma 4**.
```
