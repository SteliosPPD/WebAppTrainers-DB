package controllers;

import dao.TrainerDao;
import entities.Trainer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.TrainerService;

public class DeleteTrainer extends HttpServlet {

    
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
            List <Trainer> tlist = new ArrayList();
            tlist = tDao.SelectTrainersJPA();
            for (Trainer t : tlist){
                String delete = " <a href='DeleteTrainer?delete=" + t.getTid() + "'>Delete</a> ";
                out.println("<p>" + t + " " + delete + "</p>");
            }
            String home = " <a href='index.html'>Home</a> ";
            out.println(home);
            String stid = request.getParameter("delete");
            if (stid != null) {
                TrainerService trServ = new TrainerService();
                long stidlong = Long.parseLong(stid);
                if (trServ.DeleteTrainer(stidlong)) {
                    out.println("\nTrainer deleted successfully!");
                } else {
                    out.println("\nTrainer not deleted...");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}