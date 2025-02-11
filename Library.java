import java.util.HashMap;
import java.util.Map;

class Library {
    private Map<Integer, Books> bookCollection = new HashMap<>();

    public void addBook(String bookName, String authorName, int totalQuantity) {
        for(Books book : bookCollection.values()){
            if(book.getBookName().equals(bookName) && book.getAuthorName().equals(authorName)){
                book.returnBook(totalQuantity);
                System.out.println("Book quantity updated successfully! \nNew quantity : " + totalQuantity);
                return;
            }
        }
        Books book = new Books(bookName, authorName, totalQuantity);
        bookCollection.put(book.getBookId(), book);
        System.out.println("Book added successfully!");
        System.out.println("Book : " + book.getBookName() + " Author : " + book.getAuthorName() + " Quantity : " + book.getAvailableQuantity());
        return;
    }

    public void removeBook(int bookId){
        if(bookCollection.containsKey(bookId)){
            bookCollection.remove(bookId);
            System.out.println("Book removed successfully!");
        }else{
            System.out.println("Book not found!");
        }
    }

    public void searchBookByName(String bookName){
        for(Books book : bookCollection.values()){
            if(book.getBookName().equals(bookName)){
                book.displayBook();
                return;
            }
            else{
                System.out.println("Book not found!");
            }
        }
    }

    public void searchBookByAuthor(String authorName){
        for(Books book : bookCollection.values()){
            if(book.getAuthorName().equals(authorName)){
                book.displayBook();
                return;
            }
            else{
                System.out.println("Book not found!");
            }
        }
    }

    public void searchBookById(int bookId){
        if(bookCollection.containsKey(bookId)){
            bookCollection.get(bookId).displayBook();
        }else{
            System.out.println("Book not found!");
        }
    }

    public void DisplayAllBooks(){
        if(bookCollection.isEmpty()){
            System.out.println("No books available!");
            return;
        }
        System.out.println("Available Books:");
        for(Books book : bookCollection.values()){
            book.displayBook();
        }
    }

    public boolean borrowBook(int bookId, int quantity){
        Books book = bookCollection.get(bookId);
        if(book == null){
            System.out.println("Book not found!");
            return false;
        }
        return book.borrowBook(quantity);
    }

    public void returnBook(int bookId,int quantity){
        Books book = bookCollection.get(bookId);
        if(book == null){
            System.out.println("Book not found!");
            return;
        }
        book.returnBook(quantity);
        System.out.println("Book returned successfully!");
    }

    public void updateBookQuantity(int bookId, int quantity){
        Books book = bookCollection.get(bookId);
        if(book == null){
            System.out.println("Book not found!");
            return;
        }
        book.returnBook(quantity);
        System.out.println("Book quantity updated successfully! \nNew quantity : " + book.getAvailableQuantity());
    }
}