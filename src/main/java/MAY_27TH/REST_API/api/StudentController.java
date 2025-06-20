package MAY_27TH.REST_API.api;

import MAY_27TH.REST_API.entities.Student;
import MAY_27TH.REST_API.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@Controller /// writing controller makes class eligible to communicate
@ResponseBody /// because the response will be written in response body*/

@RestController /// combination of controller + responseBody
@RequestMapping("/student")
public class StudentController {
    ///  we will be writing the method in this class

    @Autowired
    StudentService studentService;

    /// HTTP:GET ======>  http://localhost:8080/student/getAll
    /*@RequestMapping(method = RequestMethod.GET, path = "/getAll")*/
    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        List<Student> students = studentService.getStudent();
        return students;

    }
}
