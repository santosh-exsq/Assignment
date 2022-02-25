package testcases.API;

import api.APICalls;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.PropertyFileOperation;

import java.io.File;

public class APITesting {

    PropertyFileOperation propertyReader = new PropertyFileOperation(System.getProperty("user.dir") + File.separator+"config.properties");
    APICalls apiCalls =  new APICalls();


    @Test(description = "Get single product api by passing the product number")
    public void validateGetSingleProductApi(){
        JsonPath jsonPath = apiCalls.getProductDetails("2");
        Assert.assertEquals(jsonPath.get(" title"),propertyReader.getPropertyValue("TITLE"));
        Assert.assertEquals(jsonPath.get(" price"),Float.valueOf(propertyReader.getPropertyValue("PRICE")));
        Assert.assertEquals(jsonPath.get(" description"),propertyReader.getPropertyValue("DESCRIPTION"));
        Assert.assertEquals(jsonPath.get(" category"),propertyReader.getPropertyValue("CATEGORY"));
    }

    @Test(description = "Get all categories and validate with expected result")
    public void validateGetAllCategoriesApi(){
        Assert.assertEquals(apiCalls.getAllCategories(),propertyReader.getPropertyValue("CATEGORY_RESULT"));
    }


}
