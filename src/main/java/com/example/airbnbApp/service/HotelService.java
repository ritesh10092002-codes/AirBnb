package com.example.airbnbApp.service;

import com.example.airbnbApp.dto.HotelDto;
import com.example.airbnbApp.entity.Hotel;
import org.springframework.stereotype.Service;


public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);
    HotelDto getHotelById(Long id);
    HotelDto updateHotelById(Long id,HotelDto hotelDto);

    Boolean deleteHotelById(Long id);
    void activateHotel(Long id);
}
