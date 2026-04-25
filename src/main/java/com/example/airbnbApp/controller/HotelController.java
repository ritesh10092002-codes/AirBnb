package com.example.airbnbApp.controller;

import com.example.airbnbApp.dto.HotelDto;
import com.example.airbnbApp.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDto> createNewHotel(@RequestBody HotelDto hotelDto){
        log.info("Attempting to create new hotel with name: "+hotelDto.getName());
       HotelDto hotelDto1= hotelService.createNewHotel(hotelDto);
        return ResponseEntity.ok(hotelDto1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotelsById(@PathVariable Long id){
        log.info("Attempting to get hotel with id {}",id);
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDto> updateHotelById(@PathVariable Long id,@RequestBody HotelDto hotelDto){
        log.info("Updating hotel for the id: {}",id);
        return ResponseEntity.ok(hotelService.updateHotelById(id,hotelDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable Long id){
        log.info("Deleting hotel for the id: {}",id);
        return ResponseEntity.ok(hotelService.deleteHotelById(id));
    }

    //update single field use patch mapping
    @PatchMapping("/{id}")
    public ResponseEntity<Void> activateHotel(@PathVariable Long id){
        hotelService.activateHotel(id);
        return ResponseEntity.noContent().build();
    }
}
