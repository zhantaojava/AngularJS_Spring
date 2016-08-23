package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Suggestion;

@Repository
public class SuggestionDAOImpl implements SuggestionDAO {
	
	@Autowired
	HibernateTemplate template;
	
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}


//	public void setTemplate(HibernateTemplate template) {  
//	    this.template = template;  
//	} 
	
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false) 
	public void addSuggestion(Suggestion sug) {
		template.save(sug);
	}
	
	@Override
	public Suggestion getById(int id){
		return template.get(Suggestion.class, id);
	}
	
	
	
	
	@Override
	public List<Suggestion> listSuggestion() {
		return template.loadAll(Suggestion.class);
		
	}

	@Override
	@Transactional(readOnly=false)
	public void updateSuggestion(Suggestion sug) {
		template.update(sug);

	}

	@Override
	public void deleteSuggestion(int id) {
		template.delete(getById(id));

	}

}
