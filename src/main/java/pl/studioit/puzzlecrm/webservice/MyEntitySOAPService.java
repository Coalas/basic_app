package pl.studioit.puzzlecrm.webservice;


import javax.jws.WebService;

import pl.studioit.puzzlecrm.domain.MyEntity;

@WebService
public interface MyEntitySOAPService {
	public String insert(MyEntity entity);
	public MyEntity findById(Long id);

}
