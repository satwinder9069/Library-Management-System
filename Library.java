package task3_LibraryManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Library {
    private final String libraryName;
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public Library(String libraryName) {
        if(libraryName == null || libraryName.trim().isEmpty()) {
            throw new IllegalArgumentException("Library name cannot be null or empty!");
        }
        this.libraryName = libraryName;
    }

    public void addBook(Book book) {
        if(book != null && !books.contains(book)) {
            books.add(book);
        }
    }

    public void registerMember(Member member) {
        if(member != null && !members.contains(member)) {
            members.add(member);
        }
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + libraryName + '\'' +
                ", totalBooks=" + books.size() +
                ", totalMembers=" + members.size() +
                '}';
    }

    public boolean issueBook(String memberId, String bookISBN) {
        Member member = null;
        for(Member m : members) {
            if(m.getMemberID().equals(memberId)){
                member = m;
                break;
            }
        }
        if(member == null){
            System.out.println("Member not found" + memberId);
            return false;
        }

        Book book = null;
        for(Book b : books) {
            if(b.getISBN().equals(bookISBN)) {
                book = b;
                break;
            }
        }
        if(book == null) {
            System.out.println("Book not found" + bookISBN);
            return false;
        }

        if(!book.isAvailable()){
            System.out.println("Book not available: " + book.getTitle());
           return false;
        }

        if(!member.canBorrowMoreBooks()){
            System.out.println("Member reached borrow limit: " + member.getName());
            return false;
        }

        book.setAvailable(false);

        Member.BorrowingRecord record = new Member.BorrowingRecord(book);
        member.addBorrowingRecord(record);
        System.out.println("Book issued successfully to " + member.getName() + " for " + book.getTitle());
        return true;
    }

    public boolean returnBook(String memberId, String bookISBN) {
        Member member = null;
        for(Member m : members) {
            if(m.getMemberID().equals(memberId)){
                member = m;
                break;
            }
        }
        if(member == null){
            System.out.println("Member not found" + memberId);
            return false;
        }

        Book book = null;
        for(Book b : books) {
            if(b.getISBN().equals(bookISBN)) {
                book = b;
                break;
            }
        }
        if(book == null) {
            System.out.println("Book not found" + bookISBN);
            return false;
        }

        Member.BorrowingRecord record = null;
        for(Member.BorrowingRecord r : member.getBorrowingHistory()){
            if(r.getBook().getISBN().equals(bookISBN) && r.getReturnDate() == null){
                record = r;
                break;
            }
        }
        if(record == null){
            System.out.println("No active record for " + book.getTitle() + " by " + member.getName());
            return false;
        }

        record.setReturnDate(LocalDate.now());
        book.setAvailable(true);

        System.out.println("Book returned successfully by " + member.getName() + " for " + book.getTitle() + " on " + LocalDate.now());
        return true;
    }
}