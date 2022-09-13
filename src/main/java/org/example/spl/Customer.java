package org.example.spl;

public class Customer {
    private String name;
    private Integer age;

    private Email email;

    private Phone phone;

    public void init() {
        System.out.println("Customer Bean 正在初始化。。。");
    }

    public Customer(String name, Integer age, Email email, Phone phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Hello, my name is "+ name + ", age is " + age + ".");
        System.out.println("About my email: username is  "+ email.getUsername() + ", password is " + email.getPassword() + ".");
        System.out.println("About my phone: number is  "+ phone.getNumber() + ", merchant is " + phone.getMerchant() + ".");
    }


    public void getExtraInfo(Float height, Float weight) {
        System.out.println(name + " height: " + height + "m, weight: " + weight + "kg");
    }

    // 获取年龄和性别
    public String getBasicInfo() {
        return name + ":" + age;
    }

    public void destroy() {
        System.out.println("Customer Bean 正在销毁。。。");
    }
}
