package com.arie.utility;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

import com.arie.objects.Catalog;
import com.arie.objects.Product;

/**
 * WebCrawler class which can scrape results from the Sears.com search engine, 
 * in the future other search engines can be added easily to this class.
 * 
 * This crawler is able to scrape the results of products from the two ways of searching that Sears.com has:
 * The first way is the regular search when a search is redirected to a specific department, this search 
 * is activated by a very specific query, for example: "digital camera"
 * The second way in which Sears.com can search is for more generic queries that are not assigned to a specific department
 * immediately, for example: "books"
 * 
 * In both cases, a specific page of the search results can be requested
 * 
 * @author  Arie Radilla Laureano
 */
public class WebCrawler {
	
	public static String query(String query, String store){		
		return getCount(query, store);
	}
	
	public static Catalog query(String query, String store, Integer pageNumber){
		Catalog catalog;
		switch(store){
			default: 
				catalog = querySears(query, pageNumber);
				break;
		}
		
		return catalog;
	}
	
	private static String getCount(String query, String store){
		Document document = getDocument(query, "Sears", null);
		return SearsParser.getTotalResults(document);
	}
	
	private static Catalog querySears(String query, Integer pageNumber){
		Catalog catalog = null;
		Document doc = getDocument(query, "Sears", pageNumber);
		catalog = SearsParser.extractResults(doc);
		return catalog;
	}
	
	private static Document getDocument(String query, String store, Integer pageNumber){
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("keyword", query);
		if(pageNumber != null) {
			parameters.put("pageNum", pageNumber.toString());
		}
		
		Document doc = getUrl(SearsParser.getSearchURL(), parameters);
		if(doc != null) {
			String queryURL = SearsParser.getQueryURL(doc);
			
			if(queryURL != null){
				if(pageNumber != null) {
					HashMap<String, String> pageNumParam = new HashMap<String, String>();
					pageNumParam.put("pageNum", pageNumber.toString());
					String newParam = "";
					try {
						newParam = encodeParams(pageNumParam);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					queryURL = queryURL + "&" + newParam;
				}
				doc = getUrl(queryURL);
			}
		}
		
		return doc;
	}

	private static Document getUrl(String url){
		return getUrl(url, null);
	}
	
	private static Document getUrl(String url, HashMap<String, String> params){
		Document response = null;
		
		try { 
			StringBuffer requestUrl = new StringBuffer();
			requestUrl.append(url);
			if(params != null) {
				requestUrl.append("?");
				requestUrl.append(encodeParams(params));
			}
			
			//Increased timeout to 10 secs, as responses are fairly big
			response = Jsoup.connect(new String(requestUrl)).timeout(10*1000).get();		
		} catch (SocketTimeoutException e) {
			System.out.println("HTTP Request Timeout, please try again");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error on HTTP Request");
			e.printStackTrace();
		}
		
		return response;
	}

	private static String encodeParams(HashMap<String, String> parameters) throws UnsupportedEncodingException{
		StringBuffer buffer = new StringBuffer();
		
		for(Entry<String, String> entry: parameters.entrySet()){
			if(entry.getKey() != null && entry.getValue() != null) {
				buffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
				buffer.append("=");
				buffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
				buffer.append("&");
			}
		}
		
		buffer.deleteCharAt(buffer.length() - 1);	
		
		return new String(buffer);	
	}
	
	public static void main(String[] args){
		Catalog catalog;
		
		if(args.length == 1){
			String query = args[0];
			String results = WebCrawler.query(query, "Sears");
			System.out.println("Number of results: " + results);
		} else if(args.length > 0) {
			try {
		        String query = args[0];
		        Integer resultSize = Integer.parseInt(args[1]);
		        catalog = WebCrawler.query(query, "Sears", resultSize);
				if(catalog != null){
					System.out.println(catalog.size());
					for(Product p : catalog){
						System.out.println("Product: ----------------------------");
						System.out.println("Name: " + p.getName());
						System.out.println("Price: " + p.getPrice());
						System.out.println("Vendor: " + p.getVendor());
					}
				}
		    } catch (NumberFormatException e){
		    	System.out.println("Invalid parameters, please check input parameters.");
		    }
		}
	}
	
}
