package controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import model.Comment;
import model.Suggestion;
import service.SuggestionService;

@RestController
@RequestMapping()
public class SuggestionController {

	private static final Logger logger = Logger.getLogger(SuggestionController.class);

	@Autowired
	SuggestionService suggestionService;

	@Autowired
	RestOperations restTemplate;

	@RequestMapping(value = "addSuggestion", method = RequestMethod.POST)
	public ResponseEntity<?> addSuggestion(@RequestBody Suggestion suggestion) {

		logger.info("add suggestion");

		suggestionService.addSuggestion(suggestion);
		;

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// @RequestMapping(value="getSuggestionById/{id}",method=RequestMethod.GET)
	// public ResponseEntity<Suggestion> getSuggestionById(
	// @PathVariable Integer id
	// ){
	//
	//
	// Suggestion suggestion = suggestionService.getById(id);
	//
	// return new ResponseEntity<Suggestion>(suggestion, HttpStatus.OK);
	// }

	@RequestMapping(value = "getSuggestionById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Suggestion> getSuggestionByIdWithoutComment(
			@PathVariable Integer id,
			@RequestParam(value = "includeComment", defaultValue = "false") boolean includeComment) {

		Suggestion suggestion;

		if (includeComment) {
			suggestion = suggestionService.getById(id);
		} else {
			suggestion = suggestionService.getByIdWithoutComment(id);
		}


		return new ResponseEntity<Suggestion>(suggestion, HttpStatus.OK);
	}

	@RequestMapping(value = "listSuggestion", method = RequestMethod.GET)
	public ResponseEntity<List<Suggestion>> listSuggestion() {

		List<Suggestion> listCommon = suggestionService.listSuggestion();

		MultiValueMap<String, String> headers = new HttpHeaders();

		headers.add("Access-Control-Allow-Origin", "*");

		ResponseEntity<List<Suggestion>> responseEntity = new ResponseEntity<List<Suggestion>>(listCommon, headers,
				HttpStatus.OK);

		System.out.println(responseEntity);

		return responseEntity;

	}

	/**
	 * update suggestion
	 * 
	 * @param suggestion
	 */
	@RequestMapping(value = "updateSuggestion", method = RequestMethod.PUT)
	public @ResponseBody void updateSuggestion(@RequestBody Suggestion suggestion) {

		suggestionService.updateSuggestion(suggestion);

	}

	/**
	 * delete suggestion
	 * 
	 * @param id
	 */
	@RequestMapping(value = "deleteSuggestion/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteSuggestion(@PathVariable int id) {

		suggestionService.deleteSuggestion(id);

	}

	
	//RestTemplate Test
	
	@RequestMapping(value = "client", method = RequestMethod.GET)
	// public ResponseEntity<Suggestion> client(){
	public @ResponseBody Suggestion client() {
		String url = "http://localhost:8080/AngularJS_Deploy_test/app";

		// ResponseEntity<Suggestion> responseEntity =
		// restTemplate.getForEntity(url, Suggestion.class);

		Suggestion obj = restTemplate.getForObject(url + "/getSuggestionById/{id}", Suggestion.class, 8);

//		Suggestion s = new Suggestion();

//		obj = s;

		obj.setTitle("HAHAHAHA");

		return obj;
	}
	
	
	@RequestMapping(value = "multiple", method = RequestMethod.GET)
	public ResponseEntity<Suggestion> testMultiplyParam(
			@RequestParam( defaultValue = "false") boolean include,
			@RequestParam (defaultValue="hello world") String str
			) {

		Suggestion suggestion=new Suggestion();
		
		if(include){
			suggestion.setTitle(str);
		}

		return new ResponseEntity<Suggestion>(suggestion, HttpStatus.OK);
	}

}
