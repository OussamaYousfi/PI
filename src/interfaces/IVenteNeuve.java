/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Annonces;
import models.VenteNeuve;

/**
 *
 * @author user
 */
public interface IVenteNeuve {
    public void addAnnonceventeNeuve (VenteNeuve a );
    public void updateVenteNeuve (VenteNeuve a  );
    public void RemoveVenteNeuve (int i  );
    public VenteNeuve findById( int i);

      
}
