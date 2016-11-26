import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientGet {

    public static void main(String[] args) {
        try {

            Client client = Client.create();

            String URL = "http://localhost:8080/rest/calc/";
            String ACTION = "sub";
            String NUMBER_1 = "number1=";
            String NUMBER_2 = "number2=";

            Integer number1 = 2;
            Integer number2 = 3;

            String request = URL + ACTION + ";"
                    + NUMBER_1 + number1 + ";"
                    + NUMBER_2 + number2;

            System.out.println(request);

            WebResource webResource = client
                    .resource(request);

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
