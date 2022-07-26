Coverage:
# Inventory Management System(IMS) Project 

Here is a link to my jira page - [Jira](https://seanpalla.atlassian.net/jira/software/projects/IMS/boards/6/backlog)

This is a project in which i have created a Inventory management system to Create, Update, Read and delete orders,items and customers from a database.
This project is part of my QA Academy training in which i will demonstrate my skill i have acquired during this journey. This system works with MYSQL and Java.
## Getting Started

To get this project up and running you will need to clone down this IMS repository Master branch to your local machine and open it up in an IDE.

### Prerequisites

To get this project up and running you are going to need to have a few things already installed i will list these bellow.

- Java 11 and newer JDK (Was made using Java 17)
- Maven (Maven was used as the build tools for this project)
- IDE to continue development or run existing project (e.g intellij, eclipse, vscode)``

### Installing

Bellow you will find a step by step guide on how to get an java environment set up

- Install a JDK from -Recommend Java 17-  [Oracle](https://www.oracle.com/java/technologies/downloads/)
- Setup environment variables in windows 'JAVA_HOME' and set up the PATH file to include %JAVA_HOME%/bin
- Install an IDE -Recommend VSCode but all are good-  [Eclipse](https://www.eclipse.org/ide/)
- Install a build tool - Recommend Maven -  [Maven](https://maven.apache.org/download.cgi)
- Setup maven environment variables 'MAVEN_HOME' and setup the PATH file to include %MAVEN_HOME%/bin
- Download and install Git [Git](https://gitforwindows.org/)

## Running the tests

To run both the unit test and the integration tests in eclipse you can either run them by right-clicking on srs folder and selecting run as Junit test,
or you can click on the down arrow next to the run symbol on the task bar and again select run as Junit test.

### Unit Tests 

This is a test that tests the functionality of the methods i created in the program.
Bellow is an example of testing the read all function.
To run these tests you can either right click the main folder and select run as- then click JUnit test

```
   @Test
    public void testReadAll() {
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(1L, "bat", 3.5, 1));
        assertEquals(expected, DAO.readAll());
    }
```

### Integration Tests 
I have made integration tests using Mockito,
this allows you to test methods thats are more complex and integrate more functions.
```
    @Test
    public void testReadAll() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("cat", 3.50, 10));

        Mockito.when(dao.readAll()).thenReturn(items);

        assertEquals(items, controller.readAll());

        Mockito.verify(dao, Mockito.times(1)).readAll();
    }
```

### And coding style tests

Explain what these tests test and why

## Deployment

to deploy you can create a release on github

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors
* **Sean Palla** - *Main project work* - [Git](https://github.com/SeanPalla)
* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
