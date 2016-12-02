package com.uitg.oa.enumeration;

/**
 * Description Here
 *
 * @author Michael
 */
public enum DeviceType {

    PHONE, TOKEN, PC;

    public DeviceType convert(String type) {
        for (DeviceType t : values()) {
            if (t.toString().equalsIgnoreCase(type)) {
                return t;
            }
        }
        return null;
    }

}
