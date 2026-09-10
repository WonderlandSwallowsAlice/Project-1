public class CacheExperiment
{
    public static void main(String[] args) 
    {
        int cacheSize = Integer.parseInt(args[0]);
        int numWebpages = Integer.parseInt(args[1]);
        double stanDev = Double.parseDouble(args[2]); 
        int debugLev = Integer.parseInt(args[3]);

        WebpageGenerator genPage = new WebpageGenerator(30, 0.30);
        Cache<String, Webpage> cache = new Cache<>(40);
        for (int i = 0; i < numWebpages; i++)
        {
            String url = genPage.getURL();
            Webpage found = cache.get(url);
            if(found == null)
            {
            Webpage page = new Webpage(url); 
            cache.add(page); 
            }
        }    
        System.out.println(cache);
    }
}