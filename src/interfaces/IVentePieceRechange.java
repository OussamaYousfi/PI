/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Ventepiecerechange;



/**
 *
 * @author user
 */
public interface IVentePieceRechange extends IAnnoncesService {
   public void addAnnonceVentepiecerechange (Ventepiecerechange a );
    public void updateAnnonceVentepiecerechange (Ventepiecerechange a );
    public void RemoveAnnonceVentepiecerechange (Ventepiecerechange a );
    public Ventepiecerechange  findById( int i);  
}
