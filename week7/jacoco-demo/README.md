# What is code coverage

"Code coverage is a software metric used to measure how many lines of our code are executed during automated tests." -- [Intro to JaCoCo](https://www.baeldung.com/jacoco)

It's a measurement of how many lines, statements, or blocks of your code are tested using your suite of automated tests. The higher the code coverage, the lower the chance of having undetected software bugs. 

Code coverage is further split into many subtypes: 
- **Function coverage** -- This ensures that all necessary functions are tested. It also includes testing functions with different input parameters to test the logic in the functions.
- **Branch coverage** -- Ensures that every branch in a decision-making process is executed.
- **Condition coverage** -- This reveals how variables in the conditional statements are evaluated.
- **Loop coverage** -- This ensures that every loop in the source code is executed at least once.
- **Statement coverage** -- The code is created in a way that every executable statement in the source code is executed at least once. This includes corner cases or boundary cases.

### Example of Statement Coverage

Code coverage is calculated by taking the number of lines of code that are executed and dividing by the total number of lines of code. Following are some examples of calculating code coverage given the following function of 13 lines.

```
01 public boolean isPrime(int n) {
02     if (n <= 3)
03         return n > 1;
04     if ((n % 2 == 0) || (n % 3 == 0))
05         return false;
06     int i = 5;
07     while (i * i <= n) {
08         if ((n % i == 0) || (n % (i + 2) == 0))
09             return false;
10         i += 6;
11     }
12     return true;
13 }
```

If `n <= 3`, then lines 1, 2 and 3 are executed. So statement coverage is 3 / 13, or 23%.

If `n` is divisible by 2 or 3 then lines 1, 2, 4 and 5 are executed and coverage is 4 / 13, or 31%.

If the while loop iterates 0 times (i.e. `n` is prime and < 25), then lines 1, 2, 4, 6, 7, 11 and 12 get executed giving a coverage of 7 / 13, or 54%.

If the while loop iterates at least once and `n` is prime (i.e. `n >= 29`), then lines 1, 2, 4, 6, 7, 8, 10, 11, and 12 get executed and coverage is 9 / 13, or 69%. 

If the while loop iterates at least once and `n` is divisible by 5 or 7 then lines 1, 2, 4, 6, 7, 8 and 9 get executed giving a coverage of 7 / 13, or 54%. 

If the while loop iterates at least once and `n` has a prime divisor greater than 7 (e.g. 11 or 13), then lines 1, 2, 4, 6, 7, 8, 10, 11 and finally 9 get executed giving a coverage of 9 / 13, or 69%. 

In summary, if tests are created that test for all these cases then the combined code coverage will be 100%.

### Test coverage vs. Code coverage

Unlike code coverage where test cases are written based on code, test coverage determines whether the test cases are covering the entire functional requirements, and are based on user requirements or expected functionality.

 "White box testing" is a software testing technique in which internal structure, design, and the code itself is visible to the testers; whereas "Blackbox testing" refers to not being able to see the inner workings of the software, and involves testing from an external or end-user type perspective.

Types of Test coverage

- **Unit testing** -- written at a granular level to check if each unit performs as expected. 
- **Functional testing** -- each functionality mentioned in the requirement document is tested. 
- **Performance testing** -- a way to stress test the code for its responsiveness and stability at different workloads 
- **Integration or system testing** -- Integration testing or system testing is done to test if completely integrated product works in expected manner.
- **Acceptance testing** -- Acceptance testing is generally done at the end of the development cycle. For acceptance testing, the product is handed over to the stakeholders and tested by them to determine whether the product is in acceptable state

## Code coverage with JaCoCo

JaCoCo is a code coverage report generator for Java. It can integrate with Ant, Maven, Gradle, Jenkins, Visual Studio. 

To get running with JaCoCo, some additions to `build.gradle` is necessary. 

```
plugins {
    id 'java'
    id 'jacoco'
}

test {
    useJUnitPlatform()
    finalizedBy jacocoTestReport // report is always generated after tests
    jacoco {
        destinationFile = layout.buildDirectory.file('jacoco/jacocoTest.exec').get().asFile
        classDumpDir = layout.buildDirectory.dir('jacoco/classpathdumps').get().asFile
    }
}

jacocoTestReport {
    dependsOn test // tests are required to run before generating report
    reports {
        xml.enabled false
        csv.enabled false
        html.destination layout.buildDirectory.dir('jacocoHtml').get().asFile
    }
}

jacoco {
    toolVersion = '0.8.5'
    // Gradle default for reports Directory is $buildDir/reports/jacoco
    // reportsDirectory = layout.buildDirectory.dir('customJacocoReportDir')
}
```

Here is a [link](https://docs.gradle.org/current/userguide/jacoco_plugin.html) to the Gradle docs about how to get started with JaCoCo.