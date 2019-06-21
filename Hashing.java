//Note: some decimal values may be lost through conversion of types

import java.util.*; 
import java.lang.Math; 

public class Hashing{

    LinkedList<Long> ht[] = new LinkedList[1000003];
    long nStore;

    //contructor
    public Hashing(){
        //initialize each element of the array
        for(int i = 0; i<1000003; i++ ){
            ht[i] = new LinkedList();
        }
    }

    //generates the next seed value
    public long pseudorandom(long seed){
        long xpone;
        xpone = (seed * 16807) % 2147483647;
        return xpone;
    }

    //hash function for problems in part 2A
    public long hashFuncOne(long num){
        return num % 1000003;
    }

    //hash function for problems in part 2B
    public long hashFuncTwo(long num){
        return (long)((1000003) * ((num * 0.6180339887498949) % 1));
    }

    //function will populate the hashtable with function 1 hashed seed values
    public void insertOne(long n, long seed){
        nStore = n;
        ht[(int)hashFuncOne(seed)].add(seed);
        for(int i = 1; i < n; i++){
            seed = pseudorandom(seed);
            ht[(int)hashFuncOne(seed)].add(seed);       //insert hashed seed value into hashtable
        }
    }

    //function will populate the hashtable with function 2 hashed seed values
    public void insertTwo(long n, long seed){
        nStore = n;
        ht[(int)hashFuncTwo(seed)].add(seed);
        for(int i = 1; i < n; i++){
            seed = pseudorandom(seed);
            ht[(int)hashFuncTwo(seed)].add(seed);       //insert hashed seed value into hashtable
        }
    }

    //function calculates distribution of buckets
    public void distribution(){
        Map<Integer, Integer> m = new TreeMap();
        for(int i = 0; i<1000003; i++ ){
            if (m.containsKey(ht[i].size())) {         //if map contains key update value +1
                int count = m.get(ht[i].size());
                m.put(ht[i].size(), count + 1);
            }
            else {
                m.put(ht[i].size(), 0);                // if key not present, add it
            }
        }
        //print the hashtable + distribution
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
        
            System.out.println ("Bucket Size: " + key + " | # Buckets: " + 
                (value+1) + " | Distribution: " + (double)(value)/ 1000003);
        }

        //print load factor
        System.out.println("loadfactor = " +  (double)(nStore) / 1000003);

        //code block will calculate and print the standard deviation
        {
            List<Integer> numArray = new ArrayList();
            //populate arraylist with bucket distribution values
            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                Integer key = entry.getKey();

                numArray.add(key);
            }
            
            double standardDeviation = 0.0;

            double mean = (double)(nStore) / 1000003;

            for (Integer i : numArray) {
                standardDeviation += Math.pow((i - mean), 2);
            }

            System.out.println("Standard Deviation: " + (Math.sqrt(standardDeviation/(nStore - 1))) * 100);
        }
    }

    //print all table details
    public void generate(){
        System.out.println("Table Details: ");
        System.out.println("n = " + nStore);
        distribution();
        System.out.println("-----------------------------------------------------------------");
    }
}