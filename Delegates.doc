using System.IO;
using System;
delegate void del(int i);
class Program
{
    public static int num=10;
    public static void hello(int x)
    {
        num+=x;
        
    }
    
    public static int getNum()
    {
        return num;
    }
    static void Main()
    {
        del myDelegate=new del(hello);
        myDelegate(20);
        Console.WriteLine(getNum());
    }
}
