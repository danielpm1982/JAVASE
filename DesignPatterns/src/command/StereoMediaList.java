package command;

import java.security.SecureRandom;

public class StereoMediaList {
    private static final String[] mediaList=new String[]{"MusicA","MusicB","MusicC","MusicD","MusicE"};
    public static String[] getMediaList(){
        return mediaList;
    }
    public static String getRandomMediaName(){
        SecureRandom random = new SecureRandom();
        int index = random.ints(0, mediaList.length).findFirst().getAsInt();
        return mediaList[index];
    }
}
