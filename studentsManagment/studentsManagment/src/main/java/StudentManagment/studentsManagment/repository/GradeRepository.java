package StudentManagment.studentsManagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import StudentManagment.studentsManagment.entity.GradeEntity;

public interface GradeRepository extends JpaRepository<GradeEntity,Integer> {
	List<GradeEntity> findByStudentId(Integer studentId);
}
