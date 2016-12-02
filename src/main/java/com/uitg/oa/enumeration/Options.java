package com.uitg.oa.enumeration;

import java.util.ArrayList;
import java.util.List;

import static com.uitg.oa.bean.Context.*;

/**
 * Description Here
 *
 * @author Michael
 */
public enum Options {

    // For Smart Phone
    SP_MODEL(OPTS_PHONE, "ServiceModel"),
    SP_PAYMENT(OPTS_PHONE, "Payment"),
    SP_VENDOR(OPTS_PHONE, "Vendor"),
    SP_STG_SIZE(OPTS_PHONE, "Size"),

    USER_DEPT(OPTS_USER, "Department"),
    USER_TITLE(OPTS_USER, "Title"),
    USER_REGION(OPTS_USER, "Region"),
    USER_LOCATION(OPTS_USER, "Location"),

    PC_ASSETS_TYPE(OPTS_PC, "AssetsType"),
    PC_BRAND(OPTS_PC, "Brand"),
    PC_MODEL(OPTS_PC, "PCModel"),
    PC_CPU(OPTS_PC, "CPU"),
    PC_MEMORY(OPTS_PC, "Memory"),
    PC_HDD(OPTS_PC, "HDD"),
    PC_DK_MODEL(OPTS_PC, "DKModel"),
    PC_STATUS(OPTS_PC, "Status"),
    PC_PURCHASE(OPTS_PC, "PurchaseFrom"),
    OS(OPTS_PC, "OS");



    private String name;
    private String type;

    Options(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public static Options[] getOptions(String deviceType) {
        List<Options> list = new ArrayList<Options>();
        for (Options option : values()) {
            if (option.type.equalsIgnoreCase(deviceType)) {
                list.add(option);
            }
        }
        return list.toArray(new Options[list.size()]);
    }

}
