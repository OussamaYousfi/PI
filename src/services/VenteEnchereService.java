/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import interfaces.IVenteEnchere;
import java.sql.Connection;
import models.VenteEnchere;
import techniques.DataSource;

/**
 *
 * @author user
 */
public class VenteEnchereService implements IVenteEnchere{
Connection connection;
    public VenteEnchereService() {
        connection = DataSource.getInsatance().getConnection();
    }
    
    

   /* @Override
    public void RemoveAnnonceEnchere(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void addAnnonceEnchere(VenteEnchere a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAnnonceEnchere(VenteEnchere a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VenteEnchere findById(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
}
