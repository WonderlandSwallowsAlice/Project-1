public class CacheExperiment <cacheSize, numWebpages, stanDev, debugLev>
{
    public static void main(String[] args) 
    {

        WebpageGenerator genPage = new WebpageGenerator(4, 0.10);
        Webpage page = new Webpage(genPage.getURL()); 
        Cache<String, Webpage> cache = new Cache<>(10);
        cache.get(page.getKey());   
    }
}