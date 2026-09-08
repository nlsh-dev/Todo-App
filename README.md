Java To-Do List Application

A simple and user-friendly desktop To-Do List application built using Java Swing.

This project was developed as part of an internship task to demonstrate Java GUI development, event handling, layout management, and basic MVC architecture.

📌 Project Overview

The Java To-Do List Application allows users to manage daily tasks through a simple desktop interface.

Users can:

Add new tasks

Mark tasks as completed

Delete individual tasks

Clear all completed tasks

Clear all tasks

View the total number of tasks

Press Enter to quickly add tasks

The application is built entirely with Java and Swing and does not require external libraries or frameworks.

🚀 Features

Add Tasks

Enter a task in the input field and click Add Task. You can also press Enter.

Complete Tasks

Select a task and click Complete to toggle its completion status.

Delete Tasks

Select a task and click Delete.

Clear Completed

Removes all tasks marked as completed.

Clear All

Removes all tasks after confirmation.

Task Counter

Displays the current number of tasks.

Scrollable Task List

Uses JScrollPane to support a larger number of tasks.

🛠️ Technologies Used

Java

Java Swing

AWT

IntelliJ IDEA Community Edition

No external dependencies are required.

🏗️ Architecture

The project follows a simple MVC-style architecture.

                    User
                     │
                     ▼
              ┌─────────────┐
              │    View     │
              │ Java Swing  │
              └──────┬──────┘
                     │
                     ▼
              ┌─────────────┐
              │ Controller  │
              │ Event Logic │
              └──────┬──────┘
                     │
                     ▼
              ┌─────────────┐
              │ Repository  │
              │ Data Layer  │
              └──────┬──────┘
                     │
                     ▼
              ┌─────────────┐
              │    Model    │
              │    Todo     │
              └─────────────┘

Model

Todo represents an individual task and stores its ID, title, and completion status.

View

TodoView contains the Swing user interface, including JFrame, JPanel, JLabel, JTextField, JButton, JList, and JScrollPane.

Controller

TodoController handles user interactions and application logic.

Repository

TodoRepository manages the task collection. Tasks are currently stored in memory.

📂 Project Structure

Todo/
│
├── src/
│   └── Todo/
│       ├── Controller/
│       │   └── TodoController.java
│       ├── Model/
│       │   └── Todo.java
│       ├── Repository/
│       │   └── TodoRepository.java
│       ├── View/
│       │   └── TodoView.java
│       └── Main.java
│
├── ScreenShots/
├── .gitignore
└── README.md

▶️ How to Run

Prerequisites

JDK 17 or newer

IntelliJ IDEA Community Edition or Eclipse

Run using IntelliJ IDEA

Open the project in IntelliJ IDEA.

Open src/Todo/Main.java.

Run Main.

The To-Do List desktop application will open.

🧪 Example Tasks

Complete Java assignment
Learn Java Swing
Practice OOP concepts
Create GitHub repository
Write project README
Test the To-Do application
Take screenshots
Submit internship task

📸 Screenshots

Add screenshots of the running application to the ScreenShots folder.

Example:

ScreenShots/
├── todo-app.png
├── completed-task.png
└── add-task.png

Then update the links below if the filenames match:





💡 Concepts Demonstrated

Java Swing

GUI Components

Event Handling

ActionListener

Layout Managers

BorderLayout

FlowLayout

JScrollPane

JList

DefaultListModel

JOptionPane

Event Dispatch Thread

MVC Architecture

Object-Oriented Programming

🎯 Learning Outcomes

Through this project, I learned how to:

Build desktop applications using Java Swing

Create and organize GUI components

Handle user-generated events

Work with layout managers

Manage lists using JList and DefaultListModel

Separate application responsibilities using MVC principles

Use the Event Dispatch Thread

Organize a Java project using packages

🔮 Future Improvements

Permanent task storage using a database or local file

Task deadlines

Task priorities

Task categories

Search functionality

Dark mode

Edit-task functionality

Persistent task storage

👨‍💻 Author

Neelesh

Java Internship Task — Task 6

📄 License

This project was created for educational and internship purposes.