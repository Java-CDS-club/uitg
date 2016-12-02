package com.uitg.oa.services;

import com.uitg.oa.entity.IdEntity;
import com.uitg.oa.entity.Option;

import java.util.List;

/**
 * Description Here
 *
 * @author Michael
 */
public interface OptionService extends BaseService {
    public List<Option> findByType(String type);
}
