import java.util.HashMap;
import java.util.Map;


public class User {
    private static int idCounter = 1;
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String role;
    private Map<Integer, Integer> borrowedBooks = new HashMap<>();

    public User(String userName, String password, String role,String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return userName;
    }

    public String getEmail() {
        return email;
    }   

    public String getRole(){
        return this.role;
    }

    public Boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void borrowBook(int bookId){
        borrowedBooks.put(bookId,bookId);
    }

}