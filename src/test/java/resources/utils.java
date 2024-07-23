package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils {
	
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecifications() throws IOException {
		
		if(req==null) {
		PrintStream log= new PrintStream(new FileOutputStream("logging.txt"));

		
		 req= new RequestSpecBuilder().setBaseUri(getGlobalUrl("baseUrl"))
				.addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;
	}

	
	public static String getGlobalUrl(String key) throws IOException {
		Properties prop = new Properties();
	//	FileInputStream fi= new FileInputStream("user.dir")+"//src//test//java//resources//global.properties";
	FileInputStream fi = new FileInputStream("H:\\EclipseNewWorkspace\\RestAPIFramworkBDD\\src\\test\\java\\resources\\global.properties");
	prop.load(fi);
return	prop.getProperty(key);

	
	}
	
	public String getJsonPath(Response response, String Key) {
		String resString=response.asString();
		JsonPath js= new JsonPath(resString);
		return js.get(Key).toString();
	}
}
