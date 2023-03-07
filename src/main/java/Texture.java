import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Texture {
    public int[] pixels;
    private String loc;
    public final int SIZE;

    public Texture(String location, int size) {
        loc = location;
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        load();
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(new File(loc));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Texture wood = new Texture("wood.png", 64);
    public static Texture brick = new Texture("redbrick.png", 64);
    public static Texture bluestone = new Texture("bluestone.png", 64);
    public static Texture stone = new Texture("graystone.png", 64);
    public static Texture DE1 = new Texture ("DE1.png", 64);
    public static Texture DE2 = new Texture ("DE2.png", 64);
    public static Texture DE3 = new Texture ("DE3.png", 64);
    public static Texture DE4 = new Texture ("DE4.png", 64);
    public static Texture DE5 = new Texture ("DE5.png", 64);
    public static Texture DE6 = new Texture ("DE6.png", 64);
    public static Texture DE7 = new Texture ("DE7.png", 64);
    public static Texture DE8 = new Texture ("DE8.png", 64);
    public static Texture goal = new Texture ("goal.png", 64);
    public static Texture finish = new Texture ("finish.png", 64);
    public static Texture rectangle = new Texture ("rectangle.png", 64);
    public static Texture bluecir = new Texture ("bluecir.png", 64);
    public static Texture noodle = new Texture ("noodle.png", 64);
    public static Texture redarea = new Texture ("redarea.png", 64);
    public static Texture blue = new Texture ("blue.png", 64);
    public static Texture green = new Texture ("green.png", 64);
    public static Texture yellow = new Texture ("yellow.png", 64);
    public static Texture red = new Texture ("red.png", 64);
    public static Texture RBGY = new Texture ("RBGY.png", 64);
    public static Texture square = new Texture ("square.png", 64);
    public static Texture redsquare = new Texture ("redsquare.png", 64);



}
