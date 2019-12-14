<h1>DEMO Application | Test Automation Playground</h1>

<h3>UI ◦ SERVICE ◦ PERFORMANCE TEST CASES</h3>

<h4>UI Test Cases Package</h4>
The Test Package contains the following folder:
- GuiTests

The UI Test Cases Package (folder GuiTests) contains the following sub-folders/files: 
- <b>src</b> folder that contains the UITT Source Code;
- <b>pom.xml</b> file that is needed for the installation with maven;
- <b>.gitignore</b> file that specifies intentionally untracked files that Git should ignore.

<h4>WS Test Cases Package</h4>
The Test Package contains the following folder:
- SrvTests

The Web Services Test Cases Package (folder SrvTests) contains the following sub-folders/files: 
- <b>src</b> folder that contains the SoapUI Project and Properties file with global variables.
- <b>pom.xml</b> file that is needed for the installation with maven;
- <b>.gitignore</b> file that specifies intentionally untracked files that Git should ignore.
- <b>launch-test.sh</b> shell script that is needed for the full execution of WS tests and the generation of a report.
- <b>cleanup.sh</b> shell script that is needed for the cleanup of data and generation of a report.

<h4>Performance Test Cases Package</h4>
The Test Package contains the following folder:
- PerfTests

The Performance Test Cases Package (folder GuiTests) contains the following sub-folders/files: 
- <b>src</b> folder that contains the JMeter Project and Recources that are needed for the reporting.
- <b>pom.xml</b> file that is needed for the installation with maven;
- <b>.gitignore</b> file that specifies intentionally untracked files that Git should ignore.


<h4>Software Pre-Requisites</h4>
The DEMO Application must be correctly installed and configured on the appropriate server;
The following software must be available on the machine from where the UI Test Cases/Suites will be executed:
- Java JDK 1.8.0: dependency required for the execution of Test Cases/Suites;
- Google Chrome: dependency required for the execution of Test Cases/Suites
- GIT for Windows: dependency required for the execution of the scripts;
- Apache Maven: dependency required for the installation of the test packages and execution of Test Cases/Suites;
- SoapUI Open Source: dependency required for the processing of the WS test scripts;
- Apache JMeter: dependency required for the processing of the Performance test scripts;

Usefull Links:<br>
&nbsp;&nbsp;&nbsp;https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html<br>
&nbsp;&nbsp;&nbsp;https://git-scm.com/download/win<br>
&nbsp;&nbsp;&nbsp;https://maven.apache.org/download.cgi<br>
&nbsp;&nbsp;&nbsp;https://www.soapui.org/downloads/soapui.html<br>
&nbsp;&nbsp;&nbsp;https://jmeter.apache.org/download_jmeter.cgi

<h4>UI Test Execution & Reporting</h4>
<h5>Installation of the UI Test package</h5>
Assuming that the UI Test Cases Package was extracted to “C:\DEMO\GuiTests”,<br>
open Git Bash and execute the following commands: 
        
        cd /c/DEMO/GuiTests
        mvn clean install

After successful installation, the UITT is generated in C:\DEMO\GuiTests\target

The contents of the UITT Test Tool are presented below:
- test_data	Sub-folder that contains clean-up scripts and a list of files needed for upload/load operations.
- test_suites	Sub-folder that contains all UI Test Suite XML files.
- chromedriver.exe	A separate executable that Selenium WebDriver uses to control Chrome.
- demo-test-1.0.jar	Executable jar file that is needed for UI Test Case/Suite execution.
- launch-test.sh	Main shell script that is needed for the UI Test Case/Suite execution.

<h5>Execution of UI Test Case/Suite<h5>
Assuming the UI Test Tool was installed in the C:\DEMO\GuiTests\target
- Open Git Bash;
- Navigate to the UI Test Tool folder’s path (e.g. cd C:\DEMO\GuiTests\target).

To execute all test suites, the following command can be executed:

        ./launch-test.sh

<h5>Reporting of UI Test Case/Suite</h5>
After execution of a UI Test Case/Suite,<br>
a report is generated automatically in a folder named by:
        
        \reports\<name of test case/suite>_<timestamp>

Within that folder and within sub-folder “html”,<br>
an “index.html” file will reside with the results of the report for the UI Test Case/Suite that was executed. 

<h4>WS Test Execution & Reporting</h4>
<h5>Execution of WS Test Case/Suite</h5>
Assuming that the WS Test Cases Package was extracted to “C:\DEMO\SrvTests”,<br>
open Git Bash and execute the following commands: 

        cd /c/DEMO/SrvTests
        ./launch-test.sh

<h5>Reporting of WS Test Case/Suite</h5>
After execution of a WS Test Case/Suite, a report is generated automatically in a folder named by:
        
        \test-reports\DemoAppWS_TestReport_<timestamp>

Within that folder, a “surefire-report.html” file will reside<br>
with the results of the report for the WS Test Case/Suite that was executed. 

<h5>Execution of CleanupDB Test Case</h5>
Assuming that the WS Test Cases Package was extracted to “C:\DEMO\SrvTests”,<br>
open Git Bash and execute the following commands: 

        cd /c/DEMO/SrvTests
        ./cleanup.sh

<h5>Reporting of CleanupDB Test Case</h5>
After execution of the CleanupDB WS Test Case, a report is generated automatically in a folder named by:
        
        \test-reports\DemoAppCleanupDB_TestReport_<timestamp>

Within that folder, a “surefire-report.html” file will reside<br>
with the results of the report for the CleanupDB WS Test Case that was executed. 

<h4>Performance Test Execution & Reporting</h4>
Execution of Performance Test Case/Suite
Assuming that the Performance Test Cases Package was extracted to “C:\DEMO\PerfTests”,<br>
open Git Bash and execute the following commands: 

        cd /c/DEMO/PerfTests
        mvn clean verify
        mvn pre-site

<h5>Reporting of WS Test Case/Suite</h5>
After execution of a WS Test Case/Suite, a report is generated automatically in a folder named by:

        \target\jmeter\results\dashboard

Within that folder, an “index.html” file will reside<br>
with the results of the report for the WS Test Case/Suite that was executed.
