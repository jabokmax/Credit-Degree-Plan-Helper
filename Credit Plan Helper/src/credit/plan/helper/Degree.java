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
public class Degree {
    private String desc;
    private int requireCredit;
    public List<Course> course = new ArrayList<Course>();
    
    public Degree(String desc, int requireCredit){
        this.desc = desc;
        this.requireCredit = requireCredit;
    }
    
    /**
     * 
     * @param Desc for set a new Description
     */
    public void setDesc(String Desc){
        this.desc = Desc;
    }
    
    /**
     * 
     * @param requireCredit for set a new require Credit
     */
    public void setReqCredit(int requireCredit){
        this.requireCredit = requireCredit;
    }
    
    /**
     * 
     * @return Description
     */
    public String getDesc(){
        return desc;
    }
    
    /**
     * 
     * @return require Credit
     */
    public int getRegCregit(){
        return requireCredit;
    }
    
    public void addCourse(String courseId, String name, int credit,
            int year, int term){
        course.add(new Course(courseId, name, credit, year, term));
    }
}
