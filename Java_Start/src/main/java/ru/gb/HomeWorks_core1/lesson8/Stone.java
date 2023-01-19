package ru.gb.HomeWorks_core1.lesson8;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Stone {
    BufferedImage image = null;

    public Stone (int num){
        num %= 20;
        String fileName = "images/lesson8/";

        if (num % 2 == 0){
            fileName = fileName + "w" + (num / 2 + 1) + ".png";
        } else {
            fileName = fileName + "b" + (num / 2 + 1) + ".png";
        }

        try {
            this.image = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getStone(){
        return image;
    }

}