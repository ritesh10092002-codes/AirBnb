package com.example.airbnbApp.service;

import com.example.airbnbApp.entity.Inventory;
import com.example.airbnbApp.entity.Room;
import com.example.airbnbApp.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl  implements InventoryService{

    private final InventoryRepository inventoryRepository;
    @Override
    public void initializeRoomForAYear(Room room) {

        LocalDate today=LocalDate.now();
        LocalDate endDate=LocalDate.now().plusYears(1);
        for(; !today.isAfter(endDate);today=today.plusDays(1)){
            Inventory inventory=Inventory.builder().
                    hotel(room.getHotel())
                    .room(room)
                    .bookCount(0)
                    .city(room.getHotel().getCity())
                    .date(today).
                    price(room.getPrice())
                    .surgeFactor(BigDecimal.ONE)
                    .totalCount(room.getTotalCount())
                    .close(false)
                    .build();
            inventoryRepository.save(inventory);
        }


    }

    @Override
    public void deleteFutureInventories(Room room) {
        LocalDate today=LocalDate.now();
        inventoryRepository.deleteByDateAfterAndRoom(today,room);
    }
}
