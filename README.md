How to build
============

Prerequisites
-------------
* Maven to be installed
* Java to be installed

Creating Jar
------------
* Run "mvn clean package" which creates a package toxicity-1.0.jar under <ROOT_DIR>/target

Usage
-----

* Run "java -jar toxicity.jar <checkstyle-result.xml> <output.csv>

e.g. java -jar toxicity.jar checkstyle-result.xml toxicity-output.csv