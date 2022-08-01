import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
	String address;
	ArrayList <Book> bookList;
	
	
	public Library(String libraryAddress) {
		address = libraryAddress;
		this.bookList = new ArrayList<>();
	}
	
	public static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	public void printAddress() {
		System.out.println(address);
	}
	
	public void addBook(Book newBook) {
		bookList.add(newBook);
	}
	
	public void borrowBook(String title) {
		Book bookSearch = null;
		for (Book book: this.bookList) {
			if(title.equals(book.getTitle())) {
				if (book.isBorrowed()) {
					System.out.printf("Sorry, %s is already borrowed.", title);
					bookSearch = book;
					return;
					
				} else {
					System.out.println("You successfully borrowed " + book.getTitle());
					bookSearch= book;
					book.borrowed();
					return;
				}
			}
		}
		
		if(bookSearch == null) {
				System.out.println();
				System.out.printf("Sorry, %s is not in our catalog.", title);
				System.out.println();
			}
	}
	
	public void printAvailableBooks(){
		if(this.bookList.isEmpty()) {
			System.out.println("No books in catalog ");
		}else {
			for(Book book: this.bookList) {
				if(book.isBorrowed() == false) {
					System.out.println(book.getTitle());
					continue;
				} else {
					return;
				}
			}
		}
	}
	
	
	public void returnBook(String title) {
		for(Book book: this.bookList) {
			if(title.equals(book.getTitle())) {
				book.returned();
				System.out.println("You successfully returned the Lord of the Rings!");
				break;
			}
		}
	}
	
	
	
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        //Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
      
        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();        

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
