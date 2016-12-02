package com.uitg.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CM_CONTRACT")
public class Contract extends IdEntity {
	private Integer id;
	private Order orderId;
	private User invoicePerson;
	
	public Contract(){
		
	}
	
	public Contract(Integer id){
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

    @ManyToOne
    @JoinColumn(name = "ORDERID")
	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	@ManyToOne
    @JoinColumn(name = "INVPERSION")
	public User getInvoicePerson() {
		return invoicePerson;
	}

	public void setInvoicePerson(User invoicePerson) {
		this.invoicePerson = invoicePerson;
	}

}
