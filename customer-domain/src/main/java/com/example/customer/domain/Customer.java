package com.example.customer.domain;

import com.example.shared.domain.CustomerId;

import java.util.List;
import java.util.Objects;

public class Customer {

    private final CustomerId customerId;
    private final FullName fullName;
    private final Age age;
    private Location location;
    private List<Interest> interests;
    private Email email;
    private Epurse epurse;
    private Username username;
    private Password password;
    private IsAdmin isAdmin;

    public Customer(CustomerId customerId, FullName fullName, Age age) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.age = age;
    }

    public static class Builder {

        private CustomerId customerId;
        private FullName fullName;
        private Age age;
        private Location location;
        private List<Interest> interests;
        private Email email;
        private Epurse epurse;
        private Username username;
        private Password password;
        private IsAdmin isAdmin;

        public Builder identity(String id) {
            this.customerId = CustomerId.valueOf(customerId.getValue());
            return this;
        }

        public Builder fullName(String first, String last) {
            this.fullName = FullName.valueOf(first, last);
            return this;
        }

        public Builder age(int age) {
            this.age = Age.valueOf(age);
            return this;
        }

        public Builder location(String location) {
            this.location = Location.valueOf(location);
            return this;
        }

        public List<Interest> interests(Interest... interests) {
            Interest interest = Interest.valueOf(String.valueOf(interests));
            this.interests.add(interest);
            return this.interests;
        }

        public Builder email(String email) {
            this.email = Email.valueOf(email);
            return this;
        }

        public Builder epurse(double epurse) {
            this.epurse = Epurse.valueOf(epurse);
            return this;
        }

        public Builder username(String username) {
            this.username = Username.valueOf(username);
            return this;
        }

        public Builder password(String password) {
            this.password = Password.valueOf(password);
            return this;
        }

        public Customer build() {
            Customer customer = new Customer(this.customerId, this.fullName, this.age);
            customer.setEmail(email);
            customer.setEpurse(epurse);
            customer.setInterests(interests);
            customer.setIsAdmin(isAdmin);
            customer.setLocation(location);
            customer.setPassword(password);
            customer.setUserName(username);
            return customer;
        }
    }

    public CustomerId getIdentity() {
        return customerId;
    }

    public FullName getFullName() {
        return fullName;
    }

    public Age getAge() {
        return age;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Epurse getEpurse() {
        return epurse;
    }

    public void setEpurse(Epurse epurse) {
        this.epurse = epurse;
    }

    public Username getUserName() {
        return username;
    }

    public void setUserName(Username username) {
        this.username = username;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public IsAdmin getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(IsAdmin isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId.equals(customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "identity=" + customerId +
                ", fullName=" + fullName +
                ", age=" + age +
                ", location=" + location +
                ", interests=" + interests +
                ", email=" + email +
                ", epurse=" + epurse +
                ", username=" + username +
                ", password=" + password +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
