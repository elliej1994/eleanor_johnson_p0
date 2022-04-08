package dev.johnson.utilities;

public class ArrayList<T> implements List<T>{

    private Object[] elements;
    private int currentIndex;
    public ArrayList(){
        this.elements = new Object[10];
        this.currentIndex = 0;
    }

    @Override
    public void add(T element) {


    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
