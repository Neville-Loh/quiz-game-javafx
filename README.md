# Jeopardy

Jeopardy is a quiz application built with javaFx11. This is a assignment project developed to help practices
the javaFx library. The application was built for Linux Environment


The following project uses:
- festival, (Text to speech module using Bash command)
- bash,
- javaFX11

## Getting Started
To run the following
### Method 1
rename ```path``` to the absolute path to javaFx Library
```
java --module-path /path/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.media,javafx.base,javafx.fxml -jar jeopardy.jar
```
### Method 2
modify path in run.sh to the absolute path to javaFx Library mentioned above
```
bash
> chmod +x run.sh
> ./run.sh
```
The .jar file assumes there exist a file name ```categories``` within the same directory.

## Adding Questions to the Applications
The folder ```categories``` contains question to the quiz. Each text file represent one category
and each line represent one question.

The question are written in the following format with separation of a comma.
Note that the program assume neither the question or the solution contains commas.
```
score, question prompt, solution
```


Project Structure

> **A:** The project is build with mvc design in mind

 jeopardy  
    ├── controller  
    ├── model   
    ├── view  
    │   └── css  
    └── util



## futrue imporvement
- Refactor into mvc package structure with .resources
- Replace sudo database with SQL or SQLite
- Better exception handling to cooperate changes of question set during runtime
- Better notification system
