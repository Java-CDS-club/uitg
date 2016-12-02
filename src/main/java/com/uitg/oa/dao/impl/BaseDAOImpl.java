package com.uitg.oa.dao.impl;

import com.uitg.oa.bean.Page;
import com.uitg.oa.dao.BaseDAO;
import com.uitg.oa.entity.IdEntity;
import com.uitg.oa.entity.User;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.sql.Timestamp;
import java.util.*;

/**
 * Description Here
 *
 * @author Michael
 */
public abstract class BaseDAOImpl implements BaseDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Integer save(IdEntity t) {
        t.setCreatedOn(now());
        t.setCreatedBy(currentUser());
        return (Integer) session().save(t);
    }

    @Override
    public List<Integer> saveAll(Collection<? extends IdEntity> ts) {
        List<Integer> ids = new ArrayList<>();
        for (IdEntity t : ts) {
            ids.add(save(t));
        }
        return ids;
    }

    @Override
    public void saveOrUpdate(IdEntity t) {
//        if (t.getId() != null) {
//            t.setUpdatedOn(now());
//            t.setUpdatedBy(currentUser());
//        } else {
            t.setCreatedOn(now());
            if(currentUser()!=null){
              t.setCreatedBy(currentUser());
            }
//        }
        session().saveOrUpdate(t);
    }

    @Override
    public void saveOrUpdateAll(Collection<? extends IdEntity> ts) {
        for (IdEntity t : ts) {
            saveOrUpdate(t);
        }
    }

    @Override
    public void update(IdEntity t) {
        t.setUpdatedOn(now());
        t.setUpdatedBy(currentUser());
        session().update(t);
    }

    @Override
    public void updateAll(Collection<? extends IdEntity> ts) {
        for (IdEntity t : ts) {
            update(t);
        }
    }

    @Override
    public void delete(IdEntity o) {
        session().delete(o);
    }

    @Override
    public void deleteAll(Collection<? extends IdEntity> ts) {
        for (IdEntity t : ts) {
            delete(t);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends IdEntity> E findById(Class<E> clazz, int id) {
        return (E) session().get(clazz, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends IdEntity> E findById(Class<E> clazz, int id, Collection<String> eagerFetchFields) {
        Criteria criteria = session().createCriteria(clazz);
        for(String field : eagerFetchFields) {
            criteria.setFetchMode(field, FetchMode.JOIN);
        }
        criteria.add(Restrictions.eq("id", id));
        return (E) criteria.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends IdEntity> List<E> findAll(Class<E> clazz) {
        return session().createCriteria(clazz).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends IdEntity> List<E> findAll(Class<E> clazz, Collection<String> eagerFetchFields) {
        Criteria criteria = session().createCriteria(clazz);
        for(String field : eagerFetchFields) {
            criteria.setFetchMode(field, FetchMode.JOIN);
        }
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends IdEntity> E findByExample(E e) {
        Criteria criteria = session().createCriteria(e.getClass());
        Example example = Example.create(e);
        criteria.add(example);
        return (E) criteria.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends IdEntity> List<E> findAllByExample(E e) {
        Criteria criteria = session().createCriteria(e.getClass());
        Example example = Example.create(e);
        criteria.add(example);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends IdEntity> List<E> findAllByExample(E e, int pageIndex, int pageSize) {
        Criteria criteria = session().createCriteria(e.getClass());
        Example example = Example.create(e);
        criteria.add(example);
//        criteria.addOrder()
        criteria.setFirstResult((pageIndex - 1) * pageSize);
        criteria.setMaxResults(pageSize);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends IdEntity> List<E> findByCriteria(DetachedCriteria detachedCriteria) {
        Criteria criteria = detachedCriteria.getExecutableCriteria(session());

        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> List<E> findByHql(String hql) {
        Query query = session().createQuery(hql);
        return (List<E>) query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> List<E> findByHql(String hql, int pageIndex, int pageSize) {
        Query query = session().createQuery(hql);

        query.setFirstResult((pageIndex - 1) * pageSize);
        query.setMaxResults(pageSize);
        return (List<E>) query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> List<E> findByHql(String hql, Map<String, Object> args) {
        Query query = session().createQuery(hql);
        for (Map.Entry<String, Object> entry : args.entrySet()) {
            if(entry.getValue() instanceof Collection) {
                query.setParameterList(entry.getKey(), (Collection)entry.getValue());
            } else {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return (List<E>) query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> List<E> findByHql(String hql, Map<String, Object> args, int pageIndex, int pageSize) {
        Query query = session().createQuery(hql);
        for (Map.Entry<String, Object> entry : args.entrySet()) {
            if(entry.getValue() instanceof Collection) {
                query.setParameterList(entry.getKey(), (Collection)entry.getValue());
            } else {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        query.setFirstResult((pageIndex - 1) * pageSize);
        query.setMaxResults(pageSize);
        return (List<E>) query.list();
    }

    @Override
    public List findBySQL(String sql) {
        SQLQuery sqlQuery = session().createSQLQuery(sql);
        return sqlQuery.list();
    }

    @Override
    public int findTotalSize(Criteria criteria) {
        criteria.setProjection(Projections.rowCount());
        int totalSize = ((Long) criteria.uniqueResult()).intValue();
        criteria.setProjection(null);
        return totalSize;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends IdEntity> Page<E> findOnePage(Class<E> clazz, int pageIndex, int pageSize) {

        Criteria criteria = session().createCriteria(clazz);

        int totalSize = findTotalSize(criteria);
        int totalPage = totalSize / pageSize;
        if (totalSize % pageSize != 0) {
            totalPage += 1;
        }

        if (pageIndex > totalPage) {
            pageIndex = totalPage;
        }

//        criteria.add(Restrictions.eq("scrap", false));
        criteria.setFirstResult((pageIndex - 1) * pageSize);
        criteria.setMaxResults(pageSize);

        List<E> list = criteria.list();

        return new Page<>(pageIndex, totalPage, pageSize, totalSize, list);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E extends IdEntity> Page<E> findOnePage(Class<E> clazz, Criterion criterion, int pageIndex, int pageSize) {

        Criteria criteria = session().createCriteria(clazz);
        criteria.add(criterion);

        int totalSize = findTotalSize(criteria);
        int totalPage = totalSize / pageSize;
        if (totalSize % pageSize != 0) {
            totalPage += 1;
        }

        if (pageIndex > totalPage) {
            pageIndex = totalPage;
        }

//        criteria.add(Restrictions.eq("scrap", false));
        criteria.setFirstResult((pageIndex - 1) * pageSize);
        criteria.setMaxResults(pageSize);

        List<E> list = criteria.list();

        return new Page<>(pageIndex, totalPage, pageSize, totalSize, list);
    }

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    public Timestamp now() {
        return new Timestamp(new Date().getTime());
    }

    public User currentUser() {
    	if(SecurityContextHolder.getContext().getAuthentication()!=null){
           Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
           if (user != null) {
               return (User) user;
           }
    	}
        
        return null;
    }
}
