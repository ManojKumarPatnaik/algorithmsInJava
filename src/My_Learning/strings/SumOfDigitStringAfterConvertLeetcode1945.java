package My_Learning.strings;

public class SumOfDigitStringAfterConvertLeetcode1945 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getLucky(String s, int k) {
	        StringBuilder sb=new StringBuilder();
	        for(int i=0;i<s.length();i++)
	        {
	           sb.append(Integer.toString(s.charAt(i)-'a'+1));
	        }
	        int res=0;
	        while(k!=0)
	        {
	            res=0;
	            for(int i=0;i<sb.length();i++)
	            {
	              res+=sb.charAt(i)-'0';  
	            }
	            sb.delete(0,sb.length());
	            sb.append(Integer.toString(res));
	            k--;
	        }
	        return res;
	}

}
