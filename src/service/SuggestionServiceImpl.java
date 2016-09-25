package service;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.SuggestionDAO;
import model.Suggestion;

@Service
@Transactional
public class SuggestionServiceImpl implements SuggestionService {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	SuggestionDAO suggestionDAO;
	
	@Override
	public void addSuggestion(Suggestion sug) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		suggestionDAO.addSuggestion(sug);
		
		tx.commit();
		
	}

	@Override
	public Suggestion getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		 Suggestion suggestion = suggestionDAO.getById(id);
		 
		 
		 //force initialize proxy
		 Hibernate.initialize(suggestion.getComments());
		tx.commit();
		return suggestion;
	}
	
	@Override
	public Suggestion getByIdWithoutComment(int id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		 Suggestion suggestion = suggestionDAO.getById(id);
		 
		 //暂时代替的方法， 把proxy设置为null，这样就不会实例化了
		 suggestion.setComments(null);
		 
		tx.commit();
		return suggestion;
	}
	
	
	

	@Override
	public List<Suggestion> listSuggestion() {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		List<Suggestion> listSuggestion = suggestionDAO.listSuggestion();
		
		 Hibernate.initialize(listSuggestion);
		
		tx.commit();
		
		return listSuggestion;
	}

	@Override
	public void updateSuggestion(Suggestion sug) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		suggestionDAO.updateSuggestion(sug);
		
		tx.commit();
	}

	@Override
	public void deleteSuggestion(int id) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		suggestionDAO.deleteSuggestion(id);
		
		tx.commit();

	}

}
