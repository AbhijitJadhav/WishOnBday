package com.bdaywish.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Testing {
    public static void main(String arg[]) throws IOException {
       
        BufferedImage bufferedImage = ImageIO.read(new File("D:\\MyTask\\hbday.jpg"));
        
         Graphics graphics = bufferedImage.getGraphics();
       
        // graphics.fillRect(20, 30, 200, 50);
         graphics.setColor(Color.BLACK);
         graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
         graphics.drawString("Bday wish", 70, 35);
         ImageIO.write(bufferedImage, "jpg", new File(
                 "D:\\MyTask\\image.jpg"));
         System.out.println("Image Created");
        
        
        
     
    }
}

