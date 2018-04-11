package com.scp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.scp.bean.User;
import com.scp.util.SessionFactoryUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		Session session= SessionFactoryUtil.getSessionFactory().openSession();
		session.beginTransaction();
		UserEntity entity=new UserEntity();
		entity.setUserId(user.getUserId());
		entity.setUserName(user.getUserName());
		int n=(int) session.save(entity);
		session.getTransaction().commit();
		session.close();
		if(n>0)
			return "added";
		else
			return "failed";
	}

	
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		Session session= SessionFactoryUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<UserEntity> userEtity=(List<UserEntity>) session.createCriteria(UserEntity.class).list();
		List<User> userList=new ArrayList<>();
		User user;
		for (UserEntity userEntity : userEtity) {
			user=new User();
			user.setUserId(userEntity.getUserId());
			user.setUserName(userEntity.getUserName());
			userList.add(user);
		}
		session.close();
		return userList;
	}

	@Override
	public User getUser(String userId) {
		Session session= SessionFactoryUtil.getSessionFactory().openSession();
				
		UserEntity userEtity=(UserEntity) session.createCriteria(UserEntity.class).add(Restrictions.eq("userId", userId)).uniqueResult();
		User user=new User();
		user.setUserId(userEtity.getUserId());
		user.setUserName(userEtity.getUserName());
		session.close();
		return user;
	}

}
