package nexturn.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        try {
			
        	Configuration cfg = new Configuration().configure(); //Loads hibernate.cfg.xml

			ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

			Metadata metadata = new MetadataSources(reg).addAnnotatedClass(Student.class).getMetadataBuilder()
					.build();
//			SessionFactory factory = cfg.buildSessionFactory(reg);
			
			SessionFactory factory = metadata.getSessionFactoryBuilder().build();

			Session session = factory.openSession();

//			Student s = new Student();
//			s.setName("Nikhil");
//			s.setSection("A");
//			Student s1 = new Student();
//			s1.setName("Test1");
//			s1.setSection("B");
//			session.beginTransaction();
//
//			session.persist(s);
//			session.persist(s1);
//			session.getTransaction().commit();
//        	
			Student s3 = session.get(Student.class, 1);	
			System.out.println(s3.getName());
        	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
