import java.util.HashMap;

public class CacheExperiment
{
    public static void main(String[] args) 
    {
        int cacheSize = Integer.parseInt(args[0]);
        int numWebpages = Integer.parseInt(args[1]);
        double stanDev = Double.parseDouble(args[2]); 
        int debugLev = Integer.parseInt(args[3]);

        long startTime = System.currentTimeMillis();
            WebpageGenerator genPage;
            if (args.length > 4)
            {
                long seed = Long.parseLong(args[4]);
                genPage = new WebpageGenerator(numWebpages, stanDev, seed);
            }
            else
            {
                genPage = new WebpageGenerator(numWebpages, stanDev);
            }
        Cache<String, Webpage> cache = new Cache<>(cacheSize);
        HashMap<String, Integer> dsnMap = new HashMap<>();
       
        for (int i = 0; i < numWebpages; i++)
        { 
            
            String url = genPage.getURL();
            Webpage found = cache.get(url);
            if(dsnMap.containsKey(url))
            {
                dsnMap.put(url, dsnMap.get(url) + 1);
            }
            else
            {
                dsnMap.put(url, 1);
            }
            if(found == null)
            {
            Webpage newWeb = genPage.readPage(url); 
            cache.add(newWeb);  
            }
        }    

        switch (debugLev)
        {
            case 0:
                System.out.println(cache);
                break;
            case 1:
                System.out.println("-----------------------------------------\n");
                System.out.println("Printing the Webpage Distribution:\n");
                System.out.println("-----------------------------------------\n");
                for (HashMap.Entry<String, Integer> entry : dsnMap.entrySet())
                {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
                System.out.println(cache);
                break;
            case 2:
               System.out.println("=========================================\n");
               System.out.println("Generated and serialized Webpages\n");
               System.out.println("=========================================\n");
               genPage.printWebpages(2);
                break;

            case 3:
               System.out.println("=========================================\n");
               System.out.println("URLs and Full Webpages\n");
               System.out.println("=========================================\n");
               genPage.printWebpages(3);
                break;
            default:
                System.out.println("Invalid debug level. Should be 0-3. Try again.");
                break;

                
        }


        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - startTime; 
        System.out.println("Time elapsed: " + timeElapsed + " milliseconds");
    }
} 