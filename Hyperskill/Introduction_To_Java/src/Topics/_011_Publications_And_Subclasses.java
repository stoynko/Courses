package Topics;

import java.util.Scanner;

public class _011_Publications_And_Subclasses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");

        switch (input[0]) {
            case "Publication" -> {
                Publication publication = new Publication(input[1]);
                System.out.println(publication.getInfo());
            }
            case "Newspaper" -> {
                Newspaper newspaper = new Newspaper(input[1], input[2]);
                System.out.println(newspaper.getInfo());
            }
            case "Article" -> {
                Article article = new Article(input[1], input[2]);
                System.out.println(article.getInfo());
            }
            case "Announcement" -> {
                Announcement announcement = new Announcement(input[1], Integer.parseInt(input[2].trim()));
                System.out.println(announcement.getInfo());
            }
        }

    }

    public static class Publication {

        private String title;

        public Publication(String title) {
            this.title = title;
        }

        public String getDetails() {
            return title;
        }

        public String getType() {
            return "Publication: ";
        }

        public final String getInfo() {
            return getType() + getDetails();
        }
    }

    public static class Newspaper extends Publication {

        private String source;

        public Newspaper(String title, String source) {
            super(title);
            this.source = source;
        }


        @Override
        public String getType() {
            return "Newspaper ";
        }

        @Override
        public String getDetails() {
            return "(source - " + source + "): " + super.getDetails();
        }
    }

    public static class Article extends Publication {

        private String author;

        public Article(String title, String author) {
            super(title);
            this.author = author;
        }


        @Override
        public String getDetails() {
            return "(author - " + author + "): " + super.getDetails();
        }

        @Override
        public String getType() {
            return "Article ";
        }
    }

    public static class Announcement extends Publication {

        private int daysToExpire;

        public Announcement(String title, int daysToExpire) {
            super(title);
            this.daysToExpire = daysToExpire;
        }


        @Override
        public String getDetails() {
            return "(days to expire - " + daysToExpire + "): " + super.getDetails();
        }

        @Override
        public String getType() {
            return "Announcement ";
        }
    }

}
