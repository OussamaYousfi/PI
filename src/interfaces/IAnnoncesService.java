/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Annonces;
import java.util.List;

/**
 *
 * @author user
 */
public interface IAnnoncesService extends Iservice <Annonces,Integer>{
    public void addAnnonce (Annonces a );
    public List<Annonces> getNonValid();
  
    
    
}
