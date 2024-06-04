package Week05_Inclass.slotmachine;

import javax.swing.*;
import java.awt.*;

public abstract class Symbol {
    public abstract Image getImage();
}

class Cherry extends Symbol {
    private final Image image;

    public Cherry() {
        ImageIcon icon = new ImageIcon("src/Week05_Inclass/images/cherry.png");
        this.image = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
    }

    @Override
    public Image getImage() {
        return image;
    }
}

class Lemon extends Symbol {
    private final Image image;

    public Lemon() {
        ImageIcon icon = new ImageIcon("src/Week05_Inclass/images/lemon.png");
        this.image = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
    }

    @Override
    public Image getImage() {
        return image;
    }
}

class Orange extends Symbol {
    private final Image image;

    public Orange() {
        ImageIcon icon = new ImageIcon("src/Week05_Inclass/images/orange.png");
        this.image = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
    }

    @Override
    public Image getImage() {
        return image;
    }
}

class WinnerStar extends Symbol {
    private final Image image;

    public WinnerStar() {
        ImageIcon icon = new ImageIcon("src/Week05_Inclass/images/star.png");
        this.image = icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    }

    @Override
    public Image getImage() {
        return image;
    }
}