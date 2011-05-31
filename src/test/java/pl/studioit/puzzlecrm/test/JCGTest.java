package pl.studioit.puzzlecrm.test;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.studioit.puzzlecrm.domain.Category;
import pl.studioit.puzzlecrm.domain.MyEntity;
import pl.studioit.puzzlecrm.drools.MyDomain;
import pl.studioit.puzzlecrm.jms.MyQueueSender;
import pl.studioit.puzzlecrm.service.ActivitiService;
import pl.studioit.puzzlecrm.service.CategoryService;
import pl.studioit.puzzlecrm.service.DroolsService;
import pl.studioit.puzzlecrm.service.MyEntityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/spring/applicationContext*.xml"})
public class JCGTest extends TestCase {
	@Autowired
	private MyEntityService myEntityService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ActivitiService activitiService;
	
	@Autowired
	private DroolsService droolsService;
	
	@Autowired
	private MyQueueSender myQueueSender;
	
	@Test
	public void testMyEntity() {
		MyEntity entity = new MyEntity();
		entity.setName("test");
		myEntityService.persist(entity);
	}
	@Test
	public void testCategoryEntity() {
		//categoryService.findLevel(0);
		Category entity = new Category();
		entity.setName("testowa");
		
		//List<Category> list = new  LinkedList<Category>();
		//list.add(entity);
		//categoryService.find(3L).setChildren(list);
		
		//Category cat = categoryService.find(3L);
		List <Category> l = categoryService.findLevel(0);
		for (Category c: l) {
			System.out.println("Menu "+c.getName());
		}
		//assertEquals(3, cat.getChildren().size());
		//entity.setParent(cat);
		//cat.getChildren().add(entity);
		//categoryService.merge(cat);
		//categoryService.persist(entity);
		

	}
	@Test
	public void testActiviti() {
		activitiService.startProcess();
	}
	
	@Test
	public void testDrools() {
		MyDomain domain = new MyDomain();
		domain.setName("test");
		domain.setLastName("test");
		droolsService.executeRules(domain);
		assertEquals("description ",domain.getDescription(),"set name=[jcg] and lastName =[jcg] to become a geek!!!");
	}

	@Test
	public void testJMS() {
		myQueueSender.sendMessage("test");
	}
}
