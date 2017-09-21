import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class quantizer {
    public static BufferedImage quantize(BufferedImage img, int level) {
        int count = (int)(Math.round((float)256 / level));
        List<Integer> levels = new ArrayList<Integer>();
        for (int i = 0; i <= 256; i += count) {
            levels.add(i);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int value = img.getData().getSample(i, j, 0);
                int newValue = 0;
                for (int k = 0; k < levels.size() - 1; k++) {
                    if (value >= levels.get(k) && value < levels.get(k + 1)) {
                        newValue = (levels.get(k) + levels.get(k + 1)) / 2;
                    }
                }
                img.getRaster().setSample(i, j, 0, newValue);
            }
        }
        return img;
    }
}
