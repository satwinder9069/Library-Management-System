package task3_LibraryManagementSystem;

public class Author {
    private final String name;
    private String email;

    public Author(String name, String email) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty!");
        }
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + (email !=null ? " <" + email + "> " : "");
    }
}
