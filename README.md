# Test Website Railway by Selenium + Maven + TestNG


This project contains automated tests for the Railway System using Selenium WebDriver with Java. Website for book train
ticket.

### 🔆 SOME FEATURES IN FRAMEWORK

1. Run the parallel test case
2. Read Config from Properties file
3. Extent Report
4. Base function in the package: utils 
5. Read data test from Json file 
6. Run Selenium Grid (remote)

<hr/>

### 🔆 Prerequisites

Ensure you have the following installed on your machine:

* Java Development Kit (JDK) 11 or higher
* Apache Maven
* Chrome browser
* Firefox browser
<hr/>

### ️️ 🔆 How to use

### ️ ️✳️ Run parallel the test case

* Run test case in suite XML (**src/test/testNG/**)
* Run test case from Maven pom.xml file
  (**mvn clean test**)

### ️️ ✳️ Run test with Maven in Terminal

#### 🔆 You can use mvn test to run test in Maven. Few example:


#### 1. Run a single test class.
> mvn -Dtest=Login test

#### 2. Run multiple test classes.
>mvn -Dtest=Login,Logout test
 
#### 3.  Run a single test method from a test class.
> mvn -Dtest=Login#LoginWithValidInfo test

#### 4. Run all test methods that match pattern 'Login*' from a test class.
> mvn -Dtest=Login#Login* test

#### 5. Run all test methods match pattern 'Login*' and 'email*' from a test class.
> mvn -Dtest=Login#Login*+email* test


#### 🔆 You can run test in different browsers without code change. Example:

#### 1. Run all the unit test classes.
> mvn -Dbrowser=chrome -Dtest=Logout#Logout clean test

#### 2.  Run firefox
> mvn -Dbrowser=firefox -Dtest-Logout#Logout clean test

### ️️ ✳️ Use Selenium Grid

### Download and Install

1. Download Selenium Grid 4: https://www.selenium.dev/downloads/

(download Latest stable version)

**selenium-server-4.22.0.jar** (updated 24/06/2024)

2. Set PATH for driver in Environment variables:

Follow with link:
https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/#2-the-path-environment-variable

🔆 Đặt file **selenium-server-4.22.0.jar** vào thư mục nào đó và mở CMD tại thư mục đó lên

### Run default 1 node

✅ Standalone (default port 4444)

> java -jar selenium-server-4.22.0.jar standalone

### Hub and Node
✅ Hub

> java -jar selenium-server-4.22.0.jar hub

✅ Node:

### More than one Node on the same machine

> java -jar selenium-server-4.22.0.jar node --port 5556

> java -jar selenium-server-4.22.0.jar node --port 6667

> java -jar selenium-server-4.22.0.jar node --port 7778


### More than one Node on different machines

> java -jar selenium-server-4.22.0.jar hub

> java -jar selenium-server-4.22.0.jar node --hub <hubIP>:4444

> java -jar selenium-server-4.22.0.jar node --hub <hubIP>:4444

**📝 NOTE: Thực thi nhiều lệnh thì mở nhiều CMD**

