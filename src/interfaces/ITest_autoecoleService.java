/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;
import models.Test_autoecole;
import models.User;

import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author MALEK
 */
public interface ITest_autoecoleService extends Iservice<Test_autoecole, Integer> {
         List<Test_autoecole> getByUser(User user);
  
    public ObservableList<Test_autoecole>displayallTest();
     public ObservableList<Test_autoecole>displayallTestid(Integer id_test);
}