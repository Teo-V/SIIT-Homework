package Tema2;

public class LibraryCatalog {
    private Book[] books;
    private Integer size;

    public LibraryCatalog(int capacity) {
        books = new Book[capacity];
        size = 0;
    }
    public void add(Book book) {
        books[size] = book;
        size++;
    }
    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public void delete(Book book) {
        for (int i = 0; i < size; i++) {
            if (books[i].getId() == book.getId()) {
                for (int k = i; k < size - 1; k++) {
                    books[k] = books[k + 1];
                }
                books[size] = null;
                size = size - 1;
            }
        }
    }

    public Book findById(int id) {
        for (int i = 0; i < size; i++) {
            if (books[i].getId() == id) {
                return books[i];
            }
        }
        return null;
    }
    public Integer getSize() {
        return size;
    }
}
