package Proxy.Static.jdkProxy;

import Proxy.Static.DaoInterface;
import Proxy.Static.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        DaoInterface userDao = new UserDao();
        DaoInterface proxy = (DaoInterface) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(),new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("在 代理对象 中拦截到："+method.getName());
                        Object o = method.invoke(userDao, args);//调用拦截到的方法
                        return o;
                    }
                });
        proxy.delete();
    }
}
