package LibraryCatalog;

public class Novel extends Book {
        private String type;

        public Novel(int id, String name, int numberOfPages, String type) {
            super(id, name, numberOfPages);
            this.type = type;

        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Novel{" +
                    "id='" + id + '\'' +
                    ", name='" + name + "', " +
                    "numberOfPages='" + numberOfPages + "', " +
                    "type='" + type + '\'' +
                    '}';
        }
}
