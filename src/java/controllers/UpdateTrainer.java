package controllers;

import dao.TrainerDao;
import entities.Trainer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.TrainerService;

public class UpdateTrainer extends HttpServlet {

    static long tidlong ;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateTrainer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateTrainer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Trainers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Our Trainers!</h1>");
            TrainerDao tDao = new TrainerDao();
            List<Trainer> tlist = new ArrayList();
            tlist = tDao.SelectTrainersJPA();
            for (Trainer t : tlist) {
                String UpdateName = " <a href='UpdateTrainer?updatename=" + t.getTid() + "'>UpdateName</a> ";
                String UpdateSurname = " <a href='UpdateTrainer?updatesurname=" + t.getTid() + "'>UpdateSurname</a> ";
                String UpdateSubject = " <a href='UpdateTrainer?updatesubject=" + t.getTid() + "'>UpdateSubject</a> ";
                out.println("<p>" + t + " " + UpdateName + "  " + UpdateSurname + "  " + UpdateSubject + "</p>");
            }
            String home = " <a href='index.html'>Home</a> ";
            out.println(home);

            String nameTid = request.getParameter("updatename");
            if (nameTid != null) {
                tidlong = Long.parseLong(nameTid);
                RequestDispatcher rd = request.getRequestDispatcher("updateName.jsp");
                request.setAttribute("title", "Update Name");
                rd.forward(request, response);
            }
            String snameTid = request.getParameter("updatesurname");
            if (snameTid != null) {
                tidlong = Long.parseLong(snameTid);
                RequestDispatcher rd = request.getRequestDispatcher("updateSurname.jsp");
                request.setAttribute("title", "Update Surname");
                rd.forward(request, response);
            }
            String subjectTid = request.getParameter("updatesubject");
            if (subjectTid != null) {
                tidlong = Long.parseLong(subjectTid);
                RequestDispatcher rd = request.getRequestDispatcher("updateSubject.jsp");
                request.setAttribute("title", "Update Subject");
                rd.forward(request, response);
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TrainerDao tDao = new TrainerDao();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Update Trainer</h1>");
            out.println("<br />");
            if (request.getParameter("name") != null){
                tDao.updateTrainerTnameById(tidlong, request.getParameter("name"));
                out.print("<p> Name updated! </p>");
            } else if (request.getParameter("surname") != null) {
                tDao.updateTrainerTlameById(tidlong, request.getParameter("surname"));
                out.print("<p> Surname updated! </p>");
            } else if (request.getParameter("subject") != null) {
                tDao.updateTrainerTsubjectById(tidlong, request.getParameter("subject"));
                out.print("<p> Subject updated! </p>");
            } else {
                out.print("<h2>Nothing updated!</h2>");
            }
            String home = " <a href='index.html'>Home</a> ";
            out.println(home);
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
