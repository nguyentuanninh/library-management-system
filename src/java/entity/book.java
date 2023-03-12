/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Nguyen Minh
 */
public class Book {

    private int bookid;
    private String name;
    private String author;
    private String img;
    private int category;
    private String publisher;
    private String language;
    private int total;
    private int current;
    private String position;

    public Book() {
    }

    public Book(int bookid, String name, String author, String img, int category, String publisher, String language, int total, int current, String position) {
        this.bookid = bookid;
        this.name = name;
        this.author = author;
        this.img = img;
        this.category = category;
        this.publisher = publisher;
        this.language = language;
        this.total = total;
        this.current = current;
        this.position = position;
    }

    public Book(int bookid, String name, String author, int category, String publisher, String language, int total, int current, String position) {
        this.bookid = bookid;
        this.name = name;
        this.author = author;
        this.img = "img/book/book.jpg";
        this.category = category;
        this.publisher = publisher;
        this.language = language;
        this.total = total;
        this.current = current;
        this.position = position;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String nxb) {
        this.publisher = nxb;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
