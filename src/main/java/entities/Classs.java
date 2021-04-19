/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Madsj
 */
@Entity
public class Classs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String semester; 
    private int numberOfStudents;

    @ManyToMany (mappedBy= "classsList", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
     
    private List<Teacher> teacherList = new ArrayList<>();
    
    @ManyToOne
    private Course course;
    
    public Classs() {
    }
    
    public Classs(String semester, int numberOfStudents) {
        this.semester = semester;
        this.numberOfStudents = numberOfStudents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

   public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
        teacher.getClasssList().add(this);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    
}
