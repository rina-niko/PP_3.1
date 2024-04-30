package imb;

public interface MediaItemFactory {

    public MediaItem createInstance();
    public MediaItem createInstance(int[] durationEpisode, String name, int durationIntro);


}
