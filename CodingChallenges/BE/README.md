This is my solution for the ** coding challenge, the program consists of a web crawler 
that can extract results from Sears.com's search engine.
 
This crawler is able to scrape the results of products from the two ways of searching that Sears.com has:
The first way is the regular search when a search is redirected to a specific department, this search 
 is activated by a very specific query, for example: "digital camera"
The second way in which Sears.com can search is for more generic queries that are not assigned to a specific department
 immediately, for example: "books"
 
 The only exposed method to other developers are the query methods in the WebCrawler class, depending on the number
 of methods with which the method is called then we will obtain an appropiate response.
 
 For example: 
 When we ask for results and we supply a query but no number of page, we will obtain a response which 
 only prints the number of total results
 
 If we ask a query and a particular page in the results then we will obtain a catalog, we can iterate over this catalog 
 and then print all the products found.
 
 I have used Jsoup a library to work with html documents which can perform HTTP requests, it was really useful as 
 the interaction with the html document is done via css selectors so it leads to interacting with the document very much in a way
 like javascript does it.
 
 The code is commented, and I added documentation where I felt that it was appropiate.
 The Web Crawler lacks commenting due to time constraints from my part due to school work.
 
The entry class in this jar is the WebCrawler.java class

Personal Notes:
Refactor the classes and improve methods, wasted time was an issue when doing this challenge