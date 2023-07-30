package aggregation;


/**
* Aggregation occurs when there's a one-way (HAS-A) relationship between the two classes we associate(relate) through their objects.
* In below example, we can say every student HAS-A bunch of notebooks.
*/
public class Student {
    private String name;
    private double weight;
    private Backpack backpack;
    private Notebook[] notebooks;

    public Student(String name, double weight, Backpack backpack, Notebook[] notebooks) {
        this.name = name;
        this.weight = weight;
        this.backpack = backpack;
        this.notebooks = notebooks;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public Notebook[] getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Notebook[] notebooks) {
        this.notebooks = notebooks;
    }
}
