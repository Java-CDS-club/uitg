package com.uitg.oa.util;

import org.apache.commons.beanutils.*;
import org.apache.commons.beanutils.expression.Resolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Description Here
 *
 * @author Michael
 */
public class BeanCopier {

    private Logger logger = LoggerFactory.getLogger(BeanCopier.class);

    private Object src;

    private Object dst;

    private List<String> includeFields;

    private List<String> excludeFields;

    private ConvertUtilsBean convertUtilsBean;

    private PropertyUtilsBean propertyUtilsBean;

    private BeanCopier() {
        convertUtilsBean = new ConvertUtilsBean();
        propertyUtilsBean = new PropertyUtilsBean();

        includeFields = new ArrayList<String>();
        excludeFields = new ArrayList<String>();
    }

    private BeanCopier(Object dst, Object src) {
        this();
        this.dst = dst;
        this.src = src;
    }

    public static BeanCopier buildCopier(Object dst, Object src) {
        return new BeanCopier(dst, src);
    }

    public static BeanCopier buildCopier() {
        return new BeanCopier();
    }

    public BeanCopier excludeDefault() {
        return this.exclude("id","createdBy","createdOn","updatedBy","updatedOn");
    }

    public BeanCopier exclude(String... excludeFields) {
        if(excludeFields == null || excludeFields.length == 0) {
            return this;
        }
        for(String excludeField : excludeFields) {
            if(this.excludeFields.contains(excludeField)) {
                continue;
            }
            this.excludeFields.add(excludeField);
        }
        return this;
    }

    public BeanCopier exclude(List<String> excludeFields) {
        if(excludeFields == null || excludeFields.size() == 0) {
            return this;
        }
        for(String excludeField : excludeFields) {
            if(this.excludeFields.contains(excludeField)) {
                continue;
            }
            this.excludeFields.add(excludeField);
        }
        return this;
    }

    public BeanCopier include(String... includeFields) {
        if(includeFields == null || includeFields.length == 0) {
            return this;
        }
        for(String includeField : includeFields) {
            if(this.includeFields.contains(includeField)) {
                continue;
            }
            this.includeFields.add(includeField);
        }
        return this;
    }

    public BeanCopier include(List<String> includeFields) {
        if(includeFields == null || includeFields.size() == 0) {
            return this;
        }
        for(String includeField : includeFields) {
            if(this.includeFields.contains(includeField)) {
                continue;
            }
            this.includeFields.add(includeField);
        }
        return this;
    }

    public void copy() {
        doCopy(this.dst, this.src);
    }

    public void copy(Object dst, Object src) {
        doCopy(dst, src);
    }

