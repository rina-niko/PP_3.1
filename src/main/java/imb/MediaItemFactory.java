package imb;

public interface MediaItemFactory {

    public MediaItemFactory createInstance();
    public MediaItemFactory createInstance(int[] durationEpisode, String name, int durationIntro);


}
