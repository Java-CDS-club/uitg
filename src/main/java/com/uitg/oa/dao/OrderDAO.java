package com.uitg.oa.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import com.uitg.oa.bean.Page;
import com.uitg.oa.entity.Order;

public interface OrderDAO extends BaseDAO {

    public int findTotalSize(Criteria criteria);

    public Page<Order> findOrder(int pageIndex, int pageSize, int userId, boolean isClient,boolean isAdmin);
    
    public Page<Order> findOrder(int pageIndex, int pageSize, int userId, boolean isClient,boolean isAdmin,String status);
}
