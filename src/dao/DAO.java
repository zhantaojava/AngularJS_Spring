package dao;

import java.util.LinkedList;
import java.util.List;

import model.Person;
import model.Suggestion;

public class DAO {
	
	public List<?> ListPerson(){
		
		List list=new LinkedList<>();
		
		
		Suggestion sug=new Suggestion();
		
		list.add(new Person(2,"Ervin Howell","36 president st","Shanna@melissa.tv"));
		list.add(new Person(3,"Leanne Graham","99 elm st","Sincere@april.biz"));
		list.add(sug);
		
		return list;
	}
	
}
