package com.uitg.oa.dao;


import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

import com.uitg.oa.bean.Page;
import com.uitg.oa.entity.IdEntity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Description Here
 *
 * @author Paddy
 */
public interface BaseDAO {

    public Integer save(IdEntity t);

    public List<Integer> saveAll(Collection<? extends IdEntity> ts);

    public void saveOrUpdate(IdEntity t);

    public void saveOrUpdateAll(Collection<? extends IdEntity> ts);

    public void update(IdEntity t);

    public void updateAll(Collection<? extends IdEntity> ts);

    public void delete(IdEntity t);

    public void deleteAll(Collection<? extends IdEntity> ts);

    public <E extends IdEntity> E findById(Class<E> clazz, int id);

    public <E extends IdEntity> E findById(Class<E> clazz, int id, Collection<String> eagerFetchFields);

    public <E extends IdEntity> List<E> findAll(Class<E> clazz);

    public <E extends IdEntity> List<E> findAll(Class<E> clazz, Collection<String> eagerFetchFields);

    public <E extends IdEntity> E findByExample(E e);

    public <E extends IdEntity> List<E> findAllByExample(E e);

    public <E extends IdEntity> List<E> findAllByExample(E e, int pageIndex, int pageSize);

    public <E extends IdEntity> List<E> findByCriteria(DetachedCriteria detachedCriteria);

    public <E> List<E> findByHql(String hql);

    public <E> List<E> findByHql(String hql, int pageIndex, int pageSize);

    public <E> List<E> findByHql(String hql, Map<String, Object> args);

    public <E> List<E> findByHql(String hql, Map<String, Object> args, int pageIndex, int pageSize);

    public List findBySQL(String sql);

    public int findTotalSize(Criteria criteria);

    public <E extends IdEntity> Page<E> findOnePage(Class<E> clazz, int pageIndex, int pageSize);

    public <E extends IdEntity> Page<E> findOnePage(Class<E> clazz, Criterion criterion, int pageIndex, int pageSize);
}
