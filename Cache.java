import java.util.LinkedList;

public class Cache<K, V extends KeyInterface<K>> implements CacheInterface<K, V>{

    private final LinkedList<V> cache;
    private Integer cacheMaxSize=0;
    private Integer references =0;
    private Integer hits=0; 

    //Constructor for the cache class
    public Cache(int size) {
    this.cacheMaxSize = size; 
	this.cache = new LinkedList<>();
    }

    //Get function. Used for finding the object using the key.
    //Loops through the cache and if finds it, moves it to the first position
    //in the cache using addFirst(). While in the loop it also increments
    //hits that later used to calculate the hit percentage. References are 
    //incremented every time the get function is called. When the function 
    //found the object it returns it, else it returns null.
    public @Override V get(K key)
    {
        references++; 
    for (int i = 0; i < cache.size(); i++) 
        {
        if (cache.get(i).getKey().equals(key)) 
        {
            V mostRecent = cache.remove(i);
            hits++;
            cache.addFirst(mostRecent);
            return mostRecent; 
        }
        }
        return null; 
    }
    
    //Add function. Checks if the cache is full and if it is,
    //removes LRU object using removeLast() and then adds the object
    //to the first position using addFirst(). If the cache still has space,
    //it adds the object to the first position and returns null. 
    public @Override V add(V value)
    {
        if (cache.size() >= cacheMaxSize)
        {
            V removed = cache.removeLast();
            cache.addFirst(value);
            return removed; 
            
        }
        else 
        {
            cache.addFirst(value);
            return null; 
        }
    }

    //Remove function. Goes throught the cache using the key to find
    //the object associated with it. If it finds it, it removes it and
    // returns it to the calling program. Else it returns null.
    public @Override V remove(K key)
    {
        for(int i = 0; i < cache.size(); i++)
        {
        if (cache.get(i).getKey().equals(key))
        {
            V removed = cache.remove(i);
            return removed; 
        }
        }
    return null; 

    }

    //Clear function. Just clears all entries from the cache
    // using clear(). 
    public @Override void clear()
    {
        cache.clear(); 
    }
 
    //ToString Function. First calculates the hit percentage.
    //Then changes it to 2 decimal places using String.format().
    //Creates a string output that outputs the amount of entries in the cache,
    //total references, total hits and the hit percentage.
    //Returns that output to the calling program and displays
    //in the terminal all the values and text. 
    public @Override String toString()
    {  
        double percentage = ((double)hits/references)*100.0; 
        String perc2Dec = String.format("%.2f", percentage);
        String output = ("""
                         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
                         Cache with  """ + cacheMaxSize + " entries has been created \n" 
                        + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n" 
                        + "Total number of references: " + references + "\n" 
                        + "Total number of cache hits: " + hits + "\n"
                        + "Cache hit percent: " + perc2Dec + "%\n"); 
        return output;      
    }

}