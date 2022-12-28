package com.example.designParttern.builder.improve;

/**
 * @Author LiuJixue
 * @Date 2022/12/28 23:37
 * @PackageName:com.example.designParttern.builder.improve
 * @ClassName: House
 * @Description: 产品
 * @Version 1.0
 */
public class House {
    private String basic;
    private String wall;
    private String rooted;

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRooted() {
        return rooted;
    }

    public void setRooted(String rooted) {
        this.rooted = rooted;
    }
}
