package com.qzyl;

/**
 * 单车的类
 */
public class Cycle {
    //封装属性
    private String color;//颜色
    private String height;//高度
    private String name;//名称

    //形成有参和空参构造

    public Cycle() {
    }

    public Cycle(String color, String height, String name) {
        this.color = color;
        this.height = height;
        this.name = name;
    }

    //生成get，set方法

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //单车的行为

    //启动
    public void start(){
        System.out.println(name+"启动了");
    }
    //前进
    public void advance(){
        System.out.println(name+"前进了");
    }
    //按喇叭
    public void beep(){
        System.out.println(name+"响喇叭了");
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "color='" + color + '\'' +
                ", height='" + height + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
