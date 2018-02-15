/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Pub;



/**
 *
 * @author Nourelhouda
 */
public interface IPubService extends Iservice <Pub,Integer> { 
    
    void removeAll() ;
}
