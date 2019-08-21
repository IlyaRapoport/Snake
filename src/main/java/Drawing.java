import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.ArrayList;

public class Drawing extends JPanel implements ActionListener, KeyListener {

    private boolean rKeyPressed = false, gameOver = false;
    boolean down = false;
    boolean up = false;
    boolean left = false;
    boolean right = false;
    boolean pause = false;
    private ArrayList<Integer> greenPointX = new ArrayList<>();
    private ArrayList<Integer> greenPointY = new ArrayList<>();

    private int level = 1;
    private int score = 0;
    private ArrayList<Integer> scoreArray = new ArrayList<>();
    private int size = 20;
    private int points = 30;
    private int widthHeight = size;
    private int x = 0, y = 0, velX = 0, velY = 0;
    private String inputName;
    private ArrayList<ScoreCalc> sortedScore;
    private ArrayList<Integer> redPointX = new ArrayList<>();
    private ArrayList<Integer> redPointY = new ArrayList<>();

    private ArrayList<Integer> tailX = new ArrayList<>();
    private ArrayList<Integer> tailY = new ArrayList<>();

    Drawing() {
        greenPoint();
        redPoint();
        Timer timer = new Timer(100, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        tail(x, y);
    }

    public void paint(Graphics graphics) {
        level();
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        ScoreCalc scoreCalc = new ScoreCalc();
        Rectangle rectangle;

        if (pause) {
            graphics2D.setFont(new Font("serif", Font.BOLD, 20));
            graphics2D.drawString("Pause", 300, 300);

        }
        if (level > 1) {
            for (int i = 160; i < 420; i += widthHeight) {
                rectangle = new Rectangle(10 * points, i, widthHeight, widthHeight);
                graphics2D.setColor(Color.RED);
                graphics2D.fill(rectangle);

                for (int j = 0; j < greenPointX.size(); j++) {
                    if (greenPointX.get(j) == 10 * points && greenPointY.get(j) == i)
                        greenPoint();
                }
                if (x == 10 * points && y == i) {
                    x = redPointX.get(0);
                    y = redPointY.get(0);
                }
            }
        }
        if (level > 2) {
            for (int i = 11; i <= 19; i++) {
                rectangle = new Rectangle(i * widthHeight, 160 - widthHeight, widthHeight, widthHeight);
                graphics2D.setColor(Color.RED);
                graphics2D.fill(rectangle);
                for (int j = 0; j < greenPointX.size(); j++) {
                    if (greenPointX.get(j) == i * widthHeight && greenPointY.get(j) == 160 - widthHeight)
                        greenPoint();
                }
                if (x == i * widthHeight && y == 160 - widthHeight) {
                    x = redPointX.get(0);
                    y = redPointY.get(0);
                }
            }
            for (int i = 11; i <= 19; i++) {
                rectangle = new Rectangle(i * widthHeight, 400 + widthHeight, widthHeight, widthHeight);
                graphics2D.setColor(Color.RED);
                graphics2D.fill(rectangle);
                for (int j = 0; j < greenPointX.size(); j++) {
                    if (greenPointX.get(j) == i * widthHeight && greenPointY.get(j) == 400 + widthHeight)
                        greenPoint();
                }
                if (x == i * widthHeight && y == 400 + widthHeight) {
                    x = redPointX.get(0);
                    y = redPointY.get(0);
                }
            }
        }
        if (level > 3) {

            for (int i = 4; i <= 25; i++) {
                rectangle = new Rectangle(i * widthHeight, 280, widthHeight, widthHeight);
                graphics2D.setColor(Color.RED);
                graphics2D.fill(rectangle);
                for (int j = 0; j < greenPointX.size(); j++) {
                    if (greenPointX.get(j) == i * widthHeight && greenPointY.get(j) == 280)
                        greenPoint();
                }
                if (x == i * widthHeight && y == 280) {
                    x = redPointX.get(0);
                    y = redPointY.get(0);
                }
            }
        }

        if (level > 4) {
            for (int p = 0; p <= level - 5; p++) {

                for (int i = 0; i < points; i++) {
                    rectangle = new Rectangle(i * widthHeight, p * widthHeight, widthHeight, widthHeight);
                    graphics2D.setColor(Color.RED);
                    graphics2D.fill(rectangle);
                    for (int j = 0; j < greenPointX.size(); j++) {
                        if (greenPointX.get(j) == i * widthHeight && greenPointY.get(j) == p * widthHeight)
                            greenPoint();
                    }
                    if (x == i * widthHeight && y == p * widthHeight) {
                        x = redPointX.get(0);
                        y = redPointY.get(0);
                    }
                }
                for (int i = 0; i < points; i++) {
                    rectangle = new Rectangle(i * widthHeight, 580 - p * widthHeight, widthHeight, widthHeight);
                    graphics2D.setColor(Color.RED);
                    graphics2D.fill(rectangle);
                    for (int j = 0; j < greenPointX.size(); j++) {
                        if (greenPointX.get(j) == i * widthHeight && greenPointY.get(j) == 580 - p * widthHeight)
                            greenPoint();
                    }
                    if (x == i * widthHeight && y == 580 - p * widthHeight) {
                        x = redPointX.get(0);
                        y = redPointY.get(0);
                    }
                }
                for (int i = 0; i < points; i++) {
                    rectangle = new Rectangle(p * widthHeight, i * widthHeight, widthHeight, widthHeight);
                    graphics2D.setColor(Color.RED);
                    graphics2D.fill(rectangle);
                    for (int j = 0; j < greenPointX.size(); j++) {
                        if (greenPointX.get(j) == p * widthHeight && greenPointY.get(j) == i * widthHeight)
                            greenPoint();
                    }
                    if (x == p * widthHeight && y == i * widthHeight) {
                        x = redPointX.get(0);
                        y = redPointY.get(0);
                    }
                }
                for (int i = 0; i < points; i++) {
                    rectangle = new Rectangle(580 - p * widthHeight, i * widthHeight, widthHeight, widthHeight);
                    graphics2D.setColor(Color.RED);
                    graphics2D.fill(rectangle);
                    for (int j = 0; j < greenPointX.size(); j++) {
                        if (greenPointX.get(j) == 580 - p * widthHeight && greenPointY.get(j) == i * widthHeight)
                            greenPoint();
                    }
                    if (x == 580 - p * widthHeight && y == i * widthHeight) {
                        x = redPointX.get(0);
                        y = redPointY.get(0);
                    }
                }
            }
        }
        for (int i = 0; i < redPointX.size(); i++) {
            rectangle = new Rectangle(redPointX.get(i), redPointY.get(i), widthHeight, widthHeight);
            graphics2D.setColor(Color.RED);
            graphics2D.fill(rectangle);
        }

        for (int i = 0; i < tailX.size(); i++) {

            if (tailX.size() > 2 && i > 2) {
                if (tailY.get(i) > tailY.get(i - 1) || tailY.get(i) < tailY.get(i - 1)) {
                    if (tailX.get(i) < tailX.get(i - 1)) {
                        rectangle = new Rectangle(tailX.get(i) + size, tailY.get(i), widthHeight, widthHeight);
                        graphics2D.fill(rectangle);
                    }

                    if (tailX.get(i) > tailX.get(i - 1)) {
                        rectangle = new Rectangle(tailX.get(i) - size, tailY.get(i), widthHeight, widthHeight);
                        graphics2D.fill(rectangle);
                    }
                }
            }
            if (i == tailX.size() - 1) {
                graphics2D.setColor(Color.YELLOW);
                graphics2D.fill(new RoundRectangle2D.Double(x, y, size, size, 10, 10));
            } else {
                graphics2D.setColor(Color.BLUE);
                rectangle = new Rectangle(tailX.get(i), tailY.get(i), widthHeight, widthHeight);
                graphics2D.fill(rectangle);
            }
        }

        for (int i = 0; i < tailX.size() - 1; i++) {
            if (tailX.size() > 2 && i > 2 && tailY.get(i).equals(tailY.get(tailY.size() - 1)) && tailX.get(i).equals(tailX.get(tailX.size() - 1))) {
                x = redPointX.get(0);
                y = redPointY.get(0);
            }
        }
        for (int i = 0; i < greenPointX.size(); i++) {
            rectangle = new Rectangle(greenPointX.get(i), greenPointY.get(i), widthHeight, widthHeight);
            graphics2D.setColor(Color.GREEN);
            graphics2D.fill(rectangle);
        }

        for (int i = 0; i < greenPointX.size(); i++) {
            if (x == greenPointX.get(i) && y == greenPointY.get(i)) {
                greenPoint();
                score += 10;
            }
        }
        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(new Font("serif", Font.BOLD, 14));
        graphics2D.drawString("Level: " + level, 10, 15);
        graphics2D.drawString("Score: " + score, 70, 15);

        for (int j = 0; j < redPointX.size(); j++) {
            if (x == redPointX.get(j) && y == redPointY.get(j)) {
                gameOver = true;
                rectangle = new Rectangle(0, 0, 600, 600);
                graphics2D.setColor(Color.RED);
                graphics2D.fill(rectangle);
                for (int value : scoreArray) {
                    score += value;
                }
                graphics2D.setColor(Color.BLACK);
                graphics2D.setFont(new Font("serif", Font.BOLD, 25));
                graphics2D.drawString("Game Over", 200, 220);
                graphics2D.drawString("Score: " + score, 200, 250);

                try {

                    sortedScore = scoreCalc.scoreCalc(inputName, score);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                graphics2D.setFont(new Font("serif", Font.BOLD, 14));
                int sizeIfList = sortedScore.size();
                if (sizeIfList > 5) sizeIfList = 5;

                for (int i = 0; i < sizeIfList; i++) {
                    String nameOutput = sortedScore.get(i).getNameForSorting();
                    int scoreOutput = sortedScore.get(i).getScoreForSorting();

                    if (nameOutput.equals(inputName) && scoreOutput == score) graphics2D.setColor(Color.BLUE);
                    else graphics2D.setColor(Color.BLACK);
                    graphics2D.drawString(i + 1 + ": " + nameOutput + " " + scoreOutput, 200, 300 + 17 * i);
                    if (i == sizeIfList - 1) {
                        graphics2D.setColor(Color.GREEN);
                        graphics2D.drawString("Press ENTER for renew", 200, 300 + 17 * (i + 3));
                        level = 1;
                        scoreArray.clear();
                        reset();
                        break;
                    }
                }
            }
        }
    }

    private void level() {
        if (score > 390) {
            level++;
            scoreArray.add(score);
            reset();
        }
    }

    private void tail(int x, int y) {

        tailX.add(x);
        tailY.add(y);

        for (int i = 0; i < score / 10 + 1; i++) {
            if (tailY.size() > score / 10 + 1) {

                tailX.remove(i);
                tailY.remove(i);
            }
        }
    }

    private void greenPoint() {
        greenPointX.clear();
        greenPointY.clear();
        if (((int) (Math.random() * score)) > 200) redPoint();

        for (int i = 0; i < score / 100 + 1; i++) {
            greenPointX.add(((int) (Math.random() * points)) * widthHeight);
            greenPointY.add(((int) (Math.random() * points)) * widthHeight);
        }
        for (int j = 0; j < redPointX.size(); j++) {
            for (int i = 0; i < greenPointX.size(); i++) {
                if (greenPointX.get(i).equals(redPointX.get(j)) && greenPointY.get(i).equals(redPointY.get(j)))
                    greenPoint();
            }
        }

        for (int i = 0; i < greenPointX.size(); i++) {
            for (int j = 0; j < tailX.size(); j++) {
                if (greenPointX.get(i).equals(tailX.get(j)) && greenPointY.get(i).equals(tailY.get(j))) greenPoint();
            }
        }
    }

    private void reset() {
        if (((level - 4) * widthHeight) < 0) {
            x = 0;
            y = 0;
        } else {
            x = ((level - 4) * widthHeight);
            y = ((level - 4) * widthHeight);
        }

        velY = 0;
        velX = 0;
        score = 0;

        rKeyPressed = false;
        up = false;
        down = false;
        left = false;
        right = false;

        redPoint();

        tailX.clear();
        tailY.clear();
        greenPointX.clear();
        greenPointY.clear();

        greenPoint();
        tailX.add(x);
        tailY.add(y);
    }

    private void redPoint() {

        redPointX.clear();
        redPointY.clear();
        for (int i = 0; i < score / 100 + 1; i++) {
            redPointX.add(((int) (Math.random() * points)) * widthHeight);
            redPointY.add(((int) (Math.random() * points)) * widthHeight);
        }
        for (int i = 0; i < tailY.size(); i++) {
            for (int j = 0; j < redPointX.size(); j++) {
                if (redPointX.get(j).equals(tailX.get(i)) && redPointY.get(j).equals(tailY.get(i))) greenPoint();
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (!gameOver) repaint();

        if (!rKeyPressed) {
            x += velX;
            y += velY;
        }
        if (rKeyPressed) {
            velY = 0;
            velX = 0;

            if (greenPointX.get(0) > x) x += size;
            if (greenPointX.get(0) < x) x -= size;
            if (greenPointX.get(0) == x && greenPointY.get(0) > y) y += size;
            if (greenPointX.get(0) == x && greenPointY.get(0) < y) y -= size;
            if (x == redPointX.get(0) && y == redPointY.get(0)) {
                if (((int) (Math.random() * 2)) == 1) {
                    x -= size;
                    y += size;
                } else {
                    x += size;
                    y -= size;
                }
            }
        }
        if (x < 0) x = 600 - widthHeight;
        if (y < 0) y = 600 - widthHeight;
        if (x >= 600) x = 0;
        if (y >= 600) y = 0;
        tail(x, y);
    }

    private void up() {
        up = true;
        pause = false;
        if (!down) {
            rKeyPressed = false;
            velY = -size;
            velX = 0;
            down = false;
            left = false;
            right = false;
        }
    }

    private void down() {
        down = true;
        pause = false;
        if (!up) {
            rKeyPressed = false;
            velY = size;
            velX = 0;
            up = false;
            left = false;
            right = false;
        }
    }

    private void left() {
        left = true;
        pause = false;
        if (!right) {
            rKeyPressed = false;
            velY = 0;
            velX = -size;
            right = false;
            down = false;
            up = false;
        }
    }

    private void right() {
        right = true;
        pause = false;
        if (!left) {
            rKeyPressed = false;
            velY = 0;
            velX = size;
            left = false;
            down = false;
            up = false;
        }
    }

    private void pause() {
        velX = 0;
        velY = 0;
        pause = true;
    }

    private void rKey() {
        rKeyPressed = true;
        down = false;
        left = false;
        right = false;
        up = false;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) up();
        if (code == KeyEvent.VK_DOWN) down();
        if (code == KeyEvent.VK_LEFT) left();
        if (code == KeyEvent.VK_RIGHT) right();
        if (code == KeyEvent.VK_R) rKey();
        if (code == KeyEvent.VK_ENTER) gameOver = false;
        if (code == KeyEvent.VK_SPACE) pause();
    }

    public void keyReleased(KeyEvent e) {

    }

    public String getInputName() {
        return inputName;
    }

    void setInputName(String inputName) {
        this.inputName = inputName;
    }
}
