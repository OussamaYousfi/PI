/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.User;

/**
 *
 * @author Mariem
 */
public interface IuserService extends Iservice <User, Integer> {

   
    public boolean findByLogin (String s);
    public User findByLogin1 (String s);
    public boolean findByPassword (String s);
    public String Gettype(String s);
    
   // public String getpath(String s);
   
    
}
