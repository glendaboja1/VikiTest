import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VikiVideoResponse {

      public Boolean more;
      public List<Response> response = new ArrayList<Response>();

      // Convert json data to java object
      public static VikiVideoResponse fromJson(String resp) {
                 Gson gson = new  GsonBuilder().setPrettyPrinting().create();
                 VikiVideoResponse vresponse = null;
                 try {
                         vresponse = gson.fromJson(resp, VikiVideoResponse.class);
                 } catch (Exception e) { 
                         System.out.println("Error in json to java conversion: " + e);
                 }
                 return (vresponse);
                         
      }       

      // Define viki response
      // For this exercise, define the Flags class only  
      public class Response {

	private String id;
	private String createdAt;
	private String updatedAt;
	private String type;
	private Integer duration;
	private Integer number;
	private String rootId;
	//private Origin origin;
	//private Titles titles;
	//private TitlesPhonetic titlesPhonetic;
	//private TitlesAka titlesAka;
	//private Descriptions descriptions;
	//private SubtitleCompletions subtitleCompletions;
	//private Container container;
	private String source;
	//private Images images;
	//private Likes likes;
	private Flags flags;
	//private Url url;
	//private Embed embed;
	private String rating;
	//private List<Part> parts = new ArrayList<Part>();
	private Integer vikiAirTime;
	private Integer creditsMarker;
	private Integer partIndex;
	private String author;
	private String authorUrl;
	private Boolean blocked;
	//private Blocking blocking;

        public Flags getFlags() {
            return flags;
        }

      }

      public class Flags {
	private Boolean licensed;
	private Boolean hosted;
	private Boolean onAir;
	private Boolean embeddable;
	private String state;
	private Boolean adult;
	private Boolean hd;
	private Boolean hasStream;

        public Boolean getLicensed() {
            return licensed;
        }

        public Boolean getHosted() {
            return hosted; 
        }

        public Boolean getOnAir() {
            return onAir;
        }

        public Boolean getEmbeddable() {
             return embeddable;
        }

        public String getState() {
             return state;
        }

        public Boolean getAdult() {
             return adult;
        }

        public Boolean getHd() {
             return hd;
        }

        public Boolean getHasStream() {
             return hasStream;
        }
 
      }

} 
