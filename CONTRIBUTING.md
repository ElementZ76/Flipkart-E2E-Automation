# Contributing to Wikipedia Automation

Thank you for your interest in contributing to the **Flipkart-E2E automation** project! We welcome contributions that add new test scenarios, improve existing code, or fix bugs.

## 🚀 Getting Started

1. **Fork the Repository**: Click the "Fork" button at the top right of this page to create your own copy of the repository.
2. **Clone Your Fork**:
```bash
git clone https://github.com/YOUR-USERNAME/Flipkart-E2E-Automation.git

```


3. **Open in Eclipse**: Import the project as a **Maven Project** in Eclipse.
4. **Install Dependencies**: Let Maven download the required libraries (Selenium, TestNG, Cucumber, etc.).

## 🛠 Development Workflow

1. **Create a New Branch**:
Always work on a new branch for your specific feature or fix. Do not push directly to `main`.
```bash
git checkout -b feature/your-feature-name
# OR
git checkout -b fix/issue-you-are-fixing

```


2. **Add Your Test Scenarios**:
* **Feature Files**: Add new `.feature` files in `src/test/resources`.
* **Step Definitions**: Write the corresponding Java logic in `src/test/java`.
* **Page Objects**: If you are adding new pages, ensure you follow the Page Object Model (POM) design pattern.


3. **Run Tests Locally**:
Before committing, ensure all tests pass.



## 📝 Coding Guidelines

To keep the codebase clean and maintainable, please adhere to the following rules:

### General

* **Language**: Java (JDK 8 or higher).
* **Naming Conventions**: Use `camelCase` for variables/methods and `PascalCase` for classes.
* **Comments**: Add comments for complex logic, but aim for self-explanatory code.

### Automation Specifics

* **Assertions**: Always use **TestNG assertions** (`Assert.assertEquals`, `Assert.assertTrue`) to validate test results. Do not rely on `System.out.println` for verification.
* **Waits**: Avoid using `Thread.sleep()`. Use **Explicit Waits** (`WebDriverWait`) or Fluent Waits whenever possible.
* **Locators**: Prioritize stable locators (ID, Name, CSS Selector) over absolute XPaths.
* **Gherkin Syntax**: Keep your Feature file scenarios readable and business-oriented (Given/When/Then).

## 📮 Submitting a Pull Request (PR)

1. **Push to GitHub**:
```bash
git push origin feature/your-feature-name

```


2. **Open a PR**: Go to the original repository and click **"Compare & pull request"**.
3. **Describe Your Changes**: Provide a clear title and description of what you added or fixed.
* *Example: "Added test scenarios for Wikipedia Search functionality"*


4. **Review**: Wait for a maintainer to review your code. Be open to feedback!

## 🐛 Reporting Issues

If you find a bug or have a suggestion, please open an **Issue** with the following details:

* **Description**: What is the issue?
* **Steps to Reproduce**: How can we see the error?
* **Expected Behavior**: What should happen?
* **Screenshots/Logs**: (Optional) Attach any relevant error logs or screenshots.

---

Happy Coding! 