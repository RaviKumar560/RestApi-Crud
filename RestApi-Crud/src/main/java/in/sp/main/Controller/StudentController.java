package in.sp.main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}
