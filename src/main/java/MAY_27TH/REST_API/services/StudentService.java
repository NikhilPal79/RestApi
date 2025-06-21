package MAY_27TH.REST_API.services;

import MAY_27TH.REST_API.entities.Student;
import MAY_27TH.REST_API.repo.StudentRepo;
import MAY_27TH.REST_API.util.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    StudentUtils studentUtils;

    public List<Student> getStudent(){
        List<Student> studentList = studentRepo.findAll();

        return  studentList;
    }


    ///  HANDLING NULL POINT EXCEPTIONS

    public Optional<Student> getStudentById(Integer id){

        Optional<Student> optionalStudent = studentRepo.findById(id);
        return optionalStudent;
    }

    public Student createStudent(Student student){
        Student studentEntity = studentRepo.save(student);
        return studentEntity;
    }

    public Student updateStudent(Student student){

        /// if we do the same as create, then it will not be updated it will create the new entity everytime
        ///  so we need to fetch the entity first(byId) if we have that entity only then the update will happen

        Optional<Student> optionalStudent = studentRepo.findById(student.getId());

        if (optionalStudent.isPresent()) {
            return studentRepo.save(student);
        }

        return student;
    }

    public Student patchUpdate(Student dto){
        Optional<Student> studentOptional = studentRepo.findById(dto.getId());
        Student entity = null;

        if (!studentOptional.isPresent()) {
            return null;

        }

        entity = studentOptional.get();
        studentUtils.convertPatchDto(dto , entity);

        return studentRepo.save(entity);
    }


    public List<Student> getAllByFirstName(String Name){
        List<Student> allByFirstName = studentRepo.findAllStudentByFirstName(Name);

        return allByFirstName;
    }


    public boolean deleteStudent(Integer id){
        try {
            studentRepo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
