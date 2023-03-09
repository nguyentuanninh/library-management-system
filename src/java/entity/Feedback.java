/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Nguyen Minh
 */
public class Feedback{
    private int feedbackid;
    private String title;
    private String feedback;
    private String studentID;

    public Feedback() {
    }

    public Feedback(int feedbackid, String title, String feedback, String studentID) {
        this.feedbackid = feedbackid;
        this.title = title;
        this.feedback = feedback;
        this.studentID = studentID;
    }

    public int getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(int feedbackid) {
        this.feedbackid = feedbackid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    @Override
    public String toString() {
        return "Feedback{" + "feedbackid=" + feedbackid + ", title=" + title + ", feedback=" + feedback + ", studentID=" + studentID + '}';
    }
 
}

