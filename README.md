## Springboot-jwt-demo

##About
Springboot-jwt-demo is a demonstration of a completely stateless and RESTful token-based authorization system using JSON Web Tokens (JWT) and Springboot.

##Requirements
Cerberus requires Maven and Java 1.7 or greater.

##Usage
To use start Springboot-jwt-demo, run in the terminal `mvn spring-boot:run`. Springboot-jwt-demo will now be running at `http://localhost:8080`

There are two built-in user accounts to demonstrate the differing levels of access to the endpoints:
```
User - user:123
Admin - admin:123
```

Tokens are configured to expire after 10 minutes, you can get a new token by sign in again.