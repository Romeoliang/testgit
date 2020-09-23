package com.qfedu.entity;


import java.util.Date;

public class Order {

  private String oid;
  private int uid;
  private double money;
  private int status;
  private String time;
  private int aid;

  public Order() {
  }

  public Order(String oid, int uid, double money, int status, String time, int aid) {
    this.oid = oid;
    this.uid = uid;
    this.money = money;
    this.status = status;
    this.time = time;
    this.aid = aid;
  }

  public String getOid() {
    return oid;
  }

  public void setOid(String id) {
    this.oid = id;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }


  public long getAid() {
    return aid;
  }

  public void setAid(int aid) {
    this.aid = aid;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id='" + oid + '\'' +
            ", uid=" + uid +
            ", money=" + money +
            ", status=" + status +
            ", time=" + time +
            ", aid=" + aid +
            '}';
  }
}
