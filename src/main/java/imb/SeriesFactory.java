package imb;

public class SeriesFactory implements MediaItemFactory {

    @Override
    public MediaItemFactory createInstance() {
        new Series();
        return null;
    }

    @Override
    public MediaItemFactory createInstance(int[] durationEpisode, String name, int durationIntro) {
        new Series(durationEpisode, name, durationIntro);
        return null;
    }


}
