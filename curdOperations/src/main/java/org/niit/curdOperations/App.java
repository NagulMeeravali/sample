package org.niit.curdOperations;

import java.util.ArrayList;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.niit.curdOperations.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Configuration cfg=new Configuration().configure().addAnnotatedClass(Student.class);
    	SessionFactory sf=cfg.buildSessionFactory();
    	
    	Session session= sf.openSession();
    	Session session1=sf.openSession();
    	Transaction tx=session.beginTransaction();
       System.out.println("1. insert record");
       System.out.println("2. delete record");
       System.out.println("3. update record");
       System.out.println("4. select all records");
       System.out.println("5. Search");
       System.out.println("select any one option");
       Scanner s=new Scanner(System.in);
       int opt=s.nextInt();
       if(opt==1)
       {
    	   Student obj1=new Student();
    	   obj1.setSid("s105");
    	   obj1.setName("Samatha");
    	   obj1.setMarks(90);
    	   obj1.setEmail("Samatha@gmail.com");
    	   obj1.setCity("bglr");
     	   session.save(obj1);
       }
       else if(opt==2)
       {
    	   Student d=new Student();
    	   System.out.println("Enter student id to delete");
    	   d.setSid(s.next());
    	   session.delete(d);
       }
       else if(opt==3)
       {
    	   Student ud=new Student();
    	   ud.setMarks(67);
    	  ud.setName("harish");
    	   ud.setCity("Bglr");
    	   ud.setEmail("harish@gmail.com");
    	   System.out.println("Enter student id");
    	   ud.setSid(s.next());
    	   session.update(ud);
       }
       else if(opt==4)
       {
    	   ArrayList<Student> al=new ArrayList<Student>();
    	   al=(ArrayList<Student>)session.createQuery("from Student").list();
    	   for(Student s1:al)
    	   {
    		   System.out.println(s1.getSid()+"  "+s1.getName()+" "+s1.getEmail()+"  "+s1.getMarks()+"  "+s1.getCity());
    	   }
       }
       else if(opt==5)
       {
    	   Student s2=new Student();
    	   Student s3=new Student();
    	   
    	   System.out.println("Enter your student id");
    	   String sid=s.next();
    	   String sid1=s.next();
    	   s2=(Student)session.get(Student.class,sid);
    	   s3=(Student)session1.get(Student.class,sid1);
    	   
    	   System.out.println(s2.toString());
    	   System.out.println(s3.toString());
    	   
       }
       
       tx.commit();
       session.close();
       
       
    }
}
