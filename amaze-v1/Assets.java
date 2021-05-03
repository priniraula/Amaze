//Assets

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 64, height = 64;

    public static BufferedImage wall, path, player, finish;

    //Assets initialization

    public static void init(){
    
        SpriteSheet sheet =  new SpriteSheet(ImageLoader.loadImage("sheet.png"));
        wall = sheet.crop(0, 0, width, height);
        path = sheet.crop( width, 0, width, height);
        player = sheet.crop (width * 2, 0, width, height);
        finish = sheet.crop (width * 3, 0, width, height);

    }
}
