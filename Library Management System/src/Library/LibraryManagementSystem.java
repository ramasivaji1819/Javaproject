package Library;


import java.io.*;
import java.util.*;

public class LibraryManagementSystem {
    static final String BOOK_FILE = "books.txt";
    static final String STUDENT_FILE = "students.txt";
    static final String ISSUE_FILE = "issues.txt";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Student");
            System.out.println("4. View Students");
            System.out.println("5. Issue Book");
            System.out.println("6. View Issued Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> addStudent();
                case 4 -> viewStudents();
                case 5 -> issueBook();
                case 6 -> viewIssued();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addBook() throws IOException {
        System.out.print("Book ID: ");
        String id = sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();

        Book b = new Book(id, title, author);
        writeToFile(BOOK_FILE, b.toString());
    }

    static void viewBooks() throws IOException {
        List<String> lines = readFromFile(BOOK_FILE);
        System.out.println("--- Books ---");
        for (String line : lines)
            System.out.println(Book.fromString(line));
    }

    static void addStudent() throws IOException {
        System.out.print("Student ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();

        Student s = new Student(id, name);
        writeToFile(STUDENT_FILE, s.toString());
    }

    static void viewStudents() throws IOException {
        List<String> lines = readFromFile(STUDENT_FILE);
        System.out.println("--- Students ---");
        for (String line : lines)
            System.out.println(Student.fromString(line));
    }

    static void issueBook() throws IOException {
        System.out.print("Book ID: ");
        String bookId = sc.nextLine();
        System.out.print("Student ID: ");
        String studentId = sc.nextLine();

        IssueRecord ir = new IssueRecord(bookId, studentId);
        writeToFile(ISSUE_FILE, ir.toString());
    }

    static void viewIssued() throws IOException {
        List<String> lines = readFromFile(ISSUE_FILE);
        System.out.println("--- Issued Books ---");
        for (String line : lines)
            System.out.println(IssueRecord.fromString(line));
    }

    static void writeToFile(String fileName, String line) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        fw.write(line + "\n");
        fw.close();
    }

    static List<String> readFromFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        File f = new File(fileName);
        if (!f.exists()) return lines;
        BufferedReader br = new BufferedReader(new FileReader(f));
        String l;
        while ((l = br.readLine()) != null)
            lines.add(l);
        br.close();
        return lines;
    }
}
