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
import javax.swing.JFrame;
import netscape.javascript.JSObject;

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
    private static JSONObject newObj = new JSONObject();
    public static List<Student> std = new ArrayList<Student>();
    
    public static void main(String[] args) throws ParseException, IOException {
        
        readJSONFile();
        updateStudent();
        
        Profile frame = new Profile();
        frame.setVisible(true);
        
        writeJSINFile();
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
            newObj = obj;
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
    
    public static void writeJSINFile() throws IOException{
        newObj.clear();
        JSONArray data = new JSONArray();
        
        // add info
        JSONObject tempInfo;
        for(int i = 0 ; i < std.size(); i++){
            tempInfo = new JSONObject();
            tempInfo.put("name", std.get(i).getName());
            //System.out.println(tempInfo.get("name"));
            tempInfo.put("major", std.get(i).getMajor());
            tempInfo.put("minor", std.get(i).getMinor());
            tempInfo.put("school", std.get(i).getSchool());
            tempInfo.put("department", std.get(i).getDep());
            
            // add all object to Degree
            JSONArray tempDegree = new JSONArray();
            JSONObject degree;
            for(int j = 0; j < std.get(i).degree.size(); j++){
                degree = new JSONObject();
                degree.put("reqCredit", std.get(i).degree.get(j).getRegCregit());
                degree.put("desc", std.get(i).degree.get(j).getDesc());
                
                // add all object to Course
                JSONArray tempCourse = new JSONArray();
                JSONObject course;
                for(int k = 0; k < std.get(i).degree.get(j).course.size(); k++){
                    course = new JSONObject();
                    course.put("year", std.get(i).degree.get(j).course.get(k).getYear());
                    course.put("name", std.get(i).degree.get(j).course.get(k).getName());
                    course.put("term", std.get(i).degree.get(j).course.get(k).getTerm());
                    course.put("credit", std.get(i).degree.get(j).course.get(k).getCredit());
                    course.put("courseId", std.get(i).degree.get(j).course.get(k).getCourseID());
                    
                    tempCourse.add(course);
                    
                }
                degree.put("course", tempCourse);
                tempDegree.add(degree);
            }
            tempInfo.put("degree", tempDegree);
            //System.out.println(tempInfo);
            // end
            data.add(tempInfo);

            //System.out.println(data);

        }
        newObj.put("std", data);
        
        try (FileWriter file = new FileWriter("save.json")) {
            file.write(newObj.toJSONString());
            System.out.println("Successfully Copied new JSON Object to File...");
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
