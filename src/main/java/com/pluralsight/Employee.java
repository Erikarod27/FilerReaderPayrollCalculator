package com.pluralsight;

public class Employee {
    //Private data members
    private int employeeId;
    private String name;
    private float hoursWorked;
    private float payRate;

    //Parameterized constructor
    public Employee(int employeeId, String name, float hoursWorked, float payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    //Getters and setters for each attribute
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    //Method to calculate gross pay
    public float getGrossPay() {
        return payRate * hoursWorked;
    }

    //Overriding toString method to display employee details
    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Gross Pay: " + getGrossPay();
    }

}
