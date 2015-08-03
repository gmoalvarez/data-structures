import data_structures.*;

import java.text.NumberFormat;
import java.util.Iterator;
/**
 * Created by guillermo on 4/12/15.
 */
public class ProductLookupTester {

    private ProductLookup inventory = new ProductLookup(100);
    private ProductLookup inventory2 = new ProductLookup(100);
    private String [] skuArray = {"ABC123", "DEF456", "GHI789", "JKL123", "MNP456", "QRS789", "TUV123", "WXY456","ZAB789",
                                  "CDE321", "DAS931", "IOS918", "HSA941", "HKE293", "UAH532","HAS431", "ALE471","UND892"};
    private String[] skuArray2 = {"05", "28", "04", "12", "03", "01", "09", "14","13"};

    private Double[] priceArray = new Double[skuArray.length];

    public ProductLookupTester() {

        for (int i=0; i < priceArray.length;i++)
            priceArray[i]= Double.valueOf(i+1);
        int j=0;
        for (String sku:skuArray )
            inventory.insertSku(sku,priceArray[j++]);
        insertionSort(skuArray);
        int i=0;
        for (String sku:skuArray2 )
            inventory2.insertSku(sku,priceArray[i++]);
//        for(String s:skuArray)
//            System.out.println(s);
        runTests();

    }

    private String shuffle(String input){
        LinearListADT<Character> characters = new LinearList<Character>();
        for(char c:input.toCharArray()){
            characters.addLast(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

    private void runTests() {
        double d = 29.95;
        double e = 30;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println(nf.format(d));
        System.out.println(nf.format(e));
//        inventory.insertSku("HSA212",nf.format(d));
        System.out.println("Testing the contains method");
        System.out.println("Does it contain WXY456? Should be true");
        System.out.println(inventory.containsSku("WXY456"));
        System.out.println();
        System.out.println("Does it contain ABC121? Should be false");
        System.out.println(inventory.containsSku("ABC121"));
        System.out.println();
        System.out.println("Trying to insert a duplicate key...should fail");
        if(inventory.insertSku("GHI789", 25.0d))
            System.out.println("ERROR! Inserted duplicate SKU!");
        else
            System.out.println("Good job, the duplicate SKU was not inserted");
        System.out.println();
        System.out.println("Trying to delete a valid and invalid key");

        if(inventory.deleteSku("MNP456"))
            System.out.println("Great job, you deleted item with SKU MNP456");
        else
            System.out.println("Bad job, you did not delete item with SKU MNP456 properly");
        System.out.println();
        if(inventory.deleteSku("MNA456"))
            System.out.println("Bad job, you deleted an item that doesn't exist");
        else
            System.out.println("Good job, you did not delete an invalid item");
        System.out.println();
        System.out.println("Getting the value of item with SKU HKE293");
        Double price = inventory.getPrice("HKE293");
        if(price != null)
            System.out.println("The price of the item with SKU HKE293 is " +price);
        else
            System.out.println("You did not find the item :(");
        System.out.println();
        System.out.println("Getting the value of item with invalid SKU ABF431");
        Double price2 = inventory.getPrice("ABF431");
        if(price2 != null)
            System.out.println("You should not have found it! NOT GOOD! ");
        else
            System.out.println("Great job! Search failed like it should");
        System.out.println();
        System.out.println("Looking for Key with value 7.0...should be TUV123");
        String sku = inventory.getSku(7.0d);
        System.out.println("Found "+sku);
        if(sku!=null && sku.equals("TUV123"))
            System.out.println("Great job, you found the correct sku: " +sku);
        else
            System.out.println("Bad job, you did not find the correct sku");
        System.out.println();
        System.out.println("Testing the getRange method");
        String[] keyRange = inventory.getRange("B", "F");
        for(String key:keyRange)
            System.out.println(key);
        System.out.println("Testing the iterator and printing the SKU's");
        Iterator<String> skuIterator = inventory.sku_s();
        while(skuIterator.hasNext()) {
            System.out.println(skuIterator.next());
        }
        Iterator<Double> priceIterator = inventory.prices();
        while(priceIterator.hasNext()) {
            System.out.println(priceIterator.next());
        }
        System.out.println("Now we will use the other binary tree");
        System.out.println();
        System.out.println("The original keys are:");
        Iterator<String> skuIterator2 = inventory2.sku_s();
        while(skuIterator2.hasNext()) {
            System.out.println(skuIterator2.next());
        }
        System.out.println("Trying to delete a valid and invalid key");

        if(inventory2.deleteSku("12"))
            System.out.println("Great job, you deleted item with SKU 12");
        else
            System.out.println("Bad job, you did not delete item with SKU 12 properly");
        System.out.println();
        if(inventory2.deleteSku("MNA456"))
            System.out.println("Bad job, you deleted an item that doesn't exist");
        else
            System.out.println("Good job, you did not delete an invalid item");
        System.out.println();
        System.out.println();
        System.out.println("The new keys are:");
        Iterator<String> skuIterator3 = inventory2.sku_s();
        while(skuIterator3.hasNext()) {
            System.out.println(skuIterator3.next());
        }


    }

    private static String[] insertionSort(String[] array) {
        String[] on = array;
        int in, out;
        String temp;
        for(out = 1; out < on.length; out++) {
            temp = on[out];
            in = out;
            while(in > 0 && on[in-1].compareTo(temp) > 0) {
                on[in] = on[in-1];
                in--;
            }
            on[in] = temp;
        }
        return array;
    }

    public static void main(String args[]) {
        System.out.println("Running Tests");
        new ProductLookupTester();

    }
}