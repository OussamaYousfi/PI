/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.VenteOccasion;



/**
 *
 * @author user
 */
public interface IVenteOccasion {
     public void addAnnonceventeOccasion (VenteOccasion a );
    public void updateventeOccasion (VenteOccasion a  );
    public void RemoveventeOccasion (int i );
    public VenteOccasion findById( int i);
}
