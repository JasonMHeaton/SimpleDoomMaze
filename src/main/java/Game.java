import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{

    private static final long serialVersionUID = 1L;
    public int mapWidth = 15;
    public int mapHeight = 15;
    private Thread thread;
    private boolean running;
    private BufferedImage image;
    public int[] pixels;
    public ArrayList<Texture> textures;
    public Camera camera;
    public Screen screen;
    public static int[][] map =


  /*          textures.add(Texture.red);//18
        textures.add(Texture.green);//19
        textures.add(Texture.blue);//20
        textures.add(Texture.yellow);//21
    textures.add(Texture.RBGY);//22
        textures.add(Texture.square);//23
        textures.add(Texture.redarea);//24
        textures.add(Texture.redsquare);//25*/


    {
                    {18,18,18,18,18,18,18,20,20,20,20,20,20,22,20},
                    {22, 0, 0, 0, 0, 0, 0, 0,22,20, 0, 0,22, 0,20},
                    {18,25,22,18,18,18, 0,20,20,20, 0,20,20, 0,20},
                    {22, 0, 0, 0, 0,18, 0, 0, 0,20, 0, 0,20, 0,20},
                    {18,24,24,18, 0,18,20,20, 0,20,20, 0,20, 0,20},
                    {18, 0, 0,24, 0, 0, 0,20, 0,20, 0, 0, 0, 0,20},
                    {18,18, 0,18,25,22, 0, 0, 0,20, 0,20,20,20,20},
                    {22, 0, 0, 0, 0,18, 0,20, 0,19, 0, 0, 0, 0,22},
                    {21,21,21,21, 0,18, 0,21, 0,19, 0,19,19,19,19},
                    {21, 0, 0, 0, 0, 0, 0,21, 0,19, 0, 0, 0, 0,19},
                    {21, 0,21,21,21,21,21,21, 0,19, 0,19,19, 0,19},
                    {21, 0, 0, 0, 0,21, 0, 0, 0,19, 0,19, 0, 0,19},
                    {21, 0,21,21,21,21,21,21,19,19, 0,19, 0,19,15},
                    {21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,19, 0, 0,23},
                    {21,21,21,21,21,21,21,21,19,19,19,19,19,15,19}
            };
    public Game() {
        thread = new Thread(this);
        image = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
        textures = new ArrayList<Texture>();
        textures.add(Texture.wood); //1
        textures.add(Texture.brick);  //2
        textures.add(Texture.bluestone);//3
        textures.add(Texture.stone);//4
        textures.add(Texture.DE1);//5
        textures.add(Texture.DE2);//6
        textures.add(Texture.DE3);//7
        textures.add(Texture.DE4);//8
        textures.add(Texture.DE5);//9
        textures.add(Texture.DE6);//10
        textures.add(Texture.DE7);//11
        textures.add(Texture.DE8);//12
        textures.add(Texture.goal);//13
        textures.add(Texture.rectangle);//14
        textures.add(Texture.finish);//15
        textures.add(Texture.bluecir); //16
    textures.add(Texture.noodle);//17
        textures.add(Texture.red);//18
        textures.add(Texture.green);//19
        textures.add(Texture.blue);//20
        textures.add(Texture.yellow);//21
    textures.add(Texture.RBGY);//22
        textures.add(Texture.square);//23
        textures.add(Texture.redarea);//24
        textures.add(Texture.redsquare);//25



        camera = new Camera(4.5, 4.5, 1, 0, 0, -.66);
        screen = new Screen(map, mapWidth, mapHeight, textures, 640, 480);
        addKeyListener(camera);
        setSize(640, 480);
        setResizable(false);
        setTitle("3D Engine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.black);
        setLocationRelativeTo(null);
        setVisible(true);
        start();
    }
    private synchronized void start() {
        running = true;
        thread.start();
    }
    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        bs.show();
    }
    public void run() {
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 60.0;//60 times per second
        double delta = 0;
        requestFocus();
        while(running) {
            long now = System.nanoTime();
            delta = delta + ((now-lastTime) / ns);
            lastTime = now;
            while (delta >= 1)//Make sure update is only happening 60 times a second
            {
                //handles all of the logic restricted time
                screen.update(camera, pixels);
                camera.update(map);
                delta--;
            }
            render();//displays to the screen unrestricted time
        }
    }
    public static void main(String [] args) {
        Game game = new Game();
    }
}
