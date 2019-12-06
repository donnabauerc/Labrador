package at.htl;

import at.htl.entities.Pupil;
import at.htl.entities.Table;

import java.util.LinkedList;
import java.util.List;

public class SitPupil {

    public static List<Table> sitPupils(List<Pupil> pupils){
        List<Table> tables = new LinkedList<>();
        int temp = 0;

        if((pupils.size()%2) > 0){
            pupils.add(new Pupil(-1,"empty", "empty"));
        }

        Table table = new Table();
        for (Pupil pupil : pupils) {
            if((temp % 2) == 0){
                table.setLeft(pupil);
            }else{
                table.setRight(pupil);

                if(validateSeats(table.getLeft(), table.getRight())){
                    tables.add(table);
                }

                table = new Table();
            }
            temp++;
        }

        return tables;
    }

    public static boolean validateSeats(Pupil left, Pupil right){

        for (Table table : Main.bannedTables) {
            if(!left.equals(table.getLeft()) || !right.equals(table.getRight())){
                return true;
            }
            //nochmals umsetzen
            System.out.println("*********Gefahr********");
        }

        return false;
    }

}
