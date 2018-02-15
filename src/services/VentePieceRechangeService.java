/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import techniques.DataSource;

/**
 *
 * @author user
 */
public class VentePieceRechangeService {
    Connection connection;

    public VentePieceRechangeService() {
    connection = DataSource.getInsatance().getConnection();
    }
    
}
