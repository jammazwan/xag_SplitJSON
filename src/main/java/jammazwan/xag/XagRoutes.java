package jammazwan.xag;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.language.JsonPathExpression;


public class XagRoutes extends RouteBuilder {
	JsonPathExpression jsonPathExpression1 = new JsonPathExpression("$.employees.[*].city");
	JsonPathExpression jsonPathExpression2 = new JsonPathExpression("$[*]");
	JsonPathExpression jsonPathExpression3 = new JsonPathExpression("$.majorsector_percent.[*]");
	JsonPathExpression jsonPathExpression4 = new JsonPathExpression("$.keywords.[*]");

    
    

    @Override
    public void configure() throws Exception {
		from("file://../jammazwan.shared/src/main/resources/data/json/?noop=true&fileName=shop.json")
		.split(jsonPathExpression1).log("${body}").to("mock:assert1");

		from("file://../jammazwan.shared/src/main/resources/data/json/?noop=true&fileName=employeesArray.json")
				.split(jsonPathExpression2).to("mock:assert2");
		
		from("file://../jammazwan.shared/src/main/resources/data/json/?noop=true&fileName=bank.json")
		.split(jsonPathExpression3).to("mock:assert3");
		
		from("file://../jammazwan.shared/src/main/resources/data/json/?noop=true&fileName=bower.json")
		.split(jsonPathExpression4).to("mock:assert4");}
}
