package com.qfedu.entity;


public class Goodstype {

  private int id;
  private String name;
  private int level;
  private int parent;

  public Goodstype() {
  }

  public Goodstype(int id, String name, int level, int parent) {
    this.id = id;
    this.name = name;
    this.level = level;
    this.parent = parent;
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

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getParent() {
    return parent;
  }

  public void setParent(int parent) {
    this.parent = parent;
  }

  @Override
  public String toString() {
    return "Goodstype{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", level=" + level +
            ", parent=" + parent +
            '}';
  }
}
