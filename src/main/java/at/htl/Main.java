package at.htl;

import at.htl.entities.Pupil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pupil> pupils = new LinkedList<>();
        Pupil pupil = new Pupil();

        pupils = pupil.readPupils();

        System.out.println(pupils.get(1));
    }


}
