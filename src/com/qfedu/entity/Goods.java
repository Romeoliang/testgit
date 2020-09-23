package com.qfedu.entity;


import java.sql.Date;

public class Goods {

  private int id;
  private String name;
  private Date pubdate;
  private String picture;
  private int price;
  private int star;
  private String info;
  private int typeid;

  public Goods() {
  }

  public Goods(int id, String name, Date pubdate, String picture, int price, int star, String info, int typeid) {
    this.id = id;
    this.name = name;
    this.pubdate = pubdate;
    this.picture = picture;
    this.price = price;
    this.star = star;
    this.info = info;
    this.typeid = typeid;
  }

  @Override
  public String toString() {
    return "GoodsDao{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", pubdate=" + pubdate +
            ", picture='" + picture + '\'' +
            ", price=" + price +
            ", star=" + star +
            ", info='" + info + '\'' +
            ", typeid=" + typeid +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getPubdate() {
    return pubdate;
  }

  public void setPubdate(Date pubdate) {
    this.pubdate = pubdate;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getStar() {
    return star;
  }

  public void setStar(int star) {
    this.star = star;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public int getTypeid() {
    return typeid;
  }

  public void setTypeid(int typeid) {
    this.typeid = typeid;
  }
}
