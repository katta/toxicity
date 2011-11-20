Prerequisites
-------------
* Maven to be installed
* Java to be installed

Creating Jar
------------
* Run "mvn clean package" which creates a package toxicity-1.0.jar under [ROOT_DIR]/target

Usage
-----

* Run "java -jar toxicity.jar <checkstyle-result.xml> <output.csv>

e.g. java -jar toxicity.jar checkstyle-result.xml toxicity-output.csv

How does it work
----------------

* This tool requires the checkstyle result (in the form of xml) generated from your java project.
* The following checks have been implemented in toxicity calculation 
1. asdf
2. asdfsdf
