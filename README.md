# Engseen-Purchase-Requisition-Backend

# Pre-requisite
1. Docker compose (download docker desktop should include docker-compose)
2. Gradle
3. Java 11

## Development
1. Start up database, and create DATABASE 'API'. This is because SQL SERVER cannot create database on startup. 
    - Recommend using Azure Data Studio
    - Login with connection details as follows:
        - Connection Type: Microsoft SQL Server
        - Server: 127.0.0.1,1433
        - Authentication: SQL Login
        - Username: sa
        - Password: Password123@
        - Database: Default
        - Server group: Default

```shell
docker-compose -f src/main/docker/mssql.yml up -d
```
2. Start up application
    - CLI: 
        - windows   : 
          ```/gradlew.bat bootRun```
        - unix      : 
          ```./gradlew bootRun``` (In case of Permission Denied, run ```chmod +x gradlew```)
          
3. Debug using Intellij
    - Ensure project loaded as gradle project
    - Ensure gradle is using ```gradle-wrapper.properties``` to execute tasks
    - Run application / gradle tasks
    
4. Shut down database while keeping data
```shell
docker-compose -f src/main/docker/mssql.yml stop
```

5. Start stopped database
```shell
docker-compose -f src/main/docker/mssql.yml stop
```

6. Shut down and clean up database
```shell
docker-compose -f src/main/docker/mssql.yml down
```