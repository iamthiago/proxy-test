package org.proxy.handler;

import org.proxy.domain.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by thiago on 24/09/14.
 */
public class CarInvocationHandler implements InvocationHandler {

    private static final Logger log = LoggerFactory.getLogger(CarInvocationHandler.class);

    private Object target;

    public CarInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
        log.info("Init Car Custom Handler");

        Car car = (Car) params[0];
        car.setColor("black");

        return method.invoke(target, car);
    }
}