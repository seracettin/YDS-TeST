package ydstest;

import java.nio.file.Paths;
import javax.swing.ImageIcon;

public class YdsTest {

    public static void main(String[] args) {

        ImageIcon img = new ImageIcon(Paths.get(".").toAbsolutePath().normalize().toString() + "\\data\\" + "logo.png");
        YDSJFrame ydsf = new YDSJFrame();
        ydsf.setTitle("YDS Deneme Çöz");
        ydsf.setIconImage(img.getImage());
        ydsf.setVisible(true);

    }
}
