package com.uitg.oa.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.uitg.oa.bean.Page;
import com.uitg.oa.dao.OrderDAO;
import com.uitg.oa.entity.Order;
import com.uitg.oa.entity.User;
import com.uitg.oa.util.LangUtil;

import java.util.List;

@Component
public class OrderDAOImpl extends BaseDAOImpl implements OrderDAO{

	    @Override
	    public int findTotalSize(Criteria criteria) {
	        criteria.setProjection(Projections.rowCount());
	        int totalSize =  ((Long)criteria.uniqueResult()).intValue();
	        criteria.setProjection(null);
	        return totalSize;
	    }

	    @Override
	    public Page<Order> findOrder(int pageIndex, int pageSize, int userId, boolean isClient,boolean isAdmin,String status) {

	        Criteria criteria = session().createCriteria(Order.class);
	        if(!isAdmin){
	        	if(isClient){
	        	  criteria.add(Restrictions.eq("client", new User(userId) ));
	        	  criteria.add(Restrictions.eq("mainOrder", true));
	        	}else{
	              criteria.add(Restrictions.eq("assignee", new User(userId) ));
	              if(StringUtils.isNotBlank(status)){
	            	  criteria.add(Restrictions.ne("status", LangUtil.ORDER_STATUS_FINISH));
	              }else{
	            	  criteria.add(Restrictions.eq("status", LangUtil.ORDER_STATUS_FINISH));
	              }
	        	}
	        }else{
	        	criteria.add(Restrictions.eq("mainOrder", true));
	        }
	        int totalSize = findTotalSize(criteria);
	        int totalPage = totalSize / pageSize;
	        if(totalSize % pageSize != 0) {
	            totalPage += 1;
	        }

	        if(pageIndex > totalPage) {
	            pageIndex = totalPage;
	        }

	        criteria.addOrder(org.hibernate.criterion.Order.desc("id"));
	        criteria.setFirstResult((pageIndex - 1) * pageSize);
	        criteria.setMaxResults(pageSize);

	        List<Order> orderss = criteria.list();

	        return new Page<>(pageIndex, totalPage, pageSize, totalSize, orderss);
       }

		@Override
		public Page<Order> findOrder(int pageIndex, int pageSize, int userId,boolean isClient, boolean isAdmin) {
			return findOrder(pageIndex, pageSize, userId, isClient,isAdmin,"");
		}
}