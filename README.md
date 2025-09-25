# 📚 Library Management System (Java)
## Task 3 Library Management System (Using OOP)
A simple yet powerful Library Management System built in Java using Object-Oriented Programming (OOP) concepts. This project demonstrates Association, Aggregation, and Composition relationships between classes.

---
✨ Features
---
- 📖 Book Management: Add books with ISBN, title, and author

- 👥 Member Management: Register members with contact details

- 🔄 Book Issuing: Issue books to members with borrowing limits

- 📅 Book Returning: Track return dates and update availability

- 🔒 Encapsulation: Secure data with private fields and controlled access

- 🧩 OOP Design: Strong class relationships (Aggregation/Composition)

---
🏗️ Classes & Relationships
---
1. Book Class
```
public class Book {
    private final String ISBN;     // Unique ID [International Standard Book Number] (Immutable)
    private final String title;    // Book name  (Immutable)
    private final Author author;   // Association: Book HAS-A Author (Immutable)
    private boolean isAvailable;   // Availability status  
}
```
Relationship:

✅ Aggregation with Author (Author exists independently)

Method Used:

- isAvailable() → Check if book can be issued

- setAvailable() → Update availability (protected)

2. Author Class
```
   public class Author {
    private final String name;    // Immutable author name  
    private String email;         // Contact info  
}
```
Relationship:

✅ Association with Book (Multiple books per author)

Method Used:

- toString() → Prints name + email (e.g., J.K. Rowling <jk@example.com>)

3. Member class
```
  public class Member {
    private final String memberID;           // Unique ID  
    private final String name;               // Member name  
    private String email;                    //Member email
    private String contactNumber;            //Member contact      
    private List<BorrowingRecord> history;   // Aggregation: Member HAS-A records  
}
```
Relationships:

✅ Aggregation with BorrowingRecord (Records exist independently)

Method Used:
- canBorrowMoreBooks() → Check borrowing limit (max 5 books)
- addBorrowingRecord() → Add a new borrowing record


---Inner Class: BorrowingRecord---
```
public static class BorrowingRecord {
    private final Book book;       // Book borrowed  
    private LocalDate borrowDate;  // Issue date  
    private LocalDate returnDate;  // Return date (null if not returned)  
}
```
Relationship:

✅ Composition with Member (Records are part of Member’s lifecycle)

4. Library Class
```
public class Library {
    private final String libraryName;  // Library name  
    private List<Book> books;          // Aggregation: Library HAS-A Books  
    private List<Member> members;      // Aggregation: Library HAS-A Members  
}
```
Relationships:
✅ Aggregation with Book/Member (Both exist independently)

Method Used:

- addBook() → Add a new book

- registerMember() → Register a new member

- issueBook() → Issue a book to a member

- returnBook() → Return a book and update records

📤 issueBook() workflow:
```
  A[Find Member] --> B{Member Valid?}
  B -->|Yes| C[Find Book]
  C --> D{Book Available?}
  D -->|Yes| E[Create Record]
  E --> F[Update Status]
```
📤 returnBook() workflow:
```
  A[Find Record] --> B{Active Loan?}
  B -->|Yes| C[Set Return Date]
  C --> D[Mark Book Available]
```

---
⚙️ How to Run
---
1. Compile all classes:
```
javac -d . *.java
```
2. Run tests:
```
java task3_LibraryManagementSystem.Library
```
3. Sample output:
```
=== ISSUING BOOK ===
Book issued successfully to Rohan Kumar for Clean Code: A Handbook of Agile Software Craftsmanship
Issued? true
Book available? false

=== ISSUING BOOK ===
Book issued successfully to Rohan Kumar for Spring in Action
Issued? true
Book available? false

=== RETURNING BOOK ===
Book returned successfully by Rohan Kumar for Clean Code: A Handbook of Agile Software Craftsmanship on 2025-09-26
Returned? true
Book available now? true

=== FAIL CASE ===
Book not found999
Failed return? false
Member's borrowing history size: 2
Record: Clean Code: A Handbook of Agile Software Craftsmanship borrowed on 2025-09-26, returned on 2025-09-26
Record: Spring in Action borrowed on 2025-09-26, returned on null
```
---
🚀 Key OOP Concepts Applied
---
Concept	   ⬇️     |           Where Used   ⬇️           |  	Why Important?  ⬇️ 

Encapsulation	  |  All classes (private fields)   |  Prevents data corruption

Composition	    |  BorrowingRecord in Member	    |  Records die with Member

Aggregation     |	 Books/Members in Library	      |  Books exist without Library

Association	    |  Book → Author	                |  Loose coupling

---
🌐 Project Structure:
---
task3_LibraryManagementSystem/  
├── Book.java          # Core entity  
├── Author.java        # Book's author  
├── Member.java        # With borrowing history  
├── Library.java       # System engine  
└── README.md          # THIS FILE! 🎉

---
🛠️ Technologies Used
---
☕ Java 11+

⚙️ OOP Concepts: Encapsulation, Inheritance, Polymorphism

📚 Design Patterns: Aggregation, Composition, Association

---
