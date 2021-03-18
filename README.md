# GraphQL-kickstater-springboot-tutorial



<h1 align="center"> GraphQL with SpringBoot demo </h1>  



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-tutorial">About The Tutorial</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#what-you-need">What you need</a></li>
        <li><a href="#prior-knowledge">Prior knowledge</a></li>
        <li><a href="#how-to-complete-this-tutorial">How to complete this tutorial</a></li>
      </ul>
    </li>
    <li><a href="#lets-begin">Let's begin</a></li>
    <ul>
	    <li><a href="#step-1-create-your-spring-boot-application">Step 1: Create your Spring Boot application</a></li>
	    <li><a href="#step-2-add-additional-dependencies">Step 2: Add additional dependencies</a></li>
	    <li><a href="#step-3-create-new-database">Step 3: Create new database</a></li>
	    <li><a href="#step-4-add-spring-boot-configurations-in-application.properties">Step 4: Add Spring Boot configurations in application.properties</a></li>
	    <li><a href="#step-5-create-entity-classes-and-their-repositories">Step 5: Create Entity classes and their Repositories</a></li>
	    <li><a href="#step-6-create-schema.graphql-for-basic-query-operation">Step 6: Create schema.graphql for basic query operation</a></li>
	    <li><a href="#step-7-create-resolver-classes-for-schema-type">Step 7: Create resolver classes for schema type</a></li>
	    <li><a href="#step-8-add-mutation-type-to-schema.graphql">Step 8: Add mutation type to schema.graphql</a></li>
	    <li><a href="#step-9-add-data-class-for-authorinput-and-mutation-resolver">Step 9: Add Data class for AuthorInput and Mutation Resolver</a></li>
	    <li><a href="#step-10-test-our-graphql">Step 10: Test our GraphQL</a></li>
	    
   </ul>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Tutorial

