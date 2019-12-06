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

    public int getId() {
        return id;
    }

    public Pupil getLeft() {
        return left;
    }

    public Pupil getRight() {
        return right;
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
}
