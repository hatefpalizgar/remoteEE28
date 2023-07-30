package inheritance.example01;

// Here class Boy is a child/subclass of Dad
// Since Boy is extending Dad, and Dad itself is extending Person,
// This means 'Boy extends both Dad and Person at the same time'
// In other words, Boy is a Person, Boy is a Dad.
// So, Boy inherits all the fields/methods of both Dad and Person classes.
public class Boy extends Dad{
    // Our Boy class can have its own field(s) on top of what Dad and Person have
    private String favouriteMusic;

    public Boy(String name, int age, String hairColor, String favouriteMusic) {
        super(name, age, hairColor); // To give birth to a Boy, you need first to give birth to its Dad
        this.favouriteMusic = favouriteMusic;
        // Notice that call to super constructor should ALWAYS be the first line in the child constructor.
        // Otherwise, you'll get compilation error.
    }

    public void dance(){
        System.out.println("Boy is dancing");
    }

    public String getFavouriteMusic() {
        return favouriteMusic;
    }

    public void setFavouriteMusic(String favouriteMusic) {
        this.favouriteMusic = favouriteMusic;
    }
}
