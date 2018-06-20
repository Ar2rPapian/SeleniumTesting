
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

import java.util.HashMap;

public class Main {


    public static void main(String[] args)  {

    }
}


class HttpRequest extends Unirest{
    
    public static RequestBodyEntity sendPost(String url, HashMap<String,String> headers, String jBody) throws UnirestException {
        return post(url).headers(headers).body(jBody);
    }
}


