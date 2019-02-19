package com.itheima07.packageclass;
/*

     基本类型  ---- 包装类 之间转换

       装箱
         基本类型 封装成 包装类型

       拆箱
         包装类 解析成 基本类型

         注意 我们的基本类型 就只是能转换成对应的包装类
           包装类 就是用来包装 基本类型

        我知道 我的包装类就是对应 它自己的基本类型

        JDK1.5 以后
           出现了自动装箱 与自动拆箱

           Integer i = 30;   // 自动装箱

           int ii = i; // 自动拆箱

 */
public class Demo01PackageClass {

    public static void main(String[] args) {
        int a = 10;

        // int---Integer
        Integer b = new Integer(a);

        Integer c = Integer.valueOf(a);// 装箱

        Integer d = 10;//自动装箱  你写的是这样 其实编译过后 Integer.valueOf(10)

        // Integer----int
        int i = c.intValue();//拆箱

        int ii = b;// 自动拆箱  你写的是这样 其实编译过后 b.intValue()

    }
}
