package Servlet;
import model.Student;
import model.StudentsModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentServlet extends HttpServlet {
    StudentsModel student;
    //Object info;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        Student studentInfo = new Student(req.getParameter("Name"),req.getParameter("University"),req.getParameter("RollNo"));
        resp.getWriter().write(student.Check(studentInfo));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student1;
        String rollNo = req.getParameter("RollNo");
        student1 = student.getByRollNo(rollNo);
        resp.getWriter().write(student1.stringify());
    }



    @Override
    public void init() throws ServletException {
        //super.init();
        student = new StudentsModel();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
