package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.PropertyFileOperation;
import java.io.File;
import static io.restassured.RestAssured.given;

public class APICalls {


    PropertyFileOperation propertyFileOperation = new PropertyFileOperation(System.getProperty("user.dir") + File.separator+"config.properties");

    private RequestSpecification specification(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(propertyFileOperation.getPropertyValue("API_BASE_URI"));
        return requestSpecBuilder.build();
    }


    public String getAllCategories(){
        Response response =given().spec(specification()).
                            when().get(propertyFileOperation.getPropertyValue("CATEGORY_ENDPOINT"));
        response.then().assertThat().statusCode(200);
        return response.body().asString();
    }

    public JsonPath getProductDetails(String productNumber){
        String productEndPoint = "/products/"+productNumber;
        Response response =given().spec(specification()).
                when().get(productEndPoint);
        response.then().assertThat().statusCode(200);
        return response.jsonPath();
    }

}
