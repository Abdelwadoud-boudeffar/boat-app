package com.openwt.suisse.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "boats")
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "boat_name", nullable = false, length = 50, unique = true)
    private String boatName;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    public Boat(String boatName, String description) {
        this.boatName = boatName;
        this.description = description;
    }
}
