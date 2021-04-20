/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Course;
import entities.User;
import javax.persistence.EntityManagerFactory;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

/**
 *
 * @author Madsj
 */
//
public class testTeacher {
    
    public static void main(String[] args) throws AuthenticationException {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        UserFacade uf = UserFacade.getUserFacade(emf);
        uf.addNewUser(new User("Johnkimbooo", "Jpoapapa"));
        
    }
}
