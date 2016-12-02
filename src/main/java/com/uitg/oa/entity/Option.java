package com.uitg.oa.entity;


import org.apache.commons.lang.StringUtils;

import javax.persistence.*;

@Entity
@Table(name = "CM_OPTION")
public class Option extends IdEntity {
	private Integer id;
    private String type;

    private String name;

    private String options;

    public Option() {
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Option(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "OPTIONS")
    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    @Transient
    public String[] getOptionsAsArray() {
        if (StringUtils.isNotBlank(options)) {
            return options.split("\\r\\n");
        }
        return null;
    }

    public void setOptionsAsArray(String[] optionsArray) {
        int index = 0;
        if (optionsArray != null) {
            for (String option : optionsArray) {
                if (StringUtils.isNotBlank(option)) {
                    optionsArray[index++] = option;
                }
            }

            options = StringUtils.join(optionsArray, "\r\n", 0, index);
        }
    }

}
