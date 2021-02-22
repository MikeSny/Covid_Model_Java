import java.awt.*;

public class Person {
    //location
    int x;
    int y;

    //velocity
    int vx;
    int vy;

    //status
    int status = 0;

    //recovery time
    int recoveryTime;

    //number infected
    static int numInfected;

    public void collision(Person p2){
        Rectangle per1 = new Rectangle(p2.x,p2.y,10,10);
        Rectangle per2 = new Rectangle(this.x,this.y,10,10);

        if(per1.intersects(per2)){

            if(this.status==1 && p2.status==0){
                p2.status=1;
            }else if (this.status==0 && p2.status==1){
                this.status=1;
                numInfected++;
            }
        }



    }


    public Person(){

        x =(int)(Math.random()*790+0);
        y =(int)(Math.random()*590+0);

        if (Math.random()<.02){
            status = 1;
        }
        vx =(int)(Math.random()*(10+1)+-5);
        vy =(int)(Math.random()*(10+1)+-5);

        recoveryTime = (int)(Math.random()*(7000-5000+1)+5000);

    }
    public void paint(Graphics g){

        switch (status){
            case 0:
                g.setColor(Color.LIGHT_GRAY);
                break;
            case 1:
                g.setColor(Color.RED);
                break;
            case 2:
                g.setColor(Color.BLUE);

        }

        if(status==1){
            //recovery time update
            recoveryTime-=16;
            if(recoveryTime<=0){
                status=2;
                numInfected--;
            }
        }

        x += vx;
        y += vy;

        //flip velocity, bouncing of the walls
        if (x < 0 || x >= 790){
            vx *= -1;
        }
        if (y < 0 || y >= 590){
            vy *= -1;
        }



        g.fillOval(x,y,10,10);
    }





}
