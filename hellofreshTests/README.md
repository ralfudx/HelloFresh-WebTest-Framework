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
