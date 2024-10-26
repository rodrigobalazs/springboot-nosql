## Spring Boot NoSQL
This repository contains an Spring Boot Social Application which provides a REST API related to Posts.<br/>
The goal is to show some code examples of NoSQL data persistence via Spring Data MongoDB.

### 🔧 Technology Stack

```
Java 17
Spring Boot 3 ( REST API )
Spring Data MongoDB ( NoSQL )
Misc Libraries (  Maven  /  Docker  /  SpringDoc OpenAPI  /  Apache Commons  /  Lombok  )
```

### ⚒️ Getting Started

```bash
# clone the project
git clone https://github.com/rodrigobalazs/springboot-nosql.git;
cd springboot-nosql;

# starts a NoSQL MongoDB docker container
docker run --name <container_name> -d -p 27017:27017 -v mongodb_data:/data/db mongo;

# compile and start the spring boot server
mvn clean install;
mvn spring-boot:run;
```

### 💡 API Examples

#### 1. Get all the available Posts =>
```
curl -X GET http://localhost:8080/post/getPosts               -H 'accept: application/json';
```

#### 2. Retrieves a Post by Post Title ( post_title = "How to Boost Your Creativity" ) =>
```
curl -X GET http://localhost:8080/post/title/How%20to%20Boost%20Your%20Creativity   -H 'accept: application/json';
```

#### 3. Deletes a Post by Post Title ( post_title = "Creative Writing Prompts" ) =>
```
curl -X DELETE http://localhost:8080/post/title/Creative%20Writing%20Prompts;
```

#### 4. Creates a new Post =>
```
curl -X POST http://localhost:8080/post  \
     -H 'accept: application/json'  \
     -H 'Content-Type: application/json' -d \
'{
    "title": "The Importance of Continuous Learning",
    "content": "Embracing continuous learning can help you stay relevant and adaptable in a changing world."
}';
```

### 🔍 API Documentation / Swagger

the API documentation could be accessed from => http://localhost:8080/swagger-ui/index.html

![](https://github.com/rodrigobalazs/springboot-nosql/blob/main/src/main/resources/static/socialapp_api_swagger.png)