import java.io.File;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;

public class StickerGenerator {
    
    public void create(InputStream inputStream, String filename) throws Exception{

        // read file
            java.awt.image.BufferedImage originalImage = ImageIO.read(new File("img/em_nome_do_pai.jpg"));

        // create new image in memory with tranparency and new size
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = (int) (height * 1.2);

        BufferedImage finalImage= new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        // copy image to new image

        Graphics2D graphics = (Graphics2D) finalImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);
        // add a phrase to new image
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 85));
        graphics.setColor(Color.YELLOW);
        graphics.drawString("Cool Movie", 550, newHeight -180);
        //write new file 
        ImageIO.write(finalImage, "png", new File(filename));


    }

}
