/*
 * The MIT License
 *
 * Copyright 2017 Phuwit.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package credit.plan.helper;

import java.util.List;
import java.util.ArrayList;

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
    public List<Degree> degree = new ArrayList<Degree>();
    
    /**
     * #init new student.
     * @param name
     * @param department
     * @param school
     * @param majorElective
     * @param minor 
     */
    public Student(String name, String department, String school,
            String majorElective, String minor){
        this.name = name;
        this.department = department;
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
    
    public void addDegree(String desc, int reqCredit){
        degree.add(new Degree(desc, reqCredit));
    }
}
