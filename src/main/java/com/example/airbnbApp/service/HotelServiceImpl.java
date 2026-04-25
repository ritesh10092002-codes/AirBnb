package com.example.airbnbApp.service;

import com.example.airbnbApp.dto.HotelDto;
import com.example.airbnbApp.entity.Hotel;
import com.example.airbnbApp.exception.ResourceNotFoundException;
import com.example.airbnbApp.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor //uses constructor injection
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;


    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating new hotel with name: {}",hotelDto.getName());

        Hotel hotel=modelMapper.map(hotelDto,Hotel.class);
        hotel.setActive(false);
        hotel=hotelRepository.save(hotel);
        log.info("Created new hotel with id: {}",hotelDto.getId());

        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting hotel with ID:  {}",id);
        Hotel hotel=hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not found with ID: "+id));
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating hotel with ID:  {}",id);
        Hotel hotel=hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not found with ID: "+id));
       hotel= modelMapper.map(hotelDto,Hotel.class);
       hotelRepository.save(hotel);
       return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public Boolean deleteHotelById(Long id) {
        log.info("Deleting hotel with ID: {}",id);
        Hotel hotel=hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not found with ID: "+id));
         hotelRepository.deleteById(id);
         //TODO: delete future inventory for this hotel

         return true;
    }

    @Override
    public void activateHotel(Long id) {
        log.info("Activating hotel with ID: {}",id);
        Hotel hotel=hotelRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Hotel not found with ID: "+id));

        hotel.setActive(true);

        //TODO: create inventory for all this room for this hotel



    }
}
