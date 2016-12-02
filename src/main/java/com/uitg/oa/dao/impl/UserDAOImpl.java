package com.uitg.oa.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.uitg.oa.bean.Page;
import com.uitg.oa.dao.UserDAO;
import com.uitg.oa.entity.User;

import java.util.List;

@Component
public class UserDAOImpl extends BaseDAOImpl implements UserDAO{

	    @Override
	    public int findTotalSize(Criteria criteria) {
	        criteria.setProjection(Projections.rowCount());
	        int totalSize =  ((Long)criteria.uniqueResult()).intValue();
	        criteria.setProjection(null);
	        return totalSize;
	    }

	    @Override
	    public Page<User> findUser(int pageIndex, int pageSize, String userType) {

	        Criteria criteria = session().createCriteria(User.class);
	
	        criteria.add(Restrictions.eq("userType", userType ));	        	

	        int totalSize = findTotalSize(criteria);
	        int totalPage = totalSize / pageSize;
	        if(totalSize % pageSize != 0) {
	            totalPage += 1;
	        }

	        if(pageIndex > totalPage) {
	            pageIndex = totalPage;
	        }
	
	        criteria.setFirstResult((pageIndex - 1) * pageSize);
	        criteria.setMaxResults(pageSize);

	        List<User> userlists = criteria.list();

	        return new Page<>(pageIndex, totalPage, pageSize, totalSize, userlists);
       }
}