package com.uitg.oa.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "CM_ORDER")
public class Order extends IdEntity {
	private Integer id;
	private String po;//purchase order
	private String fpo;
	private String orderDesc;
	private Date orderDate;
	private Date returnDate;
	private Date endDate;
	private Date deliveryDate;
	private User client;	
	private String status;// 1.报价  2.翻译 3.审稿 4.提交 5.结算    0.取消 5.pending 6.approve
	private User assignee;	
	private Double amount;
	private Double totalamt;
	private Double discount;
	private Integer characterCount;
	private Integer totalCount;
	private String sourceLanguage;
	private String targetLanguage;
	private String needModify;
	private String cashBack;
	private String freelancerPay;
	private String confirm;
	private String comment;
	private String currency;
	private Double score;//评分
	private Integer repetition;
	private Double repetitionRate;
	private Integer match100;
	private Double match100Rate;
	private Integer match95;
	private Double match95Rate;
	private Integer match85;
	private Double match85Rate;
	private Integer match75;
	private Double match75Rate;
	private Integer unique;
	private Double uniqueRate;
	private Integer filePrepration;
	private Double filePrepraRate;
	private Integer glossary;
	private Double glossaryRate;
	private Integer dtp;
	private Double dtpRate;
	private Integer projectMgmtFee;
	private Double projectMgmtFeeRate;
	private Integer proofread;
	private Double proofreadRate;
	private Integer edit;
	private Double editRate;
	private String accept;
	private String pending;
	private Boolean mainOrder;
	private String note;
	private Boolean copyEdit=false;
	private Boolean isFapiaoSend=false;
	private String expressNo;
	private String closed;
	public Order(){
		
	}
	
    public Order(Integer id){
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
    
    @Column(name = "PO")
	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}
		
	@Column(name = "FPO")
	public String getFpo() {
		return fpo;
	}

	public void setFpo(String fpo) {
		this.fpo = fpo;
	}
	
