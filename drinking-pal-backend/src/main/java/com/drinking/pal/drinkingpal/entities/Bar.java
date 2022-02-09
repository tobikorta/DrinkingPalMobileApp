package com.drinking.pal.drinkingpal.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    private double longitude;
    private double latitude;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Builder
    public Bar(String name, double longitude, double latitude, String description) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return Objects.equals(getId(), bar.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
