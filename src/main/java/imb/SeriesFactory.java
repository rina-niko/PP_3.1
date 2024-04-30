package imb;

public class SeriesFactory implements MediaItemFactory {

    @Override
    public MediaItem createInstance() {
        return new Series();

    }

    @Override
    public MediaItem createInstance(int[] durationEpisode, String name, int durationIntro) {
        return new Series(durationEpisode, name, durationIntro);
    }
}
