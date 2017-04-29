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
     * 
     * @param name for set a new name.
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * 
     * @param department for set a new department.
     */
    public void setDep(String department){
        this.department = department;
    }
    
    /**
     * 
     * @param majorElective for set a new major Elective.
     */
    public void setMajor(String majorElective){
        this.majorElective = majorElective;
    }
    
    /**
     * 
     * @param minor for set a new Minor.
     */
    public void setMinor(String minor){
        this.minor = minor;
    }
    
    /**
     * 
     * @param school for set a new major school.
     */
    public void setSchool(String school){
        this.school = school;
    }
    
    /**
     * 
     * @return name of Student.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * 
     * @return Student's Department.
     */
    public String getDep(){
        return this.department;
    }
    
    /**
     * 
     * @return Student's major Elective.
     */
    public String getMajor(){
        return this.majorElective;
    }
    
    /**
     * 
     * @return Student's Minor.
     */
    public String getMinor(){
        return this.minor;
    }
    
    /**
     * 
     * @return Student's School.
     */
    public String getSchool(){
        return this.school;
    }
}
