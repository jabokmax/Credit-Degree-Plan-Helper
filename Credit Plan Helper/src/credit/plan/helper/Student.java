/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credit.plan.helper;

/**
 *
 * @author Phuwit
 */
public class Student {
    private String name;
    private String department;
    private String school;
    private String majorElective;
    private String minor;
    
    /**
     * #init student object.
     * @param name 
     * @param department
     * @param school
     * @param majorElective
     * @param minor 
     */
    public void Student(String name, String department, String school,
            String majorElective, String minor){
        
        this.department = department;
        this.name = name;
        this.school = school;
        this.majorElective = majorElective;
        this.minor = minor;
        
    }
    /**
     * 
     * @param name for set a new name.
     */
    public void setName(String name){
        this.name = name;
    }
    
}
