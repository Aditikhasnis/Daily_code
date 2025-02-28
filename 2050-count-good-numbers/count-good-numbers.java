class Solution {
    public static long mod =(long) Math.pow(10,9) + 7;
         public static long Getpow(long x, long n)
        {

            if(n==0)
            return 1;
            long half=Getpow(x,n/2);
            if(n%2==0)
            return (long)(half *half)%mod;
            else return (half*half*x)%mod;

        }

    public int countGoodNumbers(long n) {


       

        long odd = n/2;
        long even= n-odd;

        return (int) ((Getpow(5,even)* Getpow(4,odd)) % mod);







        
    }
}