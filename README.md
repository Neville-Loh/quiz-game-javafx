# Jeopardy

Jeopardy is a quiz application built with javaFx11. This is a assignment project developed to help practicse
the javaFx library.


The following project uses:
- festival, (Text to speech module using Bash command)
- bash, 
- javaFX11

## Getting Started
To run the following 
rename ```path``` to the absolute path to javaFx Libaray
```
java --module-path /path/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.media,javafx.base,javafx.fxml -jar jeopardy.jar
```
The .jar file assumes there exist a file name ```categories``` within the same directory.


## Adding Questions to the Applications
The folder ```categories``` contains question to the quiz. Each text file represent one category 
and each line represent one question.

The question are writtin in the following format with seperation of a comma. 
Note that the program assume neither the question or the solution contains commas.
```
score, question prompt, solution
```


Project Strutrue

> **A:** The project is build with mvc design in mind

 jeopardy
    ├── controller
    ├── model
    ├── view
    │   └── css
    ├── util
    └── main.java


## Used Scripts


