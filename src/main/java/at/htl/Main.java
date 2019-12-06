package at.htl;

import at.htl.entities.Pupil;
import at.htl.entities.Table;

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

        List<Table> tables = new LinkedList<>();
        Table table = new Table();

        tables = table.sitPupils(pupils);

        for (int i=0;i<tables.size();i++){
            System.out.println(tables.get(i).toString());
            System.out.println("");
        }
    }


}
