package io.olen4ixxx.list.main;

import io.olen4ixxx.list.exception.CustomException;

import java.util.*;

public class CustomArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
    private Object[] array;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    public CustomArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList(int capacity) throws CustomException {
        if (capacity < 0) throw new CustomException("Illegal Capacity: "+capacity);
        array = new Object[capacity];
    }

    @Override
    public int size() {
        long size = Arrays.stream(array).filter(e->e!=null).count();
        if (size > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) Arrays.stream(array).filter(e->e!=null).count();
    }

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

        array[size()] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
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
        return false;
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
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
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

    private void grow(){}
}
