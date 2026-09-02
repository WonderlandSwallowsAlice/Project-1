public class Cache<K, V extends KeyInterface<K>> implements CacheInterface<K, V>{

    private LinkedList<V> cache;
    private Intereger cacheMaxSize;

    public Cache(int size) {
    this.cacheMaxSize = size; 
	this.cache = new LinkedList<V>();
    }

    public V get(K key)
    {
    for (V item : cache) 
        {
        if (item.getKey().equals(key)) 
        {
            return item;
        }
        }
        return null; 
    }

    public V add(V value)
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

    public V remove(K key)
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

    public void clear()
    {
        cache.clear(); 
    }
    public String toString()
    {

    }

}