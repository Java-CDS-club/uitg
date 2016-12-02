package com.uitg.oa.dao.impl;

import com.uitg.oa.dao.GenericDAO;
import com.uitg.oa.entity.IdEntity;
import org.springframework.stereotype.Component;

/**
 * Description Here
 *
 * @author Michael
 */

@Component
public class GenericDAOImpl<T extends IdEntity> extends BaseDAOImpl implements GenericDAO<T> {
}
