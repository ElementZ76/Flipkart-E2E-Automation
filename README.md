# Flipkart E2E Automation Framework

![Java](https://img.shields.io/badge/Java-21-orange) ![Selenium](https://img.shields.io/badge/Selenium-4.x-green) ![Cucumber](https://img.shields.io/badge/Cucumber-BDD-blue) ![TestNG](https://img.shields.io/badge/TestNG-7.x-red) ![Maven](https://img.shields.io/badge/Build-Maven-yellow)

## Overview
This is a robust **End-to-End (E2E) Test Automation Framework** designed to automate the Flipkart e-commerce application. 

The framework is built using **Java** and **Selenium WebDriver**, integrated with **Cucumber BDD** to support Gherkin syntax for behavior-driven testing. It leverages the **Page Object Model (POM)** design pattern to ensure code reusability, maintainability, and readability.

## Key Features
* **Page Object Model (POM):** Strict separation of Page Objects (Locators/Actions) and Test Scripts (Step Definitions) using `PageFactory`.
* **Robust Synchronization:** Implemented custom **"Safe Action Wrappers"** to handle **`StaleElementReferenceException`** and dynamic DOM updates (React/AJAX) automatically.
* **Window & Tab Management:** Intelligent handling of multi-window workflows (switching between Parent Search page and Child Product tabs).
* **Behavior Driven Development (BDD):** Feature files written in plain English (Gherkin) to bridge the gap between QA and Business requirements.
* **Hybrid Configuration:** Driven by `config.properties` for easy environment switching (URL, Browser, Timeouts).
* **Application Hooks:** Automated Browser Setup and Teardown managed via Cucumber Hooks.

## Tech Stack
| Component | Tool / Library |
| :--- | :--- |
| **Language** | Java (JDK 22) |
| **Web Automation** | Selenium WebDriver |
| **BDD Framework** | Cucumber (Gherkin) |
| **Test Runner** | TestNG |
| **Build Tool** | Maven |
| **Design Pattern** | Page Object Model (POM) with PageFactory |
| **Assertions** | TestNG Assertions |


## Prerequisites
* **Eclipse IDE:** [Download Eclipse for Java Developers](https://www.eclipse.org/downloads/packages/)
* **Java (JDK):** Ensure JDK is installed and configured in your system path.
* **Git:** [Download Git](https://www.google.com/search?q=https://git-scm.com/downloads)
* **TestNG Suite:** Ensure TestNG is configured on Eclipse. Refer to Troubleshooting for TestNG installation instructions.


## How to run locally
1. Clone the repository:
`git clone [https://github.com/ElementZ76/Flipkart-E2E-Automation.git]`

2. Import into Eclipse
1. Open Eclipse.
2. Go to **File** > **Import...**
3. Expand the **Maven** folder and select **Existing Maven Projects**.
4. Click **Next**.
5. Click **Browse** and select the **root folder** of the project you just cloned (the folder containing the `pom.xml` file).
6. Ensure the `pom.xml` checkbox is ticked.
7. Click **Finish**.

*Note: Wait for the progress bar at the bottom right (Building Workspace) to finish. Eclipse is downloading dependencies.*


3. Run vis TestNG
1. In the **Project Explorer**, locate the `TestRunner.java` file (`src/test/java/com.flipkart.runners`).
2. Right-click `TestRunner.java`.
3. Select **Run As** > **TestNG Test**. (refer to Troubleshooting if you cannot find the TestNG option)


## Troubleshooting

### Red Exclamation Mark on Project
* Right-click the project > **Maven** > **Update Project...**
* Check **Force Update of Snapshots/Releases**.
* Click **OK**.

### Cannot see "TestNG Test" under "Run As" in TestRunner file:
*  Download "TestNG for Eclipse" from Eclipse Marketplace. (Help > Eclipse Marketplace > Search for "TestNG" and download)
*  After downloading, force update the project.
*  Right click on Wikipedia-Automation > Maven > Update Project > Select "Force update of Snapshots/Releases" > Click OK.


## Project Structure
```text
src/test/java
├── com.flipkart.base        # Base Class (Driver Init, Safe Wrappers, Config Loader)
├── com.flipkart.pages       # Page Object Classes (HomePage, ProductPage, CartPage)
├── com.flipkart.runners     # TestNG Test Runner Class
├── com.flipkart.steps       # Cucumber Step Definitions & Hooks
src/test/resources
├── features                 # Gherkin Feature Files (.feature)
├── config.properties        # Global Configuration (Browser, URL, Wait Times)
