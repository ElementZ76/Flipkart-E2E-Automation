# 🛒 Flipkart E2E Automation Framework

![Java](https://img.shields.io/badge/Java-21-orange) ![Selenium](https://img.shields.io/badge/Selenium-4.x-green) ![Cucumber](https://img.shields.io/badge/Cucumber-BDD-blue) ![TestNG](https://img.shields.io/badge/TestNG-7.x-red) ![Maven](https://img.shields.io/badge/Build-Maven-yellow)

## 📄 Overview
This is a robust **End-to-End (E2E) Test Automation Framework** designed to automate critical business flows of the Flipkart e-commerce application. 

The framework is built using **Java** and **Selenium WebDriver**, integrated with **Cucumber BDD** to support Gherkin syntax for behavior-driven testing. It leverages the **Page Object Model (POM)** design pattern to ensure code reusability, maintainability, and readability.

## 🚀 Key Features
* **Page Object Model (POM):** Strict separation of Page Objects (Locators/Actions) and Test Scripts (Step Definitions) using `PageFactory`.
* **Robust Synchronization:** Implemented custom **"Safe Action Wrappers"** to handle **`StaleElementReferenceException`** and dynamic DOM updates (React/AJAX) automatically.
* **Window & Tab Management:** Intelligent handling of multi-window workflows (switching between Parent Search page and Child Product tabs).
* **Behavior Driven Development (BDD):** Feature files written in plain English (Gherkin) to bridge the gap between QA and Business requirements.
* **Hybrid Configuration:** Driven by `config.properties` for easy environment switching (URL, Browser, Timeouts).
* **Application Hooks:** Automated Browser Setup and Teardown managed via Cucumber Hooks.

## 🛠️ Tech Stack
| Component | Tool / Library |
| :--- | :--- |
| **Language** | Java (JDK 22) |
| **Web Automation** | Selenium WebDriver |
| **BDD Framework** | Cucumber (Gherkin) |
| **Test Runner** | TestNG |
| **Build Tool** | Maven |
| **Design Pattern** | Page Object Model (POM) with PageFactory |
| **Assertions** | TestNG Assertions |

## 📂 Project Structure
```text
src/test/java
├── com.flipkart.base        # Base Class (Driver Init, Safe Wrappers, Config Loader)
├── com.flipkart.pages       # Page Object Classes (HomePage, ProductPage, CartPage)
├── com.flipkart.runners     # TestNG Test Runner Class
├── com.flipkart.steps       # Cucumber Step Definitions & Hooks
src/test/resources
├── features                 # Gherkin Feature Files (.feature)
├── config.properties        # Global Configuration (Browser, URL, Wait Times)