public class TimeMap {
    LinkedHashMap<Integer,LinkedHashMap<String,String>> _map ;
    List<Integer> myList ;
    HashMap<String , Integer> _mapOfKey;
    public TimeMap() {
        _map=new LinkedHashMap<>();
        myList=new ArrayList<>();
        _mapOfKey= new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        _map.computeIfAbsent(timestamp, k -> new LinkedHashMap<>()).put(key, value);
        myList.addLast(timestamp);
        if(_mapOfKey.containsKey(key))
        {
            int prevTime=_mapOfKey.get(key);
            if(prevTime>=timestamp)
            {
                return;
            }
            else{
                _mapOfKey.remove(key);
            }

        }
        _mapOfKey.put(key,timestamp);

    }
    private int binarySearchForTimeStamp(int low , int high , int target)
    {
        if(target<this.myList.get(low))
        {
            return -1;
        }
        int mid=low +(high-low)/2;
        while(low<high)
        {
            mid = low +(high-low)/2;
            if(this.myList.get(mid)==target)
            {
                return mid;
            }
            else if(this.myList.get(mid)< target)
            {
                    low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return this.myList.get(high)<=target? high : mid ;
    }

    public String get(String key, int timestamp) {
        if(_map.containsKey(timestamp))
        {
            return _map.get(timestamp).get(key)!=null?_map.get(timestamp).get(key):"";
        }
        if(!_mapOfKey.containsKey(key))
        {
            return "";
        }
        int high = binarySearchForTimeStamp(0,this.myList.size()-1, _mapOfKey.get(key));
      int timePrevIndex = binarySearchForTimeStamp(0,high,timestamp);
      if(timePrevIndex==-1)
      {
        return "";
      }
      int timePrev=this.myList.get(timePrevIndex);
      if(timePrev!=-1 && _map.containsKey(timePrev))
      {
          return _map.get(timePrev).containsKey(key)? _map.get(timePrev).get(key): "";
      }


        return "";

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */