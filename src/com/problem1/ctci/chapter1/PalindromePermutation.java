package com.problem1.ctci.chapter1;

/**
 * Created by sowmyaparameshwara on 5/22/17.
 */
public class PalindromePermutation {

    public static void main(String[] args){
        String pali = "Rats live on no evil star";
        System.out.println(isPalindromePermutation1(pali));
        System.out.println(isPalindromePermutation2(pali));
    }

    private static boolean isPalindromePermutation2(String pali) {
        int bitVector = createBitVector(pali);
        return (bitVector==0)|| checkOnlyOneExists(bitVector);
    }

    /* Check that exactly one bit is set by subtracting one from the
	 * integer and ANDing it with the original integer. */
    private static boolean checkOnlyOneExists(int bitVector) {
        return ((bitVector & (bitVector-1))==0);
    }

    /**
     *
     *
     * Setting a bit

     Use the bitwise OR operator (|) to set a bit.

     number |= 1 << x;
     That will set bit x.

     Clearing a bit

     Use the bitwise AND operator (&) to clear a bit.

     number &= ~(1 << x);
     That will clear bit x. You must invert the bit string with the bitwise NOT operator (~), then AND it.

     Toggling a bit

     The XOR operator (^) can be used to toggle a bit.

     number ^= 1 << x;
     That will toggle bit x.

     Checking a bit

     You didn't ask for this but I might as well add it.

     To check a bit, shift the number x to the right, then bitwise AND it:

     bit = (number >> x) & 1;
     That will put the value of bit x into the variable bit.

     Changing the nth bit to x

     Setting the nth bit to either 1 or 0 can be achieved with the following:

     number ^= (-x ^ number) & (1 << n);
     Bit n will be set if x is 1, and cleared if x is 0.
     * @param pali
     * @return
     */
    	/* Create bit vector for string. For each letter with value i,
	 * toggle the ith bit. */
    private static int createBitVector(String pali) {
        int bitVector = 0;
        for(int i=0;i<pali.length();i++){
            int val = getNumericValue(pali.charAt(i));
            if(val>=0) {
//                int mask = 1 << val;
//                if ((mask & bitVector) == 0) {
//                    bitVector = bitVector | mask;
//                } else {
//                    bitVector = bitVector & ~mask;
//                }

                bitVector ^= 1 << val; 	/* Toggle the ith bit in the integer. */
                // System.out.println(Integer.toBinaryString(bitVector));
            }
        }
        return bitVector;
    }

    private static boolean isPalindromePermutation1(String pali) {

        int[] charArray=new int[26];
        int oddCount=0;

        for(int i=0;i<pali.length();i++){
            int c = getNumericValue(pali.charAt(i));
            if(c!=-1){
                charArray[c]++;
                if(charArray[c]%2==1){
                    oddCount++;
                }else{
                    oddCount--;
                }
            }
        }

        return oddCount<=1;
    }


    static int getNumericValue(char c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a<=val && val<=z){
            val= val-a;
            return val;
        }
        return -1;
    }
}
