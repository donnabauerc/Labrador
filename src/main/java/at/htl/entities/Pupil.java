package at.htl.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class Pupil {
    private int katalogNumber;
    private String lastName;
    private String firstName;

    public Pupil() {
    }

    public Pupil(int katalogNumber, String lastName, String firstName) {
        this.katalogNumber = katalogNumber;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    //reading Pupils from CSV file
    public List<Pupil> readPupils() {
        List<Pupil> pupils = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getClass()
                    .getResourceAsStream("/assets/pupils.csv"), StandardCharsets.UTF_8));
            br.readLine();

            String line;
            for (int i = 1; (line = br.readLine()) != null; i++) {
                String[] attributes = line.split(";");
                if (attributes.length == 2) {
                    Pupil pupil = new Pupil(i, attributes[1], attributes[0]);
                    pupils.add(pupil);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pupils;
    }

    public int getKatalogNumber() {
        return katalogNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Schüler: " +
                "Katalognummer:" + katalogNumber +
                ", Name: " + lastName +
                ", " + firstName;
    }
}