[![Product Name Screen Shot][product-screenshot]](https://example.com)
This is a tutorial for building GraphQL server with Spring Boot using GraphQL Java Kickstart and Spring Data JPA


### Built With

* [SpringBoot](https://start.spring.io/)
* [GraphQL Java Kickstart](https://github.com/graphql-java-kickstart)
* [Project Lombok](https://projectlombok.org/)



<!-- GETTING STARTED -->
## Getting Started

### What you need
* A text editor or IDE - We use Inteliji in this tutorial but you can choose your own preferred IDE
* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
* [Maven 3.2+](https://maven.apache.org/download.cgi)

###  Prior knowledge
* If you don't know how Spring Boot work, what is GraphQL, what is JPA, you can click these link below and learn more
* Come back to this page when you have a little comfortable with those concept.
* Maven:
	* [Maven in 5 minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
* Spring Boot: 
	* [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)
	* [Spring 5 on Udemy by Chad Darby](https://www.udemy.com/course/spring-hibernate-tutorial/): learn all you need to know about Spring 5 framework
	* [Introduction to Spring Data JPA](https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa)
* GraphQL
	* [GraphQL - learn](https://graphql.github.io/learn/)
	* [GraphQL in Java World, let's go for a dive - Vladimir Dejanović](https://www.youtube.com/watch?v=5_uSpiXCeMI)
	* [Moving beyond REST: GraphQL and Java & Spring](https://www.youtube.com/watch?v=iHxu2bq3fxI&t=1653s)


### How to complete this tutorial
* Start from scratch, you can follow all the steps below, building your own application.
* If you don't have time, clone this repo and load it on your IDE and discovery it in your free time 
```
git clone https://github.com/TienTruong98/GraphQL-kickstater-springboot-tutorial
```


## Let's begin

####  Step 1: Create your Spring Boot application
![spring initializer image](link-image-spring-initial)
* Go to [Spring Initializer](https://start.spring.io/) and create your Spring Boot app with the following configurations:
	* **Project**: maven project
	* **Language**: java
	* **Spring Boot**: latest stable version (at the time of this tutorial, the lastest one is 2.4.1)
	* **Project metatadata**:
		*  **Group**: your own group name - usual practice is com.[yourname]
		* **Artifact**: your project name
		* **Name**: use the generated default name
		* **Description**: use the generated default name
		* **Pakage name**: use the generated default name
		* **Packaging**: choose JAR
		* **Java**: choose your current JDK version
* Add **dependencies**: 
	* Lombok
	* Spring Web
	* MS SQL Server Driver
	* Spring Data JPA
* Click **Generate**, download the project zip file and extract it to your directory.
* Check the pom.xml - your pom.xml file should look like this
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.4.1</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.tientt</groupId>
	<artifactId>graphql-tutorial</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>graphql-tutorial</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.microsoft.sqlserver</groupId>
			<artifactId>mssql-jdbc</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
```
####  Step 2: Add additional dependencies
* [Jackson-databind](https://github.com/FasterXML/jackson-databind): to automatic convert POJO to JSON 
```
<dependency>  
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>  
	<version>2.11.0</version>  
</dependency>
```
* [GraphQL Java Kickstart for Spring Boot](https://github.com/graphql-java-kickstart/graphql-spring-boot)
```
<dependency>  
	<groupId>com.graphql-java-kickstart</groupId>  
	<artifactId>graphql-spring-boot-starter</artifactId>  
	<version>8.0.0</version>  
</dependency>  
<dependency>  
	<groupId>com.graphql-java-kickstart</groupId>  
	<artifactId>graphiql-spring-boot-starter</artifactId>  
	<version>8.0.0</version>  
	<scope>runtime</scope>  
</dependency>
```
####  Step 3: create new database
* Here we use Microsoft SQL Server but you can you any database - that the point of JPA
```
/*Step 1: create database*/
create database BookManagement
use BookManagement

/*Step 2: create tables*/
create table Author(
	id bigint primary key,
	fullname nvarchar(100)
)

create table Book(
	isbn char(13) primary key,
	title nvarchar(100) not null,
	edition int,
	publishedYear int,
	authorId bigint foreign key references Author(id)
)

/*Step 3: create some data*/
insert into Author values(1, N'Paulo Coelho');
insert into Author values(2, N'Rosie Nguyễn');
insert into Author values(3, N'Robin Sharma');

insert into Book values ('2518407786529', N'The Alchemist (Nhà giả kim)', 1, 2013, 1);
insert into Book values ('6911225907262', N'Tuổi Trẻ Đáng Giá Bao Nhiêu', 2, 2018, 2);
insert into Book values ('2425402340697', N'Đời Ngắn Đừng Ngủ Dài', 2, 2014, 3);
```
####  Step 4: add Spring Boot configurations in application.properties
```
#JPA configuration  
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver  
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=BookManagement  
spring.datasource.username=sa  
spring.datasource.password=123  
spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl  
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl  
#Server configuration  
server.servlet.context-path=/demo-graphQL  
#GraphQL configuration  
graphql.servlet.enabled=true  
graphql.servlet.mapping=/graphql  
graphql.tools.schema-location-pattern=**/*.graphql
```
####  Step 5: create Entity classes and their Repositories
* Class Author
```
import com.fasterxml.jackson.annotation.JsonManagedReference;  
import lombok.Data;  
import javax.persistence.*;  
import java.io.Serializable;  
import java.util.List;  
  
@Entity  
@Data  
public class Author implements Serializable{  
	@Id  
	private Long id;  
	private String fullname;  
	@JsonManagedReference  
	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)  
	private List<Book> books;  
}
```
*	Class Book
```
import com.fasterxml.jackson.annotation.JsonBackReference;  
import lombok.Data;  
import javax.persistence.*;  
import java.io.Serializable;  
  
@Entity  
@Data  
public class Book implements Serializable {  
	@Id  
	private String isbn;  
	private String title;  
	private Integer edition;  
	private Integer publishedYear;  
	@JsonBackReference  
	@ManyToOne(fetch = FetchType.EAGER)  
	@JoinColumn(name = "authorId", insertable = false, updatable = false)  
	private Author author;  
}
```
* Interface AuthorRepository
```
import com.tientt.graphqldemo.pojo.pojo.entities.Author;  
import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;  
  
@Repository  
public interface AuthorRepository extends JpaRepository<Author, Long> {  
  
}
```
* Interface BookRepository
```
import com.tientt.graphqldemo.pojo.pojo.entities.Book;  
import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;  
  
import java.util.List;  
  
@Repository  
public interface BookRepository extends JpaRepository<Book, String> {  
	List<Book> findAllByAuthor_Id(Long authorID);  
}
```
#### Step 6: create schema.graphql for basic query operation
* [Todo] Add definition for schema.graphql
```
type Author{
    id: Float!
    fullname: String
    books:[Book]
}

type Book{
    isbn: String!
    title: String
    edition: Int
    publishedYear: Int
    author: Author
}

type Query{
    getAllAuthors:[Author]
    getAuthor(authorID: Float):Author
    getAllBooks:[Book]
    getBooksByAuthor(AuthorID: Float!):[Book]
}
```
####  Step 7: create resolver classes for schema type
* Class QueryResolver
```
import com.tientt.graphqldemo.pojo.pojo.entities.Author;  
import com.tientt.graphqldemo.pojo.pojo.entities.Book;  
import com.tientt.graphqldemo.repositories.AuthorRepository;  
import com.tientt.graphqldemo.repositories.BookRepository;  
import graphql.kickstart.tools.GraphQLQueryResolver;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Component;  
import java.util.List;  	
  
@Component  
public class QueryResolver implements GraphQLQueryResolver {  
	@Autowired  
	AuthorRepository authorRepository;  
	@Autowired  
	BookRepository bookRepository; 
	 
	public List<Author> getAllAuthors(){  
	        return authorRepository.findAll();  
	}  
	public Author getAuthor(Long authorID){  
	        return authorRepository.findById(authorID).get();  
	}
	public List<Book> getAllBooks(){  
		return bookRepository.findAll();  
	}  
	public List<Book> getBooksByAuthor(Long authorID){  
	        return bookRepository.findAllByAuthor_Id(authorID);  
	}  
        public Book getBookByIsbn(String isbn){  
	        return bookRepository.findById(isbn).get();  
        }  
}
```
* Class BookResolver
```
import com.tientt.graphqldemo.pojo.pojo.entities.Author;  
import com.tientt.graphqldemo.pojo.pojo.entities.Book;  
import graphql.kickstart.tools.GraphQLResolver;  
  
public class BookResolver implements GraphQLResolver<Book> {  
	Author author(Book book){  
	        return book.getAuthor();  
	}  
}
```
* Class AuthorResolver
```
import com.tientt.graphqldemo.pojo.pojo.entities.Author;  
import com.tientt.graphqldemo.pojo.pojo.entities.Book;  
import com.tientt.graphqldemo.repositories.BookRepository;  
import graphql.kickstart.tools.GraphQLResolver;  
import org.springframework.beans.factory.annotation.Autowired;  
import java.util.List;  
  
public class AuthorResolver implements GraphQLResolver<Author> {  
	@Autowired  
	BookRepository bookRepository;  
	
	public List<Book> books(Author author){  
		return bookRepository.findAllByAuthor_Id(author.getId());  
	}  
}
```
#### Step 8: add mutation type to schema.graphql
```
input AuthorInput{
    id: Float!
    fullname: String
}

type Mutation{
    updateAuthor(author: AuthorInput!):Author
    deleteAuthor(authorId: Float!):Boolean
}
```
#### Step 9: add Data class for AuthorInput and Mutation Resolver
* Class AuthorInput
```
import lombok.Data;  
import lombok.Getter;  
import lombok.NoArgsConstructor;  
import lombok.Setter;  
  
@Data  
public class AuthorInput {  
	private Long id;  
	private String fullname;  
}
```
* Class MutatuonResolver
``` 
import com.tientt.graphqldemo.pojo.AuthorInput;  
import com.tientt.graphqldemo.pojo.pojo.entities.Author;  
import com.tientt.graphqldemo.repositories.AuthorRepository;  
import graphql.kickstart.tools.GraphQLMutationResolver;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Component;  
  
import javax.transaction.Transactional;  

@Component  
@Transactional  
public class MutationResolver implements GraphQLMutationResolver {  
	@Autowired  
	AuthorRepository authorRepository;  
	
	public Author updateAuthor(AuthorInput input){  
	        Author author = new Author();  
		author.setId(input.getId());  
		author.setFullname(input.getFullname());  
		return authorRepository.saveAndFlush(author);  
	}  
  
	public boolean deleteAuthor(Long authorID){  
	        authorRepository.deleteById(authorID);  
		return true;  
	}  
}
```
#### Step 10: Test our GraphQL
* Run our Spring Boot app - check for the context path
```
2020-12-16 09:11:08.261  INFO 2892 --- [ main] o.s.b.w.embedded.tomcat.TomcatWebServer: 
Tomcat started on port(s): 8080 (http) 
with context path '/demo-graphQL'
```
* Open Graphiql to test our GraphQL app
```
http://localhost:8080/demo-graphQL/graphiql
```
* Test these query: [TODO add result image]
```
query{
  getAllBooks{
    isbn
    title
    author{
      fullname
    }
  }
  getAllAuthors{
    id
    fullname
    books{
      title
    }
  }
}
```
```
mutation{
  updateAuthor(author:{
    	id:1
    	fullname: "Paulo Coelho1"}
	){
    id
    fullname
  }
}
```
```
mutation{
  deleteAuthor(authorId:1)   
}
```

<!-- CONTACT -->
## Contact

* Truong Tran Tien 
	* Email: [tientt1938@gmail.com](mailto:tientt1938@gmail.com)
	* Github: https://github.com/TienTruong98
* Ngo Nguyen Bang
	* Email: [bangmapleproject@gmail.com](mailto:bangmapleproject@gmail.com)
	* Github: https://github.com/bangmaple

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/github_username/repo.svg?style=for-the-badge
[contributors-url]: https://github.com/github_username/repo/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/github_username/repo.svg?style=for-the-badge
[forks-url]: https://github.com/github_username/repo/network/members
[stars-shield]: https://img.shields.io/github/stars/github_username/repo.svg?style=for-the-badge
[stars-url]: https://github.com/github_username/repo/stargazers
[issues-shield]: https://img.shields.io/github/issues/github_username/repo.svg?style=for-the-badge
[issues-url]: https://github.com/github_username/repo/issues
[license-shield]: https://img.shields.io/github/license/github_username/repo.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/github_username
