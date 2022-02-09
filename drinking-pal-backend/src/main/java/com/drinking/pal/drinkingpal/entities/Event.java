package com.drinking.pal.drinkingpal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Bar bar;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User creator;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "event_joiners", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> joiners = new ArrayList<>();


}
