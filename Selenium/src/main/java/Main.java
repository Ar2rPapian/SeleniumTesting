
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

import java.util.HashMap;

public class Main {


    public static void main(String[] args) throws Exception {

        // Authorization token
        String authUrl = "http://uatapi-club.teambeachbody.com/authreg-qa6/oauth/authorize";
        String registerUrl = "http://uatapi-club.teambeachbody.com/authreg-qa6/v2/users";

        String authBody = "{\"client_id\":\"mias-dad\",\"response_type\":\"code\",\"client_secret\":\"issocool\"}";

        HashMap<String,String> authHeaders = new HashMap<>();
        authHeaders.put("Accept", "application/hal+json");
        authHeaders.put("Content-Type", "application/json");
        authHeaders.put("Authorization", "BBOD123");
        authHeaders.put("Connection", "keep-alive");

        String access_token = new JSONObject(String.valueOf(Unirest
                .post(authUrl)
                .headers(authHeaders)
                .body(authBody)
                .asJson()
                .getBody())).getString("access_token");

        JsonNode user =  new JsonNode("{" +
                "'dateOfBirth':'" + "02/1/1985" + '\'' +
                ", 'gender':'" + "Male" + '\'' +
                ", 'sourceSystem':'" + "web" + '\'' +
                ", 'billingAddressCity':'" + "Santa Monica" + '\'' +
                ", 'billingAddressCountryCode':'" + "US" + '\'' +
                ", 'billingAddressState':'" + "AZ" + '\'' +
                ", 'billingAddressStreet1':'" + "17775 N 95th St" + '\'' +
                ", 'billingAddressZip':'" + "90404" + '\'' +
                ", 'billingFirstName':'" + "TASDASEST" + '\'' +
                ", 'billingLastName':'" + "TEASDASDST" + '\'' +
                ", 'customerType':'" + "REGISTEREDUSER" + '\'' +
                ", 'customerTypeId':'" + "FREE" + '\'' +
                ", 'emailAddress':'" + "TEST000002@beachbodytest.com" + '\'' +
                ", 'firstName':'" + "TESDASDST" + '\'' +
                ", 'lastName':'" + "ASDASDA" + '\'' +
                ", 'password':'" + "Pa$$word123" + '\'' +
                ", 'paymentInfoCreditCardNumber':'" + "4532874473837471" + '\'' +
                ", 'paymentInfoCvv2':'" + "510" + '\'' +
                ", 'paymentInfoCcType':'" + "VISA" + '\'' +
                ", 'paymentInfoExpDate':'" + "08/21" + '\'' +
                ", 'phone1':'" + "5125126565" + '\'' +
                ", 'sponsorRepID':'" + "" + '\'' +
                ", 'termsAndConditionsAgree':" + "true" +
                '}');


        HashMap<String,String> registerHeaders = new HashMap<>();
        authHeaders.put("Authorization", String.format("Bearer %s", access_token));
        authHeaders.put("Content-Type", "application/json");

        System.out.println(

        Unirest.post(registerUrl)
                .header("Accept","application/json")
                .header("Authorization",String.format("Bearer %s",access_token))
                .header("Content-Type","application/json")
                .body(user)
                .asJson()
                .getBody()

        );
    }

}
