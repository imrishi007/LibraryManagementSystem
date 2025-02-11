# 📚 Library Management System  

_A Java-based system that allows users to manage a digital library efficiently._  

## **📌 What Does This Project Do?**  
This Library Management System is designed to help **admins** manage books and users while allowing **normal users** to borrow and return books. It is built using **Java** and follows **Object-Oriented Programming (OOP)** principles.

---

## **🚀 Functionalities**  

### 🔹 **Admin Privileges**  
✅ **Manage Books** – Add, remove, update, and search books.  
✅ **Manage Users** – Add new users (admins or normal users) and remove users.  
✅ **Full Access** – Admins can also borrow/return books like normal users.  

### 🔹 **Library Features**  
✅ **Book Inventory** – Keeps track of available book copies.  
✅ **Borrowing System** – Users can borrow multiple copies of the same book.  
✅ **Returning System** – Users can return books in specific quantities.  
✅ **Search Books** – Find books by **name, author, or ID**.  

---

## **🛠️ Project Files & Structure**  

### 📂 **Java Files & Their Purpose**  

```sh
📂 LibraryManagementSystem
 ├── 📜 Books.java          # Stores book details (title, author, quantity)
 ├── 📜 Library.java        # Manages book inventory & operations
 ├── 📜 User.java           # Handles user data and borrowing system
 ├── 📜 UserManager.java    # Manages user accounts & authentication
 ├── 📜 LibrarySystem.java  # Main file to run the program
 ├── 📜 README.md           # Project Documentation
```
## **🔹 Explanation of Each Java File ** 
### **📜 Books.java**  
-- Represents individual books in the library.  
-- Tracks book name, author, total & available quantity.  
-- Handles borrowing and returning of books.  

### **📜 Library.java** 
-- Stores all books using a HashMap (Book ID → Book Object).  
-- Allows admins to add, remove, update, and search books.  
-- Manages book availability when borrowed/returned.  

### **📜 User.java**
-- Represents users (both normal users & admins).  
-- Stores user details (username, password, email).  
-- Allows users to borrow multiple copies & return books.  

### **📜 UserManager.java**
-- Manages user accounts.  
-- Handles registration & login authentication.  
-- Allows admins to add/remove users.  

### **📜 LibrarySystem.java**
-- The main file that runs the system.  
-- Provides a command-line menu for users & admins.  
-- Calls different functionalities from Library.java & UserManager.java.  