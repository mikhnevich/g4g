package bowl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sm84878 @ 1/28/14 12:50 PM
 */
public class ListSorter {

    public void sort(List list) {
        if (list.isEmpty()) {
            return;
        }
        if (containsOnlyOneType(list)) {
            Collections.sort(list);
            return;
        }

        List<Integer> intList = sort(list, Integer.class);
        List<Integer> stringList = sort(list, String.class);

        joinLists(list, intList, stringList);
    }

    public <X extends Comparable<? super X>> List<X> sort(List<X> list, Class clazz) {
        List<X> sublist = getSublist(list, clazz);
        Collections.sort(sublist);
        return sublist;
    }

    public <T> List<T> getSublist(List list, Class<T> clazz) {
        List<T> newList = new ArrayList<T>();
        for (Object o : list) {
            if (o.getClass().equals(clazz)) {
                newList.add((T) o);
            }
        }
        return newList;
    }


    private void joinLists(List list, List<?> partialList1, List<?> partialList2) {
        int idx1 = 0;
        int idx2 = 0;
        Class clazz = partialList1.get(0).getClass();
        for (int i = 0; i < list.size(); i++) {
            Class cl = list.get(i).getClass();

            if (cl.equals(clazz)) {
                list.set(i, partialList1.get(idx1++));
            } else {
                list.set(i, partialList2.get(idx2++));
            }
        }
    }

    private boolean containsOnlyOneType(List<? extends Comparable> list) {
        Class clazz = list.get(0).getClass();
        for (Object o : list) {
            if (!o.getClass().equals(clazz)) {
                return false;
            }
        }
        return true;
    }


}
