/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.data;

/**
 *
 * @author John
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory EMF =
            Persistence.createEntityManagerFactory("newCustomerPU");
    
    public static EntityManagerFactory getEmFactory() {
        return EMF;
    }
}