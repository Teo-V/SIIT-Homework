package LibraryCatalog;

public class Book {
        protected String name;
        protected int numberOfPages;
        protected int id;


        public Book(int id, String name, int numberOfPages) {
            this.id = id;
            this.name = name;
            this.numberOfPages = numberOfPages;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getNumberOfPages() {
            return numberOfPages;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", numberOfPages=" + numberOfPages +
                    '}';
        }
}
