package imb;

public class AnimeFactory implements MediaItemFactory {


    @Override
    public MediaItemFactory createInstance() {
        new Anime();
        return null;
    }

    @Override
    public MediaItemFactory createInstance(int[] durationEpisode, String name, int durationIntro) {
        new Anime(durationEpisode, name, durationIntro);
        return null;
    }
}
