# jenkins-docker-ci

A CI stack in Docker which runs:

1. Jenkins
2. Selenium Grid
3. Chrome
4. Firefox

## Jenkins

The jenkins url is http://localhost:7000
The login details are user: `admin` and password: `admin`

## Java Automation Project 

Additional to the Docker infrastructure, this repository contains a simple Java Selenium WebDriver project which can be built and run in Jenkins. The execution will run on the Selenium Grid hub.

### Maven Build task

Maven is pre-installed in the Jenkins container.

The Java project uses a number of Maven profiles which can be used to control the execution settings:

1. `firefox` or `chrome` will dictate the browser to use
2. `parallel` ensures parallel execution

#### Examples

When setting up a new Jenkins job, you can use the `Invoke top-level Maven targets` build step. An example is:

`clean test` 

This will use the defaults and run `chrome` and `parallel`

`mvn clean test -P firefox`

This will execute the tests on Firefox in non-parallel mode.
