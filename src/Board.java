import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;


public class Board extends JPanel implements ActionListener {
   // private static final long serialVersionUID = 1 L;
    protected static ArrayList < Vehicle > m;
    private final int DELAY = 10;
    private int count = 0;
    private Player player;
    private int w = 1024;
    private int h = 700;
    private int counter = 0;
    private Timer timer;
    private Vehicle enm;
    private Vehicle boomb;
    private int counter3 = 0;
    private EnemyFire gh;
    private Vehicle planeexplosion;
    private Vehicle fireplayercollide;
    private AbstractFactory abs;
    private int setpx, setpy, setmx, setmy;
    private boolean gameends;
    private int score;
    public Board() {
        initBoard();
    }

    private void initBoard() {

        m = new ArrayList < > ();

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        player = Player.getInstance();
        Player p = Player.getInstance();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension(w, h));
        player.moveTo(w / 2, h * 3 / 4);
        timer = new Timer(DELAY, this);
        timer.start();

    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (gameends) {
            gameendspaint(g2d);
        }
        if (!gameends) {
            g.setColor(getBackground());
            g.clearRect(0, 0, w, h);
            Dimension size = getSize();
            w = (int) size.getWidth();
            h = (int) size.getHeight();
            player.paintComponent(g2d);
            for (int i = 0; i < m.size(); i++) {

                m.get(i).paintComponent(g2d);

            }
        }
        Toolkit.getDefaultToolkit().sync();
    }
    public void gameendspaint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, w, h);
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i) instanceof Explosion) {
                m.get(i).paintComponent(g2d);

                if (m.get(i).count >= 4) {
                    g.clearRect(0, 0, w, h);
                    timer.stop();
                                     
                    String msg = "Game  Over";
                    String msg1 = "Total Score :" + score;
                    Font small = new Font("Helvetica", Font.BOLD, 30);
                    FontMetrics fm = getFontMetrics(small);
                    g.setColor(Color.RED);
                    g.setFont(small);
                    g.drawString(msg, (getWidth() - fm.stringWidth(msg)) / 2, getHeight() / 2);
                    g.drawString(msg1, (getWidth() - fm.stringWidth(msg)) / 2, (getHeight() / 2) + 100);
                    break;
                }
            }
        }







    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        counter++;
        step();

    }

    private void step() {
        Random rand = new Random();
        int b = rand.nextInt(w - 70);
        int n = new Random().nextInt(10);

        if (count >= 500) {
            abs = Factoryproducer.getfactory(true);
            Vehicle fighter = abs.getVehicle("fighter");
            fighter.moveTo(b, 0);

            m.add(fighter);
            count = 100;
            if (n < 6) {
                abs = Factoryproducer.getfactory(false);
                Vehicle enemyfire = abs.getVehicle("Enemyfire");
                enemyfire.moveTo(fighter.getX(), fighter.getY() + 50);
                m.add(enemyfire);
            }
        } else if (counter >= 200) {
            abs = Factoryproducer.getfactory(true);
            Vehicle bomber = abs.getVehicle("Bomber");
            bomber.moveTo(b, 0);

            m.add(bomber);
            if (n < 6) {
                abs = Factoryproducer.getfactory(false);
                Vehicle enemyfire = abs.getVehicle("Enemyfire");
                enemyfire.moveTo(bomber.getX(), bomber.getY() + 50);
                m.add(enemyfire);
            }
            counter = 0;
        }


        setpx = (player.getX() + player.getDx() + 120);
        setpy = (player.getY() + player.getDy() + 70);
        setmx = (player.getX() + player.getDx()) - 120;
        setmy = (player.getY() + player.getDy()) - 120;

        if (!(setpx > w) && !(setpy > h) && !(setmx < 0) && !(setmy < 0)) {
            player.move();
        }
        cleanup();
        repaint();



    }

    public void cleanup()

    {
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i) instanceof EnemyFire) {
                if (player.getBounds().intersects(m.get(i).getBounds())) {
                    gameends = true;
                    System.out.println("added");
                    abs = Factoryproducer.getfactory(false);
                    Vehicle ex = abs.getVehicle("explosion");
                    ex.moveTo(player.getX(), player.getY() - 60);
                    m.add(ex);
                    m.remove(m.get(i));
                }
            }
        }
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i) instanceof Explosion) {
                if (m.get(i).getCount() >= 4) {
                    m.remove(i);
                }
            }
        }
        for (int i = 0; i < m.size(); i++) {
            m.get(i).move();
        }

        for (int i = 0; i < m.size(); i++) {
            Vehicle b1 = m.get(i);
            if (b1 instanceof Bullet) {
                if (b1.getY() < 0) {
                    m.remove(i);
                }
            }



        }
        for (int i = 0; i < m.size(); i++) {
            Vehicle enm = m.get(i);
            if (enm instanceof Fighter || enm instanceof Bomber) {
                if (enm.getY() > 700 || enm.getX() > 1024 || enm.getX() < 0) {
                    m.remove(i);

                }
            }
        }

        for (int i = 0; i < m.size(); i++) {
            if (m.get(i) instanceof EnemyFire) {
                if (m.get(i).h > 700) {
                    m.remove(i);

                }
            }
        }

        for (int j = 0; j < m.size(); j++) {
            Vehicle b1 = m.get(j);
            if (b1 instanceof Bullet) {
                for (int i = 0; i < m.size(); i++) {
                    Vehicle enm = m.get(i);
                    if (enm instanceof Bomber || enm instanceof Fighter) {

                        if (enm.getBounds().intersects(b1.getBounds())) {
                            System.out.println("Length of List " + m.size());
                            abs = Factoryproducer.getfactory(false);
                            Vehicle ex = abs.getVehicle("explosion");
                            ex.moveTo(enm.getX(), enm.getY());
                            m.add(ex);
                            m.remove(enm);
                            m.remove(b1);
                            score++;
                            System.out.println("Bullet is removed");
                            System.out.println("Enemy is removed");

                        }
                    }
                }
            }
        }
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i) instanceof Bullet) {
                Vehicle v = m.get(i);
                for (int j = 0; j < m.size(); j++) {

                    Vehicle enm = m.get(j);
                    if (m.get(j) instanceof Bomber) {

                        if ((v.getBounds().getX() > enm.getBounds().getX()) &&
                            ((v.getBounds().getX() <= (enm.getBounds().getX() + enm.getBounds().getWidth())))) {

                            if (v.getBounds().getWidth() / 2 + v.getBounds().getX() > enm.getBounds().getWidth() / 2 + enm.getBounds().getX()) {

                                System.out.println("Half of Bullet width " + (v.getBounds().getWidth() / 2 + v.getBounds().getX()));
                                System.out.println("Half of Enemy width " + (enm.getBounds().getWidth() / 2 + enm.getBounds().getX()));
                                System.out.println("Enemy width " + enm.getBounds().getWidth());
                                System.out.println("Bullet width " + v.getBounds().getWidth());
                                System.out.println("Start of  X OF Bullet " + v.getBounds().getX());
                                System.out.println("Enemy Bounds  X " + enm.getBounds().getX());
                                double a = (enm.getBounds().getX() + enm.getBounds().getWidth());
                                System.out.println("Upper limit of of enemy " + a);

                                if (!(enm.getX() - 20 < 0)) {
                                    enm.moveTo(enm.getX() - 3, enm.getY());
                                }

                            } else if (v.getBounds().getWidth() / 2 + v.getBounds().getX() < enm.getBounds().getWidth() / 2 + enm.getBounds().getX())

                            {

                                System.out.println("Half of Bullet width " + (v.getBounds().getWidth() / 2 + v.getBounds().getX()));
                                System.out.println("Half of Enemy width " + (enm.getBounds().getWidth() / 2 + enm.getBounds().getX()));
                                System.out.println("Enemy width " + enm.getBounds().getWidth());
                                System.out.println("Bullet width " + v.getBounds().getWidth());
                                System.out.println("Boundat X OF Bullet " + v.getBounds().getX());
                                System.out.println("Enemy Bounds  X " + enm.getBounds().getX());
                                double a = (enm.getBounds().getX() + enm.getBounds().getWidth());
                                System.out.println("Upper limit of of enemy " + a);
                                if (!(enm.getX() + 20 > 1024)) {
                                    enm.moveTo(enm.getX() + 3, enm.getY());
                                }
                            }

                        }

                        System.out.println("----------------------");
                    }

                }

            }


        }

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }

}