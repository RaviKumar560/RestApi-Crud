package in.sp.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.Entity.Student;
import in.sp.main.Service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService Studentserv;
	
	@PostMapping("/save")
	public ResponseEntity<Student> Save(@RequestBody Student std1) {
		Student std=Studentserv.GetData(std1);
		return new ResponseEntity<>(std,HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<List<Student>>Fetch(){
		List<Student>std=Studentserv.GetData();
		return new ResponseEntity<>(std,HttpStatus.OK);
	}
	
	@GetMapping("/fetch/{rollno}")
	public ResponseEntity<Student>FetchByRoll(@PathVariable("rollno") int rollno){
		Student std1=Studentserv.GetDataByRoll(rollno);
		return new ResponseEntity<>(std1,HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{rollno}")
	public ResponseEntity<Student>Update(@RequestBody Student student,@PathVariable("rollno") int rollno)
	{
		Student std2=Studentserv.updateStudent(student,rollno);
		return new ResponseEntity<>(std2,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/del/{rollno}")
	 public ResponseEntity<String>Delete(@PathVariable("rollno") int rollno){
		Studentserv.deletStd(rollno);
		return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		
	}
	
}
