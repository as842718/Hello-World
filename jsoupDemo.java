package com.demo.tes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.xpath.XPathExpressionException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class jsoupDemo {
	
	public static void main(String args[]) throws IOException, XPathExpressionException {
		
		Scanner URL = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter URL");
	    String url = URL.nextLine();
	    
	    Scanner tag = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter element");
	    String ele = tag.nextLine();
	    	    
	//	String url = "https://yahoo.com";
	  
	    //String url =URL;
	    Document document = Jsoup.connect(url).get();
	     
	      //Element body = document.body();
	      String locator;
	      ArrayList<String> known_attribute_list = new ArrayList<String>();
	      
	      ArrayList<String> guessable_element = new ArrayList<String>();
	 
	      guessable_element.add(ele);
	     /* guessable_element.add("button");
	      guessable_element.add("button");*/
	     
	      known_attribute_list.add("id");
	      known_attribute_list.add("name");
	      known_attribute_list.add("placeholder");
	      known_attribute_list.add("value");
	      known_attribute_list.add("title");
	      known_attribute_list.add("type");
	      known_attribute_list.add("class");
	      
	    // String known_attribute_list[]  =  {"id","name","placeholder","value","title","type","class"};
	      
	 //     Elements paragraphs = body.getElementsByTag("input");
	         
	      for(String element : guessable_element) {
	    	  
	    	  Elements paragraphs=  document.body().select(element);
	      
	      for (Element paragraph : paragraphs) {
	    	//  known_attribute_list
	    	  
	    	//  System.out.println(paragraph.attr("type"));
	    	  
	    	  if(!(paragraph.attr("type").equals("hidden")) ) {
	    		  
	    		  
	    		  for(String attr :known_attribute_list) {
	    		//	System.out.println(paragraph.attr(attr).equals(""));
	    			  if(paragraph.hasAttr(attr) && (!paragraph.attr(attr).equals(""))) {
	    				  
	    				  locator=gussXPATH(element, attr,paragraph) ;
  
	    				/*  
	    				  if(//check for single value)
	    				  break;
	    			  
	    			  */
	    			  
	    			  
	    			  
	    			  }
	    			  
	    			  
//	    			  System.out.println(paragraph.text());
//	    			  else(paragraph.text())
//	    			  
	    			  
	    			  
	    		  }
	    		  
	    		  
	    		  
	    	  }
	    	  
	    	  
	    	  
	    	  
	    	/*  
	    	  if(paragraph.attr("name")!="")
	    	  {
	    	  
	    	  String xpath_expression= "//"+paragraph.nodeName()+"[@name="+"\""+paragraph.attr("name")+"\"]";
	    		System.out.println(xpath_expression);
	    	  }
	    	  
	    	  if(paragraph.attr("id")!="") {
	    		  
	    		  String xpath_expression= "//"+paragraph.nodeName()+"[@id="+"\""+paragraph.attr("id")+"\"]";    		  
	    			System.out.println(xpath_expression);
	    	  } if(paragraph.attr("class")!="") {
	    		  
	    		  String xpath_expression= "//"+paragraph.nodeName()+"[@class="+"\""+paragraph.attr("class")+"\"]";    	
	    			System.out.println(xpath_expression);	  
	    	  }
	    	 	//System.out.println(xpath_expression);
	    
	    	  */
	    	  
	    /*  System.out.println(paragraph.attr("name"));
	      System.out.println("Childe node"+paragraph.className());
	      System.out.println("node name "+paragraph.nodeName());
	      System.out.println("attribute"+paragraph.attributes());*/
	    
	  /*  XPath xPath =  XPathFactory.newInstance().newXPath();
	    
	    NodeList nodeList = (NodeList) xPath.compile(xpath).evaluate(
	    		document, XPathConstants.NODESET);*/
	    
	    	//System.out.println(paragraph.getAllElements());
	    	
	    	//System.out.println(nodeList.item(0));
	      
	      }
		//input[@id='t']
		
	}
	
	
	}
	
	public static String gussXPATH( String element, String attr, Element  paragraph) {
		
		//String xpath_expression= "//"+paragraph.nodeName()+"[@class="+"\""+paragraph.attr("class")+"\"]";     
		String xpath_expression= "//"+element+"[@"+attr+"="+"\""+paragraph.attr(attr)+"\"]";

		 System.out.println(xpath_expression);
		  
		
		return xpath_expression;
	}
	

}
