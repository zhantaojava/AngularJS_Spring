package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.DAO;

@RestController
@RequestMapping()
public class HelloController {
	
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public ResponseEntity<List> testAPI(

	) {
		
		
		DAO dao=new DAO();
		
		List list=dao.ListPerson();
		
		
		
		
		return new ResponseEntity<List>(list,HttpStatus.OK);

	}
	

}



