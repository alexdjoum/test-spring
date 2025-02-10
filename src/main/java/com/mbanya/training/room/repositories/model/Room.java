package com.mbanya.training.room.repositories.model;

import jakarta.persistence.*; // Utiliser les annotations JPA de Jakarta
import lombok.*;
import com.mbanya.training.room.repositories.Quality;
import com.mbanya.training.room.repositories.Type;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String location;
    private String description;
    private double price;

    @Enumerated(EnumType.STRING)
    private Quality quality;

    @Enumerated(EnumType.STRING)
    private Type type;

}
