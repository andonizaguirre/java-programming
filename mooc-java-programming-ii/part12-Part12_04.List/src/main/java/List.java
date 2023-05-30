/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class List<Type> {

    private Type[] arrayList;
    private int firstFreeIndex;

    public List() {
        this.arrayList = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(Type value) {
        if (this.firstFreeIndex == this.arrayList.length) {
            this.grow();
        }
        this.arrayList[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }

    private void grow() {
        int newLength = this.arrayList.length + this.arrayList.length / 2;
        Type[] newArrayList = (Type[]) new Object[newLength];
        for (int i = 0; i < this.firstFreeIndex; i++) {
            newArrayList[i] = this.arrayList[i];
        }
        this.arrayList = newArrayList;
    }

    public boolean contains(Type value) {
//        for (int i = 0; i < this.firstFreeIndex; i++) {
//            if (this.arrayList[i].equals(value)) {
//                return true;
//            }
//        }
//        return false;
        return this.indexValueOf(value) >= 0;
    }

    public void remove(Type value) {
        int indexFound = this.indexValueOf(value);
        if (indexFound >= 0) {
            this.shiftValuesToLeft(indexFound);
            this.firstFreeIndex--;
        }
    }

    public int indexValueOf(Type value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.arrayList[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public void shiftValuesToLeft(int indexFound) {
        for (int i = indexFound; i < this.firstFreeIndex - 1; i++) {
            this.arrayList[i] = this.arrayList[i + 1];
        }
    }

    public Type value(int index) {
        if (index < 0 || this.firstFreeIndex <= index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.arrayList[index];
    }

    public int size() {
        return this.firstFreeIndex;
    }
}
