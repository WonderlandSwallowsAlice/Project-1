public class CacheExperiment
{
    public static void main(String[] args) 
    {
        //Variable to store the cache size, number of webpages, standard deviation and debug level arguments.
        int cacheSize = Integer.parseInt(args[0]);
        int numWebpages = Integer.parseInt(args[1]);
        double stanDev = Double.parseDouble(args[2]); 
        int debugLev = Integer.parseInt(args[3]);

        //Stores the start time to calculate the elapsed time later. 
        long startTime = System.currentTimeMillis();

        WebpageGenerator genPage;

        //Check for the amount of arguments passed in.
        //If there is also a seed argument, it is added to the
        //WebpageGenerator constructor. If there's no seed,
        //it just uses numWebpages and stanDev for the constructor. 
        if (args.length > 4)
        {
            long seed = Long.parseLong(args[4]);
            genPage = new WebpageGenerator(numWebpages, stanDev, seed);
        }
        else
        {
            genPage = new WebpageGenerator(numWebpages, stanDev);
        }

        //Creates new cache object with the specified cache size.
        Cache<String, Webpage> cache = new Cache<>(cacheSize);

        for (int i = 0; i < numWebpages; i++)
        {
            String url = genPage.getURL();
            Webpage page = cache.get(url);

            if (page == null)
            {
                cache.add(genPage.readPage(url));
            }
        }

        //Chooses one of 4 options based on the degug level argument passed in.
        switch (debugLev)
        {
            //Case 0: prints the stats.
            case 0:
                System.out.println(cache);
                break;
            //Case 1: prints the webpage distribution using
            //getWebpageDatabasePings() provided by the WebpageGenerator class.
            //It is followed by the stats.
            case 1:
                System.out.println("-----------------------------------------\n");
                System.out.println("Printing the Webpage Distribution:\n");
                System.out.println("-----------------------------------------\n");
                genPage.getWebpageDatabasePings();
                System.out.println(cache);
                break;
            //Case 2: print the url and the summarized content of each
            //webpage using printWebpages() with the debug level 2 argument
            //provided by the WebpageGenerator class. Followed by the stats. 
            case 2:
               System.out.println("=========================================\n");
               System.out.println("Generated and serialized Webpages\n");
               System.out.println("=========================================\n");
               genPage.printWebpages(2);
               System.out.println(cache);
                break;
            //Case 3: similar to case 2, but prints the full content of the webpages
            //using printWebpages() with the debug level 3 argument provided by the 
            //WebpageGenerator class. 
            case 3:
               System.out.println("=========================================\n");
               System.out.println("URLs and Full Webpages\n");
               System.out.println("=========================================\n");
               genPage.printWebpages(3);
               System.out.println(cache);
                break;
            //Default case: if user enters invalid debug level. 
            default:
                System.out.println("Invalid debug level. Should be 0-3. Try again.");
                break;

                
        }
        //Stores current time at the end of the operations being completed.
        long currentTime = System.currentTimeMillis();
        //Calculates times elapsed and prints it to the terminal. 
        long timeElapsed = currentTime - startTime; 
        System.out.println("Time elapsed: " + timeElapsed + " milliseconds");
    }
} 