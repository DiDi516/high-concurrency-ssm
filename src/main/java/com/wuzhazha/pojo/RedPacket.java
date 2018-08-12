package com.wuzhazha.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RedPacket implements Serializable {

    private static final long serialVersionUID = 5849659734077240940L;

    private Integer id;

    private Integer userId;

    private BigDecimal amount;

    private Date sendDate;

    private Integer total;

    private BigDecimal unitAmount;

    private Integer stock;

    private Integer version;

    private String note;

    public RedPacket(Integer id, Integer userId, BigDecimal amount, Date sendDate, Integer total, BigDecimal unitAmount, Integer stock, Integer version, String note) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.sendDate = sendDate;
        this.total = total;
        this.unitAmount = unitAmount;
        this.stock = stock;
        this.version = version;
        this.note = note;
    }

    public RedPacket() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public BigDecimal getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(BigDecimal unitAmount) {
        this.unitAmount = unitAmount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}