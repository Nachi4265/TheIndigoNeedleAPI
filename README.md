# The Indigo Needle API 
### Description: This capstone is an e-commerce application, or an online store. The website uses a Spring Boot API project for the backend server, with a MySQL database for data storage.

## Features Implemented 
### Phase 1: Categories Management

GET all categories  
GET category by ID  
GET all products in a specific category  
POST create new category (Admin only)  
PUT update existing category (Admin only)  
DELETE remove category (Admin only)  

### Phase 2: Bug Fixes

Bug 1 - Search Functionality: Fixed incorrect product search results when filtering by price range. The maxPrice parameters were missing from the SQL query, causing filters to return inaccurate results.  

Bug 2 - Product Duplication: Resolved an issue where updating products created duplicates instead of modifying the existing record. The controller was incorrectly calling create() instead of update().  


# Technologies Used 🛠️

Spring Boot - Backend framework  
MySQL - Database management  
MySQL Workbench - Database design and management  
IntelliJ IDEA - IDE  
Insomnia/Postman - API testing  
Spring Security - Authentication and authorization  
JWT - Token-based authentication  


# Running the Application 
Prerequisites

Java 17 or higher  
MySQL Server  
Maven  

## Steps

Clone the repository  

bashgit clone [your-repository-url]  
cd indigo-needle-api  

Configure database connection in application.properties  

propertiesspring.datasource.url=jdbc:mysql://localhost:3306/recordshop  
spring.datasource.username=your_username  
spring.datasource.password=your_password  

Run the application  

bashmvn spring-boot:run  

The API will be available at http://localhost:8080  


# ScreenShots  

### All Products
<img width="400" height="400" alt="All Products" src="https://github.com/user-attachments/assets/87147738-4ae3-44ce-b6d8-ebef7f5e8ce8" />

### All Rock CD's
<img width="400" height="400" alt="All Rock CD&#39;s" src="https://github.com/user-attachments/assets/f7b2d04a-638f-463f-a1d2-cc898c3a3e2c" />

### CD $15 or Lower
<img width="400" height="400" alt="CD $15 or lower" src="https://github.com/user-attachments/assets/f8b56c83-b80b-406d-92e9-dc11a674eb33" />

### Products above $165
<img width="400" height="400" alt="Products above $165" src="https://github.com/user-attachments/assets/ae21bdf6-7efd-45c0-9706-3d2f61951029" />

### Category Dao Methods
<img width="400" height="400" alt="Category Dao Methods" src="https://github.com/user-attachments/assets/e29f8b29-ac05-4bf4-8c6b-9e98d2444aa7" />

### Product Dao Search 
<img width="400" height="400" alt="Product Dao Search" src="https://github.com/user-attachments/assets/28fa0278-0755-4d6d-93ea-2d43cfa6c727" />

### Category Controller
<img width="400" height="400" alt="Category Controller" src="https://github.com/user-attachments/assets/56e63ab3-8a98-4b95-8c24-b11b4b00360d" />

### Product Controller
<img width="400" height="400" alt="Product Controller" src="https://github.com/user-attachments/assets/479a7b0d-dbc0-4021-86e5-e002c7371655" />

## Status Codes
Status Code are 3 digit numbers sent from the server to the client to illustrate there was an error. 
  100's : Informational  
  200's : Success  
  300's : Redirection  
  400's : Client Error  
  500's : Server Error  

## Intresting Piece of Code:
### Request Mapping Shortcuts
@RequestMapping(path="/somepath", method = RequestMethod.GET)
It has options for each of the CRUD operations 

@GetMapping  
@PostMapping  
@PutMapping  
@DeleteMapping  

@RequestMapping(path="/products/{ID}",method = RequestMethod.GET)  
this can be shortened too  
@GetMapping("/products/{ID}")  

# Lessons Learned 

Importance of thorough testing for search and filter functionality  
Distinguishing between create and update operations in REST APIs  
Implementing role-based access control with Spring Security  
Debugging SQL queries with multiple parameters  
Best practices for RESTful API design  

# Acknowledgments 

Year Up United for the project framework
Pluralsight for the learning resources
The Spring Boot community for excellent documentation

## Resources 
https://docs.spring.io/spring-boot/reference/using/using-the-springbootapplication-annotation.html  
https://www.baeldung.com/spring-request-method-not-supported-405  
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ResponseStatus.html  
https://developer.konghq.com/insomnia/requests/  
https://developer.konghq.com/insomnia/request-authentication/  
https://www.jwt.io/  
https://restfulapi.net/http-status-codes/#2xx  
https://dev.mysql.com/doc/workbench/en/wb-develop-sql-editor-history.html  


# License 📄
This project was created as part of the Year Up United Java Development program.



