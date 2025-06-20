package MAY_27TH.REST_API.runner;

import MAY_27TH.REST_API.entities.Student;
import MAY_27TH.REST_API.repo.StudentRepo;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentDataLoader implements CommandLineRunner {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public void run(String... args) throws Exception {

        Student student = new Student();
        student.setId(4);
        student.setFirstName("Nikhil");
        student.setLastName("pal");
        student.setEmail("nikhil@gmail.com");
        student.setPhoneNumber("5194988971");


        studentRepo.save(student);

    }
}
