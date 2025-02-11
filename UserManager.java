import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserManager {
    private List<User> users = new ArrayList<>();
    private final String ADMIN_SECRET_CODE = "ad123"; // Secret admin verification code

    // Register a new user with admin verification
    public void registerUser(String username, String password, String email, String role) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the admin code: ");
        String adminCode = sc.nextLine();
        if(adminCode != ADMIN_SECRET_CODE){
            System.out.println("Invalid admin code. You cannot register as an admin.");
            return;
        }
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Username already exists. Try another.");
                return;
            }
            if (user.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Email already registered.");
                return;
            }
        }

        // If role is admin, verify the admin code
        if (role.equalsIgnoreCase("admin")) {
            if (!adminCode.equals(ADMIN_SECRET_CODE)) {
                System.out.println("Invalid admin code. You cannot register as an admin.");
                return;
            }
        }

        users.add(new User(username, password, email, role));
        System.out.println("User registered successfully as " + role + "!");
    }

    // Verify admin status on login
    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.checkPassword(password)) {
                if (user.getRole().equals("admin")) {
                    System.out.println("Admin access granted!");
                } else {
                    System.out.println("Login successful! Welcome, " + username);
                }
                return user;
            }
        }
        System.out.println("Invalid username or password.");
        return null;
    }

    public void listAllUsers(User loggedInUser) {
        if (!loggedInUser.getRole().equals("admin")) {
            System.out.println("Only admins can view all users.");
            return;
        }
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        System.out.println("Registered Users:");
        for (User user : users) {
            System.out.println("ID: " + user.getUserId() + " | Username: " + user.getUsername() + " | Role: " + user.getRole());
        }
    }
    public void removeUser(String username, User admin){
        if(!admin.getRole().equals("admin")){
            System.out.println("Only admins can remove users.");
            return;
        }
        if(admin.getUsername().equalsIgnoreCase(username)){
            System.out.println("Admin cannot remove itself.");
            return;
        }
        for(User user: users){
            if(user.getUsername().equalsIgnoreCase(username)){
                users.remove(user);
                System.out.println("User removed successfully.");
                return;
            }
        }
        System.out.println("User not found.");
    }

    public void addUsersByAdmin(String username, String password, String email, String role, User loggedInUser){
        if(!loggedInUser.getRole().equalsIgnoreCase("admin")){
            System.out.println("Only admins can add users.");
            return;
        }

        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(username)){
                System.out.println("Username already exists. Try another.");
                return;
            }
            if(user.getEmail().equalsIgnoreCase(email)){
                System.out.println("Email already registered.");
                return;
            }
        }
        users.add(new User(username,password,email,role.toLowerCase()));
        System.out.println("User added successfully!");
    }
}