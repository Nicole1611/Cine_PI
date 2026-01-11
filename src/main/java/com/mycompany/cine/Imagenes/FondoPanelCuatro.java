package com.mycompany.cine.Imagenes;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoPanelCuatro extends JPanel {

    private Image imagen;

    public FondoPanelCuatro() {
        // Ruta de la imagen en resources/imagenes/Cine.jpg
        imagen = new ImageIcon(getClass().getResource("/imagenes/FondoCliente.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen escalada al tamaño del panel
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}