# Running-tracking-system

#Project 1 - running information analysis service
Steps:
1. mvn clean install
2. cd target
3. java -jar running....jar (if using application.properties/application.yml)
   java -jar -Dspring.profiles.active=prod running....jar (if running application-prod.properties

Docker mysql:
4. create and edit a file docker-compose.yml
5. start docker container: docker-compose up -d
6. docker exec -it [container_name] bash/mysql -uroot -p

Postman:
7. POST https://localhost:8080/runningInfo and add requestBody, JSON type
8. GET https://localhost:8080/runningInfo?page=1&size=2
9. DELETE https://localhost:8080/runningInfo/1

