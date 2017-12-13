package DynamicDijsktars;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mansi
 */
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;


public class Utility
{
//  public static void main(String[] args) throws Exception
//  {
//    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    System.out.println("Please enter a location:");
//    String postcode=reader.readLine();
// String latLongs[] = getLatLongPositions(postcode);
//    System.out.println("Latitude: "+latLongs[0]+" and Longitude: "+latLongs[1]);
//  }
    
   //  private static Map<Integer,String> zipcode = new HashMap();
  public static void addZipcode(Map zipcode){
    zipcode.put(0, "02123");
    zipcode.put(1, "01223");
    zipcode.put(2, "04116");
    zipcode.put(3, "05345");
    zipcode.put(4, "02190");
   
    
    
  }
  
  
   
   
  public static Double[] getLatLongPositions(String address) throws Exception
  {
    int responseCode = 0;
    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + 
            URLEncoder.encode(address, "UTF-8") + "&sensor=true";
    URL url = new URL(api);
    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
    httpConnection.connect();
    responseCode = httpConnection.getResponseCode();
    if(responseCode == 200)
    {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document document = builder.parse(httpConnection.getInputStream());
      XPathFactory xPathfactory = XPathFactory.newInstance();
      XPath xpath = xPathfactory.newXPath();
      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
      String status = (String)expr.evaluate(document, XPathConstants.STRING);
      if(status.equals("OK"))
      {
         expr = xpath.compile("//geometry/location/lat");
         Double latitude = Double.parseDouble((String) expr.evaluate(document, XPathConstants.STRING));
         expr = xpath.compile("//geometry/location/lng");
         Double longitude = Double.parseDouble((String) expr.evaluate(document, XPathConstants.STRING));
         
         return new Double[] {latitude, longitude};
      }
      else
      {
         throw new Exception("Error from the API - response status: "+status);
      }
    }
    return null;
  }
  
  //---------------------Distance calculator---------------
  
  public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}

		return (dist);
	}
        
        private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
        
        private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
