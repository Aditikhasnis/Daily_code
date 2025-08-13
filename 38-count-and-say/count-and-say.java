class Solution {
    public String countAndSay(int n) {
     StringBuilder sb = new StringBuilder("1");
     int counter=1;
     int count=1;
     StringBuilder _nwStr = new StringBuilder();
     while(counter<n)
     {
        
        _nwStr.setLength(0);
        count=1;
        for(int i=1;i<sb.length();i++)
        {
           if(sb.charAt(i-1)!=sb.charAt(i))
           {
              _nwStr.append(String.valueOf(count));
              _nwStr.append(sb.charAt(i-1));
              count=1;
           }
           else{
           count++;
           }
        }
        System.out.println(count);
        _nwStr.append(String.valueOf(count));
        _nwStr.append(sb.charAt(sb.length()-1));
        sb = new StringBuilder(_nwStr.toString());
        counter++;
        System.out.println(counter + " " + sb.toString() +"-->"+ _nwStr.toString());
     }

     return sb.toString();

    }
}