# Spring-Boot-CRUD-Roles
This repository includes basic spring  boot implementation for micro service which enables REST APIs for CRUD operations in roles in a company

#### **Libraries used**

* Spring Boot 2.3.1.RELEASE
* MongoDB
* Custom: Exceptions,  
* Spring Boot Test
* Swagger API
* Maven

#### **Features**

This service(REST API) can perform,

1. Roles CRUD operations
2. Retrieve role from NIC number
3. Retrieve roles by organization and role type
4. Delete role by id
5. Integration tests

#### **Installing**

**1. Clone the application**

`git clone https://github.com/NirodhaSuchinthana/Spring-Boot---CRUD-Roles.git`

**2. Build and run the application**

`cd <directory>`
`mvn clean install  `

run the application

`mvn spring-boot:run`

The backend server will start at http://localhost:8095.

#### **Instructions and Navigations**

All the code is organized in to folders for easy convenience.

![alt text](https://github.com/NirodhaSuchinthana/Spring-Boot---CRUD-Roles.git/tree/master/src/main/resources/readme_content/folder-structure.png)

The document for Role is as follows.
`public class Roles {
 
     public enum RoleType {
         DRIVER,
         ASSISTANT
     }
 
     @Id
     private static Integer id;
     private String organization;
     private String firstName;
     private String lastName;
     private String nicNo;
     private RoleType roleType;
     private Date createdDate;
     private Date modifiedDate;
     
     //and Constructor,getters and setters`

![alt text](https://github.com/NirodhaSuchinthana/Spring-Boot---CRUD-Roles/blob/master/src/main/resources/readme_content/folder-structure.png)

