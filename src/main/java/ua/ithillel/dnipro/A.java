package ua.ithillel.dnipro;


import java.io.*;

public class A implements Serializable {
    public int width;
    public transient int  height;
    public int depth;
    public String label;

    public A(){
        label = "Box";
        width = 20;
        height = 30;
        depth = 15;
    }

    public int getVolume(int w, int h, int d){
        w = width;
        h = height;
        d = depth;
        return w * h * d;
    }
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        A ts = new A();
        oos.writeObject(ts);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        A a = (A) oin.readObject();
        System.out.println("width="+a.width);
    }
}
