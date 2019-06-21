//CS700 - Sabeel Kazi - Project 1
import java.util.*;

public class Main{

    public static void main(String[] args){
        System.out .println("Part 2a ****************************************************************************************************");
        Hashing a = new Hashing();
        a.insertOne(800000, 98760053);
        //System.out.println(a.ht);
        a.generate();

        Hashing b = new Hashing();
        b.insertOne(1000000, 98760053);
        //System.out.println(b.ht);
        b.generate();

        Hashing c= new Hashing();
        c.insertOne(2000000, 98760053);
        //System.out.println(b.ht);
        c.generate();

        Hashing d = new Hashing();
        d.insertOne(3000000, 98760053);
        //System.out.println(b.ht);
        d.generate();

        System.out .println("Part 2b ****************************************************************************************************");
        Hashing aa = new Hashing();
        aa.insertTwo(800000, 98760053);
        //System.out.println(a.ht);
        aa.generate();

        Hashing bb = new Hashing();
        bb.insertTwo(1000000, 98760053);
        //System.out.println(b.ht);
        bb.generate();

        Hashing cc= new Hashing();
        cc.insertTwo(2000000, 98760053);
        //System.out.println(b.ht);
        cc.generate();

        Hashing dd = new Hashing();
        dd.insertTwo(3000000, 98760053);
        //System.out.println(b.ht);
        dd.generate();

        System.out .println("Part 3a ****************************************************************************************************");
        OpenAdd one = new OpenAdd();
        one.insert(500000, 98760053);
        one.generate();

        OpenAdd two = new OpenAdd();
        two.insert(800000, 98760053);
        two.generate();

        OpenAdd three = new OpenAdd();
        three.insert(1000000, 98760053);
        three.generate();

        OpenAdd four = new OpenAdd();
        four.insert(1048575, 98760053);
        four.generate();

        System.out .println("Part 3b ****************************************************************************************************");
        OpenAdd aaa = new OpenAdd();
        aaa.insertTwo(500000, 98760053);
        aaa.generate();

        OpenAdd bbb = new OpenAdd();
        bbb.insertTwo(800000, 98760053);
        bbb.generate();

        OpenAdd ccc = new OpenAdd();
        ccc.insertTwo(1000000, 98760053);
        ccc.generate();

        OpenAdd ddd = new OpenAdd();
        ddd.insertTwo(1048575, 98760053);
        ddd.generate();

        System.out .println("Part 3c ****************************************************************************************************");
        OpenAdd aaaa = new OpenAdd();
        aaaa.insertThree(500000, 98760053);
        aaaa.generate();

        OpenAdd bbbb = new OpenAdd();
        bbbb.insertThree(800000, 98760053);
        bbb.generate();

        OpenAdd cccc = new OpenAdd();
        cccc.insertThree(1000000, 98760053);
        cccc.generate();

        OpenAdd dddd = new OpenAdd();
        dddd.insertThree(1048575, 98760053);
        dddd.generate();
    }
}