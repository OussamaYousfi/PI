/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author MALEK
 */
public class Test_autoecole {
    private int id_test;
    private String question;
    private String reponses;
    private User user;
    private String fausse1;
    private String fausse2;
    private String fausse3;
    private String Path;

    public Test_autoecole() {
    }

    public Test_autoecole(int id_test, String question, String reponses, String fausse1, String fausse2, String fausse3, String Path) {
        this.id_test = id_test;
        this.question = question;
        this.reponses = reponses;
        this.fausse1 = fausse1;
        this.fausse2 = fausse2;
        this.fausse3 = fausse3;
        this.Path = Path;
        
    }

    public Test_autoecole(String question, String reponses, String fausse1, String fausse2, String fausse3, String Path) {
        this.question = question;
        this.reponses = reponses;
        this.fausse1 = fausse1;
        this.fausse2 = fausse2;
        this.fausse3 = fausse3;
        this.Path = Path;
    }

    public Test_autoecole(String question, String reponses, User user, String fausse1, String fausse2, String fausse3, String Path) {
        this.question = question;
        this.reponses = reponses;
        
        this.fausse1 = fausse1;
        this.fausse2 = fausse2;
        this.fausse3 = fausse3;
        this.Path = Path;
        this.user = user;
    }

    public Test_autoecole(int id_test, String question, String reponses,  String fausse1, String fausse2, String fausse3, String Path,User user) {
        this.id_test = id_test;
        this.question = question;
        this.reponses = reponses;
        
        this.fausse1 = fausse1;
        this.fausse2 = fausse2;
        this.fausse3 = fausse3;
        this.Path = Path;
        this.user = user;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }

    public Test_autoecole(int id_test, String question, String reponses, User user) {
        this.id_test = id_test;
        this.question = question;
        this.reponses = reponses;
        this.user = user;
    }

    public Test_autoecole(int id_test, String question, String reponses, String fausse1, String fausse2, String fausse3) {
        this.id_test = id_test;
        this.question = question;
        this.reponses = reponses;
        this.fausse1 = fausse1;
        this.fausse2 = fausse2;
        this.fausse3 = fausse3;
    }

    public Test_autoecole(String question, String reponses, String fausse1, String fausse2, String fausse3) {
        this.question = question;
        this.reponses = reponses;
        this.fausse1 = fausse1;
        this.fausse2 = fausse2;
        this.fausse3 = fausse3;
    }

    public Test_autoecole(int id_test) {
        this.id_test = id_test;
    }

    public Test_autoecole(String question, String reponses, String fausse1, String fausse2, String fausse3, User user) {
        this.question = question;
        this.reponses = reponses;
        
        this.fausse1 = fausse1;
        this.fausse2 = fausse2;
        this.fausse3 = fausse3;
        this.user = user;
    }

    public Test_autoecole(int id_test, String question, String reponses, String fausse1, String fausse2, String fausse3, User user) {
        this.id_test = id_test;
        this.question = question;
        this.reponses = reponses;
        
        this.fausse1 = fausse1;
        this.fausse2 = fausse2;
        this.fausse3 = fausse3;
        this.user = user;
    }

    public String getFausse1() {
        return fausse1;
    }

    public void setFausse1(String fausse1) {
        this.fausse1 = fausse1;
    }

    public String getFausse2() {
        return fausse2;
    }

    public void setFausse2(String fausse2) {
        this.fausse2 = fausse2;
    }

    public String getFausse3() {
        return fausse3;
    }

    public void setFausse3(String fausse3) {
        this.fausse3 = fausse3;
    }

    public Test_autoecole(String question, String reponses, User user) {
        this.question = question;
        this.reponses = reponses;
        this.user = user;
    }

    public int getId_test() {
        return id_test;
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponses() {
        return reponses;
    }

    public void setReponses(String reponses) {
        this.reponses = reponses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Test_autoecole{" + "id_test=" + id_test + ", question=" + question + ", reponses=" + reponses + ", user=" + user + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Test_autoecole other = (Test_autoecole) obj;
        if (!Objects.equals(this.id_test, other.id_test)) {
            return false;
        }
        return true;
    }
    
    
}
