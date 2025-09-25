package task3_LibraryManagementSystem;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("City Central Library");

        Author author = new Author("Robert C. Martin", "robert.cmartin@gmail.com");
        Book book1 = new Book("1220123", "Clean Code: A Handbook of Agile Software Craftsmanship", author);
        library.addBook(book1);

        Author author1 = new Author("Craig Walls", "");
        Book book2 = new Book("1220134", "Spring in Action", author1);
        library.addBook(book2);

        Member member = new Member("M001", "Rohan Kumar", "rohan@email.com", "1234456789");
        library.registerMember(member);

        // Issuing book (TEST)
        System.out.println("=== ISSUING BOOK ===");
        boolean issued = library.issueBook("M001", "1220123");
        System.out.println("Issued? " + issued);
        System.out.println("Book available? " + book1.isAvailable());  // false

        System.out.println();

        System.out.println("=== ISSUING BOOK ===");
        boolean issued1 = library.issueBook("M001", "1220134");
        System.out.println("Issued? " + issued1);
        System.out.println("Book available? " + book2.isAvailable());

        // Returning book (TEST)
        System.out.println("\n=== RETURNING BOOK ===");
        boolean returned = library.returnBook("M001", "1220123");
        System.out.println("Returned? " + returned);
        System.out.println("Book available now? " + book1.isAvailable());  // true

        //fail case (no record) (TEST)
        System.out.println("\n=== FAIL CASE ===");
        boolean failReturn = library.returnBook("M001", "999");
        System.out.println("Failed return? " + failReturn);

        // Check member's history
        System.out.println("Member's borrowing history size: " + member.getBorrowingHistory().size());
        for (Member.BorrowingRecord r : member.getBorrowingHistory()) {
            System.out.println("Record: " + r.getBook().getTitle() +
                    " borrowed on " + r.getBorrowDate() +
                    ", returned on " + r.getReturnDate());
        }
    }
}
