/**
 * TODO - complete the summary javadoc for the class here.
 * @author CS321 Instructors
 */

public interface CacheInterface<K, V extends KeyInterface<K>> {

    /**
     * When the application needs the object this function searches and reads it.
     * @param key - used for finding associated with it object in the cache
     * @return - the object associated with the key if in the cache or null if the object is not present 
     */
    public V get(K key);

    /**
     * Adds an object to the first position of the cache. In case the cache is full, it removes the LRU object first before adding a new one. 
     * @param value - the object that gets added to the first position of the cache
     * @return - the removed least recently used object or null if the cache was not full
     */
    public V add(V value);

    /**
     * Searches the cache and removes the matched object. The removed object is returned to the calling program.
     * @param key - used for removing the object matched with that key
     * @return - removed object or null if such object was not found in the cache
     */
    public V remove(K key);

    /**
     * Clears all entries from the cache. 
     */
    public void clear();

    /**
     * Returns cache as string with the number of references, hits and the hit percentage. 
     * {@inheritDoc} Cache.java
     */
    public String toString();
    
}
