[![Build Status](https://secure.travis-ci.org/katta/toxicity.png?branch=master)](https://travis-ci.org/katta/toxicity)

This is a java based tool which calculates the toxicity of your code based on the [checkstyle](http://maven.apache.org/plugins/maven-checkstyle-plugin/) report generated for your code. Currently the following checks have been implemented.

        BooleanExpressionComplexityCheck
        ClassDataAbstractionCouplingCheck
        ClassFanOutComplexityCheck
        CyclomaticComplexityCheck
        FileLengthCheck
        MethodLengthCheck
        MissingSwitchDefaultCheck
        NestedIfDepthCheck
        NestedTryDepthCheck
        ParameterNumberCheck
        

## Prerequisites

* Maven 2.0 
* Java 1.6

## Creating Jar

* `toxicity.jar` is available under `[ROOT_DIR]/dist` or you can build one using the next instruction
* Run `mvn clean package` which creates a package `toxicity-1.0.jar` under `[ROOT_DIR]/target`

## Usage


* Run the following command 

        java -jar toxicity.jar <checkstyle-result.xml> <output.csv>

        e.g. java -jar toxicity.jar checkstyle-result.xml toxicity-output.csv
        
* This command does print the summary of all the checks on the console and generates a csv (with given output file name) which contains the toxicity value for each of the check for every file.

## How does it work


* This tool requires the [checkstyle](http://maven.apache.org/plugins/maven-checkstyle-plugin/) result (in the form of xml) generated from your java project.        

* To create a suitable Checkstyle report outside of Maven use the following command 
         
        java -jar checkstyle-all.jar -c toxicity/checks.xml -f xml -o <checkstyleFilePath> -r <javaSourcePath>
        
        e.g. java -jar checkstyle-all.jar -c toxicity/checks.xml -f xml -o checkstyle-result.xml -r ./myproject/src

* Checkstyle creates localized reports. Reports in languages other then English are not recognized by `toxicity.jar`. Use `-Duser.language=en` to run Checkstyle under an English locale.

* There are two types of categories in the above mentioned checks. One which has the `limit` configured for a given check and the second which checks for `existence` of the voilation.

* If we consider a `MethodLengthCheck`, lets assume the limit configured in checkstyle as 20. This means that if a method length exceeds 20 lines that method is voilating this check. In this case the toxicity is calculated as 

        toxicity = (number of actual lines in a method) / (limit configured for MethodLengthCheck)
        
        e.g. If method has 50 lines, formulae for toxicity looks like `toxicity = 50/20` which is 2.5
        
* For checks like `MissingSwitchDefaultCheck` which does not have a limit configured, toxicity is calculated as 

        toxicity = number of swtich statements in a given file with missing default option


        