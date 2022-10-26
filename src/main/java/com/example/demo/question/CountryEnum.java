package com.example.demo.question;

import lombok.Getter;

/**
 * @Author LiuJixue
 * @Date 2022/10/26 15:08
 * @PackageName:com.example.demo.question
 * @ClassName: CountryEnum
 * @Description: TODO
 * @Version 1.0
 */
public enum CountryEnum {
    /**
     * 枚举实际生产中的使用案例
     * */
    ONE(1,"齐"),TWO(2,"齐"),THREE(3,"齐"),FOUR(4,"齐"),FIVE(5,"齐"),SIX(6,"齐");

    @Getter private Integer retCode;
    @Getter private String retMsg;

    CountryEnum(Integer retCode,String retMsg) {
        this.retCode =retCode;
        this.retMsg = retMsg;
    }

    public static CountryEnum foreach_CountryEnum(int index){
        CountryEnum[] myArray = CountryEnum.values();
        for(CountryEnum element : myArray){
            if(index == element.getRetCode()){
                return element;
            }
        }
        return null;
    }
}
