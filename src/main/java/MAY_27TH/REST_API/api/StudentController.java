package MAY_27TH.REST_API.api;

import MAY_27TH.REST_API.entities.Student;
import MAY_27TH.REST_API.services.StudentService;
import MAY_27TH.REST_API.util.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*@Controller /// writing controller makes class eligible to communicate
@ResponseBody /// because the response will be written in response body*/

@RestController /// combination of controller + responseBody
@RequestMapping("/student")
public class StudentController {
    ///  we will be writing the method in this class

    @Autowired
    StudentService studentService;

    @Autowired
    StudentUtils studentUtils;

    /// HTTP:GET ======>  http://localhost:8080/student/getAll
    /*@RequestMapping(method = RequestMethod.GET, path = "/getAll")*/
    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        List<Student> students = studentService.getStudent();
        return students;

    }

    ///  there are only threee places where they can send letters
    /// 1. body
    /// 2. url => called path variable
    /// 3. query parameters ===> are also the part of url



    @GetMapping("/byId")
    public Optional<Student> getById(@RequestParam("id") Integer identification){
        Optional<Student> studentById = studentService.getStudentById(identification);

        return studentById;

    }


    /// THE ABOVE METHOD AND BELOW METHOD ARE the SAME

    /*@GetMapping("/byId{id}")
    public Optional<Student> getById(@PathVariable("id{id}") Integer identification) {
        Optional<Student> studentById = studentService.getStudentById(identification);

        return studentById;
    }*/

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        Student studentServiceStudent = studentService.createStudent(student);

        return studentServiceStudent;
    }

    /// WE USE PUT TO UPDATE THE ENTRIES

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        Student studentServiceStudent1 = studentService.updateStudent(student);

        return studentServiceStudent1;
    }

    @PatchMapping("/patch")
    public Student patch(@RequestBody Student student){
        return studentService.patchUpdate(student);
    }

    @GetMapping("/allByName")
    public List<Student> getAllByFirstName(@RequestParam String Name){
        List<Student> allByFirstName = studentService.getAllByFirstName(Name);
        return allByFirstName;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);

    }




}
