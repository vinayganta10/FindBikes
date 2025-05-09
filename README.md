# 🚗 ZigWheels.com Automation Testing Project

This project automates and validates key functionalities of [ZigWheels.com](https://www.zigwheels.com) using **Selenium WebDriver**, **TestNG**, **Cucumber (BDD)**, and **Apache POI** for Excel-based test data management.

---

## 📌 Tech Stack

| Tool         | Purpose                                  |
|--------------|-------------------------------------------|
| Selenium     | Web browser automation                    |
| TestNG       | Test execution and assertions             |
| Cucumber     | BDD-style test writing with Gherkin       |
| Apache POI   | Reading and writing Excel data            |
| Maven        | Dependency management and build tool      |
| Java         | Programming language                      |

---

## ✅ Features Tested

- Search functionality
- Navigation through car/bike brands
- Filtering and sorting vehicles
- Data validation from tables/lists

---

## 🧪 BDD Scenario Example

```gherkin
Feature: Search for bikes on ZigWheels

  Scenario: User searches for popular bikes
    Given I open ZigWheels homepage
    When I click on the "New Bikes" section
    And I filter by "Popular Bikes"
    Then I should see a list of popular bike models
