package com.taochong.joshuachang.mytextdemo.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 常守达  2016/12/23 18:00
 * joshuachang0823@gmail.com
 */
@Entity
public class Bean {
    @Id
    private Long id;
    private int age;
    private String name;


    @Generated(hash = 900972386)
    public Bean(Long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Generated(hash = 80546095)
    public Bean() {
    }


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
