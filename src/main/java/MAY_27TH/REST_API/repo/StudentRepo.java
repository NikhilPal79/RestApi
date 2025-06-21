package MAY_27TH.REST_API.repo;

import MAY_27TH.REST_API.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {


    /// TO RETURN LIST USE ALL AFTER FIND
    List<Student> findAllStudentByFirstName(String name);
}
