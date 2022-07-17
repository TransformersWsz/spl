package org.example.spl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static void main(String[] args) {
        Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        log.debug("启动项目中。。。");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customerBean = (Customer) context.getBean("customerBean");
        customerBean.displayInfo();

        ((ClassPathXmlApplicationContext) context).close();

        log.error("项目报错！！！");
    }
}
