# Brainy-Bite
![Animation2](https://github.com/user-attachments/assets/6d025c9a-9603-4f47-afcf-ec6061753c28)

Brainy-Bite is a simple web application for reading and managing articles. It features a backend REST API built with **Java Spring Boot** and a frontend interface utilizing **HTML, Vanilla JavaScript, and Tailwind CSS**, all integrated into a single project.

## Features

* **Home View:** Displays a grid of the latest articles.
* **Category Filter:** Easily browse articles by categories such as Technology, Science, and Lifestyle.
* **Article Detail:** Click on any article to read its full content.
* **RESTful API:** A fully functional backend supporting CRUD operations:
    * Fetch all articles or filter by ID / Category.
    * Create new articles.
    * Delete existing articles.

## Tech Stack

**Backend:**
* Java 17
* Spring Boot 3.5.11
* Spring Web (REST API)
* Spring JDBC (Database access)
* MySQL Connector

**Frontend:**
* HTML5
* Vanilla JavaScript (Fetch API)
* Tailwind CSS (via CDN)

## Database Setup

This project uses **MySQL** as its primary database and utilizes `JdbcTemplate` for queries.

1. Create a new database in MySQL named `brainy_bite`:
   ```sql
   CREATE DATABASE brainy_bite;
   ```
2. Create the article table to store data:
    ```sql
    USE brainy_bite;

    CREATE TABLE article (
        id INT AUTO_INCREMENT PRIMARY KEY,
        category VARCHAR(100),
        title VARCHAR(255),
        description TEXT,
        content LONGTEXT,
        thumbnail_url VARCHAR(500),
        published DATE
    );
    ```
3. Verify and update the database credentials in your <kbd>src/main/resources/application.properties</kbd> file:
    ```Properties
    spring.datasource.url=jdbc:mysql://localhost:3306/brainy_bite
    spring.datasource.username=root
    spring.datasource.password=486948
    ```
*(Note: Change the username and password to match your local MySQL setup.)*

## How to Run
1. Open your terminal or command prompt in the project's root directory.
2. Run the following Maven command to start the Spring Boot application:
    ```Bash
    ./mvnw spring-boot:run
    ```
*(For Windows users, <kbd>run mvnw.cmd spring-boot:run</kbd>)*

3. Open your web browser and navigate to: http://localhost:8080 to view the application.

# API Endpoints

|Method|Endpoint|Description|
|:-------------------------|:----------------------:|:-----------------------:|
| GET             | /api/articles      | Retrieve a list of all articles                     |
| GET           | /api/article/{id}            | Retrieve a specific article by its ID        |
| GET          | /api/article/category/{category}                     | Retrieve articles filtered by category (e.g., technology)             |
| POST     | /api/articles                     | Create a new article             |
| DELETE     | /api/article/{id}                    | Delete an article by its ID             |

## Project Structure Overview
* src/main/java/com/thara/brainybite/controller/: API Request handlers (ArticleController) *

* src/main/java/com/thara/brainybite/model/: Data models (Article) *

* src/main/java/com/thara/brainybite/repository/: JDBC database access logic (JdbcArticleRepository) *

* src/main/resources/static/: Frontend web files (index.html) *
