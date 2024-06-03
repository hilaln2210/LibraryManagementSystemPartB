package com.library.models;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;

    public Book(int id, String isbn, String title, String author) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", isbn='" + isbn + "', title='" + title + "', author='" + author + "'}";
    }
}
