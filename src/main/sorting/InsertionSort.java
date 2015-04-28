package sorting;

import user.types.RegUser;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jeff Schulthies
 * .
 */

public class InsertionSort {
    public static ArrayList<RegUser> insertionSort(ArrayList<RegUser> userList, int min, int max) {
        //ArrayList<RegUser> userListTemp = new ArrayList<RegUser>();
        RegUser temp;
        for(int i = min + 1; i <= max; i++) {
            int j = i;
             temp = (userList.get(i));
            while(j > min && temp.getUserID() < userList.get(j - 1).getUserID()) {
                userList.set(j, userList.get(j - 1));
                j--;
            }
            userList.set(j, temp);
        }
        return userList;
    }
}
