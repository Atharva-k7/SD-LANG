package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortinglist {
    public static void main(String[] args){
        List<String> strobjs=new ArrayList<>();

        strobjs.add("hitesh");
        strobjs.add("atharva");
        strobjs.add("rushi");

        System.out.println(strobjs);
       String a= descending(strobjs);
        System.out.println("\n "+a);
     }
        public static String descending(List<String>  strobjs) {

                Collections.sort(strobjs, new java.util.Comparator<String>() {
@Override
                    public int compare(String s, String t1) {
                        if (s.equals(t1)) {
                            return 0;

                        } else if (s.charAt(0) < t1.charAt(0)) {
                            return 1;

                        } else {
                            return -1;
                        }
        }

                });


            return null;
        }}

