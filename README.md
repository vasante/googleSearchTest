#Google search
> Simple test automation solution based on Java cucumber, Selenium web driver and Maven

## 1 - Run locally
* Clone the solution using git [google example repos](https://github.com/vasante/googleSearchTest.git)
* Build the solution using Maven ``mvn -B -DskipTests clean package``
* Run the test using Maven ```mvn test```
* Optionally you can use ```-Dcucumber.filter.tags``` parameter to indicate with scenarios you wish to run example:`` mvn clean test -Dcucumber.filter.tags="@smoke``

## 2- Run on a CI/CD server (Jenkins)
Using the Jenkins file provided you could first:
* Checkout the sources from github (Jenkinsfile - stage 1)
* Build the solution (Jenkinsfile - stage 2)
* Run the test (Jenkinsfile - stage 3)
* Displays test results (Jenkinsfile - stage 4)

## 3 - Further integration (Jenkins)
If we wish to integrate the test solution in the application deployment
we could use one of the solutions below:
* Using an automation server webhooks to detect the application build status and trigger our acceptance test
* Add the test source code to the same repository as the application code and use a pipeline like the
one described in the JenkinsfileGlobal to launch test. 
