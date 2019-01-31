package utils;
        
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpClient {
  String uri=null;
  
  public HttpClient(String uri) {
    this.uri = uri;
  }
  
  public String makeHttpRequest(String params) throws MalformedURLException,IOException {
    URL url = new URL(uri+params);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    con.setRequestProperty("Accept", "text/plain;charset=UTF-8");
    String result;
    try (Scanner scan = new Scanner(con.getInputStream())) {
      result = null;
      if (scan.hasNext()) {
        result = scan.nextLine();
      }
    }
    return result;
  }
  
// MAIN METODE BLEV BRUGT SOM EN LILLE "TEST".  
  
//  public static void main(String[] args) throws IOException {
//    HttpClient client = new HttpClient("http://localhost:8084/simpleCalculator/calculator");
//    String res = client.makeHttpRequest("?operation=add&n1=2&n2=3");
//    System.out.println(res);
//  }
}