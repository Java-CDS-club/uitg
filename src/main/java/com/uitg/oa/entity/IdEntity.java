package com.uitg.oa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Description Here
 *
 * @author Michael
 */
@MappedSuperclass
public abstract class IdEntity implements Serializable {

    protected User createdBy;
    protected Date createdOn;

    protected User updatedBy;
    protected Date updatedOn;

    
    @ManyToOne
    @JoinColumn(name="CREATED_BY")
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="CREATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @ManyToOne
    @JoinColumn(name="UPDATED_BY")
    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Column(name="UPDATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
