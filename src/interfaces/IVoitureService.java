/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.User;
import models.voiture;



/**
 *
 * @author Nourelhouda
 */
public interface IVoitureService extends Iservice <voiture, Integer> {
    
    List<voiture> getByUser(User user );
     void removeAll(); 
    
}
