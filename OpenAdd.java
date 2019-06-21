import java.util.*;

public class OpenAdd{
    long[] ht = new long[1048576];
    final int m = 1048576;
    long nStore;
    ArrayList<Integer> nProbe = new ArrayList<>();          //keeps track of number of probes
    ArrayList<Integer> clusterCount = new ArrayList<>();          //keeps track of cluster sizes
    ArrayList<Integer> ecCount = new ArrayList<>();          //keeps track of empty cluster sizes
    
    public OpenAdd(){
        //initialize each element of the array to null
        for(int i = 0; i<1048576; i++ ){
            ht[i] = -1;
        }
    }

    public long pseudorandom(long seed){
        long xpone;
        xpone = (seed * 16807) % 2147483647;
        return xpone;
    }

    //hash function for problems in part 2A
    public long hashFunc(long num){
        return (long)(m * ((num * 0.6180339887498949) % 1));
    }

    public long hashFunc3(long num){
        if((num%m)%2 == 0){
            num %= m;
        }
        else {
            num = (num  % m) + 1;
        }
        return (long)(m * ((num * 0.6180339887498949) % 1));
    }

    //needed to convert long to integer in array index situations
    public int long_to_int(long i){
        return ((int)(i));
    }

    //insert function given in class
    public void insert1(long seed){
        int i = 0;
        long j = (long)hashFunc(seed);
        int probeCount = 1;
        do {
            j = (j+i) % m; 
            if(ht[long_to_int(j)] == -1){
                ht[long_to_int(j)] = (int)seed;
                nProbe.add(probeCount);
                return;
            }
            probeCount += 1;
            i++;
        } while(i != m);
    }

    //insert function two for 3b
    public void insert2(long seed){
        int i = 0;
        long j = (long)hashFunc(seed);
        int probeCount = 1;
        do {
            j = (j+((i)*(i+1)/2) % m); 
            if(ht[long_to_int(j)] == -1){
                ht[long_to_int(j)] = (int)seed;
                nProbe.add(probeCount);
                return;
            }
            probeCount += 1;
            i++;
        } while(i != m);
    }

    public void insert3(long seed){
        int i = 0;
        long j = (long)hashFunc3(seed);
        int probeCount = 1;
        do {
            j = (j+((i)*(i+1)/2) % m); 
            if(ht[long_to_int(j)] == -1){
                ht[long_to_int(j)] = (int)seed;
                nProbe.add(probeCount);
                return;
            }
            probeCount += 1;
            i++;
        } while(i != m);
    }

    //function will populate the hashtable with fu nction 1 hashed seed values
    public void insert(int n, long seed){
        nStore = n;
        ht[(int)hashFunc(seed)] = (int)seed;
        for(int i = 1; i < n; i++){
            seed = pseudorandom((int)seed);
            insert1(seed);
        }
    }

    public void insertTwo(int n, long seed){
        nStore = n;
        ht[(int)hashFunc(seed)] = (int)seed;
        for(int i = 1; i < n; i++){
            seed = pseudorandom((int)seed);
            insert2(seed);
        }
    }

    public void insertThree(int n, long seed){
        nStore = n;
        ht[(int)hashFunc(seed)] = (int)seed;
        for(int i = 1; i < n; i++){
            seed = pseudorandom((int)seed);
            insert3(seed);
        }
    }

    //function will count empty clusters
    public int countCluster(){
        int cCount = 0; 
        outer:
        for(int i=0; i<m; i++){          
            if(ht[i] != -1){                    //find start of a cluster
                cCount++;
                //count until you find the next non nil
                for(int j=i+1; j< m; j++){
                    if(ht[j] == -1) {
                        i = j;
                        continue outer;
                    }
                }
            }
        }
        return cCount;
    }

    public void avgCluster(){
        outer:
        for(int i=0; i<m; i++){          
            if(ht[i] != -1){                    //find start of a cluster
                int cSize = 1;
                //count until you find the next non nil
                for(int j=i+1; j< m; j++){
                    if(ht[j] == -1) {
                        i = j;
                        clusterCount.add(cSize);
                        continue outer;
                    }
                    cSize++;
                }
            }
        }
        int count = 0;
        for (int num: clusterCount) {
            count += num;
        }
        System.out.println("Average Empty Cluster Sizes = " +  (double)count/clusterCount.size());
    }

    //function will count empty clusters
    public int countEmptyCluster(){
        int cCount = 0; 
        outer:
        for(int i=0; i<m; i++){          
            if(ht[i] == -1){                    //find start of a cluster
                cCount++;
                //count until you find the next non nil
                for(int j=i+1; j< m; j++){
                    if(ht[j] != -1) {
                        i = j;
                        continue outer;
                    }
                }
            }
        }
        return cCount;
    }

    public void avgEmptyCluster(){
        outer:
        for(int i=0; i<m; i++){          
            if(ht[i] == -1){                    //find start of a cluster
                int cSize = 1;
                //count until you find the next non nil
                for(int j=i+1; j< m; j++){
                    if(ht[j] != -1) {
                        i = j;
                        ecCount.add(cSize);
                        continue outer;
                    }
                    cSize++;
                }
            }
        }
        int count = 0;
        for (int num: ecCount) {
            count += num;
        }
        System.out.println("Average Empty Cluster Sizes = " +  (double)count/ecCount.size());
    }

    public void distribution(){
        //print load factor
        System.out.println("loadfactor = " +  (double)(nStore) / m);

        //print probe count
        int count = 0;
        for (int num: nProbe) {
            count += num;
        }
        System.out.println("Average Probes = " +  (double)count/nProbe.size());

        //print #  clusters
        System.out.println("Num. of Clusters = " +  countCluster());

        //print avg number of  clusters
        avgCluster();

        //print # empty clusters
        System.out.println("Num. of Empty Clusters = " +  countEmptyCluster());

        //print avg number of empty clusters
        avgEmptyCluster();
    }

    public void generate(){
        // System.out.println(Arrays.toString(ht));
        System.out.println("Table Details: ");
        System.out.println("n = " + nStore);
        distribution();
        System.out.println("-----------------------------------------------------------------");
    }
}