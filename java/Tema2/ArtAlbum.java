package Tema2;


public class ArtAlbum extends Book {
        private String paperQuality;


        public ArtAlbum(int id, String name, int numberOfPages, String paperQuality) {
            super(id, name, numberOfPages);
            this.paperQuality = paperQuality;
        }

        public String getPaperQuality() {
            return paperQuality;
        }

        @Override
        public String toString() {
            return "ArtAlbum{" +
                    "id='" + id + '\'' +
                    ", name='" + name + "', " +
                    "numberOfPages='" + numberOfPages + "', " +
                    "paperQuality='" + paperQuality + '\'' +
                    '}';
        }
}
