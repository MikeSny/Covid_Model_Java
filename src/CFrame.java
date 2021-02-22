import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CFrame extends JPanel implements ActionListener {

    ArrayList<Person> people = new ArrayList<Person>();
    ArrayList<Point> points = new ArrayList<Point>();
    int time = 0;



    public static void main(String[] args) {
        CFrame cFrame= new CFrame();

    }

    public void paint(Graphics g){

        time += 16;
        points.add(new Point(time/16, Person.numInfected));

        super.paint(g);
        for(Person p:people){
            p.paint(g);
        }

        for (int i =0; i<people.size();i++){
            for (int j = i+1;j<people.size();j++){
                people.get(i).collision(people.get(j));
            }
        }

        for(Point p:points){
            g.fillOval(p.time,200-p.value,5,5);
        }





    }

    public CFrame(){
        JFrame frame = new JFrame("Simulation");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        for(int i=0;i<150;i++){
            people.add(new Person());

        }
        //Timer for animation
        Timer t = new Timer(32,this);
        t.start();



        frame.add(this);




        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

