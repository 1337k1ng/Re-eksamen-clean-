/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.ClassesDTO;
import dto.ClasssDTO;
import dto.CourseDTO;
import dto.CoursesDTO;
import entities.Classs;
import entities.Course;
import entities.Teacher;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import security.errorhandling.AuthenticationException;

/**
 *
 * @author Madsj
 */
public class CourseFacade {

    private static EntityManagerFactory emf;
    private static CourseFacade instance;

    public CourseFacade() {
    }

    public static CourseFacade getCourseFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CourseFacade();
        }
        return instance;
    }

    public List<CourseDTO> getAllCourses() {

        EntityManager em = emf.createEntityManager();
        List<Course> courseList = em.createQuery("SELECT c FROM Course c", Course.class).getResultList();

        return new CoursesDTO(courseList).getAll();

    }
    
   /* public List<ClasssDTO> getAllClasses() {

        EntityManager em = emf.createEntityManager();
        List<Classs> classsList = em.createQuery("SELECT c FROM Classs c", Classs.class).getResultList();

        return new ClassesDTO(classsList).getAll();

    }
*/
    public Course addNewCourse(Course newCourse) throws AuthenticationException {

        if (newCourse.getCourseName().isEmpty() || newCourse.getDescription().isEmpty()) {
            throw new AuthenticationException("Something went wrong. Try again. ");
        }
        EntityManager em = emf.createEntityManager();

        Course course = new Course(newCourse.getCourseName(), newCourse.getDescription());

        try {

            em.getTransaction().begin();

            em.persist(course);
            em.getTransaction().commit();

        } catch (RollbackException e) {
            throw new AuthenticationException("Course already exist. Try another Course name");

        } catch (Exception e) {
            throw new AuthenticationException("Something went wrong. Server may be unavailable at the moment");
        } finally {
            em.close();
        }
        return course;

    }

}
