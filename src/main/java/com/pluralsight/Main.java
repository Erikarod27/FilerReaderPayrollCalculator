package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the name of the file employee file to process: ");
            String inputFileNName = scanner.nextLine();

            //Create a FileReader object connected to the File
            FileReader filereader = new FileReader("src/main/resources/" +  inputFileNName);

            //Create a BufferReader to manage input stream
            BufferedReader bufferedReader = new BufferedReader(filereader);

            String input;

            //Skip first line
            bufferedReader.readLine();

            //Create FileWriter object for the payroll file
            System.out.print("Enter the name of the payroll file to create: ");
            String outputFileName = scanner.nextLine();

            FileWriter fileWriter = new FileWriter(outputFileName);

            //Writer header for payroll file
            fileWriter.write("id|name|gross pay\n");

            //Read until there is no more data
            while ((input = bufferedReader.readLine()) != null) {
                String[] splitInput = input.split("\\|");
                int id = Integer.parseInt(splitInput[0]);
                String name = splitInput[1];
                float hoursWorked = Float.parseFloat(splitInput[2]);
                float payRate = Float.parseFloat(splitInput[3]);
                Employee employee = new Employee(id, name, hoursWorked, payRate);

                //Write employee information to payroll file
                fileWriter.write(String.format("%d|%s|%.2f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay()));

            }

            //Close the stream and release the resources
            bufferedReader.close();
            fileWriter.close();

        } catch (IOException e) {
            //Display the stack trace if there was an error
            e.printStackTrace();
        }
    }
}
