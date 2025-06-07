package Library;

public class Book {
    public String id;
    public String title;
    public String author;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return id + "," + title + "," + author;
    }

    public static Book fromString(String line) {
        String[] parts = line.split(",");
        return new Book(parts[0], parts[1], parts[2]);
    }
}

