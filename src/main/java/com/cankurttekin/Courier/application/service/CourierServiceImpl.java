package com.cankurttekin.Courier.application.service;

import com.cankurttekin.Courier.application.dto.CourierDTO;
import com.cankurttekin.Courier.application.mapper.CourierMapper;
import com.cankurttekin.Courier.domain.entity.Courier;
import com.cankurttekin.Courier.domain.entity.DeliveryStatus;
import com.cankurttekin.Courier.domain.exception.CourierNotFoundException;
import com.cankurttekin.Courier.domain.repository.CourierRepository;
import com.cankurttekin.Courier.domain.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierServiceImpl implements CourierService {
    @Autowired
    private CourierRepository courierRepository;

    @Autowired
    private CourierMapper courierMapper;

    @Override
    public List<CourierDTO> getAllCouriers() {
        return List.of();
    }

    @Override
    public Courier getCourierById(Long id) {
        return courierRepository.findById(id).orElseThrow(
                () -> new CourierNotFoundException("Courier not found with id: " + id)
        );
    }

    @Override
    public Courier createCourier(Courier courier) {
        return courierRepository.save(courier);
    }

    @Override
    public void updateCourier(Long id, DeliveryStatus status) {
        // implement
        Courier courier = getCourierById(id);
        //courier.setStatus(status);
        courierRepository.save(courier);
    }
}
