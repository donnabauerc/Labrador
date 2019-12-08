package at.htl;

import at.htl.entities.Pupil;
import at.htl.entities.Table;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SitPupil {

    //setting tables with pupils
    public static List<Table> sitPupils(List<Pupil> pupils) {
        List<Table> tables = new LinkedList<>();

        //if the pupils in one class aren't even, one pupil has to sit alone
        if ((pupils.size() % 2) > 0) {
            pupils.add(new Pupil(-1, "empty", "empty"));
        }

        Table table = new Table();
        Random random = new Random();

        for (int i = pupils.size(); i > 0; i -= 2) {
            //randomly generating pairs and check if they aren't the same
            int temp1 = random.nextInt(pupils.size());
            Pupil left = pupils.get(temp1);


            int temp2 = random.nextInt(pupils.size());
            while (temp2 == temp1) {
                temp2 = random.nextInt(pupils.size());
            }
            Pupil right = pupils.get(temp2);

            //check wether the two pupils are allowed to sit to each other
            if (validateSeats(left, right)) {
                table.setLeft(left);
                table.setRight(right);
                tables.add(table);

                //removing them for future tables (in specific way, so the index doesn't get effected
                if (temp1 > temp2) {
                    pupils.remove(temp1);
                    pupils.remove(temp2);
                } else {
                    pupils.remove(temp2);
                    pupils.remove(temp1);
                }
            } else { //else a new pair should be generated
                i += 2;
            }

            table = new Table();//reset table
        }

        return tables;
    }

    public static boolean validateSeats(Pupil left, Pupil right) {
        //check if the pair is allowed in every possible way
        for (Table table : Main.bannedTables) {
            if (left.equals(table.getLeft()) && right.equals(table.getRight())) {
                System.out.println("Nicht erlaubt!");
                return false; //not allowed
            } else if (right.equals(table.getLeft()) && left.equals(table.getRight())) {
                System.out.println("Nicht erlaubt!");
                return false; //not allowed
            }
        }
        return true; //alowed
    }

}
