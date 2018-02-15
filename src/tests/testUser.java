package tests;

import java.sql.Date;
import java.sql.SQLException;
import interfaces.IuserService;
import models.Actualite;
import models.Message;
import models.Pub;
import models.User;
import models.voiture;
import services.ActualiteService;
import services.MessageService;

import services.PubService;
import services.UserService;
import services.VoitureService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mariem
 */
public class testUser {

    public static void main(String[] args) throws SQLException {
       String a = "admin";
        User u = new User("Mariem", "Hasnaoui", 14253140, "mariem.hasnaoui@esprit.tn", 92339150, "mimi", "123456", a,"","");
        
        User u2 = new User("Ahmed", "Yousfi", 14253140, "Ahmed.yousfi@esprit.tn", 55676850, "bohmid", "545", a, "", "");
        //User u1 = new User(3,"yousfi", "Oussama", 07202627, "oussama.yousfi@esprit.tn", 97426342, "mourouj", "oussamaa", "123456", "", "admin", "");
        IuserService userService = new UserService();
        //userService.add(u);
        userService.add(u2);

        Message M = new Message(u, u2, "salut");
        MessageService me = new MessageService();
        me.add(M);
        /*Date date= Date.valueOf("2014-01-25");
        Actualite a = new Actualite(u2, "mohamed","fdgdg",date,"hafseyya","dgsg");
        ActualiteService A = new ActualiteService();
        A.add(a);
        A.getAll();*/
        // MessageService.envoyer(M);
        // System.out.println(userService.getAll()); 

        ///////////////TEST VOITURE \\\\\\\\\\\\\\\\\
        // VoitureService vs = new VoitureService() ; 
        //u.setId(2);
        //voiture v1= new voiture (3,u,"fiat","123Tun4430","2/12/2012","12/12/2012", "12/12/2012","12/12/2012") ;
        //vs.add(v1); 
        //vs.remove(3); 
        ///////////TEST PUB \\\\\\\\\\\\\\\
        //PubService ps = new PubService() ;
        //Pub p = new Pub(1,u,"titre1","desc1","15/10/2017","path1") ;
        //ps.add(p);
        //ps.removeAll();
        // ps.add(p); 
    }
}
