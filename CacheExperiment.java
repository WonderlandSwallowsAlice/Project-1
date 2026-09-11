public class CacheExperiment
{
    public static void main(String[] args) 
    {
        int cacheSize = Integer.parseInt(args[0]);
        int numWebpages = Integer.parseInt(args[1]);
        double stanDev = Double.parseDouble(args[2]); 
        int debugLev = Integer.parseInt(args[3]);

        long startTime = System.currentTimeMillis();
        WebpageGenerator genPage = new WebpageGenerator(numWebpages, stanDev);
        Cache<String, Webpage> cache = new Cache<>(cacheSize);
       
        for (int i = 0; i < numWebpages; i++)
        {
            
            String url = genPage.getURL();
            
            Webpage found = cache.get(url);
            if(found == null)
            {
            Webpage newWeb = genPage.readPage(url); 
            cache.add(newWeb);  
            }
        }    
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - startTime; 
        System.out.println("Time elapsed: " + timeElapsed);
        System.out.println(cache);
    }
}