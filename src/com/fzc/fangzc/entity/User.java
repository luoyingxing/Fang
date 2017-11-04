package com.fzc.fangzc.entity;

/**
 * User
 * <p>
 * Created by Administrator on 2017/10/26 0026.
 */
public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    private String phone;
    private String address;
    private String email;
    private String tag;

    public User() {
    }

    public User(int id, String name, String password, int age, String phone, String address, String email, String tag) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.tag = tag;
    }

    public User(String name, String password, int age, String phone, String address, String email, String tag) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.tag = tag;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "--------------------------------------------" +
                "<br>id  " + id + "<br> name  " + name + "<br> password  " + password + "<br> age  " +
                age + "<br> phone  " + phone + "<br> address  " + address + "<br> email  " + email + "<br> tag  " + tag;
    }
}