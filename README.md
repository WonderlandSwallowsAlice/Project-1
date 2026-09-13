CS 321 Data Structures Project #1

This project is an implementation of a cache using Java linked list class. Class Cache contains the functions get(), add(), remove(), clear() and toString() that are used for searching, adding and removing objects and printing out the stats (Deeper description of each function and how it works can be found in the Cache.java and CacheInterface. java files). Class CacheExperiment uses get method to add every page to the cache. If the page was not found it generates it and then adds it to the cache. To check if the program works properly use 1 of 4 levels of debug described below. 
 

There are 2 ways to run this program:
1. To run the test type in ./run-tests.sh command in the terminal. You will get the following output:
   <img width="660" height="687" alt="image" src="https://github.com/user-attachments/assets/ec2335d9-aa94-4277-9088-a468daac4bc3" />

2. To manually run the test use java size of cache, number of webpages, standard deviation, debug level and seed (optional, the program will check for this argument).

Levels of debug: 
There are 4 total levels of debugging that provide different outputs:

Level 0 or case 0: Stats

<img width="507" height="181" alt="image" src="https://github.com/user-attachments/assets/9654137d-1f32-442c-bbbc-4451c2f2c399" />

Level 1 or case 1: Webpage Distribution and Stats

<img width="527" height="650" alt="image" src="https://github.com/user-attachments/assets/ea195a7f-3a08-4f33-af3c-8aa2b2e9e433" />

Level 2 or case 2: Webpages URLS and Webpage Summary

<img width="1005" height="627" alt="image" src="https://github.com/user-attachments/assets/68559dad-160e-4359-a4d1-239dfd040c8e" />

Level 3 or case 3: Webpages URLS and Full Webpage Content

<img width="1006" height="620" alt="image" src="https://github.com/user-attachments/assets/d168910b-ab5f-4fd6-b6e6-9be36b427b47" />


AI usage: 

For this project I had to use copilot to make the junit jupiter work (I usually have it turned off but this was my last hope). I followed the instructions provided by the professor on how to get the junit jupiter working for VS code, tried troubleshooting techniques provided in the document, tried different versions of junit jupiter as well as reinstalling all the Java extensions and restarting both VS code and my computer. I was not able to make it work until I got my other laptop, installed VS code there and asked copilot to run the commands to make the junit jupiter work and it finally did. I think I spent about 5 hours of just trying fight this issue. It still says that the import org.junit cannot be resolved but at least I was able to make the program compile. Before it was giving me the error that such package does not exist that was not going away. I assume it could be some folder hierarchy issue but adjusting it at least the way I did it, did not help. 

I also used it to explain me some parts of the existing code, mostly syntax that I could not understand myself and since this is my first program that I wrote in Java (I only used C and C++ before) I asked it to give me different examples of some of the syntax that I knew how to write in C++ that I was not able to find examples of in the resources cited below, provided by the instructor or in some of files already provided with this project. 

Other resources used in this project:

https://www.w3schools.com/java
https://www.geeksforgeeks.org/java
https://math.hws.edu/javanotes/c5/s1.html#OOP.1.1
https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/System.html#currentTimeMillis%28%29
https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/LinkedList.html
https://programmedlessons.org/Java9/index.html#part01


