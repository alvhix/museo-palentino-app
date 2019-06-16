/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disenno;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

public class ImagenFondo implements Border {

    private BufferedImage mImagen = null;

    /**
     * Constructor, indicamos la imagen que queremos que se redimensione
     *
     * @param pImagen ImageIO.read(new File(ruta imagen))
     */
    public ImagenFondo(BufferedImage pImagen) {
        mImagen = pImagen;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (mImagen != null) {
            g.drawImage(mImagen, 0, 0, width, height, null);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
