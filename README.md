# Apptimize Automated Registration Test

A simple selenium implementation to test user registration flow from the Apptimize homepage.
Web drivers for windows, linux, and OSX are included in the `external` folder.
`configs.txt` is set to default install paths for the binaries. Please change it according to your installation.

This project uses maven for selenium dependencies, which is a little different depending on the IDE and environment.

### Eclipse
* clone git repository
* `file > new > project from source folder` and select the local copy
* Eclipse should see the Maven file and fetch all needed libraries
* set src as the Source folder
* run either `ApptimizeRegistration_chromeTest` or `ApptimizeRegistration_firefoxTest` from the IDE to see the automation.


### IntelliJ

* clone git repository
* `file > new > project from existing sources` and select the `pom.xml` file
* Right click the `src` folder and set it as Sources Root  `Mark Directory as > Sources Root`


### Terminal
Tests are wrapped around JUnit and can be compiled and run without an IDE given the proper classpath and sources. Sample cmd for javac and java in a windows machine. Executed from the project folder.
```sh
javac -cp {path to lib folder with selenium, jUnit jars} -sourcefolder src src/ApptimizeRegistration_firefoxTest.java
java ApptimizeRegistation_firefoxTest
```