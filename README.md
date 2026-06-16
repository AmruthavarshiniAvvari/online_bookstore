# 📚 Online Bookstore Management System

A full-stack Bookstore Management System developed using Spring Boot, Thymeleaf, MySQL, Spring Data JPA, and Spring Security.

The application allows users to browse books, search books, manage a shopping cart, and provides role-based access for administrators to manage the bookstore inventory.

---

## 🚀 Features

### User Features
- User Registration
- User Login & Logout
- Browse Available Books
- Search Books by Keyword
- Add Books to Cart
- View Shopping Cart
- Responsive User Interface

### Admin Features
- Secure Admin Login
- Add New Books
- Edit Existing Books
- Delete Books
- View Dashboard
- Total Books Statistics
- Total Stock Statistics

### Security Features
- Spring Security Authentication
- Role-Based Authorization
- Admin/User Access Control
- Protected URLs

---

## 🛠️ Technologies Used

### Backend
- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security

### Frontend
- Thymeleaf
- HTML5
- CSS3
- Bootstrap 5

### Database
- MySQL

### Build Tool
- Maven

---

## 📂 Project Structure

```
src
│
├── controller
├── service
├── repository
├── model
├── config
│
├── templates
│   ├── index.html
│   ├── login.html
│   ├── register.html
│   ├── books.html
│   ├── addBook.html
│   ├── editBook.html
│   ├── cart.html
│   └── dashboard.html
│
└── static
    └── css
        └── style.css
```

---

## 📊 Database Tables

### Users
| Column | Type |
|----------|---------|
| id | Long |
| name | String |
| email | String |
| password | String |
| role | String |

### Books
| Column | Type |
|----------|---------|
| id | Long |
| title | String |
| author | String |
| category | String |
| price | Double |
| stock | Integer |

### Cart
| Column | Type |
|----------|---------|
| id | Long |
| bookTitle | String |
| price | Double |
| quantity | Integer |

---

## ⚙️ Setup Instructions

### 1. Clone Repository

```bash
git clone https://github.com/AmruthavarshiniAvvari/online-bookstore.git
```

### 2. Configure MySQL

Create a database:

```sql
CREATE DATABASE online_bookstore;
```

### 3. Update application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/online_bookstore
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Run Application

```bash
mvn spring-boot:run
```

### 5. Open Browser

```
http://localhost:8080
```

### 6. For admin login , use 

```
Email: ammu@gmail.com 
password: 3805
```

---


## 🎥 Project Demo

Watch the complete project demonstration here:

🔗 [Demo Video](https://www.linkedin.com/posts/amrutha-varshini-avvari-a081202b7_java-springboot-fullstackdevelopment-activity-7472526476010258432-QscY?utm_source=share&utm_medium=member_desktop&rcm=ACoAAEwDo6gBo_TvIBkwcc6IUn2O0D_6-UjtuB4)

---


## 🎯 Learning Outcomes

This project helped in understanding:

- Spring Boot Architecture
- MVC Design Pattern
- Spring Security Authentication & Authorization
- Database Integration using JPA
- Thymeleaf Template Engine
- CRUD Operations
- Role-Based Access Control
- Full Stack Java Development

---


## 👩‍💻 Author

**Amrutha varshini Avvari**


---

## ⭐ If you like this project, give it a star on GitHub!
