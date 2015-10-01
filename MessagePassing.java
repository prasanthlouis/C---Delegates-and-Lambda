class Messenger{
    Boolean flag=false;
    public synchronized void print(String s)
    {if(flag)
        {try{
            wait();
        }catch(Exception e){}
        }
    System.out.println(s);
    flag=true;
    notify();
    }
    public synchronized void printagain(String s)
    {if(!flag)
        {try{
            wait();
        }catch(Exception e){}
        }
    System.out.println(s);
    flag=false;
    notify();}
}

class ThreadClass1 implements Runnable{
    Thread t;
      Messenger m;
      ThreadClass1(Messenger map)
      {
          m=map;
      }

    String[] s={"Hi There","How are you","Good"};
     public void run()
     {
         for(int i=0;i<3;i++)
         m.printagain(s[i]);
     }
     public void start()
     {
    
     t=new Thread(this,"Thread1");
     t.start();
     }
     
}

class ThreadClass2 implements Runnable{
    Thread t;
      Messenger m;
      ThreadClass2(Messenger map)
      {
          m=map;
      }
   
    String[] s={"HI!","Doing Well. You?","Bye!"};
     public void run()
     {
         for(int i=0;i<3;i++)
         m.print(s[i]);
     }
     public void start()
     {
    
     t=new Thread(this,"Thread2");
     t.start();
     }
     
}


public class HelloWorld{
    public static void main(String args[])
    {
         Messenger m=new Messenger();
     ThreadClass1 tc1=new ThreadClass1(m);
         tc1.start();
     ThreadClass2 tc2=new ThreadClass2(m);
 
     tc2.start();
    }
}
