package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    Log LOOGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOOGER.info("Hemos ingresado al metodo printWithDependency");
        int number = 1;
        LOOGER.debug("El numero enviado es: " + number);
        System.out.println("number = " + myOperation.sum(number));
        System.out.println("Implementacion de un bean con dependencia");
    }
}
