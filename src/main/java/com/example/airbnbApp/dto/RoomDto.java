package com.example.airbnbApp.dto;

import com.example.airbnbApp.entity.Hotel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RoomDto {
    private Long id;
    private String type;
    private BigDecimal price;
    private String[] photos;
    private String[] amenities;
    private Integer totalCount;
    private Integer capacity;

}
