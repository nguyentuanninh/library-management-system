/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbObject;

/**
 *
 * @author Nguyen Minh
 */
public class Book {
    private int bookid;
    private String name;
    private String author;
    private String img;
    private String category;
    private String publisher;
    private String language;
    private int total;
    private int current;
    private String poisition;

    public Book() {
    }

    public Book(int bookid, String name, String author, String img, String category, String publisher, String language, int total, int current, String poisition) {
        this.bookid = bookid;
        this.name = name;
        this.author = author;
        this.img = img;
        this.category = category;
        this.publisher = publisher;
        this.language = language;
        this.total = total;
        this.current = current;
        this.poisition = poisition;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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

    public String getPoisition() {
        return poisition;
    }

    public void setPoisition(String poisition) {
        this.poisition = poisition;
    }

    @Override
    public String toString() {
        return "Book{" + "bookid=" + bookid + ", name=" + name + ", author=" + author + ", img=" + img + ", category=" + category + ", nxb=" + publisher + ", language=" + language + ", total=" + total + ", current=" + current + ", poisition=" + poisition + '}';
    }
    
    
}
