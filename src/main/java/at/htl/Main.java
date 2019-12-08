package at.htl;

import at.htl.entities.Pupil;
import at.htl.entities.Table;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Table> bannedTables = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pupil> pupils = new LinkedList<>();
        int a = 0;
        int b = 0;
        String input;

        //reading pupils from csv
        Pupil pupil = new Pupil();
        pupils = pupil.readPupils();

        System.out.println("Sitzplangenerator: ");
        System.out.println();
        System.out.println("Bitte geben Sie die Katalognummer " +
                "(Nummer von 1-" + pupils.size() + ") jener Schüler an, die nicht" +
                "nebeneinander sitzen sollen");

        //setting banned kombinations (Table) of Pupils
        do {
            System.out.print("Katalognummer von Schüler 1: ");
            a = sc.nextInt() - 1;
            System.out.println();

            System.out.print("Katalognummer von Schüler 2: ");
            b = sc.nextInt() - 1;
            System.out.println();

            if (a >= 0 && b >= 0) {
                bannedTables.add(new Table(-10, pupils.get(a), pupils.get(b))); //Banned Tables have id=-10
            } else {
                System.out.println("Eine der Katalognummern ist fehlerhaft!");
            }

            System.out.print("Wollen Sie weitere Kombinationen setzen (j/n)?: ");
            input = sc.nextLine();

        } while (input != "n");

        //Sitting Pupils on a Table & save tables
        List<Table> tables = new LinkedList<>();
        Table table = new Table();
        tables = SitPupil.sitPupils(pupils);

        for (int i = 0; i < tables.size(); i++) {
            System.out.println(tables.get(i).toString());
            System.out.println("");
        }
    }


}
