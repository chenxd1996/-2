import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("请输入量化级别：");
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        try {
            BufferedImage img = ImageIO.read(new File("images/37.png"));
            img = quantizer.quantize(img, level);
            ImageIO.write(img, "png", new File("images/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
