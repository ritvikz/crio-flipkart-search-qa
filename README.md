# Flipkart Search — QA Automation Suite

## 📖 Overview
Automated test suite for **Flipkart Search** functionality built using Selenium WebDriver, Java, and TestNG as part of the Crio.do QA Automation track. Validates end-to-end search workflows including keyword search, product filtering, sorting, and result validation on one of India's largest e-commerce platforms.

---

## 🚀 Key Testing Highlights
- **Search Validation:** Verified keyword-based search returns accurate and relevant product results
- **Filter Testing:** Validated brand, price range, and category filters work correctly in combination
- **Sort Validation:** Tested sorting by price (low-high, high-low), popularity, and relevance
- **Negative Testing:** Handled invalid searches, special characters, and empty queries
- **Page Object Model:** Clean POM architecture for maintainable and scalable test code
- **Dynamic Waits:** Implemented explicit waits for AJAX-heavy search result pages

---

## 🛠️ Tech Stack
| Technology | Purpose |
|---|---|
| Java | Core language |
| Selenium WebDriver | Browser automation |
| TestNG | Test runner & assertions |
| Maven | Build & dependency management |
| Page Object Model | Framework architecture |

---

## 📂 Project Structure
```
crio-flipkart-search-qa/
├── src/
│   ├── main/java/pages/
│   │   ├── HomePage.java
│   │   └── SearchResultsPage.java
│   └── test/java/tests/
│       ├── SearchTest.java
│       └── FilterSortTest.java
├── test-output/
├── pom.xml
└── README.md
```

---

## ✅ Test Coverage
| Feature | Test Type | Status |
|---|---|---|
| Keyword Search | Functional | ✅ |
| Filter by Brand | Functional | ✅ |
| Filter by Price Range | Functional | ✅ |
| Sort by Price | Functional | ✅ |
| Invalid Search Handling | Negative | ✅ |
| Regression Suite | Regression | ✅ |

---

## ▶️ How to Run
```bash
git clone https://github.com/ritvikz/crio-flipkart-search-qa.git
cd crio-flipkart-search-qa
mvn test
```
View reports: Open `test-output/index.html`

---

## 👤 Author
**Ritvik Singh Chouhan** — Senior QA Automation Engineer | SDET-II
🔗 [GitHub](https://github.com/ritvikz) | [Portfolio](https://www.crio.do/learn/portfolio/ritvikchouhan77/) | [LinkedIn](https://www.linkedin.com/in/ritvik-singh-chouhan-8a2a6815a/)
