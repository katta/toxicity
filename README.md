How to build
============

* Run "mvn clean install" which creates a package toxicity.jar under <ROOT_DIR>/target

Usage
-----

* Run "java -jar toxicity.jar <checkstyle-result.xml> <output.csv>
** e.g. java -jar toxicity.jar checkstyle-result.xml toxicity-output.csv