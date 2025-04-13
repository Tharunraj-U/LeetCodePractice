package org.example.ZohoLevel_3.TrainBooking.model;

public class Passenger {
    private  int passengerId;
    private  String name;
    private  int age;
    private  String  gender;
    private  String birthPreference;
    private  String allocatedBerth;

    public Passenger(int age, String allocatedBerth, String birthPreference, String gender, String name, int passengerId) {
        this.age = age;
        this.allocatedBerth = allocatedBerth;
        this.birthPreference = birthPreference;
        this.gender = gender;
        this.name = name;
        this.passengerId = passengerId;
    }

    public int getAge() {
        return age;
    }

    public Passenger setAge(int age) {
        this.age = age;
        return this;
    }

    public String getAllocatedBerth() {
        return allocatedBerth;
    }

    public Passenger setAllocatedBerth(String allocatedBerth) {
        this.allocatedBerth = allocatedBerth;
        return this;
    }

    public String getBirthPreference() {
        return birthPreference;
    }

    public Passenger setBirthPreference(String birthPreference) {
        this.birthPreference = birthPreference;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Passenger setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getName() {
        return name;
    }

    public Passenger setName(String name) {
        this.name = name;
        return this;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public Passenger setPassengerId(int passengerId) {
        this.passengerId = passengerId;
        return this;
    }
}
