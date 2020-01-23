package at.htl.entities;

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
            return "Tisch: " +
                    "Linke Seite: " + left.getLastName() +
                    ", Rechte Seite: " + right.getLastName();
        } catch (Exception e) {
            return "Tisch ist leer!";
        }
    }
}