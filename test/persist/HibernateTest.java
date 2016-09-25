package persist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.FlushMode;
import org.hibernate.Hibernate;
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
		
		//s.setId(94);
		s.setTitle("Tops Diner");
		s.setAddress("31 arlington blvd");
		s.setOpenHour(1479834566673L);
		s.setCloseHour(1489834566673L);
		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//template.save(new Comment(1,"Good Nice Hao chi"));
		
		Comment c=new Comment();
		c.setId(94);
		c.setText("Pig Pig 2222");
		c.setSuggestion(template.get(Suggestion.class, 1));
		
		Set<Comment> commentSet=new HashSet<Comment>();
		
		commentSet.add(c);

		s.setComments(commentSet);
		
		template.save(c);
		
		//s.setComments(commentSet);//put commentSet into suggestion
		
		//template.save(s);
		//template.save(c);
		
		
		//System.out.println(template.load(Suggestion.class, 94).getComments());
		List<Suggestion> loadAll = template.loadAll(Suggestion.class);
	
		
		
		
		//Set<Comment> set= template.load(Suggestion.class, 94).getComments();
		
	
		
		
		
		session.getTransaction().commit();
		

		

	}
	
	@Test
	public void FetchTypeTest(){
		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		
		List<Suggestion> loadAll = template.loadAll(Suggestion.class);
		System.out.println(loadAll);
		
		Hibernate.initialize(loadAll.get(0).getComments());
		
		session.getTransaction().commit();
		
//		Session session1 = sessionFactory.getCurrentSession();
//		session1.beginTransaction();
		
		Suggestion suggestion = loadAll.get(0);
		Set<Comment> comments = suggestion.getComments();
		
		for(Comment c:comments){
			System.out.println("*********:"+c.getText());
		}
		
//		session1.getTransaction().commit();
		
		//System.out.println(loadAll.get(0).getComments());
		
		
	}

}















