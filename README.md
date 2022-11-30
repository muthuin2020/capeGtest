# steps to execute
set environmnent in the "CapeGTest\Env\selectEnvHere.txt" file
provide all env data in "CapeGTest\Env\test.txt" or "CapeGTest\Env\dev.txt" or "CapeGTest\Env\prod.txt"
create properties file in the name of the test scenario and provide all input data for corresponding test scenario. eg - "CapeGTest\Input\Login test\Verify Borrow Estimation.properties"
run "mvn test" to run test cases
run "mvn test -Dcucumber.options="--tags @SmokeTest" to run test cases that are tagged as smoke
run "mvn test -Dcucumber.options="src/test/resources/feature/LoginTest.feature" to run LoginTest

Note : firefox and edge drivers are not availabel in the repo. if required, download it and place it in "\Driver\" folder 
