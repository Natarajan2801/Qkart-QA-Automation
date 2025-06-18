# 🛒 QKart Shopping Interface - Products Page Automation

Welcome to the **QKart Shopping Interface - Products Page Automation** project!  
This repository demonstrates a robust, scalable, and data-driven Selenium automation framework built for testing the Products page of the QKart shopping web application.

---

## 🔍 Project Overview

This framework is designed to ensure the quality and functionality of the **QKart Products Page** using modern automation best practices. It follows the **Page Object Model (POM)** design pattern, and leverages **TestNG** for test configuration, grouping, prioritization, and parameterization.

---

## 🧰 Tech Stack & Tools

| Technology | Purpose |
|------------|---------|
| **Java** | Core programming language |
| **Selenium WebDriver** | Web automation tool |
| **TestNG** | Testing framework for grouping, ordering, and parameterizing tests |
| **Gradle** | Build automation and dependency management |
---

## 🧪 Framework Features

- ✅ **Data-Driven Testing**  
  Enables flexible and scalable test case execution using external test data.

- 🧱 **Page Object Model (POM) Pattern**  
  Organizes code efficiently, separating UI locators and actions from test logic.

- 📷 **Automatic Screenshot Capture**  
  Screenshots are taken automatically for both passed and failed test cases for better traceability.

- ⏱️ **Smart Waits**  
  Enhances reliability with correctly used **implicit** and **explicit waits**, reducing flakiness.

- 🧪 **TestNG Integration**  
  Enables powerful test execution capabilities such as:
  - Grouping tests
  - Prioritizing test cases
  - Parameterizing test data

---

## 📁 Project Structure

```plaintext
QKart_Automation_Framework/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/            # Page Object Model classes
│   └── test/
│       └── java/
│           └── tests/            # TestNG test cases
│
├── testdata/                     # External test data files
├── screenshots/                  # Auto-captured screenshots (on test pass/fail)
├── test-output/                  # TestNG output reports
├── build.gradle                  # Gradle configuration file
└── testng.xml                    # Test suite configuration
