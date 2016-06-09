package jammazwan.xag;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.language.JsonPathExpression;

public class XagRoutes extends RouteBuilder {
	// A
	JsonPathExpression jsonPathExpression1 = new JsonPathExpression("$.employees.[*].city");
	JsonPathExpression jsonPathExpression4 = new JsonPathExpression("$.keywords.[*]");

	/*
	 * See NOTES.md two semantics shown, alternating between each of A, B.
	 */

	@Override
	public void configure() throws Exception {
		// A
		from("file://../jammazwan.shared/src/main/resources/data/json/?noop=true&fileName=shop.json")
				.split(jsonPathExpression1).log("${body}").to("mock:assert1");

		// B
		from("file://../jammazwan.shared/src/main/resources/data/json/?noop=true&fileName=employeesArray.json").split()
				.jsonpath("$[*]").to("mock:assert2");

		// A
		from("file://../jammazwan.shared/src/main/resources/data/json/?noop=true&fileName=bank.json").split()
				.jsonpath("$.majorsector_percent.[*]").to("mock:assert3");

		// B
		from("file://../jammazwan.shared/src/main/resources/data/json/?noop=true&fileName=bower.json")
				.split(jsonPathExpression4).to("mock:assert4");
	}
}
