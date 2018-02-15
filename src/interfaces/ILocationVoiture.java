/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.LocationVoiture;

/**
 *
 * @author user
 */
public interface ILocationVoiture {
     public void addAnnonceLocation (LocationVoiture a );
    public void updateAnnonceLocation (LocationVoiture a  );
    public void RemoveAnnonceLocation (int i );
    public LocationVoiture findById( int i);
}
