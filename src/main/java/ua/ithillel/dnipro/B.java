package ua.ithillel.dnipro;

import java.io.*;
import java.util.Scanner;

public class B extends A implements Serializable {
    public C c;
    public double cost;
    public double price;
    public int distance;
    public transient String route;

    public B(){
        c = new C();
        c.setCityMap();
        System.out.println("Введите город доставки:");
        for (String k: c.cityMap.keySet()) System.out.print(k + "\t");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        route =scanner.next();
        price = 0.005;
        try {
            distance = c.cityMap.get(route);
        } catch (Exception e){
            System.out.println("City not found");
        }
        System.out.println(distance);
        getCost();
        System.out.println(getCost());
    }

    public double getCost() {
        cost = price * getVolume(width, height, depth) * distance;
        return cost;
    }
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp1.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        B ts = new B();
        oos.writeObject(ts);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("temp1.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        B b = (B) oin.readObject();
        System.out.println("distance="+b.distance);
    }
}
