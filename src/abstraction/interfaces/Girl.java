package abstraction.interfaces;

// You can implement multiple interfaces separated by comma in Java
// In other terms, 'multiple implementation' is allowed in Java

// BUT, 'multiple inheritance' is not allowed in Java
// The only exception to this rule is 'Object' class
public class Girl extends Human implements Loveable, Playable{
    private String name;

    public Girl(String skinColor, String name) {
        super(skinColor);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void love() {
        System.out.println("showing love to a girl");
    }


    @Override
    public void play() {
        System.out.println("girl is playing");
    }
}
