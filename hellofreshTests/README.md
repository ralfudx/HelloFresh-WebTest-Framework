# Home test task

**What do you already have?**
-----
 * web application with url http://automationpractice.com/index.php;
 * 3 [test cases](TESTCASES.md);
 * 3 automated tests.
 
We give the initial version of tests in order to save your time on extracting locators. 

**What do you need to do?**
----
You need to improve given automated tests as much as you can by designing your own solution to develop such kinds of tests for similar applications.
Feel free to replace any tool we used in initial version of tests(maven, junit) or add other ones, if you need.

Your solution can include:
* logging;
* taking screenshot on failed tests;
* generation human readable report;
* generating random values for insignificant test data, for example, for new user;
* WebDriver factory;
* encapsulation layers like test data, logic of tests, actions on web pages and so on;
* configurator:
  * run tests in parallel mode;
  * ability to run tests for different browsers/OS by configuring;
  * ability to run tests for different environments(urls) by configuring/by command-line.
* reading test data from file, for example, the name of dress, size and color in the checkout test.

If you would like to impress us cover as much point as you can!

**Evaluation Criteria**
-------------------
1. The improvements are done in efficient and effective manner.
2. The improved tests pass stably and follow described cases.
3. The solution is well and logically organised.
4. Tests execution does not take more time than initial version.
5. The code is documented and is easy to-follow.
6. The application is supplied with all the information required for us to run and validate it as well as a description and purpose of used additional libraries.


**Improvements Made**
-------------------
1.	Included capture screenshot functionality which is triggered only when the test fails
2.	Added data driven functionality which allows to read data from file (xml) and fill required fields (Also selecting the shopping item - 	like name of dress is included here)
3.	Implemented Page Object Model for separation of concern and easy maintainability of test framework
4.	Implemented driver factory and managernstance of driver throughout test run
5. 	Included cross browser functionality which allows to run test on different browsers (Only Chrome, Firefox and IE are currently 	configured) - value can be configured in desktop.xml file
6.	Added functionality to run tests for different environment (urls) by configuring this in config.properties file
7.	Changed the test framework from Junit to Testng for more flexibility and better reporting structure
8	Included functionality to generate human readable reportNG HTML and XML report file (listeners need to be added to the desktop.xml file 	in .src/test/resources/suites folder)
9.	Included ability to run test programmatically - designing a custom testng.xml file (desktop.xml)


**Run Instructions**
-------------------
Web-Tests on Eclipse IDE 
1. 	Unzip and Import project as maven project
2. 	Ensure all dependencies (already in pom.xml) are loaded
3. 	Ensure is ChromeDriver located in ../src/test/resources/drivers/ folder is compatible with the test machine (it's currently 	chromedriver_win32, version ChromeDriver 2.38)
4. 	Clean project
5. 	Right click on project and Run as Java Application (Please select: Driver - com.hellofresh.driver)

API-Tests on Eclipse IDE
1. 	Unzip and Import project as maven project
2. 	Ensure all dependencies (already in pom.xml) are loaded
3. 	Clean project
4. 	Right click on project and Run as TestNG Test