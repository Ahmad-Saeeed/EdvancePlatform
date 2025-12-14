# EdvancePlatform
A Test Automation project for the **Edvance** platform  

![Java](https://img.shields.io/badge/Java-11+-blue.svg)
![Maven](https://img.shields.io/badge/Maven-3+-orange.svg)
![TestNG](https://img.shields.io/badge/TestNG-7+-green.svg)
![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-CI%2FCD-lightgrey.svg)

---

## 👥 Participants

**Participating students on this mega project are:**
- Doaa Mahmoud  
- Mayar Magdy  
- Taymourlank Farawilla  
- Ahmed Azam  
- Ahmed Saeed  

> **Note:** Participating students have the full rights to share this project on any platform they prefer to showcase their work.

---

## 🔗 Important Links

- **GitHub:** [EdvancePlatform](https://github.com/Ahmad-Saeeed/EdvancePlatform)  
- **Presentation:** [Canva Link](https://www.canva.com/design/DAG7B3HgPIM/kL9uvsEVZLCsMwuco25evA/edit)  
- **API Documentation:** [Postman Link](https://documenter.getpostman.com/view/37731054/2sB3dLVCTz)  
- **Final Deliverables:** [Google Drive](https://drive.google.com/drive/folders/1-CDgmwAXnDLO12exUgpZhQwKSEhEVbY3?usp=drive_link)  

---

# Edvance Test Automation Suite

This repository contains a **TestNG-based automation framework** for validating the Edvance platform across multiple user roles (Admin, Teacher, Student, Company, University Student, Parent).  
It integrates **cross-browser testing**, **data-driven testing**, and the **Page Object Model (POM)** for scalability and maintainability.  
It also leverages **GitHub Actions** for continuous integration and automated test execution.

---

## 📂 Project Structure

```
src/
 ├── main/java
 │    ├── Engine/                  # Bot engine for WebDriver interactions
 │    ├── Utilities/               # ConfigReader and helpers
 │    ├── Pages/                   # Page Object classes (Login, Dashboard, SignUp, Profile)
 │    └── DataProviders/Excel      # ExcelUtilsData
 │
 ├── main/resources
 │    └── Properties               # Configuration for browser & credentials (Admin, Teacher, Student, Company, University Student)
 │
 ├── test/java
 │    ├── ExcelTest/               # ExcelDataProvider
 │    ├── PagesTests/              # Test classes for Admin, Teacher, Student, Company, University
 │    ├── APITests/                # API test classes
 │    └── CrossBrowsingExecution/  # CrossBrowserBaseTest
 │
 └── test/resources
      └── LoginSheet.xlsx          # Excel data provider file
```

---

## ⚙️ Setup

### Prerequisites
- Java 11+  
- Maven 3+  
- TestNG  
- Chrome & Edge browsers installed  
- WebDriver binaries available in PATH or managed by WebDriverManager  

### Configuration
- **Browser selection:**  
  Defined in `browser.properties` → `browser.type=chrome` or `edge`.  
- **User credentials:**  
  Stored in `usertype.properties` (e.g., `teacher.properties`).  
- **Excel credentials:**  
  Stored in `LoginSheet.xlsx` under multiple sheets (Admin, Teachers, Companies, Parents, UniversityStudents, Students).  

---

## ▶️ Running Tests

### Run all tests
```bash
mvn test
```

### Run specific test class
```bash
mvn test -Dtest=PagesTests.AdminLoginTest
```

### Run cross-browser suite
```bash
mvn test -DsuiteXmlFile=src/test/resources/testing-cros-browser.xml
```

---

## ⚡ GitHub Actions CI/CD

This project uses **GitHub Actions** to automate:
- **Builds** → Compiles the project with Maven.  
- **Tests** → Executes TestNG suites across Chrome and Edge.  
- **Reports** → Publishes test results and artifacts.  

### Example Workflow (`.github/workflows/maven.yml`)
```yaml
name: CI - Build & Test for AdvancePlatform (Windows)

on:
  push:
    branches:
      - main
      - develop
  pull_request:
    branches:
      - main
      - develop

jobs:
  build-test:
    runs-on: windows-latest

    env:
      CHROME_DRIVER_PATH: ${{ github.workspace }}\chromedriver-win64\chromedriver.exe
      SELENIUM_BROWSER: chrome

    steps:
      - name: Checkout repository
        uses: actions/checkout@v4

      - name: Set up JDK 21
        uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: 21
          cache: maven

      - name: Cache Maven local repo
        uses: actions/cache@v4
        with:
          path: ~\.m2\repository
          key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
          restore-keys: |
            ${{ runner.os }}-m2-

      - name: Install Chrome browser
        run: |
          choco install googlechrome -y
        shell: powershell

      - name: Download ChromeDriver
        run: |
          $chromeVersion = (Get-Item "C:\Program Files\Google\Chrome\Application\chrome.exe").VersionInfo.ProductVersion
          $majorVersion = $chromeVersion.Split('.')[0]
          Write-Host "Chrome version: $chromeVersion"
          Write-Host "Major version: $majorVersion"
          
          # Download ChromeDriver for the matching Chrome version
          $url = "https://storage.googleapis.com/chrome-for-testing-public/$chromeVersion/win64/chromedriver-win64.zip"
          
          try {
            Invoke-WebRequest -Uri $url -OutFile chromedriver.zip
          } catch {
            # If exact version not found, try with major version
            Write-Host "Exact version not found, trying with major version..."
            $latestUrl = "https://googlechromelabs.github.io/chrome-for-testing/latest-versions-per-milestone-with-downloads.json"
            $json = Invoke-RestMethod -Uri $latestUrl
            $driverUrl = $json.milestones.$majorVersion.downloads.chromedriver | Where-Object { $_.platform -eq "win64" } | Select-Object -First 1 -ExpandProperty url
            Invoke-WebRequest -Uri $driverUrl -OutFile chromedriver.zip
          }
          
          Expand-Archive -Path chromedriver.zip -DestinationPath . -Force
          Write-Host "ChromeDriver downloaded and extracted"
        shell: powershell

      - name: Verify ChromeDriver
        run: |
          $env:PATH += ";${{ github.workspace }}\chromedriver-win64"
          & "${{ github.workspace }}\chromedriver-win64\chromedriver.exe" --version
        shell: powershell

      - name: Build without tests
        run: mvn -B -DskipTests package
        shell: cmd

      - name: Run TestNG tests
        run: mvn -B test
        shell: cmd
        env:
          webdriver.chrome.driver: ${{ github.workspace }}\chromedriver-win64\chromedriver.exe

      - name: Upload test results (Surefire)
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: surefire-reports
          path: target\surefire-reports\

      - name: Generate JaCoCo coverage report
        run: mvn -B jacoco:report
        shell: cmd

      - name: Upload coverage report
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: jacoco-report
          path: target\site\jacoco\

      - name: Upload screenshots on failure
        if: failure()
        uses: actions/upload-artifact@v4
        with:
          name: test-screenshots
          path: screenshots\

```

> With this setup, every push or pull request triggers automated builds and test runs, ensuring continuous integration.

---

## 🧩 Key Components

### Base Classes
- **BaseTest** → Initializes `Bot` engine, handles setup/teardown.  
- **CrossBrowserBaseTest** → Enables Chrome/Edge parallel execution.  

### Data Providers
- **ExcelDataProvider** → Reads credentials from `LoginSheet.xlsx`.  
- **LoginSheet.xlsx** → Contains login data for all roles.  

### Utilities
- **Bot** → Wrapper for WebDriver actions.  
- **ConfigReader** → Reads properties files.  

### TestNG Suite
- **testing-cros-browser.xml** → Defines parallel execution across Chrome and Edge.  

---

## 🧪 Test Coverage

### Admin
- `AdminLoginTest` → Valid/invalid login, empty credentials, forgot password.  
- `AdminDashboardTest` → Dashboard visibility, URL, title, navigation menu, logout.  

### Company
- `CompanyLoginPageTest` → Valid login.  
- `CompanyDashboardPageTest` → Dashboard statistics validation.  

### Student
- `StudentLoginPageTest` → Links, language toggle, header buttons, data-driven login.  
- `StudentDashBoardPageTest` → Navigation (dashboard, courses, AI study guide, progress).  
- `StudentSignUpPageTest` → Signup validation, mandatory fields, error messages, terms acceptance.  

### Teacher
- `TeacherLoginPageTest` → Valid/invalid login, navigation links, theme/language toggles.  
- `TeacherDashBoardPageTest` → Dashboard navigation, profile editing, earnings, logout, course creation/deletion.  
- `TeacherSignUpPageTest` → Successful signup workflow.  

### University Student
- `UniversityStudentProfileTest` → Profile navigation, course filtering, login via Excel data provider.  

---

## 🚀 Features
- **Cross-browser testing** (Chrome, Edge).  
- **Data-driven testing** (Excel-based credentials).  
- **Page Object Model (POM)** for maintainability.  
- **Parallel execution** for efficiency.  
- **GitHub Actions CI/CD** for automated builds and test runs.  
- **Scalable design** for adding new roles and workflows.  

---

## 📌 Notes
- Valid signup tests for Students are commented out to avoid duplicate account creation.  
- Excel-driven tests iterate once per row in the selected sheet.  
- Extend `BaseTest` for single-browser tests, `CrossBrowserBaseTest` for multi-browser tests.  

---

## ✅ Summary
This suite provides **comprehensive coverage** of login, signup, dashboard, and profile workflows across all user roles in the Edvance platform.  
It is designed for **clarity, scalability, and maintainability**, with **GitHub Actions CI/CD** ensuring continuous integration and automated quality checks.
```

---

