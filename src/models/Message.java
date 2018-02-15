/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariem
 */
public class Message {
    private int id_msg;
    private User user1 ;
    private User user2;
    private String message;
    private Date date;
    
    public Message() {
    }

    public Message(int id_msg, User user1, User user2, String message) {
        this.id_msg = id_msg;
        this.user1 = user1;
        this.user2 = user2;
        this.message = message;
        
    }

    public Message(User user1, Date date) {
        this.user1 = user1;
        this.date = date;
    }
    
public Message(User user1, User user2, String message) {
        this.user1 = user1;
        this.user2 = user2;
        this.message = message;
        
     
    }

    public Message(User user1, String message, Date date) {
        this.user1 = user1;
        this.message = message;
        this.date = date;
    }

    public Message(User user1, User user2, String message, Date date) {
        this.user1 = user1;
        this.user2 = user2;
        this.message = message;
        this.date = date;
    }
    


    public Message(int id_msg, User user1, User user2, String message, Date date) {
        this.id_msg = id_msg;
        this.user1 = user1;
        this.user2 = user2;
        this.message = message;
        this.date = date;
    }

    public Message(String message) {
        
        this.message = message;
    }
    

    public int getId_msg() {
        return id_msg;
    }

    public void setId_msg(int id_msg) {
        this.id_msg = id_msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getname(User u)
    {
        return u.getNom();
    }

    @Override
    public String toString() {
        return "Message{" + "id_msg=" + id_msg + ", user1=" + user1 + ", user2=" + user2 + ", message=" + message + ", date=" + date + '}';
    }
    
}