/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class HashMap<K, V> {

    private List<Pair<K, V>>[] values;
    private int firstFreeIndex;

    public HashMap() {
        this.values = new List[32];
        this.firstFreeIndex = 0;
    }

    public void add(K key, V value) {
        List<Pair<K, V>> valuesAtIndex = this.getListBasedOnKey(key);
        int index = this.getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this.firstFreeIndex++; // Total pairs in the HashMap, usually pretty close the amount of index positions occupied in the array
        } else {
            valuesAtIndex.value(index).setValue(value);
        }
        if (1.0 * this.firstFreeIndex / this.values.length > 0.75) { // Grow if number of values (lists) are > 75% of the total length of the array
            this.grow();
        }
    }

    private List<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length); // Modulo wraps the value around the length
        if (this.values[hashValue] == null) {
            this.values[hashValue] = new List<>();
        }
        return this.values[hashValue];
    }

    private int getIndexOfKey(List<Pair<K, V>> myList, K key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.value(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        // create a new array
        List<Pair<K, V>>[] newArray = new List[this.values.length * 2];
        for (int i = 0; i < this.values.length; i++) { // Loop over array
            // copy the values of the old array into the new one
            this.copy(newArray, i);
        }
        // replace the old array with the new
        this.values = newArray;
    }

    private void copy(List<Pair<K, V>>[] newArray, int fromIdx) {
        for (int i = 0; i < this.values[fromIdx].size(); i++) { // Loop over list in index position
            Pair<K, V> value = this.values[fromIdx].value(i);
            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length); // Recalculate hashcode considering new length
            if (newArray[hashValue] == null) {
                newArray[hashValue] = new List<>();
            }
            newArray[hashValue].add(value);
        }
    }

    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            return null;
        }
        List<Pair<K, V>> valuesAtIndex = this.values[hashValue];
        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (valuesAtIndex.value(i).getKey().equals(key)) {
                return valuesAtIndex.value(i).getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        List<Pair<K, V>> valuesAtIndex = this.getListBasedOnKey(key);
        if (valuesAtIndex.size() == 0) { // Empty list
            return null;
        }
        int index = this.getIndexOfKey(valuesAtIndex, key);
        if (index < 0) { // Not in list
            return null;
        }
        Pair<K, V> pair = valuesAtIndex.value(index);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }
}
