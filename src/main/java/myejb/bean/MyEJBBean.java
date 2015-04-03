package myejb.bean;

import myejb.myInterface.MyEJB;
import myejb.myInterface.MyTimer;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by root on 15-4-3.
 */
@Stateless
@Remote(value = {MyEJB.class,MyTimer.class})
//@Local(value = {MyTimer.class})

public class MyEJBBean implements MyEJB,MyTimer{
    @Override
    public String sayHello(String name) {
        return "hello "+name;
    }

    @Override
    public String getTime() {

        Date now = new Date();
        DateFormat dateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
        String time = dateTimeFormat.format(now);
        System.out.println("current time is "+time);
        return time;
    }

}
