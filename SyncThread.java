class Printing
{
    public void print()
    {
    for(int i=0;i<10;i++)
            {
                System.out.println("Hi! I'm running the "+i+" th time");
            } 
    }
}
class ThreadClass implements Runnable
{
public String threadname;
Thread t;
Printing PD;
    ThreadClass(String t,Printing pd)
    {
        threadname=t;
        PD=pd;
        
    }
    public void run()
    {
        try
        {
            synchronized(PD){
           PD.print();}
        }catch(Exception e){}
         System.out.println(threadname + " is exiting.");
    }
    public void start()
    {
        System.out.println(threadname+" is going to start!");
        t=new Thread(this,threadname);
        t.start();
    }
}
public class HelloWorld
{
    public static void main(String args[])
    {
        Printing PD=new Printing();
        ThreadClass tc1=new ThreadClass("Thread1",PD);
        tc1.start();
        ThreadClass tc2=new ThreadClass("Thread2",PD);
        tc2.start();
    }
}
