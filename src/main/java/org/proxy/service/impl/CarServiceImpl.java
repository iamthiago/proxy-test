package org.proxy.service.impl;

import org.proxy.domain.Car;
import org.proxy.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by thiago on 24/09/14.
 */
@Service
public class CarServiceImpl implements CarService {

    private static final Logger log = LoggerFactory.getLogger(CarService.class);

    @Override
    public void save(Car car) {
        log.info(car.getModel() + " - " + car.getColor());
    }
}
