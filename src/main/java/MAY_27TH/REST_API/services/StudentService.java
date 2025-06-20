package MAY_27TH.REST_API.services;

import MAY_27TH.REST_API.entities.Student;
import MAY_27TH.REST_API.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> getStudent(){
        List<Student> studentList = studentRepo.findAll();

        return  studentList;
    }
}
