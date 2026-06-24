ATM Simulator & OOP Validation Project
This is an ATM Simulator written in Java, following clean Object-Oriented Programming (OOP) principles. The primary goal of this project is to demonstrate SDET (Software Development Engineer in Test) and software development best practices, with a strong focus on layered architecture, business logic isolation, and rigorous unit testing (JUnit 5).

🏗️ Architecture and Design (SRP & Abstraction)
The project breaks away from a monolithic structure and is divided into distinct components following the Single Responsibility Principle (SRP):

Main: Handles the user interface (console interaction) and basic process flow control.

LoginValidator: Performs technical pre-screening of input data (Null and Empty checks) and enforces ATM-specific formatting rules.

UserDatabase: The data abstraction layer that dynamically handles the storage (cards.csv), verifies credentials, and completely hides file operations from upper layers.

LoginSession: A stateful class containing business logic to count failed attempts and handle security card blocking.

🔒 ATM Business Rules
Authentication: Login is processed using a card number and a PIN code (instead of a traditional username/password pair).

PIN Validation: For security reasons, the system only passes PIN codes that consist of exactly 4 digits to the database.

Security Lockout: After 3 consecutive failed attempts, the LoginSession blocks access for security reasons (the ATM swallows the card).

📊 Database Format (cards.csv)
Authentication data is stored in a comma-separated CSV file located at the root of the project:

Code snippet
12345678,4321
87654321,1111

🧪 Testing Strategy (JUnit 5)
The robustness of the project is guaranteed by an extensive unit test suite covering all business logic:

Data-Driven Testing: The LoginValidatorTest utilizes an external test data file (invalid_pins.csv) to perform Boundary Value Analysis and Equivalence Partitioning on malformed PIN formats (e.g., too short, too long, or containing alphabetic characters).

Isolated Unit Tests: Separate test classes safeguard the internal logic of the session manager (LoginSessionTest) and the file reader (UserDatabaseTest), ensuring fast and reliable feedback.