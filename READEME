# 🏥 FHIR Patient Management System

Este projeto é um ecossistema completo para gestão de pacientes utilizando o padrão internacional **HL7 FHIR (R4)**. Ele abrange desde a definição de regras de negócio brasileiras (IG) até a persistência em um servidor HAPI FHIR via Docker e uma interface de usuário em Java Spring Boot.

## 🚀 O Ecossistema

O projeto é dividido em três pilares principais:

1.  **Guia de Implementação (IG):** Definido via FSH (FHIR Shorthand), estabelecendo o perfil de "Paciente Brasileiro" onde o **CPF é obrigatório**.
2.  **Infraestrutura (Docker):** Um servidor **HAPI FHIR JPA** rodando sobre um banco de dados **PostgreSQL**.
3.  **Aplicação Java (Spring Boot):** Uma interface web para cadastrar e listar pacientes, validando os dados conforme o perfil definido no IG.

-----

## 🛠️ Tecnologias Utilizadas

  * **Linguagem:** Java 17
  * **Framework:** Spring Boot 3.2.0
  * **Padrão de Saúde:** HL7 FHIR R4
  * **Ferramenta FHIR:** HAPI FHIR SDK
  * **Banco de Dados:** PostgreSQL 14 (Docker)
  * **Front-end:** HTML5, Thymeleaf, Bootstrap 5
  * **Modelagem FHIR:** FSH (SUSHI)

-----

## 📋 Pré-requisitos

Antes de começar, você precisará ter instalado:

  * [Docker](https://www.docker.com/) e Docker Compose
  * [Java 17](https://www.google.com/search?q=https://adoptium.net/pt-br/temurin/releases/%3Fversion%3D17) ou superior
  * [Maven](https://maven.apache.org/)

-----

## 🔧 Como Rodar o Projeto

### 1\. Subir a Infraestrutura

Navegue até a pasta `fhir-server` e suba os containers:

```bash
docker-compose up -d
```

> O servidor estará disponível em `http://localhost:8080`. Aguarde cerca de 2 minutos para a inicialização completa do HAPI FHIR.

### 2\. Registrar o Perfil (IG) no Servidor

Para que o servidor valide o CPF conforme as regras brasileiras, envie o Perfil (StructureDefinition):

```powershell
# No PowerShell, dentro da pasta fhir-ig/fsh-generated/resources
$file = Get-Content -Raw -Path "StructureDefinition-paciente-br.json" -Encoding UTF8
Invoke-RestMethod -Uri "http://localhost:8080/fhir/StructureDefinition" -Method Post -Body $file -ContentType "application/fhir+json"
```

### 3\. Rodar a Aplicação Java

Navegue até a pasta `fhir-app-java` e execute:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8081`.

-----

## 📖 Funcionalidades

  * **`/` (Home):** Formulário de cadastro de pacientes.
  * **`/cadastrar`:** Envia os dados para o servidor HAPI, vinculando o recurso ao perfil `paciente-br`.
  * **`/listar`:** Consulta o servidor FHIR e exibe todos os pacientes cadastrados em uma tabela.

-----

## 📐 Regras de Negócio (FHIR Profile)

O perfil de paciente implementado neste projeto impõe as seguintes restrições:

  * **Identifier (CPF):** Obrigatório (`min: 1`).
  * **System:** Deve ser obrigatoriamente `https://gov.br/cpf`.
  * **Value:** O número do CPF deve estar presente.

-----

## 🤝 Contribuição

1.  Faça um Fork do projeto
2.  Crie uma Branch para sua feature (`git checkout -b feature/NovaFeature`)
3.  Adicione suas mudanças (`git commit -m 'Adicionando uma nova feature'`)
4.  Feed para a Branch (`git push origin feature/NovaFeature`)
5.  Abra um Pull Request

-----

### 📄 Licença

Este projeto está sob a licença MIT.

-----
