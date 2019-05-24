package com.aca.collections;

import java.util.*;

public class MyOwnArrayList<E> implements List<E> {

    private Object[] elementData;
    private int size = 0;
    private int currentIndex = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyOwnArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(E e) {
        if (currentIndex == elementData.length) {
            elementData = Arrays.copyOf(elementData, size * 2);
            elementData[currentIndex++] = e;
            size++;
        } else {
            elementData[currentIndex++] = e;
            size++;
        }

        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new RuntimeException("Index out of bounds!");
        } else if (index == size) {
            add(element);
            size++;
        } else {
            if (size < elementData.length) {
                Object[] array = elementData;
                elementData = new Object[elementData.length];
                int i = 0;
                for (int j = 0; j <= size; j++) {
                    if (j == index) {
                        elementData[j] = element;
                    } else {
                        elementData[j] = array[i];
                        i++;
                    }
                }
                size++;
            } else {
                Object[] array = elementData;
                elementData = new Object[elementData.length * 2];
                int i = 0;
                for (int j = 0; j < size + 1; j++) {
                    if (j == index) {
                        elementData[j] = element;

                    } else {
                        elementData[j] = array[i];
                        i++;
                    }
                }
                size++;
            }
        }
    }

    public int getLength() {
        return elementData.length;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = elementData[i];
        }

        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return Arrays.copyOf(a, a.length);
    }

    @Override
    public boolean remove(Object o) {

        if (check(o, elementData)) {
            Object[] array = elementData;
            elementData = new Object[elementData.length];
            int j = 0;
            int k = 0;
            for (int i = 0; i < size; i++) {
                if (array[i].equals(o)) {
                    j++;
                }
                if (array[i].equals(o) && j == 1) {
                    continue;
                } else {
                    elementData[k] = array[i];
                    k++;
                }
            }
            size--;
        } else {
            return false;
        }

        return true;
    }

    private boolean check(Object o, Object[] elementData) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {

        if (index > size || index < 0) {
            throw new RuntimeException("Index out of bounds!");
        } else {
            Object[] array = elementData;
            elementData = new Object[elementData.length];
            int j = 0;
            for (int i = 0; i < size; i++) {
                if (i != index) {
                    elementData[j] = array[i];
                    j++;
                }
            }
            size--;
            return (E) array[index];
        }

    }

    @Override
    public E get(int index) {

        if (index > size || index < 0) {
            throw new RuntimeException("Index out of bounds!");
        } else {
            return (E) elementData[index];
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
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
    public E set(int index, E element) {
        return null;
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
    public int indexOf(Object o) {
        return 0;
    }
}
