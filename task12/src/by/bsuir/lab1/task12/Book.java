package by.bsuir.lab1.task12;

import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int price;
    private int isbn;
    private static int edition;

    public void implementComparators() {
        Comparator<Book> titleComparator = new Comparator<Book>() {
            @Override
            public int compare(Book src, Book dst) {
                return src.title.compareTo(dst.title);
            }
        };

        Comparator<Book> authorComparator = new Comparator<Book>() {
            @Override
            public int compare(Book src, Book dst) {
                return src.author.compareTo(dst.author);
            }
        };

        Comparator<Book> priceComparator = new Comparator<Book>() {
            @Override
            public int compare(Book src, Book dst) {
                return src.price - dst.price;
            }
        };

        Comparator<Book> titleAuthorComparator = titleComparator.thenComparing(authorComparator);
        Comparator<Book> authorTitleComparator = authorComparator.thenComparing(titleComparator);
        Comparator<Book> titlePriceComparator = titleComparator.thenComparing(priceComparator);
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return this == obj || title == book.title && price == book.price && author == book.author;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price, edition);
    }

    @Override
    public String toString() {
        return title + " (" + author + "; " + edition + ") :" + price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Book other) {
        return isbn - other.isbn;
    }
}
