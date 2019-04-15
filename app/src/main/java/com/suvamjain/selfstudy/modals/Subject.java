package com.suvamjain.selfstudy.modals;

public class Subject {

    private String name;
    private int percentCompleted, imgResid;

    public Subject(String name, int percentCompleted, int imgResid) {
        this.name = name;
        this.percentCompleted = percentCompleted;
        this.imgResid = imgResid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercentCompleted() {
        return percentCompleted;
    }

    public void setPercentCompleted(int percentCompleted) {
        this.percentCompleted = percentCompleted;
    }

    public int getImgResid() {
        return imgResid;
    }

    public void setImgResid(int imgResid) {
        this.imgResid = imgResid;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", percentCompleted='" + percentCompleted + '\'' +
                ", imgResid='" + imgResid + '\'' +
                '}';
    }
}
