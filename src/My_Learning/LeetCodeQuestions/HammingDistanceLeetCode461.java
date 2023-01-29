package My_Learning.LeetCodeQuestions;

public class HammingDistanceLeetCode461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int hammingDistance(int x, int y) {
	    int res = 0;
	    int m = x^y;                  // take the xor of two numbers which contain on bit at change bit position of x and y
	    while(m != 0){                // count the no of "1"s 
	        if((m&1) == 1) // taking and with each bit and adding to answer
	            res++;
	        m = m>>1;
	    }
	    return res;
	}
	
	public int hammingDistance2(int x, int y) {
        int count = 0;
        int n = x^y;
        for(int i=0; i<32; i++)
        {
            if(((n>>i)&1) == 1){ // right shifting n each time and anding it to 1
                count++;
            }
                
        }
        return count;
    }

}
