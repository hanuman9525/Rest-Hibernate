package com.scp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

	static SessionFactory sessionFactoy;
	
	public static SessionFactory getSessionFactory(){
		if(null==sessionFactoy){
			sessionFactoy=new Configuration().configure().buildSessionFactory();
		}
		return sessionFactoy;
	}
	
	
}