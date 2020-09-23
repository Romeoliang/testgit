package com.qfedu.entity;

public class Cart {

    private int cid;
    private int uid;
    private int pid;
    private int num = 0;
    private int money;
    private Goods goods;

    public Cart() {
    }

    public Cart(int uid, int pid, int num, int money) {
        this.uid = uid;
        this.pid = pid;
        this.num = num;
        this.money = money;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMoney() {
        int price = goods.getPrice();
        return price * num;
    }
    //    public long getMoney() {
//        int price = goods.getPrice();
//        return price * num;
//    }


    public void setMoney(int money) {
        this.money = money;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "uid=" + uid +
                ", pid=" + pid +
                ", num=" + num +
                ", money=" + getMoney() +
                ", goods=" + goods +
                '}';
    }
}
