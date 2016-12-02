package com.uitg.oa.entity;

import javax.validation.constraints.NotNull;

public class RegistrantValue extends User{
	@NotNull(message="{validation.not.empty}")
	private String confirmPassword;
	private String verifyCode;
	private Boolean freelancer; 

	public RegistrantValue() {
		super();
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	public Boolean getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Boolean freelancer) {
		this.freelancer = freelancer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result
				+ ((verifyCode == null) ? 0 : verifyCode.hashCode());
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
		RegistrantValue other = (RegistrantValue) obj;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
			return false;
		if (verifyCode == null) {
			if (other.verifyCode != null)
				return false;
		} else if (!verifyCode.equals(other.verifyCode))
			return false;
		return true;
	}
	
	

}
