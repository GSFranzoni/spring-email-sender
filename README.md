# Spring Boot Email Sender

## Introduction
This is a simple Spring Boot application that sends an email using the JavaMailSender interface.

## Configuration
You can see below the steps to run the application.

```zsh
./mvnw clean package
docker-compose up -d
```

## Usage
You can send an email sending a POST request to the endpoint `/email` with the following body:
```json
{
  "receiver": "<String>",
  "subject": "<String>",
  "content": "<String>"
}
```