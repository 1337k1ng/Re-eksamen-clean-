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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Madsj
 */
@Entity
@Table(name = "Teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; 
    
    
    
    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Teacher_Classs",
            joinColumns = {@JoinColumn(name = "Teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "Classs_id")}
    )
    private List<Classs> classsList = new ArrayList<>();

    public Teacher() {
    }

    
    
    
    public Teacher( String name) {
       
        this.name = name;
    }
    
    
    
    
    
    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

   

    public List<Classs> getClasssList() {
        return classsList;
    }

    

  

 
    
}
