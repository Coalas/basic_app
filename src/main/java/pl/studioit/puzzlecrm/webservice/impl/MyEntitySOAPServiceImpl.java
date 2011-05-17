package pl.studioit.puzzlecrm.webservice.impl;


import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.studioit.puzzlecrm.domain.MyEntity;
import pl.studioit.puzzlecrm.service.MyEntityService;
import pl.studioit.puzzlecrm.webservice.MyEntitySOAPService;

@WebService(endpointInterface = "pl.studioit.puzzlecrm.webservice.MyEntitySOAPService")
public class MyEntitySOAPServiceImpl implements MyEntitySOAPService {

	private Logger log = LoggerFactory.getLogger(MyEntitySOAPService.class);
	
	@Autowired
	private MyEntityService myEntityService;
	
	public String insert(@WebParam(name = "myentity")MyEntity entity) {
		log.info("insert method invoked");
		myEntityService.persist(entity);
		return "entity with id =[{"+entity.getId()+"}] persisted";
	}
	
	public MyEntity findById(@WebParam(name = "id")Long id) {
		return myEntityService.find(id);
	}

}
