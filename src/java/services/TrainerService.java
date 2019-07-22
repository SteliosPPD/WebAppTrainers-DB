package services;

import dao.TrainerDao;
import entities.Trainer;
import java.io.IOException;
import java.util.List;

public class TrainerService {
    
    TrainerDao trDao = new TrainerDao ();
    
//    public String getTrainer() throws IOException {
//        
//        List<Trainer> trainers = trDao.PrintTrainers();
//        StringBuilder str = new StringBuilder(); 
//        
//            for (Trainer tr : trainers) {
////                String delete = " <a href='DeleteStudent?delete=" + st.getId() + "'>Delete</a> ";
////                String update = " <a href='UpdateStudent?update=" + st.getId() + "'>Update</a> ";
//                str.append("<p>").append(tr).append("</p>");
//            } 
//            str.append("</body>")
//                .append("</html>");
//        
//        String string = str.toString();
//        
//        return string;
//    }
    
    public boolean InsertTrainer(Trainer tr) {
        
        if (trDao.InsertTrainerJPA(tr)) return true;
        
        return false;  
}
    
    public boolean DeleteTrainer(long tid) {
        
        if (trDao.DeleteTrainerJpaById(tid)) return true;
        
        return false;  
}

}
