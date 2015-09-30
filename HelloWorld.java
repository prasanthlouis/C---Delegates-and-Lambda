class ThreadClass implements Runnable
{
 String threadname;   
 Thread t;
 ThreadClass(String t)
 {
     threadname=t;
     System.out.println("Creating Thread "+threadname);
 }
 public void run()
 {try{
     for(int i=0;i<10;i++)
     {
         System.out.println("Hi, I'm "+threadname+" on my "+i+"th loop");
         Thread.sleep(50);
     }
 }catch(Exception e){}
 }
    public void start()
    {
        System.out.println("Going to start thread "+threadname);
        t=new Thread(this,threadname);
        t.start();
    }
}
public class HelloWorld{
    public static void main(String args[])
    {
    ThreadClass tc1=new ThreadClass("Thread1");
    tc1.start();
    ThreadClass tc2=new ThreadClass("Thread2");
    tc2.start();
    }
}
