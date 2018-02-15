/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import javafx.collections.ObservableList;
import models.Message;

import models.User;

/**
 *
 * @author Mariem
 */
public interface IMessage {
    void add(Message m);
    void remove(Integer r);
    List<Message> getConversationByUsersId(User u1,User u2);
    public List<String> GetConversationByUsersId(User u1, User u2);
    public List<Message> getAll();
     
    public ObservableList<Message> displayallmessages();
    public ObservableList<Message> displayallmessagesrecus();
       public void deletebytext(String texte);
       
}
