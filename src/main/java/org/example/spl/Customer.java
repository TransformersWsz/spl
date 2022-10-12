package org.example.spl;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String username;
    private String  password;


    public void init() {
        System.out.println("Customer Bean 正在初始化。。。");
    }


    public void displayInfo() {
        System.out.println("Hello, my username is "+ username + ", password is " + password + ".");
    }

    public void getExtraInfo(Float height, Float weight) {
        System.out.println(username + " height: " + height + "m, weight: " + weight + "kg");
    }

    // 获取用户名和密码
    public String getBasicInfo() {
        return username + ":" + password;
    }

    public void destroy() {
        System.out.println("Customer Bean 正在销毁。。。");
    }
}
