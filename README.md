# Java Banking System — Thread Synchronization

A simple console-based banking application developed in Java to demonstrate **multithreading and thread synchronization** using the `Runnable` interface, `Thread` class, and `synchronized` methods.

## 📌 Project Overview

This project simulates basic banking operations such as depositing and withdrawing money from a shared bank account.

The application uses separate threads for deposit and withdrawal operations. Since multiple threads can access the same bank account, synchronization is implemented to prevent concurrent modification of the shared account balance.

## ✨ Features

- **Account Initialization:** Create a bank account with or without an initial balance.
- **Deposit:** Add money to the account using a separate thread.
- **Withdrawal:** Withdraw money from the account using a separate thread.
- **Multithreading:** Execute banking operations using independent threads.
- **Thread Synchronization:** Protect the shared account balance using Java's `synchronized` keyword.
- **Custom Exception Handling:** Handle invalid menu options using a custom checked exception.

## 🛠️ Technologies Used

- Java
- Java Multithreading
- Runnable Interface
- Thread Class
- Synchronization
- Exception Handling

## 📂 Project Structure

```text
Java-Banking-System/
│
├── bank_system.java
└── README.md
```

## ⚙️ How It Works

### 1. BANK_ACCOUNT Class

The `BANK_ACCOUNT` class represents the user's bank account.

It contains:
- `username` – Stores the account holder's name.
- `BANK_AMOUNT` – Stores the current account balance.
- `DEPOSITE()` – Performs deposit operations.
- `WITHDRAW()` – Performs withdrawal operations.

Both transaction methods are declared using the `synchronized` keyword.

### 2. Runnable Interface

Two separate classes implement the `Runnable` interface:

- `DepositeThread` – Executes deposit operations.
- `WithDrawThread` – Executes withdrawal operations.

Both classes receive a reference to the same `BANK_ACCOUNT` object.

### 3. Thread Creation

The application creates separate threads using the `Thread` class.

The `start()` method initiates independent thread execution.

### 4. Thread Synchronization

Both `DEPOSITE()` and `WITHDRAW()` are synchronized instance methods.

Since both methods operate on the same account object, they share the same intrinsic lock (monitor).

This ensures that only one thread at a time can execute either synchronized method on that account object.

## 🚀 How to Run

### Prerequisites

- Java Development Kit (JDK) installed.
- A Java-supported IDE or terminal.

### Compilation

Open a terminal in the project directory and execute:

```bash
javac bank_system.java
```

### Execution

```bash
java bank_system
```

## 💻 Application Workflow

1. Enter the account holder's name.
2. Choose whether the account has an existing balance.
3. Enter the initial balance if applicable.
4. Select a banking operation:
   - `D` – Deposit
   - `W` – Withdraw
5. Enter the transaction amount.
6. Choose whether to continue with another transaction.

## 🧠 Concepts Demonstrated

| Concept | Purpose |
|---|---|
| Runnable Interface | Defines independent transaction tasks |
| Thread Class | Executes tasks in separate threads |
| `start()` | Initiates thread execution |
| `synchronized` | Controls access to shared account data |
| Intrinsic Lock | Provides mutual exclusion |
| Custom Exception | Handles invalid menu options |

## ⚠️ Current Limitations

- Account balance is stored in memory and is not persistent.
- Transaction history is not stored in a file or database.
- Input validation for transaction amounts can be improved.
- The application currently uses a console-based interface.
- Transaction execution order is not guaranteed by the thread scheduler.

## 🎯 Project Objective

The primary objective of this project is to understand how Java multithreading works and how synchronization helps maintain data consistency when multiple threads access a shared resource.

---

**Developed as a Java OOPs practical project to demonstrate Thread Synchronization.**