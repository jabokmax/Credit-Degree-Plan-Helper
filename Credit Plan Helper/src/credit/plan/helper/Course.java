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

/**
 *
 * @author Phuwit
 */
public class Course {
    private String courseId;
    private String name;
    private String type;
    private int credit;
    private int year, term;
    
    /**
     * #init new Course.
     * @param courseId
     * @param name
     * @param type
     * @param credit
     * @param year
     * @param term 
     */
    public Course(String courseId, String name, String type, int credit,
            int year, int term){
        
        this.courseId = courseId;
        this.name = name;
        this.type = type;
        this.credit = credit;
        this.year = year;
        this.term = term;
    }
    
    /**
     * 
     * @param courseId for set new course Id.
     */
    public void setCourseId(String courseId){
        this.courseId = courseId;
    }
    
    /**
     * 
     * @param name for set new name.
     */
    public void setName(String name){
        this.name = name;
    } 
    
    /**
     * 
     * @param credit for set new credit.
     */
    public void setCredit(int credit){
        this.credit = credit;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
}
