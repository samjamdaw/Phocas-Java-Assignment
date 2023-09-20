# Phocas-Java-Assignment
Java Project as part of the pre-interview process for an intership at Phocas


This project is designed to process a supplied newline delimited JSON file to answer a series of questions. As the data supplied is pre-cleaned there has been little error-handling implemeneted in order to hand the assingment in in a timely manner.

#Instructions for running the code are as follows:

- Navigate in your terminal to phocas
- mvn compile
- mvn test          /* for JUnit testing (optional) */
- mvn exec:java -Dexec.mainClass="phocas.Main"

Program will proccess the .NDJSON file located in phocas/jsonfiles and return the answered questions in order. 
