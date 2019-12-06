package at.htl.entities;

import java.util.LinkedList;
import java.util.List;

public class Table {
    private int id;
    private Pupil left;
    private Pupil right;

    public Table() {
    }

    public Table(int id, Pupil left, Pupil right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    public void setLeft(Pupil left) {
        this.left = left;
    }

    public void setRight(Pupil right) {
        this.right = right;
    }

    @Override
    public String toString() {
        try {
            return "Table{" +
                    "left=" + left.getLastName() +
                    ", right=" + right.getLastName() +
                    '}';
        } catch (Exception e) {
            return "Table{left=empty,right=empty}";
        }
    }

    public List<Table> sitPupils(List<Pupil> pupils){
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
                tables.add(table);

                table = new Table();
            }
            temp++;
        }

        return tables;
    }


}
