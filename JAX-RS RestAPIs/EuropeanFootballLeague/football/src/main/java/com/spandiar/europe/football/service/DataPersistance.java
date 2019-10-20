package com.spandiar.europe.football.service;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.spandiar.europe.football.database.FootballClubDBModel;

public class DataPersistance {
	
	private SessionFactory sessionFactory;
	private static final int MAXFETCHCOUNT = 25;

	public DataPersistance() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public FootballClubDBModel selectSpecificObject(String clubId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		FootballClubDBModel clubDetailsFromDB = session.get(FootballClubDBModel.class, clubId);
		session.close();
		sessionFactory.close();
		return clubDetailsFromDB;
	}
	
	public List<FootballClubDBModel> selectSpecificClubsFromCountry(String country) {
		String selectClause = "FROM FootballClubDBModel a WHERE a.country = :reqCountry";
		Session session = sessionFactory.openSession();
		Query<FootballClubDBModel> querySession = session.createQuery(selectClause, FootballClubDBModel.class);
		querySession.setParameter("reqCountry", country);
		List<FootballClubDBModel> resultList = querySession.getResultList();
		session.close();
		sessionFactory.close();
		return resultList;
	}
	
	public List<FootballClubDBModel> selectAllRecords() {
		
		String hql = "FROM FootballClubDBModel A";
		Session session = sessionFactory.openSession();
		Query<FootballClubDBModel> querySession = session.createQuery(hql,FootballClubDBModel.class);
		querySession.setMaxResults(MAXFETCHCOUNT);
		List<FootballClubDBModel> resultList = querySession.getResultList();
		session.close();	
		sessionFactory.close();
		return resultList;
	}
	
	public void saveObject(FootballClubDBModel clubDetails) {
		
		clubDetails.setCreatedDt(new Date());
		clubDetails.setModifiedDt(new Date());
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(clubDetails);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
