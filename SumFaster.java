package sumfaster;

public class SumFaster
{
    public int[] array = {-7, -5, -3, -2, -1, 0, 1, 4, 5, 6, 7};
    public int two_count, three_count;
    public int N, FPI;    
    
    public SumFaster()
    {        
        N = array.length;
        twoSum();
        threeSum();        
    }
    
    public void twoSum()
    {
        int i = 0;//First number we check for pairs
        FPI  = firstPosNum();
        int j = FPI;//Iterator number
                        
        int sum;//sum of i and j to limit array access
        
        while(i < N - 1)
        {            
            while(j < N)
            {               
                if(i >= j) {j = i + 1;}
                
                if(j >= N) {break;}
                
                sum = array[i] + array[j];
                
                if(sum == 0){//Found sum-zero pair
                    System.out.printf("Zero-Pair of %d, %d at %d & %d\n", array[i], array[j], i, j);
                    two_count++;                    
                    j++;}
                
                else if(sum > 0){//J is too big for i                   
                    i++;
                    j = FPI;}//i has no more matches, increment i. j needs to be reset                                                            
                
                else{//Keep looking for pair
                    j++;}                    
            }
            if(j >= N) {j = FPI; i++;}//Could not find pair, ran out of j. Increment i.
        }
        System.out.printf("Zero-sum pairs: %d\n\n", two_count);
    }//End of TwoSum    
    
    public void threeSum()
    {
        for(int i=0; i < N; i++)
        {
            int j = i + 1;
            int k = N - 1;
            while(j < k)
            {
                int sum  = array[i] + array[j];
                
                if(sum + array[k] < 0) {j++;}//J is too small, increase
                
                else if(sum + array[k] > 0) {k--;}//K is too big, decrease
                
                else//Found a zero-triplet
                {
                    System.out.printf("Zero-triplet of %d, %d, %d, found at %d, %d, & %d\n", 
                                            array[i], array[j], array[k], i, j, k);
                    three_count++;
                    j++;
                    k--;
                }
            }
        }
        System.out.printf("Zero-sum triplets: %d\n\n", three_count);
    }//End of ThreeSum
    
    //Finds first positive int in SORTED array
    public int firstPosNum()
    {        
        for(int iter=0; iter < N; iter++)
        {            
            if(array[iter] >= 0)                
               {System.out.printf("First Positive Integer: %d at %d\n", array[iter], iter);
                return iter;}}        
            //Else
                return -1;
    }
    public static void main(String[] args)
    {                
        SumFaster sf = new SumFaster();        
    }
}
