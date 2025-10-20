package collection;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class SWap_list {

    public static void swap(List<Integer> newswaplist,int x,int y){
            int swap= newswaplist.get(x);
        newswaplist.set(x, newswaplist.get(y));
        newswaplist.set(y, swap);

    }
    public static int reverselist(List<Integer> newswaplist){
        for (int i= newswaplist.size()-1;i<=0;i--){

            newswaplist.get(i);
            System.out.println();
        }

        return 0;
    }


    public static void main(String[] args){
        List<Integer> reversedlist=new ArrayList<>();
     List<Integer> newswaplist= Arrays.asList(10,5,4,5,8,7,5);
//        System.out.println(newswaplist);

        System.out.println( reverselist(newswaplist));
//        Collections.reverse(newswaplist);
//
//
//        System.out.println(newswaplist.size());

    }
}
