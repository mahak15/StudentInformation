package model;
import com.google.gson.JsonObject;
public class Student {
      String  studentName;
       String studentUniversity;
     String studentRollNo;


    public Student(String name, String university, String rollNo){

        this.studentName=name;
        this.studentUniversity=university;
        this.studentRollNo=rollNo;

    }// Accept : application/json
    // Accept : application/xml

    public String stringify(){
        JsonObject studentJson = new JsonObject();
        studentJson.addProperty("Name",studentName);
        studentJson.addProperty("University",studentUniversity);
        studentJson.addProperty("RollNo",studentRollNo);
        return studentJson.toString();
    }

    public String getRollNo(){
        return studentRollNo;
    }

}


