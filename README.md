# SDET Learning: Java Input Validation & OOP Architecture

This repository demonstrates my journey of learning Java, Clean Code principles, and Unit Testing from scratch, specifically tailored for an **SDET (Software Development Engineer in Test)** career path.

## 📈 The Evolution of the Project
Instead of just writing a final solution, this project was built incrementally to simulate real-world software refactoring:
1. **Phase 1 (Procedural):** A simple, hardcoded `if-else` login logic using `Scanner`.
2. **Phase 2 (Edge Cases):** Handling empty inputs and case-insensitivity (`equalsIgnoreCase`).
3. **Phase 3 (Control Flow):** Introducing a `for` loop to limit the user to maximum 3 login attempts.
4. **Phase 4 (OOP & Clean Architecture):** Separating the responsibilities into three distinct layers:
    - `Main` (UI / Console layer)
    - `LoginValidator` (Business logic layer)
    - `UserDatabase` (Data layer)
5. **Phase 5 (Testing):** Covering the core business logic with automated **JUnit 5** Unit Tests.

## 🛠️ Tech Stack
- **Language:** Java
- **Testing Framework:** JUnit 5
- **Version Control:** Git & GitHub

## 🧪 Automated Tests
The core validation logic is strictly tested to ensure reliability. More edge cases are being added continuously to achieve high test coverage.