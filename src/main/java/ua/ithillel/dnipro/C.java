package ua.ithillel.dnipro;

import java.io.*;
import java.util.HashMap;

public class C implements Serializable {
    public HashMap<String, Integer> cityMap = new HashMap<String, Integer>();

    public HashMap setCityMap() {
        cityMap.put("Kyiv", 467 );
        cityMap.put("Zaporijya", 80);
        cityMap.put("Lviv", 900);
        return cityMap;
    }
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp2.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        C ts = new C();
        oos.writeObject(ts);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("temp2.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        C c = (C) oin.readObject();
        System.out.println("Kyiv distance="+c.cityMap.values());
    }
}
