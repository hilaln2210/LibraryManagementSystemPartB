package com.library.services;

import com.library.dao.IDao;
import com.library.models.Book;

import java.util.List;

public class BookService {
    private IDao<Book> bookDao;

    public BookService(IDao<Book> bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(Book book) {
        bookDao.add(book);
    }

    public Book getBookById(int id) {
        return bookDao.get(id);
    }

    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    public void deleteBook(int id) {
        bookDao.delete(id);
    }
}
