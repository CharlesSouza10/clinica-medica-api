# 🏥 Clínica Médica API

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de uma clínica médica.

## 📌 Funcionalidades

- CRUD de Pacientes
- CRUD de Médicos
- CRUD de Consultas
- CRUD de Exames
- Validação de dados com Jakarta Validation
- Autenticação e autorização com JWT
- Tratamento global de exceções
- Containerização com Docker
- Arquitetura em camadas (Controller, Service, Repository)

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT Authentication
- MySQL
- Hibernate / JPA
- Maven
- Docker
- Swagger / OpenAPI
- Jakarta Validation

---

## 📂 Estrutura do Projeto

```txt
src
 ┣ controller
 ┣ dto
 ┣ exception
 ┣ model
 ┣ repository
 ┣ security
 ┣ service
 ┗ resources
```

---

## 🔐 Segurança

O projeto utiliza:

- Spring Security
- JWT Authentication
- Endpoints protegidos
- Bearer Token
- Criptografia de senha

Exemplo de autenticação:

```http
POST /auth/login
```

---

## 📋 Endpoints Principais

### Pacientes

```http
GET /pacientes
POST /pacientes
PUT /pacientes/{id}
DELETE /pacientes/{id}
```

### Médicos

```http
GET /medicos
POST /medicos
PUT /medicos/{id}
DELETE /medicos/{id}
```

### Consultas

```http
GET /consultas
POST /consultas
PUT /consultas/{id}
DELETE /consultas/{id}
```

### Exames

```http
GET /exames
POST /exames
PUT /exames/{id}
DELETE /exames/{id}
```

---

## ⚙️ Configuração do Banco de Dados

Arquivo:

```properties
application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/clinica
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

---

## 🐳 Docker

### Build da imagem

```bash
docker build -t clinica-api .
```

### Rodar container

```bash
docker run -p 8080:8080 clinica-api
```

---

## ▶️ Executando o Projeto

### Pelo Maven

```bash
./mvnw spring-boot:run
```

### Build do projeto

```bash
./mvnw clean package
```

---

## 🧪 Testes da API

A API foi testada utilizando:

- Insomnia
- Swagger UI

---

## 👨‍💻 Autor

**Charles Souza**

GitHub: https://github.com/CharlesSouza10
LinkedIn: www.linkedin.com/in/charles-souza1