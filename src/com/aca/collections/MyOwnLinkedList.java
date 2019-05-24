package com.aca.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyOwnLinkedList<E> implements List<E> {

    static class Node<E> {
        private E e;
        private Node<E> next;
        private Node<E> previous;

        Node(Node<E> previous, E e, Node<E> next) {
            this.e = e;
            this.next = next;
            this.previous = previous;
        }

    }

    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;

    @Override
    public boolean add(E e) {

        Node<E> last = this.last;
        Node<E> node = new Node<>(last, e, null);
        if (first == null) {
            first = node;
        }
        if (last != null) {
            last.next = node;
        }
        this.last = node;
        size++;

        return true;
    }

    @Override
    public void add(int index, E element) {
        Node<E> node = first;
        Node<E> newNode;
        if (index == 0) {
            newNode = new Node<>(null, element, node);
            node.previous = newNode;
            first = newNode;
        }
        if (index == size){
            Node<E> n = last;
            newNode = new Node<>(last,element,null);
            n.next = newNode;
            last = newNode;
        }
        if (index > 0 && index < size) {
            for (int i = 1; i < size; i++) {
                node = node.next;
                if (i == index) {
                    newNode = new Node<>(node.previous, element, node);
                    node.previous.next = newNode;
                    node.previous = newNode;
                }
            }
        }

        size++;
    }

    @Override
    public E get(int index) {

        if (index >= 0 && index < size) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    return node.e;
                }
                node = node.next;
            }
        }

        throw new IndexOutOfBoundsException("Index out of bounds!");
    }

    @Override
    public E remove(int index) {

        if (index > 0 && index < size) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    node.previous.next = node.next;
                }
                node = node.next;
            }
        } else if (index == 0) {
            Node<E> node = first;
            first = node.next;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        size--;
        return null;
    }

    @Override
    public boolean remove(Object o) {

        Node<E> node = first;
        if (first.e.equals(o)) {
            first = node.next;
            size--;
            return true;
        }
        node = node.next;
        for (int i = 1; i < size; i++) {
            if (node.e.equals(o)) {
                if (i == size - 1){
                    node.previous.next = null;
                    size--;
                    return true;
                }
                node.previous.next = node.next;
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.e;
        return result;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.e = null;
            x.next = null;
            x.previous = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Node<E> x = first; x != null; x = x.next){
            if (x.e.equals(o)){
                return true;
            }
        }

        return false;
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
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
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
    public E set(int index, E element) {
        return null;
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
}
