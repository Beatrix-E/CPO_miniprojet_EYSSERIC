
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LightsOffGUI {

    private static final int GRID_SIZE = 5; // Taille de la grille (5x5)
    private boolean[][] lights; // État des lumières (allumées/éteintes)
    private JButton[][] buttons; // Boutons représentant les lumières

    public LightsOffGUI() {
        lights = new boolean[GRID_SIZE][GRID_SIZE];
        buttons = new JButton[GRID_SIZE][GRID_SIZE];
        initLights(); // Initialisation des lumières
        createAndShowGUI(); // Création de l'interface graphique
    }

    private void initLights() {
        // Initialiser les lumières avec des états aléatoires
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                lights[i][j] = Math.random() > 0.5;
            }
        }
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Lights Off");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                JButton button = new JButton();
                button.setBackground(lights[i][j] ? Color.YELLOW : Color.BLACK);
                button.addActionListener(new ButtonListener(i, j));
                buttons[i][j] = button;
                frame.add(button);
            }
        }

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private void toggleLight(int x, int y) {
        if (x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE) {
            lights[x][y] = !lights[x][y];
            buttons[x][y].setBackground(lights[x][y] ? Color.YELLOW : Color.BLACK);
        }
    }

    private void toggleAdjacentLights(int x, int y) {
        toggleLight(x, y); // Toggle la lumière cliquée
        toggleLight(x - 1, y); // Haut
        toggleLight(x + 1, y); // Bas
        toggleLight(x, y - 1); // Gauche
        toggleLight(x, y + 1); // Droite
    }

    private boolean checkWinCondition() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (lights[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private class ButtonListener implements ActionListener {
        private final int x;
        private final int y;

        public ButtonListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            toggleAdjacentLights(x, y);
            if (checkWinCondition()) {
                JOptionPane.showMessageDialog(null, "Congratulations! You've turned off all the lights!");
                initLights(); // Réinitialiser les lumières
                for (int i = 0; i < GRID_SIZE; i++) {
                    for (int j = 0; j < GRID_SIZE; j++) {
                        buttons[i][j].setBackground(lights[i][j] ? Color.YELLOW : Color.BLACK);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LightsOffGUI::new);
    }
}
