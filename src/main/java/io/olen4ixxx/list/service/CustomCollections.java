package io.olen4ixxx.list.service;

import java.util.List;
import java.util.Random;

/**
 * CustomCollections is the custom implementation of Collections class to service Lists.
 *
 * Please see the olen4ixxx.github.io class for true identity
 * @author Leanid Nasanovich
 *
 */
public class CustomCollections<E extends Comparable<E>> {
    public void quickSort(List<E> list, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(list, begin, end);

            quickSort(list, begin, partitionIndex-1);
            quickSort(list, partitionIndex+1, end);
        }
    }

    private int partition(List<E> list, int begin, int end) {
        var rand = new Random();
        var pivot = list.get(rand.nextInt(begin, end));
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;

                var swapTemp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, swapTemp);
            }
        }

        var swapTemp = list.get(i+1);
        list.set(i+1, list.get(end));
        list.set(end, swapTemp);

        return i+1;
    }

}
