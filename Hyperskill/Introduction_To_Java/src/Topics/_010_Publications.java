package Topics;

import java.util.Scanner;

public class _010_Publications {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");

        switch (input[0]) {
            case "Publication" -> {
                Publication publication = new Publication(input[1]);
                System.out.println(publication.getDetails());
            }
            case "Newspaper" -> {
                Newspaper newspaper = new Newspaper(input[1], input[2]);
                System.out.println(newspaper.getDetails());
            }
            case "Article" -> {
                Article article = new Article(input[1], input[2]);
                System.out.println(article.getDetails());
            }
            case "Announcement" -> {
                Announcement announcement = new Announcement(input[1], Integer.parseInt(input[2].trim()));
                System.out.println(announcement.getDetails());
            }
        }

    }

    public static class Publication {

        private String title;

        public Publication(String title) {
            this.title = title;
        }

        public String getDetails() {
            return "title=\"" + title.trim() + "\"";
        }
    }

    public static class Newspaper extends Publication {

        private String source;

        public Newspaper(String title, String source) {
            super(title);
            this.source = source;
        }

        @Override
        public String getDetails() {
            return super.getDetails() + ", source=\"" + source.trim() + "\"";
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
            return super.getDetails() + ", author=\"" + author.trim() + "\"";
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
            return super.getDetails() + ", daysToExpire=" + daysToExpire;
        }

    }

}
