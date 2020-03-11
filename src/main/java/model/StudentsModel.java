package model;
import model.Student;

import java.util.HashMap;

public class StudentsModel {
    private HashMap<String, Student> studentMap;

    public StudentsModel(){
        studentMap = new HashMap<>();
    }
    public String Check(Student student) {
        studentMap.put(student.getRollNo(),student);
        return "register\n";
    }
    public Student getByRollNo(String rollNo) {

        if(studentMap.containsKey(rollNo)){
            return studentMap.get(rollNo);
        }
        else return new Student("nan ","nan","nan");
    }
}