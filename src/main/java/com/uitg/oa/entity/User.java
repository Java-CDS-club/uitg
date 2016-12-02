package com.uitg.oa.entity;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.uitg.oa.bean.SelectLabelBean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "CM_USER")
public class User extends IdEntity implements UserDetails {
	private Integer id;
	private String userno;
	private String employeeNo;
    private String username;
    private String password;
    private String firstName; 
    private String familyName;
    private String email;
    private String primaryEmail;
    private String address;
    private String fax;
    private String cellPhone;   
    private String phone;
    private String zipCode;
    private String imAccount;
    private String status;//freelance  active passive
    private String quality;//freelance quality A B C
   
    private String language;//system language
    private String nationality;     
    private String industry;
    private String region;
    private String location;
    private String title;

    private Integer yearsOfWorking;
    private String school;
    private String major;
    private String degree;
    
    private String clientType;//MLV-VIP\important\big \small client
	private String userType;//1 freelancer 2 admin 3 sales 4 finance 5 project manager 6 client

    private String companyName;	
    private String website;		
	private String currency;
	private Boolean needInvoice;
	private String paymentTerms;//default 30
	private String invoiceName;//发票抬头
	private String invoiceReceiver;//发票接收人
	private String invoiceTaxIdentifyNo;//纳税人识别号
	
    
    private Boolean freelancerAudit;
    private String sourceLanguage;//source
	private String targetLanguage;//target
	private String sourceLanguage2;//source
	private String targetLanguage2;//target
	private String sourceLanguage3;//source
	private String targetLanguage3;//target
	private String motherTongue;
    private String foreignLanguage1;
    private String foreignLanguage2;
    private String foreignLanguage3;
    private Double unitPrice;// quote/sourceprice
	private String payType;//Cash, PayPal,  Cheque, Bank transfer(bank transfer by default)
	private Boolean translation;
	private Boolean trados;
	private String tradosVersion;
    private Boolean gameLocalization;
    private Boolean transcreation;
    private Boolean interpreting;
    private Double unitPriceInter;//Quote/hour for Interpreting
    private Boolean subtitling;
    private Double unitPriceSub;//Quote/minute for subtitling
    private String subSoftware;
    private Boolean voiceOver;
    private Double unitPriceVoice;
    

    private List<GrantedAuthority> authorities;

    public User() {
    }

