package com.wuzhazha.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserRedPacket implements Serializable{

    private static final long serialVersionUID = -8491335375577428387L;

    private Integer id;

    private Integer redPacketId;

    private Integer userId;

    private BigDecimal amount;

    private Date grabTime;

    private String note;

    public UserRedPacket(Integer id, Integer redPacketId, Integer userId, BigDecimal amount, Date grabTime, String note) {
        this.id = id;
        this.redPacketId = redPacketId;
        this.userId = userId;
        this.amount = amount;
        this.grabTime = grabTime;
        this.note = note;
    }

    public UserRedPacket() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRedPacketId() {
        return redPacketId;
    }

    public void setRedPacketId(Integer redPacketId) {
        this.redPacketId = redPacketId;
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

    public Date getGrabTime() {
        return grabTime;
    }

    public void setGrabTime(Date grabTime) {
        this.grabTime = grabTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}