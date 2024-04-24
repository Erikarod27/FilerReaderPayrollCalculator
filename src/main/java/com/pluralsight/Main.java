package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            //Create a FileReader object connected to the File
            FileReader filereader = new FileReader("src/main/resources/employees.csv");

            //Create a BufferReader to manage input stream
            BufferedReader bufferedReader = new BufferedReader(filereader);

            String input;

            //Skip first line
            bufferedReader.readLine();

            //Read until there is no more data
            while ((input = bufferedReader.readLine()) != null) {
                String[] splitInput = input.split("\\|");
                int id = Integer.parseInt(splitInput[0]);
                String name = splitInput[1];
                float hoursWorked = Float.parseFloat(splitInput[2]);
                float payRate = Float.parseFloat(splitInput[3]);
                Employee employee = new Employee(id, name, hoursWorked, payRate);
                System.out.printf("Employee ID: %d \nName: %s \nGross Pay: %.2f\n\n", employee.getEmployeeId(), employee.getName(), employee.getPayRate());
            }

            //Close the stream and release the resources
            bufferedReader.close();
            
        } catch (IOException e) {
            //Display the stack trace if there was an error
            e.printStackTrace();
        }
    }
}
