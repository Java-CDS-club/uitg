package com.uitg.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CM_INDUSTRY")
public class IndustryCode extends IdEntity {
	private Integer id;
	private String industrydesc;
	private String code;
	
	public IndustryCode(){
		
	}
	
	public IndustryCode(Integer id){
		this.id = id;
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
    
    @Column(name = "DESCIRPTION")
    public String getIndustrydesc() {
		return industrydesc;
	}

	public void setIndustrydesc(String industrydesc) {
		this.industrydesc = industrydesc;
	}

	@Column(name = "CODE")
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndustryCode other = (IndustryCode) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
    
	
    
}
