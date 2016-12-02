package com.uitg.oa.services;

import com.uitg.oa.entity.IdEntity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Description Here
 *
 * @author Michael
 */
public interface BaseService {

    public Integer save(IdEntity t);

    public void saveAll(Collection<? extends IdEntity> ts);

    public void saveOrUpdate(IdEntity t);

    public void saveOrUpdateAll(Collection<? extends IdEntity> ts);

    public void update(IdEntity t);

    public void updateAll(Collection<IdEntity> ts);

    public void delete(IdEntity t);

    public <E extends IdEntity> E findById(Class<E> clazz, int id);

    public <E extends IdEntity> List<E> findAll(Class<E> clazz);

    public <E extends IdEntity> E findByExample(E e);

    public <E extends IdEntity> List<E> findAllByExample(E e);

    public <E> List<E> findByHql(String hql);

    public <E> List<E> findByHql(String hql, Map<String, Object> args);

}
