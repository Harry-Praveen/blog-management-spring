**Blog Management System (Spring Boot + AI + AWS)**


A backend service built with **Spring Boot** for managing blogs. It includes:
- CRUD operations for blog posts
- AI-powered text summarization (OpenAI API)
- MySQL database with Spring Data JPA
- Dockerized for easy deployment


# 🚀 Features
- 📝 Create, Read, Update, Delete blogs
- 🤖 AI-powered blog summarization (via OpenAI API)
- 📦 Dockerized for easy deployment

## 🛠️ Setup Instructions

**(1) Clone the repository****

**sh**
git clone https://github.com/Harry-Praveen/blog-management-spring.git

cd blog-management-spring

**(2️) Configure MySQL Database**

Update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/blog_db

spring.datasource.username=root

spring.datasource.password=yourpassword

**(3️) Set OpenAI API Key**

Add API key to application.properties:

openai.api.key=sk-xxxxxxxxxxxxxxxx

**(4️) Run the Application**

Using Maven:

mvn spring-boot:run

**📡 API Endpoints**

Method	Endpoint	Description

POST	    /api/blogs	        Create a new blog

GET      	/api/blogs      	  Get all blogs (paginated)

GET    	  /api/blogs/{id}    	Get blog by ID

PUT    	  /api/blogs/{id}    	Update blog

DELETE  	/api/blogs/{id}    	Delete blog

GET	      /api/blogs/{id}/summary	      Get AI-generated summary
