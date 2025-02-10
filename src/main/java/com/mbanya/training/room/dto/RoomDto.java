package com.mbanya.training.room.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    
    private String name;
    private String location;
    private String description;
    private double price;
    private String quality;
    private String type;

}
