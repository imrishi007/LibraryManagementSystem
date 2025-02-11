import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();  // Manages books
        UserManager userManager = new UserManager();  // Manages users
        User loggedInUser = null;

        while (true) {
            if (loggedInUser == null) {
                loggedInUser = authenticationMenu(sc, userManager);
            } else {
                if (loggedInUser.getRole().equals("admin")) {
                    adminMenu(sc, library, userManager, loggedInUser);
                } else {
                    userMenu(sc, library, loggedInUser);
                }
            }
        }
    }

    //Authentication Menu (Register/Login)
    private static User authenticationMenu(Scanner sc, UserManager userManager) {
        while (true) {
            System.out.println("\n--- Welcome to the Library Management System! ---");
            System.out.println("1️Register");
            System.out.println("2️Login");
            System.out.println("3️Exit");
            System.out.print("Enter choice: ");


            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    return registerUser(sc, userManager);
                case 2:
                    return loginUser(sc, userManager);
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    //Register a new user
    private static User registerUser(Scanner sc, UserManager userManager) {
        System.out.print("Enter username: ");
        String regUsername = sc.nextLine();
        System.out.print("Enter password: ");
        String regPassword = sc.nextLine();
        System.out.print("Enter email: ");
        String regEmail = sc.nextLine();
        System.out.print("Enter role (admin/user): ");
        String regRole = sc.nextLine();

        String adminCode = "";
        if (regRole.equalsIgnoreCase("admin")) {
            System.out.print("Enter Admin Verification Code: ");
            adminCode = sc.nextLine();
        }

        userManager.registerUser(regUsername, regPassword, regEmail, regRole);
        return null;
    }

    //Login user
    private static User loginUser(Scanner sc, UserManager userManager) {
        System.out.print("Enter username: ");
        String loginUsername = sc.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = sc.nextLine();
        return userManager.loginUser(loginUsername, loginPassword);
    }

    //Admin Menu (Admin can do everything - Manage the users as well as the books in library!)
    private static void adminMenu(Scanner sc, Library library, UserManager userManager, User admin) {
        while (true) {
                System.out.println("\n--- Admin Panel ---");
                System.out.println("1. Manage Users");
                System.out.println("2. Manage Books");
                System.out.println("3. Logout");

                int choice = sc.nextInt();
                sc.nextLine();

                switch(choice){
                    case 1:
                        manageBooks(sc, library);
                        break;
                    case 2:
                        manageUsers(sc, userManager, admin);
                        break;
                    case 3:
                        System.out.println("Logged out successfully.");
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        }

    //User Menu (Search, Borrow, Return)
    private static void userMenu(Scanner sc, Library library, User user) {
        while (true) {
            System.out.println("\n--- User Dashboard ---");
            System.out.println("1. Search a book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book name: ");
                    String bookName = sc.nextLine();
                    library.searchBookByName(bookName);
                    break;
                case 2:
                    System.out.print("Enter book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    library.borrowBook(bookId, quantity);
                    break;
                case 3:
                    System.out.print("Enter book Id to return : ");
                    int returnBookId = sc.nextInt();
                    System.out.print("Enter quantity to return : ");
                    int returnQuantity = sc.nextInt();
                    sc.nextLine();
                    library.returnBook(returnBookId, returnQuantity);
                    break;
                case 4:
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void manageBooks(Scanner sc, Library library){
        while(true){
            System.out.println("--- Book Management ---");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search a book by name");
            System.out.println("4. Search a book by author");
            System.out.println("5. Update book quantity");
            System.out.println("6. List all books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Enter book name: ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String authorName = sc.nextLine();
                    System.out.print("Enter total quantity: ");
                    int totalQuantity = sc.nextInt();
                    sc.nextLine();
                    library.addBook(bookName, authorName, totalQuantity);
                    break;
                case 2:
                    System.out.print("Enter book ID to remove: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    library.removeBook(bookId);
                    break;
                case 3:
                    System.out.print("Enter book name to search: ");
                    String searchBookName = sc.nextLine();
                    library.searchBookByName(searchBookName);
                    break;
                case 4:
                    System.out.print("Enter author name to search: ");
                    String searchAuthorName = sc.nextLine();
                    library.searchBookByAuthor(searchAuthorName);
                    break;
                case 5:
                    System.out.print("Enter book ID to update quantity: ");
                    int updateBookId = sc.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = sc.nextInt();
                    sc.nextLine();
                    library.updateBookQuantity(updateBookId, newQuantity);
                    break;
                case 6:
                    library.DisplayAllBooks();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void manageUsers(Scanner sc, UserManager userManager, User admin){
        while(true){
            System.out.println("--- User Management ---");
            System.out.println("1. List all users");
            System.out.println("2. Remove a user");
            System.out.println("3. Add a new user (Admin or Normal)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    userManager.listAllUsers(admin);
                    break;
                case 2:
                    System.out.print("Enter username to remove: ");
                    String removeUsername = sc.nextLine();
                    userManager.removeUser(removeUsername, admin);
                    return;
                case 3:
                    System.out.print("Enter username: ");
                    String regUsername = sc.nextLine();
                    System.out.print("Enter password: ");
                    String regPassword = sc.nextLine();
                    System.out.print("Enter email: ");
                    String regEmail = sc.nextLine();
                    System.out.print("Enter role (admin/user): ");
                    String regRole = sc.nextLine();
                    
                    if(regRole.equalsIgnoreCase("admin") && !regRole.equalsIgnoreCase("user")){
                        System.out.println("Invalid role! Try again.");
                        return;
                    }
                    userManager.addUsersByAdmin(regUsername, regPassword, regEmail, regRole, admin);
                    break;
                case 4:
                    System.out.println ("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}