    /**
     *
     * Code copied from org.apache.commons.beanutils.BeanUtils.copyProperties
     */
    private void doCopy(Object dist, Object orig) {

        // Validate existence of the specified beans
        if (dist == null) {
            throw new IllegalArgumentException
                    ("No destination bean specified");
        }
        if (orig == null) {
            throw new IllegalArgumentException("No origin bean specified");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("BeanUtils.copyProperties(" + dist + ", " +
                    orig + ")");
        }

        try {
            // Copy the properties, converting as necessary
            if (orig instanceof DynaBean) {
                DynaProperty[] origDescriptors = ((DynaBean) orig).getDynaClass().getDynaProperties();
                for (DynaProperty origDescriptor : origDescriptors) {
                    String name = origDescriptor.getName();

                    if(includeFields.size() > 0 && !includeFields.contains(name)) {
                        continue;
                    }

                    if(excludeFields.size() > 0 && excludeFields.contains(name)) {
                        continue;
                    }

                    // Need to check isReadable() for WrapDynaBean
                    // (see Jira issue# BEANUTILS-61)
                    if (getPropertyUtils().isReadable(orig, name) &&
                            getPropertyUtils().isWriteable(dist, name)) {
                        Object value = ((DynaBean) orig).get(name);
                        copyProperty(dist, name, value);
                    }
                }
            } else if (orig instanceof Map) {
                for (Object o : ((Map) orig).entrySet()) {
                    Map.Entry entry = (Map.Entry) o;
                    String name = (String) entry.getKey();

                    if(includeFields.size() > 0 && !includeFields.contains(name)) {
                        continue;
                    }

                    if(excludeFields.size() > 0 && excludeFields.contains(name)) {
                        continue;
                    }

                    if (getPropertyUtils().isWriteable(dist, name)) {
                        copyProperty(dist, name, entry.getValue());
                    }
                }
            } else /* if (orig is a standard JavaBean) */ {
                PropertyDescriptor[] origDescriptors = getPropertyUtils().getPropertyDescriptors(orig);
                for (PropertyDescriptor origDescriptor : origDescriptors) {
                    String name = origDescriptor.getName();
                    if ("class".equals(name)) {
                        continue; // No point in trying to set an object's class
                    }

                    if(includeFields.size() > 0 && !includeFields.contains(name)) {
                        continue;
                    }

                    if(excludeFields.size() > 0 && excludeFields.contains(name)) {
                        continue;
                    }

                    if (getPropertyUtils().isReadable(orig, name) &&
                            getPropertyUtils().isWriteable(dist, name)) {
                        try {
                            Object value = getPropertyUtils().getSimpleProperty(orig, name);
                            copyProperty(dist, name, value);
                        } catch (NoSuchMethodException e) {
                            // Should not happen
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Internal Error: ", e);
        }
    }

    public void copyProperty(Object bean, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {

        // Trace logging (if enabled)
        if (logger.isTraceEnabled()) {
            StringBuilder sb = new StringBuilder("  copyProperty(");
            sb.append(bean);
            sb.append(", ");
            sb.append(name);
            sb.append(", ");
            if (value == null) {
                sb.append("<NULL>");
            } else if (value instanceof String) {
                sb.append((String) value);
            } else if (value instanceof String[]) {
                String[] values = (String[]) value;
                sb.append('[');
                for (int i = 0; i < values.length; i++) {
                    if (i > 0) {
                        sb.append(',');
                    }
                    sb.append(values[i]);
                }
                sb.append(']');
            } else {
                sb.append(value.toString());
            }
            sb.append(')');
            logger.trace(sb.toString());
        }

        // Resolve any nested expression to get the actual target bean
        Object target = bean;
        Resolver resolver = getPropertyUtils().getResolver();
        while (resolver.hasNested(name)) {
            try {
                target = getPropertyUtils().getProperty(target, resolver.next(name));
                name = resolver.remove(name);
            } catch (NoSuchMethodException e) {
                return; // Skip this property setter
            }
        }
        if (logger.isTraceEnabled()) {
            logger.trace("    Target bean = " + target);
            logger.trace("    Target name = " + name);
        }

        // Declare local variables we will require
        String propName = resolver.getProperty(name); // Simple name of target property
        Class type = null;                            // Java type of target property
        int index = resolver.getIndex(name);         // Indexed subscript value (if any)
        String key = resolver.getKey(name);           // Mapped key value (if any)

        // Calculate the target property type
        if (target instanceof DynaBean) {
            DynaClass dynaClass = ((DynaBean) target).getDynaClass();
            DynaProperty dynaProperty = dynaClass.getDynaProperty(propName);
            if (dynaProperty == null) {
                return; // Skip this property setter
            }
            type = dynaProperty.getType();
        } else {
            PropertyDescriptor descriptor = null;
            try {
                descriptor =
                        getPropertyUtils().getPropertyDescriptor(target, name);
                if (descriptor == null) {
                    return; // Skip this property setter
                }
            } catch (NoSuchMethodException e) {
                return; // Skip this property setter
            }
            type = descriptor.getPropertyType();
            if (type == null) {
                // Most likely an indexed setter on a POJB only
                if (logger.isTraceEnabled()) {
                    logger.trace("    target type for property '" +
                            propName + "' is null, so skipping ths setter");
                }
                return;
            }
        }
        if (logger.isTraceEnabled()) {
            logger.trace("    target propName=" + propName + ", type=" +
                    type + ", index=" + index + ", key=" + key);
        }

        // Convert the specified value to the required type and store it
        if (index >= 0) {                    // Destination must be indexed
            value = convert(value, type.getComponentType());
            try {
                getPropertyUtils().setIndexedProperty(target, propName,
                        index, value);
            } catch (NoSuchMethodException e) {
                throw new InvocationTargetException
                        (e, "Cannot set " + propName);
            }
        } else if (key != null) {            // Destination must be mapped
            // Maps do not know what the preferred data type is,
            // so perform no conversions at all
            // FIXME - should we create or support a TypedMap?
            try {
                getPropertyUtils().setMappedProperty(target, propName,
                        key, value);
            } catch (NoSuchMethodException e) {
                throw new InvocationTargetException
                        (e, "Cannot set " + propName);
            }
        } else {                             // Destination must be simple
            value = convert(value, type);
            try {
                getPropertyUtils().setSimpleProperty(target, propName, value);
            } catch (NoSuchMethodException e) {
                throw new InvocationTargetException
                        (e, "Cannot set " + propName);
            }
        }

    }

    protected Object convert(Object value, Class type) {
        Converter converter = getConvertUtils().lookup(type);
        if (converter != null) {
            logger.trace("        USING CONVERTER " + converter);
            return converter.convert(type, value);
        } else {
            return value;
        }
    }

    public ConvertUtilsBean getConvertUtils() {
        return convertUtilsBean;
    }

    public PropertyUtilsBean getPropertyUtils() {
        return propertyUtilsBean;
    }

}
