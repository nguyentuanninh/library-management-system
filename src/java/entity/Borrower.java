/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Nguyen Minh
 */
public class Borrower {
    private int id;
    private String username;
    private int bookid;
    private String borrow_from;
    private String borrow_to;
    private String status;
    private boolean late;
    
    public Borrower() {
    }

    public Borrower(int id, String username, int bookid, String borrow_from, String borrow_to, String status) {
        this.id = id;
        this.username = username;
        this.bookid = bookid;
        this.borrow_from = borrow_from;
        this.borrow_to = borrow_to;
        this.status = status;
        this.late= false;
    }
    
    public Borrower(int id, String username, int bookid, String status){
        this.id = id;
        this.username = username;
        this.bookid = bookid;
        this.borrow_from = null;
        this.borrow_to = null;
        this.status = status;
        this.late= false;
    }

    public boolean isLate() {
        return late;
    }

    public void setLate(boolean late) {
        this.late = late;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBorrow_from() {
        return borrow_from;
    }

    public void setBorrow_from(String borrow_from) {
        this.borrow_from = borrow_from;
    }

    public String getBorrow_to() {
        return borrow_to;
    }

    public void setBorrow_to(String borrow_to) {
        this.borrow_to = borrow_to;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Borrower_Table{" + "username=" + username + ", bookid=" + bookid + ", borrow_from=" + borrow_from + ", borrow_to=" + borrow_to + ", status=" + status + '}';
    }
   
    
}
