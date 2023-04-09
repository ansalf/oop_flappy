package FlappyBird.Control;

import FlappyBird.Util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

import static FlappyBird.Util.Constant.*;

public class PipeTest {
  // Declare the type of variables in private scope
    private BufferedImage image;
    private int Xlocation;
    private int Ylocation;

  // Initialize PipeTest constructor

    public PipeTest(int xlocation, int ylocation) {
        this.image = Util.loadBufferedImage(PIPE_PATH);
        Xlocation = xlocation;
        Ylocation = ylocation;
    }

    public  int getWidth()
    {
        return   65;
    }
    public  int getHeigth()
    {
        return   heightPipe - 3;
    }
public int getX() {
    return Xlocation + 18;
}

    public int getY() {
        return Ylocation;
    }



    public void draw(Graphics g) {
        g.drawImage(image, Xlocation, Ylocation, widthPipe, heightPipe, null);
//        g.drawRect(getX(),getY(),getWidth(),getHeigth());
    }

    public void setXYlocation(int xlocation,int ylocation) {
        Xlocation = xlocation;
        Ylocation = ylocation;
    }
}
