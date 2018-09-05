# SpringBoot_JWT


git clone <URL>

mvn clean install
mvn spring-boot:run

Step1: signup user(post)
http://localhost:8080/signup
{
	"username":"name",
	"password":"password",
	"age":27,
	"salary":2121
}

step2: Get Token(Post)
http://localhost:8080/token/generate-token
{
	"username":"lokesh",
	"password":"lokesh"
}

Step3: get All users(Get)
http://localhost:8080/users


Branch: swagger_impl
Access swagger using http://localhost:8080/swagger-ui.html
