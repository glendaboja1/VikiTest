import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.DataOutputStream;  
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/**
 * Get VIKI video data
 *
 * References:
 * http://docs.oracle.com/javase/tutorial/networking/urls/connecting.html
 * http://www.jsonschema2pojo.org/ (SourceType: JSON, AnnotationStyle:None)
 * http://www.studytrails.com/java/json/java-google-json-parse-json-to-java.jsp
 * 
 * @author gboja
 *
 */
public class vikivideos {
        
        public static void main( String[] args ) throws Exception {
	  
                int i = 1;        
		int Hdfalse = 0;
                int Hdtrue = 0;
                Boolean getnextpage=true;
                try {

                    while (getnextpage) { 
		        String vikiurl = "http://api.viki.io/v4/videos.json?app=100250a&per_page=10&page=" + i;

                        URL url = new URL(vikiurl);
                        System.out.println("Fetching URL: " + vikiurl );
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                
                        // Get Response
	                InputStream is = null;
                        is = conn.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);

                        int numChRead;
                        char[] charArray = new char[1024];
                        StringBuffer sb = new StringBuffer();
                        while ( (numChRead = isr.read(charArray)) > 0 ) {
                                sb.append(charArray, 0, numChRead);
                        }
                        String result = sb.toString();

                        //System.out.println("Response ---------");
                        //System.out.println("Result: " + result);

                        //get all headers
                        //Map<String, List<String>> map = conn.getHeaderFields();
                        //for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                        //        System.out.println("Key : " + entry.getKey() + " ,Value : " + entry.getValue()); 
                        //}
                        //System.out.println("-----------------");

                        // Convert response to java object
			VikiVideoResponse res = VikiVideoResponse.fromJson(result);

			// If there are no more pages to get, set nextpage to false 
                        if ( res.more == false ) {
		           getnextpage = false;
                        } else {
                           i++;
                        }

                        for ( VikiVideoResponse.Response vr : res.response ) {
                            if ( vr.getFlags().getHd() == true ) {
			       Hdtrue++;
			    } else {
			       Hdfalse++;
                            }
                            
                        }

                   }
                   System.out.println("Total number of Objects where HD is true: " + Hdtrue );
                   System.out.println("Total number of Objects where HD is false:" + Hdfalse );

                } catch ( Exception e ) {
                        System.out.println("Exception: " + e.getMessage() );
                        e.printStackTrace();
                }
        }


}

