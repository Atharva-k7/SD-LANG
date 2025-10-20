package collection;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.frequency;

public class fequencychallenge {
    public static void main(String[] args){

        List newlistcollection =new ArrayList();

        newlistcollection.add("atharva");
        newlistcollection.add("atharva");
        newlistcollection.add("atharva");
        newlistcollection.add("atharv");


    int a=frequency(newlistcollection,"atharva");
        System.out.println(a);
    }
}
