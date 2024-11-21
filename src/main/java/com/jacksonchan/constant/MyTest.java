package com.jacksonchan.constant;

public class MyTest {
    public static void main(String[] args) {
        ProductCategory category = ProductCategory.CHINESE;
        String s = category.name();
        System.out.println(s);

        String s2 = "JAPANESE";
        ProductCategory category2 = ProductCategory.valueOf(s2);
        String s3 = category2.name();
        System.out.println(s2.equals(s3));
    }
}
