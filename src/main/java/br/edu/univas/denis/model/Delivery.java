package br.edu.univas.denis.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Delivery {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderCode;

    private String cpfReceiver;

    private Date deliveryDate;

    private String cep;

    private String deliveryStatus;

    /**
     * @return long return the orderCode
     */
    public long getOrderCode() {
        return orderCode;
    }

    /**
     * @param orderCode the orderCode to set
     */
    public void setOrderCode(long orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * @return String return the cpfReceiver
     */
    public String getCpfReceiver() {
        return cpfReceiver;
    }

    /**
     * @param cpfReceiver the cpfReceiver to set
     */
    public void setCpfReceiver(String cpfReceiver) {
        this.cpfReceiver = cpfReceiver;
    }

    /**
     * @return Date return the deliveryDate
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return String return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return String return the delieryStatus
     */
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
     * @param delieryStatus the delieryStatus to set
     */
    public void setDelieryStatus(String delieryStatus) {
        this.deliveryStatus = delieryStatus;
    }

}