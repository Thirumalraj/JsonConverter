import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

import java.io.File;
import java.net.URL;
import java.io.IOException;

public class UserTest {
  public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    File jsonFile = new File("user.json");
    String jsonStr = "{"about":"Grootan","created":1173923446,"id":"grootan_123","likes":4229,"submitted":[123.00,1.00]}";
    User user = null;

    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
    
    // IMPORTANT
    // without this option set adding new fields breaks old code
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    user = mapper.readValue(jsonFile, User.class);
    System.out.println(user.getAbout().getCreated(),getId());
  }
}
