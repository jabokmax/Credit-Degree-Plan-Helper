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

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Phuwit
 */
public class CreditPlanHelper {
    /**
     * @param args the command line arguments
     */
    
    private static JSONObject obj  = new JSONObject();
    private static List<Student> std = new ArrayList<Student>();
    
    public static void main(String[] args) throws ParseException, IOException {
        
        readJSONFile();
        updateStudent();
        
        System.out.println(std.get(1).degree.get(0).course.get(0).getName());
        System.out.println(std.get(1).degree.get(0).getRegCregit());
        System.out.println(std.get(0).degree.get(0).getRegCregit());
        /*
        
        
        System.out.println(std.size());
        System.out.println(std.get(1).getName());
        
        std = new Student("Max", "CS", "ITI", "n/a", "n/a");
        std.addDegree("Major");
        std.addDegree("Minor");
        
        std.degree.get(0).addCourse("CS100", "Introduction to Com Sci", 3, 1, 1);
        
        System.out.println(std.degree.size());
        System.out.println(std.degree.get(0).getDesc());
        System.out.println(std.degree.get(0).course.get(0).getName());
        System.out.println(std.degree.get(1).getDesc());
        */

        
    }
    
    private static void readJSONFile() throws ParseException, IOException{
        JSONParser parser = new JSONParser();
        String tempStr;
        try{
            JSONObject temp = (JSONObject) parser.parse(new FileReader(
                "save.json"));
            System.out.println("File Opened.");
            obj = temp;
            //System.out.println(obj);
            
        }
        catch(FileNotFoundException e){
            tempStr = "{\"std\":[]}";
            obj = (JSONObject) parser.parse(tempStr);
            System.out.println("File not Found Create a new one.");
            
            try (FileWriter file = new FileWriter("save.json")) {
		file.write(obj.toJSONString());
		System.out.println("Successfully Create JSON Object to File...");
		//System.out.println("JSON Object: " + tempStr);
            }
        }
        catch(ParseException e){
            System.out.println("Error to parse file Please Delete ' save.json ' file.");
        }
    }
    
    public void writeJSINFile() throws IOException{
        try (FileWriter file = new FileWriter("save.json")) {
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            //System.out.println("JSON Object: " + tempStr);
        }
    }
    
    private static void updateStudent(){
        // Student Object
        String name;
        String department;
        String school;
        String majorElective;
        String minor;

        
        // Add Student
        JSONArray getStdArray = (JSONArray) obj.get("std");
        for(int i = 0; i < getStdArray.size(); i++){
            
            JSONObject tempStd = (JSONObject) getStdArray.get(i);
            name = tempStd.get("name").toString();
            department = tempStd.get("department").toString();
            school = tempStd.get("school").toString();
            majorElective = tempStd.get("major").toString();
            minor = tempStd.get("minor").toString();
            std.add(new Student(name, department, school, majorElective, minor));
            
            //Add Degree
            // Degree Object
            String desc;
            int reqCredit;
            
            JSONArray getDegreeArray = (JSONArray) tempStd.get("degree");
            for(int j = 0; j < getDegreeArray.size(); j++){
                
                JSONObject tempDegree = (JSONObject) getDegreeArray.get(j);
                desc = tempDegree.get("desc").toString();
                reqCredit = (int) tempDegree.get("reqCredit").hashCode();
                std.get(i).addDegree(desc, reqCredit);
                
                // Add Course
                // Course Object
                String courseId;
                String CourseName;
                int credit;
                int year, term;
                
                JSONArray getCourseArray = (JSONArray) tempDegree.get("course");
                for(int k = 0; k < getCourseArray.size(); k++){
                    JSONObject tempCourse = (JSONObject) getCourseArray.get(k);
                    courseId = tempCourse.get("courseId").toString();
                    CourseName = tempCourse.get("name").toString();
                    credit = (int) tempCourse.get("credit").hashCode();
                    year = (int) tempCourse.get("year").hashCode();
                    term = (int) tempCourse.get("term").hashCode();
                    
                    std.get(i).degree.get(j).addCourse(courseId, CourseName, credit, year, term);
                    
                }
                
            }
        }
        
        
    }
    
}
