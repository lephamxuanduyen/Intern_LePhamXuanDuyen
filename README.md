# Test Website Railway by Selenium + Maven + TestNG
<hr/>

This project contains automated tests for the Railway System using Selenium WebDriver with Java. Website for book train ticket.

## Setup Instructions
<hr/>

### Prerequisites

Ensure you have the following installed on your machine:

* Java Development Kit (JDK) 11 or higher
* Apache Maven
* Chrome browser
* Firefox browser

### Run test

You can use mvn test to run test in Maven. Few example:

```
# Run a single test class.
$ mvn -Dtest=Login test

# Run multiple test classes.
$ mvn -Dtest=Login,Logout test

# Run a single test method from a test class.
$ mvn -Dtest=Login#LoginWithValidInfo test

# Run all test methods that match pattern 'Login*' from a test class.
$ mvn -Dtest=Login#Login* test

# Run all test methods match pattern 'Login*' and 'email*' from a test class.
$ mvn -Dtest=Login#Login*+email* test

```

You can run test in different browsers without code change. Example: 
```
# Run all the unit test classes.
$ mvn -Dbrowser=chrome -Dtest=Logout#Logout clean test

# Run firefox
$ mvn -Dbrowser=firefox -Dtest-Logout#Logout clean test
```
