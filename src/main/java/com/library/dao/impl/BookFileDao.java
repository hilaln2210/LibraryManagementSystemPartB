package com.library.dao.impl;

import com.library.dao.IDao;
import com.library.models.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookFileDao implements IDao<Book> {
    private String filePath;

    public BookFileDao(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void add(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(book.getId() + "," + book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book get(int id) {
        return getAll().stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int bookId = Integer.parseInt(parts[0]);
                    String isbn = parts[1];
                    String title = parts[2];
                    String author = parts[3];
                    books.add(new Book(bookId, isbn, title, author));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void delete(int id) {
        List<Book> books = getAll();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Book book : books) {
                if (book.getId() != id) {
                    writer.write(book.getId() + "," + book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
