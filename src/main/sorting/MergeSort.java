package sorting;

import user.types.RegUser;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jeff Schulthies
 * .
 */
public class MergeSort {

    public static void mergeSort(ArrayList<RegUser> userList) {
        mergeSort(userList, 0, userList.size());
    }
    public static void mergeSort(ArrayList<RegUser> userList, int startIndex,
                                               int endIndex) {
        int midIndex = (startIndex + endIndex) / 2;

        mergeSort(userList, startIndex, midIndex);
        mergeSort(userList, midIndex + 1, endIndex);

        if(userList.get(midIndex).getUserID() <= userList.get(midIndex + 1).getUserID()) {
        } else {
            merge(userList, startIndex, midIndex, endIndex);
        }
    }

    public static ArrayList<RegUser> merge(ArrayList<RegUser> userList, int min, int mid, int max) {
        ArrayList<RegUser> userListTemp = new ArrayList<RegUser>();

        int i = min;
        int j = mid + 1;


        while(i <= mid && j <= max) {
            if(userList.get(i).getUserID() <= userList.get(j).getUserID()) {
                userListTemp.add(userList.get(i));
                i++;
            } else {
                userListTemp.add(userList.get(j));
                j++;
            }
        }

        while(i <= mid) {
            userListTemp.add(userList.get(i));
            i++;
        }

        while(j <= max) {
            userListTemp.add(userList.get(j));
            j++;
        }

        return userListTemp;

    }
}
