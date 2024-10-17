#PROJECT TITLE: Student Grading System

Description: This project is a comprehensive Student Grading System designed to allow teachers to manage students’ information, assign grades, and (if there is enough time) generate course reports. The system ensures easy grade entry and calculates final grades based on various inputs. Users (teachers) can interact with the system through a graphical interface, making it more intuitive and user-friendly. 
Additionally, the system enforces input validation to avoid errors such as invalid grades or missing information.

#FEATURES:

1.	Student and Grade Management:
●	Teachers can add, remove, or modify student information and assign grades for multiple courses.
●	Each student’s grades are stored and can be edited as necessary.
●	Input validation will ensure grades are between 0-100 and that all fields (name, ID, course) are correctly entered.

2.	Grade Calculation:
●	The system will support various grading schemes (e.g., letter grades or percentage grades).
●	Teachers will be able to calculate the final grade for a student, taking into account weighted averages for different assignments or exams.
3.	Optional features(If time permits):
●	The system will generate reports showing each student’s performance in different subjects, their final grades, and overall ranking.
●	The reports can be printed directly in the console or displayed using a GUI (JavaFX or Swing).
●	Reports can be exported to a text file for future reference.

#LIBRARIES:

1.	JavaFX(for graphical user interface development)
2.	JUnit (for testing methods such as grade calculation and student data validation)
