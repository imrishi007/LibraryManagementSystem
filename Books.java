class Books {
    private static int count = 1; // Auto-incremented book ID
    private int bookId;
    private String bookName;
    private String authorName;
    private int totalQuantity;
    private int availableQuantity;

    public Books(String bookName, String authorName, int totalQuantity) {
        this.bookId = count++;
        this.bookName = bookName;
        this.authorName = authorName;
        this.totalQuantity = totalQuantity;
        this.availableQuantity = totalQuantity;
    }

    // Getters
    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }
    
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public boolean borrowBook(int quantity){
        if(quantity > availableQuantity){
            System.out.println("Only "+ availableQuantity + " books are available.");
            return false;
        }
        availableQuantity-= quantity;
        return true;
    }

    public void returnBook(int quantity){
        availableQuantity+= quantity;
        if(availableQuantity > totalQuantity){
            availableQuantity = totalQuantity;
        }
    }
    public void displayBook(){
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author Name: " + authorName);
        System.out.println("Total Quantity: " + totalQuantity);
        System.out.println("Available Quantity: " + availableQuantity);
    }
}