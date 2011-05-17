package pl.studioit.puzzlecrm.service;

import pl.studioit.puzzlecrm.drools.MyDomain;

public interface DroolsService {

	public void executeRules(MyDomain domain);
	
}
