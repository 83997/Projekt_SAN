# score-storage

> Mikroserwis odpowiedzialny za zapis statystyk

## Zmienne środowiskowe

| Nazwa                      | Wartość domyślna                               | Opis                                     |
| -------------------------- | ---------------------------------------------- | ---------------------------------------- |
| SCORE_STORE_RDBMS_URL      | `jdbc:postgresql://localhost:5432/postgres`     | URL połączenia z bazą danych PostgreSQL  |
| SCORE_STORE_RDBMS_USERNAME | `postgres`                                     | Nazwa użytkownika bazy danych PostgreSQL |
| SCORE_STORE_RDBMS_PASSWORD | `postgres`                                     | Hasło użytkownika bazy danych PostgreSQL |

## Tworzenie obrazu Dockerowego bazy danych

```
$ cd compose
$ docker-compose up
```

## Uruchamianie jako aplikacja pakietowa

```
$ java -jar {path}/{jar_name}.jar
```

## Uruchamianie korzystając z wtyczki Gradle Plugin

```
$ gradle bootRun
```

lub bez instalacji wtyczki

```
$ ./gradlew bootRun
```

## Actuator

* health
```
http://{ip}:8082/ops/health
```