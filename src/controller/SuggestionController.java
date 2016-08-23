package controller;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

import model.Suggestion;
import service.SuggestionService;

@RestController
@RequestMapping()
public class SuggestionController {
	
	private static final Logger logger = Logger.getLogger(SuggestionController.class);
	
	
	@Autowired
	SuggestionService suggestionService;
	
	
	@RequestMapping(value="addSuggestion",method=RequestMethod.POST)
	public @ResponseBody void addSuggestion(
			@RequestBody Suggestion suggestion
			){
		
		
		logger.info("add suggestion");
		
		suggestionService.addSuggestion(suggestion);;
		
		
	}


	@RequestMapping(value="getSuggestionById/{id}",method=RequestMethod.GET)
	public ResponseEntity<Suggestion> getSuggestionById(
			@PathVariable Integer id
			){
		
		logger.info("get suggestion");
		
		Suggestion suggestion = suggestionService.getById(id);
		
		return new ResponseEntity<Suggestion>(suggestion, HttpStatus.OK);
	}


	@RequestMapping(value = "listSugggestion", method = RequestMethod.GET)
	public ResponseEntity<List<Suggestion>> listSuggestion(	) {
	
		logger.info("list suggestion");
		
		List<Suggestion> listCommon = suggestionService.listSuggestion();
		
		MultiValueMap<String , String> headers =new HttpHeaders();
		
		headers.add("Access-Control-Allow-Origin", "*");
		
		return new ResponseEntity<List<Suggestion>>(listCommon,headers, HttpStatus.OK);
	
	}
	
	
	/**
	 *  update suggestion
	 * @param suggestion
	 */
	@RequestMapping(value="updateSuggestion",method=RequestMethod.PUT)
	public @ResponseBody void updateSuggestion(
			@RequestBody Suggestion suggestion
			){
		
		suggestionService.updateSuggestion(suggestion);
		
	}
	
	/**
	 *  delete suggestion 
	 * @param id
	 */
	@RequestMapping(value="deleteSuggestion/{id}",method=RequestMethod.DELETE)
	public @ResponseBody void deleteSuggestion(
			@PathVariable int id
			){
		
		suggestionService.deleteSuggestion(id);
		
	}
	
	
}
