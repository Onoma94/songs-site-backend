package a.songs_site;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;  

public class Test {

	public static void main(String[] args) {  
	    ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
	    BeanFactory factory = context;
	    Song song=(Song)factory.getBean("song");
	    song.display();
	    
	}  
	
}
