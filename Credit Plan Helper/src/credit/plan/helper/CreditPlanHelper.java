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
import java.io.FileReader;
import java.io.IOException;
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
    
    private JSONObject obj = new JSONObject();
    
    public static void main(String[] args) {
        // TODO code application logic here
        readJSONFile();
        Student std = new Student("Max", "CS", "ITI", "n/a", "n/a");
        std.addDegree("Major");
        std.addDegree("Minor");
        
        std.degree.get(0).addCourse("CS100", "Introduction to Com Sci", 3, 1, 1);
        
        System.out.println(std.degree.size());
        System.out.println(std.degree.get(0).getDesc());
        System.out.println(std.degree.get(0).course.get(0).getName());
        System.out.println(std.degree.get(1).getDesc());

        
    }
    
    private static void readJSONFile() throws ParseException, IOException{
        JSONParser parser = new JSONParser();
        try{
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(
                "save.json"));
        }
        catch(FileNotFoundException e){
            System.out.println("File not Found Create a new one.");
        }
        catch(ParseException e){
            System.out.println("Error to parse file Please Delete ' save.json ' filr.");
        }
    }
    
    public void writeJSINFile(){
        
    }
    
}
