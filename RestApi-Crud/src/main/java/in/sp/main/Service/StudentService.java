package in.sp.main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Entity.Student;
import in.sp.main.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository StudentRepo;
	
	//save data in DB
	public Student GetData(Student std) {
		
		return StudentRepo.save(std);
	}
	//get All data from DB
	public List<Student> GetData() {
		return StudentRepo.findAll();
	}
	//get By Roll no.
	public Student GetDataByRoll(int rollno) {
		
		return StudentRepo.findByRollno(rollno);
	}
	
	
	public Student updateStudent(Student student,int rollno) {
		Student std=StudentRepo.findByRollno(rollno);
		std.setCity(student.getCity());
		return StudentRepo.save(std);
	}
	
	public String deletStd(int rollno) {
		Student std3=StudentRepo.findByRollno(rollno);
		StudentRepo.delete(std3);
		return null;
	}

}