	@Column(name = "ORDERDESC")
	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	@Column(name = "ORDERDATE")
	@Temporal(TemporalType.DATE)
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "ENDDATE")
	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@ManyToOne
    @JoinColumn(name = "CLIENTID")
	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Column(name = "STATUS", nullable = false,columnDefinition="char(1) default 'P'")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne
    @JoinColumn(name = "ASSIGNEE")
	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	@Column(name = "AMOUNT")
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "DISCOUNT")
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Column(name = "COUNT")
	public Integer getCharacterCount() {
		return characterCount;
	}

	public void setCharacterCount(Integer characterCount) {
		this.characterCount = characterCount;
	}
	
	
	@Column(name = "DELIVERYDATE")
	@Temporal(TemporalType.DATE)
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Column(name = "SOURCELANG")
	public String getSourceLanguage() {
		return sourceLanguage;
	}

	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}

	@Column(name = "TARGETLANG")
	public String getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

	@Column(name = "ISMODIFY")
	public String getNeedModify() {
		return needModify;
	}

	public void setNeedModify(String needModify) {
		this.needModify = needModify;
	}
	
	
	@Column(name = "ISCASHBACK")
	public String getCashBack() {
		return cashBack;
	}

	public void setCashBack(String cashBack) {
		this.cashBack = cashBack;
	}

	@Column(name = "ISFREELANCERPAY")
	public String getFreelancerPay() {
		return freelancerPay;
	}

	public void setFreelancerPay(String freelancerPay) {
		this.freelancerPay = freelancerPay;
	}
	
	
	@Column(name = "ISCONFIRM")
	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	@Column(name = "COMMENT")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "CURR")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "SCORE")
	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
	
	@Column(name = "REPETITION")
	public Integer getRepetition() {
		return repetition;
	}

	public void setRepetition(Integer repetition) {
		this.repetition = repetition;
	}

	@Column(name = "REPERATE")
	public Double getRepetitionRate() {
		return repetitionRate;
	}

	public void setRepetitionRate(Double repetitionRate) {
		this.repetitionRate = repetitionRate;
	}

	@Column(name = "MATCH100")
	public Integer getMatch100() {
		return match100;
	}

	public void setMatch100(Integer match100) {
		this.match100 = match100;
	}
		
	@Column(name = "MATCH100RATE")
	public Double getMatch100Rate() {
		return match100Rate;
	}

	public void setMatch100Rate(Double match100Rate) {
		this.match100Rate = match100Rate;
	}

	@Column(name = "MATCH95")
	public Integer getMatch95() {
		return match95;
	}

	public void setMatch95(Integer match95) {
		this.match95 = match95;
	}

	@Column(name = "MATCH95RATE")
	public Double getMatch95Rate() {
		return match95Rate;
	}

	public void setMatch95Rate(Double match95Rate) {
		this.match95Rate = match95Rate;
	}

	@Column(name = "MATCH85")
	public Integer getMatch85() {
		return match85;
	}

	public void setMatch85(Integer match85) {
		this.match85 = match85;
	}

	@Column(name = "MATCH85RATE")
	public Double getMatch85Rate() {
		return match85Rate;
	}

	public void setMatch85Rate(Double match85Rate) {
		this.match85Rate = match85Rate;
	}

	@Column(name = "MATCH75")
	public Integer getMatch75() {
		return match75;
	}

	public void setMatch75(Integer match75) {
		this.match75 = match75;
	}

	@Column(name = "MATCH75RATE")
	public Double getMatch75Rate() {
		return match75Rate;
	}

	public void setMatch75Rate(Double match75Rate) {
		this.match75Rate = match75Rate;
	}

	@Column(name = "UNIQUECOL")
	public Integer getUnique() {
		return unique;
	}

	public void setUnique(Integer unique) {
		this.unique = unique;
	}

	@Column(name = "UNIQUERATE")
	public Double getUniqueRate() {
		return uniqueRate;
	}

	public void setUniqueRate(Double uniqueRate) {
		this.uniqueRate = uniqueRate;
	}

	@Column(name = "FILEPREPRA")
	public Integer getFilePrepration() {
		return filePrepration;
	}

	public void setFilePrepration(Integer filePrepration) {
		this.filePrepration = filePrepration;
	}

	@Column(name = "FILEPREPRARATE")
	public Double getFilePrepraRate() {
		return filePrepraRate;
	}

	public void setFilePrepraRate(Double filePrepraRate) {
		this.filePrepraRate = filePrepraRate;
	}

	@Column(name = "GLOSSARY")
	public Integer getGlossary() {
		return glossary;
	}

	public void setGlossary(Integer glossary) {
		this.glossary = glossary;
	}

	@Column(name = "GLOSSARTRATE")
	public Double getGlossaryRate() {
		return glossaryRate;
	}

	public void setGlossaryRate(Double glossaryRate) {
		this.glossaryRate = glossaryRate;
	}

	@Column(name = "DTP")
	public Integer getDtp() {
		return dtp;
	}

	public void setDtp(Integer dtp) {
		this.dtp = dtp;
	}

	@Column(name = "DTPRATE")
	public Double getDtpRate() {
		return dtpRate;
	}

	public void setDtpRate(Double dtpRate) {
		this.dtpRate = dtpRate;
	}

	@Column(name = "PROJECT")
	public Integer getProjectMgmtFee() {
		return projectMgmtFee;
	}

	public void setProjectMgmtFee(Integer projectMgmtFee) {
		this.projectMgmtFee = projectMgmtFee;
	}

	@Column(name = "PROJECTRATE")
	public Double getProjectMgmtFeeRate() {
		return projectMgmtFeeRate;
	}

	public void setProjectMgmtFeeRate(Double projectMgmtFeeRate) {
		this.projectMgmtFeeRate = projectMgmtFeeRate;
	}	
	
	@Column(name = "TOTALAMT")
	public Double getTotalamt() {
		return totalamt;
	}

	public void setTotalamt(Double totalamt) {
		this.totalamt = totalamt;
	}
		
	@Column(name = "ACCEPT")
	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}
	
	@Column(name = "TOTALCOUNT")
	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	@Column(name = "PROOFREAD")
	public Integer getProofread() {
		return proofread;
	}

	public void setProofread(Integer proofread) {
		this.proofread = proofread;
	}

	@Column(name = "PROOFREADRATE")
	public Double getProofreadRate() {
		return proofreadRate;
	}

	public void setProofreadRate(Double proofreadRate) {
		this.proofreadRate = proofreadRate;
	}

	@Column(name = "EDIT")
	public Integer getEdit() {
		return edit;
	}

	public void setEdit(Integer edit) {
		this.edit = edit;
	}

	@Column(name = "EDITRATE")
	public Double getEditRate() {
		return editRate;
	}

	public void setEditRate(Double editRate) {
		this.editRate = editRate;
	}
		
	@Column(name = "PENDING")
	public String getPending() {
		return pending;
	}

	public void setPending(String pending) {
		this.pending = pending;
	}
		
	@Column(name = "MAINORDERFLAG", nullable = false)
	@Type(type = "yes_no")
	public Boolean getMainOrder() {
		return mainOrder;
	}

	public void setMainOrder(Boolean mainOrder) {
		this.mainOrder = mainOrder;
	}
	
	@Lob  
	@Basic(fetch = FetchType.EAGER) 
	@Column(name = "NOTE", columnDefinition="Text", nullable=true)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	@Column(name = "COPYEDITLAG", nullable = false,columnDefinition="char(1) default 'N'")
	@Type(type = "yes_no")
	public Boolean getCopyEdit() {
		return copyEdit;
	}

	public void setCopyEdit(Boolean copyEdit) {
		this.copyEdit = copyEdit;
	}	
	
	@Column(name = "ISFAPIAOSEND", nullable = false,columnDefinition="char(1) default 'N'")
	@Type(type = "yes_no")
	public Boolean getIsFapiaoSend() {
		return isFapiaoSend;
	}

	public void setIsFapiaoSend(Boolean isFapiaoSend) {
		this.isFapiaoSend = isFapiaoSend;
	}

	@Column(name = "EXPRESSNO")
	public String getExpressNo() {
		return expressNo;
	}

	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}	
	
	@Column(name = "CLOSED")
	public String getClosed() {
		return closed;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}	
	
	@Column(name = "RETURNDATE")
	@Temporal(TemporalType.DATE)
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((po == null) ? 0 : po.hashCode());
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (po == null) {
			if (other.po != null)
				return false;
		} else if (!po.equals(other.po))
			return false;
		return true;
	}


    
}
