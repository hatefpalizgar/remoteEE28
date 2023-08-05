package polymorphism.override;

public class HBOPlayer extends VodPlayer{
    @Override
    public void play(String title) {
        System.out.println("HBO player is playing " + title);
    }
}
