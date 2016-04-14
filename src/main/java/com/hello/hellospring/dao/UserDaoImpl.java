package com.hello.hellospring.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hello.hellospring.model.User;
import org.springframework.transaction.annotation.Transactional;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {


	@Transactional
	public void save(User user) {
		persist(user);
	}

	@Transactional
	public User findById(int id) {
		return getByKey(id);
	}

	@Transactional
	public User findBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		return (User) crit.uniqueResult();
	}

}
