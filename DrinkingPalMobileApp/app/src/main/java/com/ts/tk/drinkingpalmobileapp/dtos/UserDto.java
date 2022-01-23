package com.ts.tk.drinkingpalmobileapp.dtos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Role role;

    private SubscriptionType subscriptionType;
    private LocalDate joiningDate;
    private boolean disabled;
    private AccountState status;
    private Set<Language> spokenLanguages = new HashSet<>();

    @Builder
    public UserDto(Long id, String firstName, String lastName, String email, String password, Role role,
                   SubscriptionType subscriptionType, LocalDate joiningDate, boolean disabled,
                   AccountState status, Set<Language> spokenLanguages) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.subscriptionType = subscriptionType;
        this.joiningDate = joiningDate;
        this.disabled = disabled;
        this.status = status;
        this.spokenLanguages = spokenLanguages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return getEmail() != null && Objects.equals(getEmail(), userDto.getEmail());
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

    public enum Role {
        USER;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public AccountState getStatus() {
        return status;
    }

    public void setStatus(AccountState status) {
        this.status = status;
    }

    public Set<Language> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(Set<Language> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }
}
