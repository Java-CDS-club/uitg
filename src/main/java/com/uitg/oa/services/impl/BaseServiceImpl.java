package com.uitg.oa.services.impl;

import com.uitg.oa.dao.GenericDAO;
import com.uitg.oa.entity.IdEntity;
import com.uitg.oa.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Description Here
 *
 * @author Michael
 */
public abstract class BaseServiceImpl implements BaseService {

    @Autowired
    GenericDAO baseDao;

    @Override
    public Integer save(IdEntity t) {
        return baseDao.save(t);
    }

    @Override
    public void saveAll(Collection<? extends IdEntity> ts) {
        baseDao.saveAll(ts);
    }

    @Override
    public void saveOrUpdate(IdEntity t) {
        baseDao.saveOrUpdate(t);
    }

    @Override
    public void saveOrUpdateAll(Collection<? extends IdEntity> ts) {
        baseDao.saveOrUpdateAll(ts);
    }

    @Override
    public void update(IdEntity t) {
        baseDao.update(t);
    }

    @Override
    public void updateAll(Collection<IdEntity> ts) {
        baseDao.updateAll(ts);
    }

    @Override
    public void delete(IdEntity t) {
        baseDao.delete(t);
    }

    @Override
    public <E extends IdEntity> E findById(Class<E> clazz, int id) {
        return baseDao.findById(clazz, id);
    }

    @Override
    public <E extends IdEntity> List<E> findAll(Class<E> clazz) {
        return baseDao.findAll(clazz);
    }

    @Override
    public <E extends IdEntity> E findByExample(E e) {
        return baseDao.findByExample(e);
    }

    @Override
    public <E extends IdEntity> List<E> findAllByExample(E e) {
        return baseDao.findAllByExample(e);
    }

    @Override
    public <E> List<E> findByHql(String hql) {
        return baseDao.findByHql(hql);
    }

    @Override
    public <E> List<E> findByHql(String hql, Map<String, Object> args) {
        return baseDao.findByHql(hql, args);
    }

    public Date now() {
        return new Date();
    }
}
