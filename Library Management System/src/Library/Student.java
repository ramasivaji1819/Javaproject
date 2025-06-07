package Library;

public class Student {
    public String id;
    public String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + "," + name;
    }

    public static Student fromString(String line) {
        String[] parts = line.split(",");
        return new Student(parts[0], parts[1]);
    }
}

