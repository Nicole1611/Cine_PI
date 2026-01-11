package com.mycompany.cine.Imagenes;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoPanel extends JPanel {

    private Image imagen;

    public FondoPanel() {
        // Ruta de la imagen en resources/imagenes/Cine.jpg
        imagen = new ImageIcon(getClass().getResource("/imagenes/FondoVPrincipal.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen escalada al tamaño del panel
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}

