package in.sp.main.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Entity.Student;
import in.sp.main.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository StudentRepo;

	public Student GetData(Student std) {
		
		return StudentRepo.save(std);
	}
	
	

}
