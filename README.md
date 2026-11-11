# JAVA-Projects

Small console-based Java projects built while learning core Java, OOP and
data structures, on the way to backend development with Spring Boot.

## Projects

| Project | Description | Concepts |
|---|---|---|
| [Parking System](Parking%20system/) | Console parking lot manager: park, remove by plate, fee calculation, slot status | Abstract classes, inheritance, overriding, encapsulation, ArrayList, HashMap |

More projects will be added here as they are built.

## How to run any project

Every project is plain Java with no build tool, so you only need a JDK
installed (Java 8 or newer).

```bash
cd "<project folder>"
javac *.java
java Main
```

Each project folder has its own README with the exact steps, a class
diagram and sample output.

## Repository structure

```text
JAVA-Projects/
├── README.md
├── .gitignore
└── Parking system/
    ├── README.md
    ├── docs/
    │   └── architecture.png
    └── *.java
```

## Conventions used in every project

- One class per file, with the file name matching the class name
- Private fields with getters, and `final` where a value never changes
- Javadoc comments on classes and non-trivial methods
- Input validation on every console prompt
- Test cases written with expected output, then compared with the real output

## Author

Dharmik, a student learning Java and backend development.