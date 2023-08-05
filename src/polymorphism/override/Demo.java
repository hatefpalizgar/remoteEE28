package polymorphism.override;

/*
 * I recommend you reading my article on Medium website:
 * https://medium.com/swlh/why-and-when-to-use-polymorphism-ffcbf3709509
 **/
public class Demo {
    public static void main(String[] args) {
        String player = args[0];
        VodPlayer vodPlayer = null;

        if (player.equals("Netflix")) {
            vodPlayer = new NetflixPlayer();
        } else if (player.equals("HBO")){
            vodPlayer = new HBOPlayer();
        } else {
            vodPlayer = new DefaultPlayer();
        }

        playEpisode(vodPlayer, "HOUSE_OF_CARDS_S01E01");

    }

    public static void playEpisode(VodPlayer player, String title) {
        // The exact implementation of play() method is defined at run-time
        // That's why method overriding is called runtime polymorphism
        player.play(title);
    }

    // Thanks to polymorphism, you can have a single playEpisode(...) method that behaves
    // differently based on the input

    // Without polymorphism, we should have written 3 different playEpisode methods:
    public static void playEpisode(NetflixPlayer player, String title) {
        player.play(title);
    }

    public static void playEpisode(HBOPlayer player, String title) {
        player.play(title);
    }

    public static void playEpisode(DefaultPlayer player, String title) {
        player.play(title);
    }

}
