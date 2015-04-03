package myejb.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Created by root on 15-4-4.
 */

public class MyInterceptor {

    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception
    {
        System.out.println("interceptor.....");
        System.out.println("此时执行的方法："+ctx.getMethod().getName());
        Object obj=ctx.proceed();
        System.out.println(ctx.getMethod().getName()+"已经执行成功。");
        return obj;
    }
}
