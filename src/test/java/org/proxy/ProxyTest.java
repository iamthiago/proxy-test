package org.proxy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.proxy.domain.Audi;
import org.proxy.domain.Bmw;
import org.proxy.domain.Car;
import org.proxy.handler.CarInvocationHandler;
import org.proxy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ProxyTest {

    @Autowired CarService carService;

    private Car bmw;
    private Car audi;

    @Before
    public void setup() {
        bmw = new Bmw();
        bmw.setModel("320i");

        audi = new Audi();
        audi.setModel("A3");
    }

    @Test
    public void testProxyCar() {
        CarService proxied = (CarService) Proxy
                .newProxyInstance(
                        this.getClass().getClassLoader(),
                        carService.getClass().getInterfaces(),
                        new CarInvocationHandler(carService));

        proxied.save(bmw);
        proxied.save(audi);
    }
}
