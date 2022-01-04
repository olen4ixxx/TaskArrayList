package io.olen4ixxx.list.main;

import io.olen4ixxx.list.exception.CustomException;

import java.util.*;

/**
 * CustomArrayList is the custom implementation of List interface.
 *
 * Please see the olen4ixxx.github.io class for true identity
 * @author Leanid Nasanovich
 *
 */
public class CustomArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
    private Object[] array;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};
    private int size = 0;

    public CustomArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList(int capacity) throws CustomException {
        if (capacity < 0) throw new CustomException("Illegal Capacity: "+capacity);
        array = new Object[capacity];
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return Arrays.asList(array).contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> { // TODO: 1.01.22

        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        // prevent creating a synthetic constructor
        Itr() {}
        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public E next() {
            return null;
        }
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) { // TODO: 1.01.22
        return null;
    }

    @Override
    public boolean add(E e) {
        if (size == array.length) array = grow();
        array[size] = e;
        size = size + 1;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int k = 0;
        while (k < array.length) {
            if (array[k].equals(o)) {
                array = decrease(k);
                return true;
            }
            k++;
        }
        size = size - 1;
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for (Object o : c) {
            int k = 0;
            while (k < array.length) {
                if (array[k].equals(o)) {
                    array = decrease(k);
                    result = true;
                }
                k++;
            }
            size = size - 1;
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public E set(int index, E e) {
        var oldElement = (E) array[index];
        array[index] = e;
        return oldElement;
    }

    @Override
    public void add(int index, E e) {
        array = growInsert(index);
        array[index] = e;
        size = size + 1;
    }

    @Override
    public E remove(int index) {
        var oldElement = (E) array[index];
        array = decrease(index);
        size = size - 1;
        return oldElement;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public CustomArrayList<E> clone() {
        try {
            CustomArrayList clone = (CustomArrayList) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomArrayList<?> that = (CustomArrayList<?>) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    private void rangeCheckForAdd(int index) throws CustomException {
        if (index < 0 || index > array.length)
            throw new CustomException("IndexOutOfBounds: " + index);
    }

    private Object[] grow() {
        int oldCapacity = array.length;
        var newArray = new Object[oldCapacity + oldCapacity / 2 + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    private Object[] growInsert(int index) {
        int oldCapacity = array.length;
        int newCapacity = oldCapacity + 1;
        var newArray = new Object[newCapacity];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        for (int i = index; i < newCapacity; i++) {
            newArray[i+1] = array[i];
        }
        return newArray;
    }

    private Object[] decrease(int index) {
        int oldCapacity = array.length;
        int newCapacity = oldCapacity - 1;
        var newArray = new Object[newCapacity];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        for (int i = index; i < newCapacity; i++) {
            newArray[i] = array[i+1];
        }
        return newArray;
    }
}
