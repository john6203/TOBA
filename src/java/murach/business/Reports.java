/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.business;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import murach.data.DBUtil;

/**
 *
 * @author John
 */
public class Reports {

    public Reports() {
    }
    
    public static List<User> selectMonthlyUsers() {
            EntityManager em = DBUtil.getEmFactory().createEntityManager();
            String qString = "SELECT u from User u" +
                             "WHERE U.RegisterDate = 'n'";
            TypedQuery<User> q = em.createQuery(qString, User.class);
            
            List<User> users;
            try {
                users = q.getResultList();
                if (users == null || users.isEmpty())
                    users = null;
            }
            finally {
                em.close();
            }
            return users;
    }
}
