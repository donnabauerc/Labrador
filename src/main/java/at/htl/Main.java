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
import java.util.Scanner;

public class Main {
    public static List<Table> bannedTables = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Pupil> pupils = new LinkedList<>();
        Pupil pupil = new Pupil();

        pupils = pupil.readPupils();
        int a = 0;
        int b = 0;

        while(a > -1 && b > -1){
            System.out.print("Kat# 1: ");
            a = sc.nextInt()-1;

            System.out.println();

            System.out.print("Kat# 2: ");
            b = sc.nextInt()-1;

            System.out.println();
            System.out.println();
            if(a >= 0 && b >= 0){
                bannedTables.add(new Table(-10, pupils.get(a), pupils.get(b)));
            }
        }



        List<Table> tables = new LinkedList<>();
        Table table = new Table();

        tables = SitPupil.sitPupils(pupils);

        for (int i=0;i<tables.size();i++){
            System.out.println("Tisch "+(i+1)+" "+tables.get(i).toString());
            System.out.println("");
        }
    }


}
