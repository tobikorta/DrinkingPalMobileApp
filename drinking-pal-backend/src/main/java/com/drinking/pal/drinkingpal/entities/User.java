package com.drinking.pal.drinkingpal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;
    @CreatedDate
    private LocalDate joiningDate;
    private boolean disabled;
    private AccountState status;
    @ManyToMany()
    @JoinTable(name = "user_spoken_languages")
    private Set<Language> spokenLanguages = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getEmail() != null && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }

    public enum SubscriptionType {
        MANUAL, GOOGLE
    }

    public enum AccountState {
        CLOSED, NEW, VALIDATED
    }
}
