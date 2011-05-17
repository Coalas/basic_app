package pl.studioit.puzzlecrm.dao;


import org.springframework.stereotype.Repository;

import pl.studioit.puzzlecrm.domain.MyEntity;

@Repository("myEntityDAO")
public class MyEntityDAO extends GenericDAO<MyEntity,Long> {
	

}
