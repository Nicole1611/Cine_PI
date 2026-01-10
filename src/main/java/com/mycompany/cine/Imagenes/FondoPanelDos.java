package com.mycompany.cine.Imagenes;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoPanelDos extends JPanel {

    private Image imagen;

    public FondoPanelDos() {
        imagen = new ImageIcon(getClass().getResource("/imagenes/FondoPelicula.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }

}
