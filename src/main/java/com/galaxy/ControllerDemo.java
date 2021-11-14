package com.galaxy;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import model.Student;
import model.StudentDao;

@Controller
public class ControllerDemo {
	private ApplicationContext conn;
	
	@RequestMapping("/home")
	public String view1()
	{
		return "home";
	}
	
	@RequestMapping("/register")
	public String view2(Model m)
	{
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Student stud= conn.getBean("info",Student.class);
		m.addAttribute("bean",stud);
		return "register";
	}
	
	@RequestMapping("/store")
	public String view3(@ModelAttribute("bean") Student s , Model m)
	{
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentDao obj=conn.getBean("dao",StudentDao.class);
		obj.save(s);
		m.addAttribute("msg","Record Inserted Succesfully...");
		return "register";
	}
	
	
	@RequestMapping("/display")
	public String view4(Model m)
	{
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentDao obj=conn.getBean("dao",StudentDao.class);
		List list=obj.display();
		m.addAttribute("data",list);
		return "display";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m){ 
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentDao obj=conn.getBean("dao",StudentDao.class);
        Student emp=obj.getEmpById(id);  
        m.addAttribute("command",emp);
        return "editform";  
    }
	
	@RequestMapping(value="/editsave")
    public String editsave(@ModelAttribute("bean") Student s){  
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentDao obj=conn.getBean("dao",StudentDao.class);
        obj.update(s); 
		return "redirect:/display";
    }
	
	@RequestMapping("/delete/{id}")
	  public String delete(@PathVariable int id){  
		StudentDao obj=conn.getBean("dao",StudentDao.class);
        obj.delete(id);  
        return "redirect:/display";  
    }
}