    public User(Integer id) {
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

    @NotBlank(message = "{user.username} {validation.not.empty}")
    @Column(name = "NAME", nullable = false, unique = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Length(min=0,max = 256)
    @Column(name = "PASSWORD", length = 256)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "EMAIL", length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "CELLPHONE", length = 11)
    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Column(name = "LANGUAGE", length = 10)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(name = "REGION", nullable = true)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "LOCATION", nullable = true)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "TITLE", nullable = true)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "USERTYPE")
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "IS_FREELANCERAUDIT" ,nullable=false)
	@Type(type = "yes_no")
	public Boolean getFreelancerAudit() {
		return freelancerAudit;
	}

	public void setFreelancerAudit(Boolean freelancerAudit) {
		this.freelancerAudit = freelancerAudit;
	}

	@Column(name = "FIRSTNAME")
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "FAMILYNAME")
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@Column(name = "NATIONAITY")
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Column(name = "MOTHERTONGUE")
	public String getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	@Column(name = "FOREIGNLANG1")
	public String getForeignLanguage1() {
		return foreignLanguage1;
	}

	public void setForeignLanguage1(String foreignLanguage1) {
		this.foreignLanguage1 = foreignLanguage1;
	}

	@Column(name = "FOREIGNLANG2")
	public String getForeignLanguage2() {
		return foreignLanguage2;
	}

	public void setForeignLanguage2(String foreignLanguage2) {
		this.foreignLanguage2 = foreignLanguage2;
	}

	@Column(name = "FOREIGNLANG3")
	public String getForeignLanguage3() {
		return foreignLanguage3;
	}

	public void setForeignLanguage3(String foreignLanguage3) {
		this.foreignLanguage3 = foreignLanguage3;
	}

	@Column(name = "INDUSTRY")
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Column(name = "UNITPRICE")
	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "PRIMARYEMAIL")
	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	@Column(name = "IMACCOUNT")
	public String getImAccount() {
		return imAccount;
	}

	public void setImAccount(String imAccount) {
		this.imAccount = imAccount;
	}

	@Column(name = "WORKINGDURATION")
	public Integer getYearsOfWorking() {
		return yearsOfWorking;
	}

	public void setYearsOfWorking(Integer yearsOfWorking) {
		this.yearsOfWorking = yearsOfWorking;
	}

	@Column(name = "SCHOOL")
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Column(name = "MAJOR")
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "DEGREE")
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	
	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Column(name = "PHONE")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		phone = phone;
	}
		
	@Column(name = "FAX")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
	@Column(name = "ZIPCODE")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


    @Column(name = "COMPANYNAME")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	 @Column(name = "CLIENTTYPE")
	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	@Column(name = "PAYTERMS")
	public String getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	@Column(name = "PAYTYPE")
	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	@Column(name = "CURRENCY")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "WEBSITE")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Column(name = "NEEDINVOICE", nullable = false)
	@Type(type = "yes_no")
	public Boolean getNeedInvoice() {
		return needInvoice;
	}

	public void setNeedInvoice(Boolean needInvoice) {
		this.needInvoice = needInvoice;
	}
	
	@Column(name = "SOURCELANG")
	public String getSourceLanguage() {
		return sourceLanguage;
	}

	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}
		
	@Column(name = "SOURCELANG2")
	public String getSourceLanguage2() {
		return sourceLanguage2;
	}

	public void setSourceLanguage2(String sourceLanguage2) {
		this.sourceLanguage2 = sourceLanguage2;
	}

	@Column(name = "SOURCELANG3")
	public String getSourceLanguage3() {
		return sourceLanguage3;
	}

	public void setSourceLanguage3(String sourceLanguage3) {
		this.sourceLanguage3 = sourceLanguage3;
	}

	@Column(name = "TARGETLANG")
	public String getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}
	
	@Column(name = "TARGETLANG2")
    public String getTargetLanguage2() {
		return targetLanguage2;
	}

	public void setTargetLanguage2(String targetLanguage2) {
		this.targetLanguage2 = targetLanguage2;
	}

	@Column(name = "TARGETLANG3")
	public String getTargetLanguage3() {
		return targetLanguage3;
	}

	public void setTargetLanguage3(String targetLanguage3) {
		this.targetLanguage3 = targetLanguage3;
	}

	@Column(name = "INVOCIENAME")
    public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	@Column(name = "INVOICERECEIVER")
	public String getInvoiceReceiver() {
		return invoiceReceiver;
	}

	public void setInvoiceReceiver(String invoiceReceiver) {
		this.invoiceReceiver = invoiceReceiver;
	}

	@Column(name = "INVTAXIDENTIFYNO")
	public String getInvoiceTaxIdentifyNo() {
		return invoiceTaxIdentifyNo;
	}

	public void setInvoiceTaxIdentifyNo(String invoiceTaxIdentifyNo) {
		this.invoiceTaxIdentifyNo = invoiceTaxIdentifyNo;
	}
		
	@Column(name = "USERNO")
	public String getUserno() {
		return userno;
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
	@Column(name = "EMPNO")
	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
		
	@Column(name = "QUALITY")
	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	
	@Column(name = "ISTRADOS")
	@Type(type = "yes_no")
	public Boolean getTrados() {
		return trados;
	}

	public void setTrados(Boolean trados) {
		this.trados = trados;
	}

	@Column(name = "TRADOSVERSION")
	public String getTradosVersion() {
		return tradosVersion;
	}

	public void setTradosVersion(String tradosVersion) {
		this.tradosVersion = tradosVersion;
	}

	@Column(name = "IS_GAMELOCAL")
	@Type(type = "yes_no")
	public Boolean getGameLocalization() {
		return gameLocalization;
	}

	public void setGameLocalization(Boolean gameLocalization) {
		this.gameLocalization = gameLocalization;
	}

	@Column(name = "IS_TRANSCREATION")
	@Type(type = "yes_no")
	public Boolean getTranscreation() {
		return transcreation;
	}

	public void setTranscreation(Boolean transcreation) {
		this.transcreation = transcreation;
	}

	@Column(name = "IS_INTERPRETING" )
	@Type(type = "yes_no")
	public Boolean getInterpreting() {
		return interpreting;
	}

	public void setInterpreting(Boolean interpreting) {
		this.interpreting = interpreting;
	}

	@Column(name = "UNITPRICEINTER")
	public Double getUnitPriceInter() {
		return unitPriceInter;
	}

	public void setUnitPriceInter(Double unitPriceInter) {
		this.unitPriceInter = unitPriceInter;
	}

	@Column(name = "IS_SUBTITLING")
	@Type(type = "yes_no")
	public Boolean getSubtitling() {
		return subtitling;
	}

	public void setSubtitling(Boolean subtitling) {
		this.subtitling = subtitling;
	}

	@Column(name = "UNITPRICESUB")
	public Double getUnitPriceSub() {
		return unitPriceSub;
	}

	public void setUnitPriceSub(Double unitPriceSub) {
		this.unitPriceSub = unitPriceSub;
	}

	@Column(name = "SUBSW")
	public String getSubSoftware() {
		return subSoftware;
	}

	public void setSubSoftware(String subSoftware) {
		this.subSoftware = subSoftware;
	}

	@Column(name = "IS_VOICEOVER")
	@Type(type = "yes_no")
	public Boolean getVoiceOver() {
		return voiceOver;
	}

	public void setVoiceOver(Boolean voiceOver) {
		this.voiceOver = voiceOver;
	}

	@Column(name = "UNITPRICEVOICE")
	public Double getUnitPriceVoice() {
		return unitPriceVoice;
	}

	public void setUnitPriceVoice(Double unitPriceVoice) {
		this.unitPriceVoice = unitPriceVoice;
	}

	@Column(name = "IS_TRANSLATION")
	@Type(type = "yes_no")
	public Boolean getTranslation() {
		return translation;
	}

	public void setTranslation(Boolean translation) {
		this.translation = translation;
	}

	@Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
    
    

}
