package com.qfedu.entity;


public class OrderDetail {

  private int odid;
  private int pid;
  private String oid;
  private int num;
  private double money;

  public OrderDetail() {
  }

  public OrderDetail(int odid, int pid, String oid, int num, double money) {
    this.odid = odid;
    this.pid = pid;
    this.oid = oid;
    this.num = num;
    this.money = money;
  }

  public long getId() {
    return odid;
  }

  public void setId(int id) {
    this.odid = id;
  }


  public long getPid() {
    return pid;
  }

  public void setPid(int pid) {
    this.pid = pid;
  }


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }


  public long getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "OrderDetail{" +
            "id=" + odid +
            ", pid=" + pid +
            ", oid='" + oid + '\'' +
            ", num=" + num +
            ", money=" + money +
            '}';
  }
}
