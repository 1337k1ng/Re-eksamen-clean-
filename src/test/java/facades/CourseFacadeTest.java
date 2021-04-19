//package facades;
//
//
//import entities.Course;
//import utils.EMF_Creator;
//import entities.User;
//import errorhandling.API_Exception;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//
//
//public class CourseFacadeTest {
//
//    private static EntityManagerFactory emf;
//    private static CourseFacade courseFacade;
//
//    public CourseFacadeTest() {
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//       emf = EMF_Creator.createEntityManagerFactoryForTest();
//  
//       courseFacade = CourseFacade.getCourseFacade(emf);
//               EntityManager em = emf.createEntityManager();
//
//               try {
//
//         User u1 = new User("bobby", "123456");
//       User u2 = new User("teacher", "123456");
//       Course course = new Course("java","java");
//        
//     
//         em.getTransaction().begin();
//         
//           em.createQuery("delete from Course").executeUpdate();         
//           em.createQuery("delete from User").executeUpdate();
//      
//         em.persist(u1);
//         em.persist(u2);
//         em.persist(course);
//         em.getTransaction().commit();
//
//               }
//                finally {
//            em.close();
//        }
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
////        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
//    }
//
//    // Setup the DataBase in a known state BEFORE EACH TEST
//    //TODO -- Make sure to change the code below to use YOUR OWN entity class
//    @BeforeEach
//    public void setUp() {
//        EntityManager em = emf.createEntityManager();
//        
//        
//        try {
//            em.getTransaction().begin();
//        
//  
//    
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
//
//    @AfterEach
//    public void tearDown() {
////        Remove any data after each test was run
//    }
//
//    
//
//   
//   
//   
//  
//
//}
