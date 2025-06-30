# Country Weather Service

Questo progetto implementa un microservizio Spring Boot che integra dati provenienti da due API pubbliche:

- [REST Countries](https://restcountries.com/v3.1/name/{country})
- [Open-Meteo](https://api.open-meteo.com/v1/forecast)

Il microservizio espone due endpoint REST per restituire informazioni relative a un paese e al meteo corrente della sua capitale.

## Caratteristiche

- Endpoint `GET /country-weather/{country}`:
  - Recupera informazioni del paese (capitale, popolazione, valuta, bandiera) e il meteo della capitale.
  - Salva o aggiorna i dati in un database H2.

- Endpoint `PUT /country-weather/{country}`:
  - Permette di aggiornare informazioni aggiuntive come `visited`, `notes`, `rating`.

- Documentazione API generata automaticamente tramite OpenAPI/Swagger, accessibile tramite interfaccia web.

- Containerizzazione tramite Docker.

## Requisiti

- Java 17
- Maven 3.9+
- Docker (per esecuzione containerizzata)

## Build e avvio con Maven

Per compilare il progetto ed eseguire il jar:

```bash
./mvnw clean package
java -jar target/*.jar# MicroServiceEsame
