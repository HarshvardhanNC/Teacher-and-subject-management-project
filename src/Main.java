import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Teachers.Teacher;
import Model.Subjects.Subject;
import Model.Teachers.manageTeacher;
import Model.Subjects.manageSubject;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main extends JFrame implements ActionListener {
    private ArrayList<Teacher> teachers;
    private ArrayList<Subject> subjects;
    private manageTeacher teacherManager;
    private manageSubject subjectManager;
    private JPanel mainPanel;
    ObjectMapper mapper = new ObjectMapper();
    Scanner sc = new Scanner(System.in);


    public Main() {
        setTitle("Teacher and Subject Management");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10));
        add(mainPanel);

        JButton addTeacherBtn = new JButton("Add Teacher");
        addTeacherBtn.addActionListener(this);
        mainPanel.add(addTeacherBtn);

        JButton removeTeacherBtn = new JButton("Remove Teacher");
        removeTeacherBtn.addActionListener(this);
        mainPanel.add(removeTeacherBtn);

        JButton viewTeacherDetailBtn = new JButton("View Teacher Detail");
        viewTeacherDetailBtn.addActionListener(this);
        mainPanel.add(viewTeacherDetailBtn);

        JButton viewAllTeachersBtn = new JButton("View All Teachers");
        viewAllTeachersBtn.addActionListener(this);
        mainPanel.add(viewAllTeachersBtn);

        JButton addSubjectBtn = new JButton("Add Subject");
        addSubjectBtn.addActionListener(this);
        mainPanel.add(addSubjectBtn);

        JButton removeSubjectBtn = new JButton("Remove Subject");
        removeSubjectBtn.addActionListener(this);
        mainPanel.add(removeSubjectBtn);

        JButton viewSubjectDetailBtn = new JButton("View Subject Detail");
        viewSubjectDetailBtn.addActionListener(this);
        mainPanel.add(viewSubjectDetailBtn);

        JButton viewAllSubjectsBtn = new JButton("View All Subjects");
        viewAllSubjectsBtn.addActionListener(this);
        mainPanel.add(viewAllSubjectsBtn);

        // Initialize managers
        teacherManager = new manageTeacher();
        subjectManager = new manageSubject();

        // Load data
        teachers = teacherManager.getTable();
        subjects = subjectManager.getTable();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Teacher")) {
            // Logic for adding a teacher
            System.out.println("Add Teacher button clicked");
            System.out.println("How do you wish to create the Teacher Id: ");
            System.out.println("1. Auto Generate Id and Add no other Details");
            System.out.println("2. Auto Generate Id and Add other Details");
            System.out.println("3. Provide Teacher Id");
            System.out.print("Enter your choice: ");
            int teacherIdChoice = sc.nextInt();
            sc.nextLine();

            if (teacherIdChoice == 1) {
                Teacher newTeacher = new Teacher();
                teacherManager.getTable().add(newTeacher);
            } else if (teacherIdChoice == 2) {
                System.out.println("Enter Teacher First Name and Last Name: ");
                String name = sc.nextLine();
                String[] nameSplit = name.split(" ");

                System.out.println("Enter Teacher Email: ");
                String email = sc.nextLine();

                System.out.println("Enter Teacher Address: ");
                String addr = sc.nextLine();

                System.out.println("Enter Teacher Mobile No: ");
                String mobNo = sc.nextLine();

                System.out.println("Enter Teacher CET Percentage: ");
                double cetPercentage = sc.nextDouble();
                sc.nextLine();

                Teacher newTeacher = new Teacher(cetPercentage, nameSplit[0], nameSplit[1], email, addr, mobNo);
                teacherManager.getTable().add(newTeacher);
            } else if (teacherIdChoice == 3) {
                System.out.println("Enter Teacher Id: ");
                int teacherId = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Teacher First Name and Last Name: ");
                String name = sc.nextLine();
                String[] nameSplit = name.split(" ");

                System.out.println("Enter Teacher Email: ");
                String email = sc.nextLine();

                System.out.println("Enter Teacher Address: ");
                String addr = sc.nextLine();

                System.out.println("Enter Teacher Mobile No: ");
                String mobNo = sc.nextLine();

                System.out.println("Enter Teacher CET Percentage: ");
                double cetPercentage = sc.nextDouble();
                sc.nextLine();

                Teacher newTeacher = new Teacher(teacherId, cetPercentage, nameSplit[0], nameSplit[1], email, addr, mobNo);
                teacherManager.getTable().add(newTeacher);
            }

            try {
                teacherManager.writeTeacherJsonFile("src/Model/Teachers/Teachers.json", teacherManager.getTable());
                System.out.println("Teacher added successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        } else if (e.getActionCommand().equals("Remove Teacher")) {
            // Logic for removing a teacher
            System.out.println("Remove Teacher button clicked");
            System.out.print("Enter Teacher Index to Delete: ");
            int teacherIdxDelete = sc.nextInt();
            sc.nextLine();

            if (teacherIdxDelete >= 0 && teacherIdxDelete < teacherManager.getTable().size()) {
                String fname = teacherManager.getTable().get(teacherIdxDelete).getFname();
                String lname = teacherManager.getTable().get(teacherIdxDelete).getLname();
                System.out.println("Teacher Deleted Name: " + fname + " " + lname);
                teacherManager.getTable().remove(teacherIdxDelete);

                try {
                    teacherManager.writeTeacherJsonFile("src/Model/Teachers/Teachers.json", teacherManager.getTable());
                    System.out.println("Teacher removed successfully!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Invalid teacher index!");
            }


        } else if (e.getActionCommand().equals("View Teacher Detail")) {
            // Logic for viewing teacher details
            System.out.println("View Teacher Detail button clicked");
            teachers = teacherManager.readTeacherJsonFile("src/Model/Teachers/Teachers.json");
            System.out.print("Enter Teacher Index to Display: ");
            int teacherIdx = sc.nextInt();
            sc.nextLine();

            if (teacherIdx >= 0 && teacherIdx < teachers.size()) {
                teachers.get(teacherIdx).display();
            } else {
                System.out.println("Invalid teacher index!");
            }


        } else if (e.getActionCommand().equals("View All Teachers")) {
            // Logic for viewing all teachers
            System.out.println("View All Teachers button clicked");

            for(int i = 0; i < teachers.size(); i++)
            {
                teachers.get(i).display();
                System.out.println("-----------------------------");
            }


        } else if (e.getActionCommand().equals("Add Subject")) {
            // Logic for adding a student
            System.out.println("Add Subject button clicked");
            System.out.println("Add Subject button clicked");
            System.out.println("How do you wish to create the Subject Id: ");
            System.out.println("1. Auto Generate Id and Add no other Details");
            System.out.println("2. Auto Generate Id and Add other Details");
            System.out.println("3. Provide Subject Id and Other details");
            System.out.print("Enter your choice: ");
            int subjectIdChoice = sc.nextInt();
            sc.nextLine();

            if (subjectIdChoice == 1) {
                subjects.add(new Subject());
            } else if (subjectIdChoice == 2) {
                System.out.println("Enter Subject Name: ");
                String name = sc.nextLine();
                String[] nameSplit = name.split(" ");

                System.out.println("Enter Subject Duration: ");
                String duration = sc.nextLine();

                System.out.println("Enter Subject Credit: ");
                int credits = sc.nextInt();
                sc.nextLine();

                subjects.add(new Subject(nameSplit[0], duration, credits));

            } else if (subjectIdChoice == 3) {
                System.out.println("Enter Subject Id: ");
                int subjectId = sc.nextInt();
                // To avoid unnecessary skip of input
                sc.nextLine();

                System.out.println("Enter Subject Name: ");
                String name = sc.nextLine();
                String[] nameSplit = name.split(" ");

                System.out.println("Enter Subject Duration: ");
                String duration = sc.nextLine();

                System.out.println("Enter Subject Credit: ");
                int credits = sc.nextInt();
                sc.nextLine();

                subjects.add(new Subject(subjectId, nameSplit[0], duration, credits));
                try {
                    subjectManager.writeSubjectJsonFile("src/Model/Subjects/Subjects.json", subjectManager.getTable());
                    System.out.println("Subject added successfully!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }


        } else if (e.getActionCommand().equals("Remove Subject")) {
            // Logic for removing a Subject
            System.out.print("Enter Subject Index to Delete: ");
            int subjectIdxDelete = sc.nextInt();
            sc.nextLine();

            if (subjectIdxDelete >= 0 && subjectIdxDelete < subjects.size()) {
                String subjectName = subjects.get(subjectIdxDelete).getSubject_name();
                System.out.println("Subject Deleted Name: " + subjectName);
                subjects.remove(subjectIdxDelete);

                try {
                    subjectManager.writeSubjectJsonFile("src/Model/Subjects/Subjects.json", subjectManager.getTable());
                    System.out.println("Subject removed successfully!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Invalid subject index!");
            }


        } else if (e.getActionCommand().equals("View Subject Detail")) {
            // Logic for viewing Subject details
            System.out.println("View Subject Detail button clicked");
            subjects = subjectManager.readSubjectJsonFile("src/Model/Subjects/Subjects.json");
            System.out.print("Enter Subject Index to Display: ");
            int subjectIdx = sc.nextInt();
            sc.nextLine();

            if (subjectIdx >= 0 && subjectIdx < subjects.size()) {
                subjects.get(subjectIdx).display();
            } else {
                System.out.println("Invalid subject index!");
            }


        } else if (e.getActionCommand().equals("View All Subjects")) {
            // Logic for viewing all Subjects
            System.out.println("View All Subjects button clicked");

            for(int i = 0; i < subjects.size(); i++)
            {
                subjects.get(i).display();
                System.out.println("-----------------------------");
            }


        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
