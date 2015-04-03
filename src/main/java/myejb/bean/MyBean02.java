package myejb.bean;

import myejb.interceptor.MyInterceptor;
import myejb.myInterface.Caculator;
import myejb.myInterface.MyEJB;
import myejb.myInterface.MyTimer;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by root on 15-4-3.
 */
@Stateless
@Remote(value = {Caculator.class,MyTimer.class,MyEJB.class})
@Interceptors({MyInterceptor.class})
public class MyBean02 implements Caculator,MyTimer,MyEJB
{
    @Override
    public String sayHello(String name) {
        return "nihao "+name;
    }

    @Override
    public float add(float param1, float param2) {
        return param1+param2;
    }

    @Override
    public String getTime() {
        Date now = new Date();
        DateFormat dateTimeFormat = DateFormat.getDateTimeInstance();
        String time = dateTimeFormat.format(now);
        System.out.println("current time is "+time);
        return time;
    }
}
