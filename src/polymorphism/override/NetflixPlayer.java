package polymorphism.override;

public class NetflixPlayer extends VodPlayer{
    @Override
    public void play(String title) {
        System.out.println("Netflix player is playing " + title);
    }
}
