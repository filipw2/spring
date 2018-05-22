package com.itemtracker.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenaRepositoryCustomImpl implements CenaRepositoryCustom{

	@Autowired
	EntityManager em;
	
	@Override
	public List<Cena> getLatestCenas() {
		DetachedCriteria maxQuery = DetachedCriteria.forClass( Cena.class );
		maxQuery.setProjection( Projections.max( "data" ) );

		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		//query.add( Property.forName( "data" ).eq( maxQuery ) );
		return null;
	}

}
