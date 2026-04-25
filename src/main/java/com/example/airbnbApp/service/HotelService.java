package com.example.airbnbApp.service;

import com.example.airbnbApp.dto.HotelDto;
import org.jspecify.annotations.Nullable;


public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);
    HotelDto getHotelById(Long id);
    HotelDto updateHotelById(Long id,HotelDto hotelDto);

    @Nullable Void deleteHotelById(Long id);
    void activateHotel(Long id);
}
