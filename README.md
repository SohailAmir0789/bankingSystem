# 🏧 ATM Simulation System

A console-based ATM simulation system developed in Java using core Object-Oriented Programming (OOP) concepts. This project allows users to securely log in with account credentials and perform typical banking operations such as balance inquiry, deposit, and withdrawal.

---

## 🚀 Features

- User login with **account number** and **PIN**
- Multiple user support using `HashMap`
- Secure authentication logic
- Menu-driven interface for:
  - Balance Inquiry
  - Cash Deposit
  - Cash Withdrawal
  - Exit
- Input validation and basic error handling
- Realistic simulation of ATM system flow

---

## 🧠 OOP Concepts Used

| Concept         | How it's applied                                                                 |
|----------------|-----------------------------------------------------------------------------------|
| **Encapsulation** | User data (PIN, balance) is private and accessed through public methods         |
| **Abstraction**   | Interface `AccountOperations` can be used to abstract account-related methods   |
| **Polymorphism**  | Methods like `withdraw()` can be overridden or varied for account types         |
|
