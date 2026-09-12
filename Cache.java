import java.util.LinkedList;

public class Cache<K, V extends KeyInterface<K>> implements CacheInterface<K, V>{

    private final LinkedList<V> cache;
    private Integer cacheMaxSize=0;
    private Integer references =0;
    private Integer hits=0; 

    public Cache(int size) {
    this.cacheMaxSize = size; 
	this.cache = new LinkedList<>();
    }

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

    public @Override void clear()
    {
        cache.clear(); 
    }
 
    public @Override String toString()
    {  
        double percentage = ((double)hits/references)*100.0; 
        String output = ("""
                         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
                         Cache with """ + cacheMaxSize + " entries has been created \n" 
                        + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n" 
                        + "Total number of references: " + references + "\n" 
                        + "Total number of cache hits: " + hits + "\n"
                        + "Cache hit percent: " + percentage + "\n");
        return output;      
    }

}