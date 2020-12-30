/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangmaple.demosbgraphql;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

class Employee implements Serializable {
    private String firstName;
    private String lastName;

    public Employee() {

    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}



public class Main {
    private static String getEmployeesJSONFromFile() throws IOException {
        StringBuilder data = null;
        try (BufferedReader br = new BufferedReader(new FileReader("employees.json"))) {
            String str = null;
            while ((str = br.readLine()) != null) {
                data.append(str);
            }
        }
        return data.toString();
    }
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee[] empList = objectMapper.readValue(getEmployeesJSONFromFile(), Employee[].class);
        System.out.println(Arrays.toString(empList));
    }
}
