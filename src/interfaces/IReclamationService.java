/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import models.Reclamation;
import models.User;

import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author MALEK
 */
public interface IReclamationService extends Iservice<Reclamation, Integer> {
     List<Reclamation> getByUser(User user);
     ObservableList<Reclamation>displayallreclamation();
      ObservableList<Reclamation>displayallreclamationid(Integer id_reclamation);
      public void updateTraite(Reclamation r);

}
