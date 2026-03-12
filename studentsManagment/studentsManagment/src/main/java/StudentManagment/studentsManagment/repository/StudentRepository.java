package StudentManagment.studentsManagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import StudentManagment.studentsManagment.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{

}
