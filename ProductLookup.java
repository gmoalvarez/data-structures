/*  Guillermo Alvarez
    masc0863
*/
import java.util.Iterator;
import data_structures.*;
import java.text.NumberFormat;


public class ProductLookup {
    private DictionaryADT<String,Double> dictionary;

    // creates a new Dictionary with max capacity.
    // suitable for hashtable implementations
    public ProductLookup(int capacity) {
        dictionary = new HashTable<>(capacity);
    }

    // creates a new Dictionary with no max capacity.
    // suitable for tree implementations
    public ProductLookup() {
//        dictionary = new BinarySearchTree<>();
        dictionary = new RedBlackTree<>();
    }

    // inserts a new Product and its price
    public boolean insertSku(String sku, Double price) {
        if(!dictionary.add(sku, price)) {
            System.out.println("Could not insert item");
            return false;
        }
        return true;
    }

    // removes the key value pair that is identified by the key from the dictionary
    public boolean deleteSku(String sku) {
        if(!dictionary.delete(sku)) {
            System.out.println("Item not found");
            return false;
        }
        return true;
    }

    // looks up the price of an Product
    public Double getPrice(String sku) {
        return dictionary.getValue(sku);
    }

    // returns the first sku found with the given price, null otherwise
    public String getSku(Double price) {
        return dictionary.getKey(price);
    }

    // returns true if the sku is already in the dictionary
    public boolean containsSku(String sku) {
        return dictionary.contains(sku);
    }

    // returns all of the keys in the dictionary within the range start .. finish
    // inclusive, in sorted order. Neither value 'start' or 'finish' need be in the
    // dictionary.  Returns null if there are no keys in the range specified.
    public String[] getRange(String start, String finish) {
        Iterator<String> keyIterator = dictionary.keys();
        String[] keyRange = new String[dictionary.size()];
        int j = 0;
        String currentKey;
        while(keyIterator.hasNext()) {
            currentKey = keyIterator.next();
            if(currentKeyIsInRange(start, finish, currentKey))
                keyRange[j++] = currentKey;
        }
        String[] keyArray = new String[j];
        for(int i=0; i<j; i++)
            keyArray[i]=keyRange[i];
        return keyArray;
    }

    private boolean currentKeyIsInRange(String start, String finish, String currentKey) {
        return currentKey.compareTo(start) >= 0 && currentKey.compareTo(finish) <= 0;
    }

    // returns an Iterator of the sku's (the keys) in the dictionary,
    // in sorted order.
    public Iterator<String> sku_s() {
        return dictionary.keys();
    }

    // returns the prices in the dictionary, in exactly the same order
    // as the sku_s() Iterator
    public Iterator<Double> prices() {
        return dictionary.values();
    }

}