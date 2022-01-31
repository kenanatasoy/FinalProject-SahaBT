package org.example.domain;

import java.util.List;
import java.util.Objects;

public class Customer {
    private Identity identity;
    private FullName fullName;
    private Age age;
    private Location location;
    private List<Interest> interests;
    private Email email;
    private Epurse epurse;
    private Username userName;
    private Password password;
    private IsAdmin isAdmin;

    public static class Builder{
        private Identity identity;
        private FullName fullName;
        private Age age;
        private Location location;
        private List<Interest> interests;
        private Email email;
        private Epurse epurse;
        private Username userName;
        private Password password;
        private IsAdmin isAdmin;

        public Builder identity(String id) {
            this.identity = Identity.valueOf(identity);
            return this;
        }

        public Builder fullName(String first,String last) {
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

        public List<Interest> interests(Interest... interests1) {
           Interest interest = Interest.valueOf(String.valueOf(interests1));
           this.interests.add(interest);
           return interests;
        }

        public Builder email(String email) {
            this.email = Email.valueOf(email);
            return this;
        }

        public Builder epurse(double epurse) {
            this.epurse = Epurse.valueOf(epurse);
            return this;
        }

        public Builder userName(String userName) {
            this.userName = Username.valueOf(userName);
            return this;
        }

        public Builder password(String password) {
            this.password = Password.valueOf(password);
            return this;
        }

        public Customer build(){
            Customer customer = new Customer(this.identity);
            customer.setAge(age);
            customer.setEmail(email);
            customer.setEpurse(epurse);
            customer.setFullName(fullName);
            customer.setInterests(interests);
            customer.setIsAdmin(isAdmin);
            customer.setLocation(location);
            customer.setPassword(password);
            customer.setUserName(userName);
            return customer;
        }
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
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
        return userName;
    }

    public void setUserName(Username userName) {
        this.userName = userName;
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
        return identity.equals(customer.identity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "identity=" + identity +
                ", fullName=" + fullName +
                ", age=" + age +
                ", location=" + location +
                ", interests=" + interests +
                ", email=" + email +
                ", epurse=" + epurse +
                ", userName=" + userName +
                ", password=" + password +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
