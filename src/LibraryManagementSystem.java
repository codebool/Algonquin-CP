/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-16
 * Modified: 2024-07-16
 * Description: Lab assignment
 */

import java.util.*;

public class LibraryManagementSystem {
    private Map<Integer, Book> books = new HashMap<>();

    private Set<Integer> borrowedBooks = new HashSet<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void borrowBook(int bookId) {
        if (books.containsKey(bookId) && !borrowedBooks.contains(bookId)) {
            borrowedBooks.add(bookId);
        } else {
            System.out.println("Book not found or already borrowed!");
        }
    }

    public void returnBook(int bookId) {
        if (books.containsKey(bookId) && borrowedBooks.contains(bookId)) {
            borrowedBooks.remove(bookId);
        } else {
            System.out.println("Book not found or not borrowed!");
        }
    }

    public void listAvailableBooks() {
        for (int bookId : books.keySet()) {
            if (!borrowedBooks.contains(bookId)) {
                System.out.println(books.get(bookId));
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();

        lms.addBook(new Book(1, "My God it's Java", "Mr. Snapes"));
        lms.addBook(new Book(2, "Where's the poison at", "George Licas"));
        lms.addBook(new Book(3, "Here is the Object", "Penniesworth"));
        lms.addBook(new Book(4, "Coffee Programming", "Roasted Beans"));
        lms.addBook(new Book(5, "Where is my book?", "Charlie Brown"));

        System.out.println("Available books: ");
        lms.listAvailableBooks();

        lms.borrowBook(3);
        lms.borrowBook(4);
        lms.borrowBook(5);

        System.out.println("\nAfter borrowing the available books: ");
        lms.listAvailableBooks();

        lms.returnBook(4);

        System.out.println("\nAfter returning the available book: ");
        lms.listAvailableBooks();
    }
}
