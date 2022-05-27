Coverage: 34%
# Project Title

This project consists of multiple tables in a database that ultimately link to a JAR file that allows the user to update, create, delete and read any entries in the aforementioned tables

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You need preferrably either something that runs SQL through CLI(MY_SQL) or through a GUI(POPSQL)
You need Eclipse or another Java IDE installed
In Java you need the JUnit dependencies installed

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be



## Running the tests
The tests are all located in src/test/java. The tests are divided up into their relevant fields, with controllers being grouped together using Mockito(because they rely on code outside their methods), and DAOs being grouped elsewhere.

### Unit Tests 

Unit tests are for testing individual methods that YOU have created. They tend to not have any external dependencies and are mainly of your own making. Testing these are vital as they consist the foundation of your codebase.
You run Unit tests for through Junit(4 or 5). Import JUnit, use AssertEquals to compare the expectation of a method you're testing and the outcome. If they're the same, the lights will be green, if not they will be red, and further testing will need to be done.
### Integration Tests 
Integration tests are basically testing the system as a whole. They are designed to ensure compatibility between your code and libraries, and others. It's unit testing on a wider scale.
```

## Deployment



## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
