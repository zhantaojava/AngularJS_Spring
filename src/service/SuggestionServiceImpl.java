package service;

import java.util.List;

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
		
		tx.commit();
		return suggestion;
	}

	@Override
	public List<Suggestion> listSuggestion() {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		List<Suggestion> listSuggestion = suggestionDAO.listSuggestion();
		
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
