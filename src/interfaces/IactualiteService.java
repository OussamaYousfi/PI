/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Date;
import javafx.collections.ObservableList;
import models.Actualite;



/**
 *
 * @author Yousfi Oussama
 */
public interface IactualiteService extends Iservice <Actualite, Integer>{
    public ObservableList<Actualite>displayallactualite();
    public void deletebynamedate(String nom, Date date);
}