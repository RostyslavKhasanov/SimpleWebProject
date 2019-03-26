# How to run it?
The backend is done with 
- Java 8
- Spring Boot
- SDK 1.8
- IntelliJ IDEA 2018.3.4
- Maven 3 (version 3.3.9)

There is embedded tomcat and embedded in-memory h2 database.

Running from IDE : File - Open - choose project and run.

Running as a Packaged Application:
- jdk1.8.0_171

In console go to the directory of project, then:
```
java -jar target/test-0.0.1-SNAPSHOT.jar
```
# curl for test (from postman):

Add user:

```
curl --location --request POST "http://localhost:8080/users" \
  --header "Content-Type: application/json" \
  --data "{
	\"name\" : \"Vitya\",
	\"age\" : 24,
	\"article\" : {
		\"id\" : 2
	}
}"
```

Get users with green article:
```
curl --location --request GET "http://localhost:8080/articles/user/color?color=GREEN" \
  --header "Content-Type: application/json" \
  --data ""
```

Get users with age > some number:
```
curl --location --request GET "http://localhost:8080/users/age?number=20" \
  --header "Content-Type: application/json" \
  --data ""
```
Get users with more then 2 articles:
```
curl --location --request GET "http://localhost:8080/users/article" \
  --data ""
```

Add article (for user): 
```
curl --location --request POST "http://localhost:8080/articles" \
  --header "Content-Type: application/json" \
  --data "{
	\"text\" : \"Some text\",
	\"color\" : \"RED\",
	\"user\" : {
		\"id\" : 2
	}
}"
```
