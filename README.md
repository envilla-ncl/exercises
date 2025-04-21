
# 🧪 QA Automation Exercise: TODO App

This is a practical QA automation exercise covering both **UI testing** and **API testing** using Java, Maven, Selenium, and RestAssured.

---

## ✅ Applications Under Test

- **Web UI**: https://demo.playwright.dev/todomvc
- **API**: https://jsonplaceholder.typicode.com/todos

---

## 🔧 Tech Stack

| Area       | Tool              |
|------------|-------------------|
| Language   | Java              |
| Build Tool | Maven             |
| Web UI     | Selenium WebDriver + TestNG |
| API        | RestAssured + TestNG |
| Drivers    | WebDriverManager  |

---

## ✅ Task 1 — Web UI Automation: Basic TODO Actions

**File:** `TodoTests.java`

### Steps:
1. Navigate to the TODO UI.
2. Add a TODO: `"Buy milk"`
3. Validate it appears in the list.
4. Delete the TODO.
5. Confirm that no TODOs remain.

### Validations:
- List should contain 1 item after adding.
- Text of the item should be `"Buy milk"`.
- After deletion, list should be empty.

---

## ✅ Task 2 — API Automation: Basic CRUD Operations

**File:** `TodoApiTests.java`

### Steps:
1. GET `/todos/1`
2. POST a new TODO
3. PATCH an existing TODO
4. DELETE a TODO

### Validations:
- **GET**: Status 200, `id = 1`, title not empty, userId present.
- **POST**: Status 201, correct title and userId in response.
- **PATCH**: Status 200, title updated.
- **DELETE**: Status 200

---

## ✅ Task 3 — Web UI Automation: Filter Completed TODOs

**File:** `TodoFilterTests.java`

### Steps:
1. Add 3 TODOs: "Buy milk", "Wash car", "Call mom"
2. Complete "Wash car" and "Call mom"
3. Filter: Click “Completed”
4. Validate completed items
5. Switch back to “All”

### Validations:
- 3 items after adding.
- 2 items shown under “Completed”: "Wash car", "Call mom"
- 3 items shown again after switching to “All”

---

## ✅ Task 4 — API Automation: Create → Update → Retrieve

**File:** `TodoApiChainTests.java`

### Steps:
1. POST new TODO: `"Review automation strategy"`
2. Capture `id`
3. PATCH it to mark as completed
4. GET by `id`

### Validations:
- **POST**: 201, title and userId match, completed false
- **PATCH**: 200, completed = true
- **GET**: title unchanged, userId = 2, completed = true

---

## ▶️ How to Run

```bash
mvn clean test
```

Or use TestNG from your IDE.

---

## 📁 Project Structure

```
todo-automation/
├── pom.xml
├── README.md
└── src/
    ├── main/java/
    └── test/java/
        ├── tests/
        │   ├── TodoTests.java
        │   └── TodoFilterTests.java
        └── api/
            ├── TodoApiTests.java
            └── TodoApiChainTests.java
```


---

## ✅ Task 5 — UI Automation with Extent Report (Demo)

**File:** `TodoExtentReportExample.java`

This task is a demonstration of how to generate an Extent Report with:
- Test status (pass/fail)
- Error messages on failure
- Automatic screenshots

### Steps:
1. Navigate to the TODO UI.
2. Add a TODO: `"Test Extent Report"`
3. Validate it appears in the list.

### Validations:
- The TODO list contains the item with exact text `"Test Extent Report"`

### Result:
After running this test, check:
```
test-output/ExtentReport.html
```
to view the full report with logs and screenshots (if failed).
