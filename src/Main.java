import java.awt.*;
import java.io.*;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


class Main extends JPanel implements KeyListener {
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    char cKey;

    public Main(){



    }

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(new FileReader("src/resources/SETUP.txt"));
        int mins = Integer.parseInt(br.readLine());
        int sec = Integer.parseInt(br.readLine());
        int tSec = mins * 60 + sec;
        int orig = tSec;
        StdDraw.setCanvasSize(1700,1000);

        StdDraw.enableDoubleBuffering();
        char key = 0;
        while(true) {


            StdAudio.play("src/resources/Alarm.wav");
            if(tSec == 0)tSec = orig;
            String blinds = br.readLine();

            if(blinds.equalsIgnoreCase("break")){
                System.exit(0);
                break;
            }

            while(tSec > 0){

                int min = tSec / 60;
                int secs = tSec % 60;
                String clock = min + ":" + secs;
                if(secs <10) clock = min + ":0" + secs;

                run(clock, blinds);


                Thread.sleep(1000);
                StdDraw.clear();
                tSec--;

            }

        }

    }

    private static void run(String clock, String blinds){
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledRectangle(.5,.5,.5,.5);
        //consolas
        StdDraw.setFont(new Font("Arial", Font.PLAIN, 300));
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.text(.5,.35,blinds);
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.setFont(new Font("alarm clock", Font.PLAIN, 300));
        StdDraw.text(.5,.63,clock);
        StdDraw.show();
        StdDraw.pause(0);

    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        System.out.println("You pressed down: " + c);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}