package br.edu.univas.denis.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Auditing {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_delivery")
    private Delivery registerCode;

    private Date dateTime;

    private String operation;

    public Auditing(long id, Delivery registerCode, String operation, Date dateTime){
        this.id = id;
        this.registerCode = registerCode;
        this.dateTime = dateTime;
        this.operation = operation;
    }

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return long return the registerCode
     */
    public Delivery getRegisterCode() {
        return registerCode;
    }

    /**
     * @param registerCode the registerCode to set
     */
    public void setRegisterCode(Delivery registerCode) {
        this.registerCode = registerCode;
    }

    /**
     * @return Date return the dateTime
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }


    /**
     * @return String return the operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

}