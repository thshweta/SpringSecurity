# 🔐 Spring Security Practice Project

This is a small hands-on project created to **understand the internal workings of Spring Security** — beyond just the defaults.  
The goal was to **learn by doing**, experimenting with custom configurations and setups rather than relying on auto-magic behavior.

---

## 💡 Features Implemented

✅ Custom Login Flow  
✅ CSRF Token Handling  
✅ Custom Security Configuration Class  
✅ User Verification from MySQL Database  
✅ Bcrypt Password Hashing for Secure Storage  
✅ **JWT Token Generation & Validation** for stateless authentication  

This project isn't meant for production — it's more of a **learning playground** where I could tinker and see how things actually work under the hood.

---

## 🛠 Tech Stack

- Java 21  
- Spring Boot 3.5.3  
- Spring Web  
- Spring Data JPA  
- Spring Security  
- **JWT (JSON Web Token)**  
- MySQL  
- IntelliJ IDEA  

---

## 🧠 What I Learned

Initially, getting into Spring Security was honestly a bit overwhelming — with filters, encoders, CSRF tokens, and custom configurations flying around.  
But with time, practice, and experimentation, things started connecting — and it all began to make much more sense.  
It’s been a **very rewarding experience** to get the basics working myself and gain clarity on what happens behind the scenes.  

Implementing JWT added a whole new layer of understanding — especially around stateless authentication, filters, and secure token handling.

---

## 📂 Project Structure


```
src/
└── main/
    └── java/
        └── com/example/SpringSecurity/
            ├── Configurations/
            │   ├── JwtFilter.java
            │   └── SecurityConfig.java
            ├── Controller/
            │   ├── HelloController.java
            │   ├── StudentController.java
            │   └── UserController.java
            ├── Model/
            │   ├── Student.java
            │   ├── UserPrincipal.java
            │   └── Users.java
            ├── Repository/
            │   └── UserRepo.java
            ├── Service/
            │   ├── JWTService.java
            │   ├── MyUserDetailService.java
            │   └── UserService.java
            └── SpringSecurityApplication.java

```

---

## 🙏 Acknowledgment

Big thanks to **Navin Reddy Sir** — whose clear explanations and practical teaching style made learning Spring Security approachable and effective.
