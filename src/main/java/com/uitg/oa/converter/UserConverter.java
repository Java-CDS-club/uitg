package com.uitg.oa.converter;

import com.uitg.oa.entity.User;
import org.springframework.core.convert.converter.Converter;

/**
 * Description Here
 *
 * @author Michael
 */
public class UserConverter implements Converter<String, User> {
    @Override
    public User convert(String source) {
        return new User(Integer.valueOf(source));
    }
}
