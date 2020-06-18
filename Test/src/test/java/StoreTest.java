
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class StoreTest {

	@Test
	void insertSupplierTest() {
		List<String> supplierList = new ArrayList<String>();
		
		supplierList.add("Freshco");
		supplierList.add("BigBasket");
		supplierList.add("DMart");
		supplierList.add("BigBazar");
		supplierList.add("Village");
		
		for(String supplier : supplierList) 
		{
			InsertSupplier(supplier);
		}

	}
	
	void InsertSupplier(String supplierName) {
		JSONObject request = new JSONObject();
		request.put("supplierName", supplierName);

		given().body(request.toJSONString())
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.post("http://localhost:8088/saveSupplier")
		.then()
		.statusCode(200)
		.body("supplierName", equalTo(supplierName));
		
	}
	
	@Test
	void insertCatlogTest() {
		try
		{
			JSONParser parser = new JSONParser();
			JSONObject objJsonCat = (JSONObject)parser.parse(new FileReader("D:/spring-dev/Test/catalog.json"));
			JSONArray catArray = (JSONArray) objJsonCat.get("catalog");
			Iterator iterator = catArray.iterator();
			while(iterator.hasNext()) {
				InsertCatalog((JSONObject) iterator.next());
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	void InsertCatalog(JSONObject catalogItem) {
		System.out.println(catalogItem.toJSONString());
		String skuCode = given().body(catalogItem.toJSONString())
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.post("http://localhost:8088/saveCatalog")
		.then()
		.statusCode(200)
		.extract().response().asString();
		
		System.out.println("Inserted skuCode: " + skuCode);
	}


	@Test
	void searchTest() {
		int i = 0;
		int searchIdx;
		int supplierIdx;
		Random rand = new Random();
		List<String> searchTerms = new ArrayList<String>();
		List<Integer> supplierList = new ArrayList<Integer>();
		supplierList.add(4);
		supplierList.add(5);
		supplierList.add(6);
		supplierList.add(7);
		supplierList.add(8);
		searchTerms.add("EGG");
		searchTerms.add("Multinational");
		searchTerms.add("Toned");
		searchTerms.add("Slim");
		searchTerms.add("BB");
		searchTerms.add("DMART");

		while(i < 20) {
			supplierIdx = rand.nextInt(supplierList.size()-1);
			searchIdx = rand.nextInt(searchTerms.size()-1);	
			searchCatalog(supplierList.get(supplierIdx), searchTerms.get(searchIdx));
			
			i++;
		}
		
		
		
	}
	
	void searchCatalog(Integer sid, String searchTerm) {
		JSONObject request = new JSONObject();
		request.put("supplierId", sid);
		request.put("searchTerm", searchTerm);
		
		String res = given().body(request.toJSONString())
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.post("http://localhost:8088/search")
		.then()
		.statusCode(200)
		.extract().response().asString();
		
		System.out.println(res);
		
	}

}
