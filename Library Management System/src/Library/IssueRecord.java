package Library;

public class IssueRecord {
    public String bookId;
    public String studentId;

    public IssueRecord(String bookId, String studentId) {
        this.bookId = bookId;
        this.studentId = studentId;
    }

    public String toString() {
        return bookId + "," + studentId;
    }

    public static IssueRecord fromString(String line) {
        String[] parts = line.split(",");
        return new IssueRecord(parts[0], parts[1]);
    }
}
