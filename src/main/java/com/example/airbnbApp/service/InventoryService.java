package com.example.airbnbApp.service;

import com.example.airbnbApp.entity.Room;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteFutureInventories(Room room);


}
