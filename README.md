# The Mauritian Adventure

I love Mauritius and Spring Boot... So I thought that I will try to write a browser game using Spring Boot, Redis,
Velocity templating engine, Bootstrap and a few other technologies.

Let's see how far it will get. Once there is something playable there, I will host it and if it is fun I may even
use some real front end technologies!

* Run the application locally: `mvn spring-boot:run`
* Build a Docker image: `mvn spring-boot:build-image`

## Issues 
* For some reason Freemarker requires all the types to be public. There's got to be some way around this.
* Spring's integration for Freemarker and GraalVM do not like each other at the moment. 
