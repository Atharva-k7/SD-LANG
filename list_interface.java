package collection;

import java.util.ArrayList;
import java.util.List;

public class list_interface {

//

    public static void main(String[] args){
        List new_type_of_arraylist=new ArrayList();
        new_type_of_arraylist.add(0,"athava");
        new_type_of_arraylist.add(1,"hitsh");
        System.out.println(new_type_of_arraylist.size());
       // System.out.println(new_type_of_arraylist);
       for (int i = 0; i < new_type_of_arraylist.size(); i++) {

          System.out.println(new_type_of_arraylist.get(i));
        }


    }
}
