package imb;

public class AnimeFactory implements MediaItemFactory {


    @Override
    public MediaItem createInstance() {
        return new Anime();
    }

    @Override
    public MediaItem createInstance(int[] durationEpisode, String name, int durationIntro) {
        return new Anime(durationEpisode, name, durationIntro);

    }
}
