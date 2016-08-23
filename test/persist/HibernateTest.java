package persist;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

import dao.SuggestionDAOImpl;
import model.Comment;
import model.Suggestion;
import service.SuggestionService;

public class HibernateTest {

	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	HibernateTemplate template = (HibernateTemplate) context.getBean("template");
	SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	SuggestionService suggestionService =(SuggestionService) context.getBean("SuggestionService");
	
	
	@Test
	public void testGetUserbyId() {

		SuggestionDAOImpl sDAOImpl = new SuggestionDAOImpl();
		

		Suggestion s = new Suggestion();
		s.setId(1);
		s.setTitle("Tops Diner");
		s.setAddress("31 arlington blvd");
		s.setOpenHour(1479834566673L);
		s.setCloseHour(1489834566673L);
		//sDAOImpl.setSessionFactory(sessionFactory);

		// sDAOImpl.addCommonByTemplate(s);
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//template.save(new Comment(1,"Good Nice Hao chi"));
		
		//template.save(s);
		
		
		
		session.getTransaction().commit();
		
		//System.out.println(sDAOImpl.getById(11).getOpenHour());

		

	}

}
