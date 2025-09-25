package task3_LibraryManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String memberID;
    private final String name;
    private String email;
    private String contactNumber;

    // Member HAS-A list of records
    private List<BorrowingRecord> borrowingHistory = new ArrayList<>();

    public Member(String memberID, String name, String email, String contactNumber ) {
        if(memberID == null || name == null) {
            throw new IllegalArgumentException("Member ID and name cannot be null! ");
        }
        if (contactNumber == null || !contactNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Contact number must be exactly 10 digits!");
        }
       this.memberID = memberID;
       this.name = name;
       this.email = email;
       this.contactNumber = contactNumber;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public List<BorrowingRecord> getBorrowingHistory() {
        return new ArrayList<>(borrowingHistory);
    }

    public boolean canBorrowMoreBooks() {
        return borrowingHistory.size() < 5 ;
    }

    public void addBorrowingRecord(BorrowingRecord record) {
        if(record != null) {
            borrowingHistory.add(record);
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + memberID + '\''+
                ", name='" + name + '\'' +
                ", activeLoans" + borrowingHistory.size() +
                '=' +
                "}";
    }

    public static class BorrowingRecord {
        private final Book book;
        private LocalDate borrowDate;
        private LocalDate returnDate;


        //with default date
        public BorrowingRecord(Book book) {
            this.book = book;
            this.borrowDate = LocalDate.now(); // Default: Today
            this.returnDate = null; // if not returned
        }

        //with custom date
        public BorrowingRecord(Book book, LocalDate borrowDate, LocalDate returnDate){
            this.book = book;
            this.borrowDate = borrowDate;
            this.returnDate = returnDate;
        }
        public Book getBook() {
            return book;
        }

        public LocalDate getBorrowDate() {
            return borrowDate;
        }

        public LocalDate getReturnDate() {
            return returnDate;
        }

        public void setReturnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
        }
    }
}
