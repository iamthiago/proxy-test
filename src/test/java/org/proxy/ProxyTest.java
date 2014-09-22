package org.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.proxy.handler.CustomInvocationHandler;
import org.proxy.service.BasicFunc;
import org.proxy.service.impl.BasicServiceImpl;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ProxyTest {

    @Test
    public void testProxy() {
        BasicFunc ex = new BasicServiceImpl();
        BasicFunc proxied = (BasicFunc) Proxy
                .newProxyInstance(
                        this.getClass().getClassLoader(),
                        ex.getClass().getInterfaces(),
                        new CustomInvocationHandler(ex));

        proxied.fooMethod();
    }
}
