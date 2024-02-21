# poc-1
Proof of concept project

## Tools
- Java 17
- Gradle 7.3
- Spring Boot 2.7.18
- PostgreSQL
- FlyWay
- Dockerfile, docker-compose

## Features
- Read values from csv file

## Run
### Dockerfile, image, container vie docker-compose
```
gradle clean build
docker build -t poc-1 .
docker compose -f docker-compose.yml pull
docker compose -f docker-compose.yml up -d
```

### Localhost
```
docker pull postgres
docker run --name poc-1-postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=poc_1 -d postgres
edit configuration → add poc-1.env
```