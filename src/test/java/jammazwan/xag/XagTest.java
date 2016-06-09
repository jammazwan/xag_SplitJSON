package jammazwan.xag;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XagTest extends CamelSpringTestSupport {

    @Override
    protected AbstractXmlApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
    }

    @Test
    public void testXag() throws Exception {
		MockEndpoint mock1 = getMockEndpoint("mock:assert1");
		mock1.expectedMessageCount(25);
		
		MockEndpoint mock2 = getMockEndpoint("mock:assert2");
		mock2.expectedMessageCount(25);
		
		MockEndpoint mock3 = getMockEndpoint("mock:assert3");
		mock3.expectedMessageCount(4);
		
		MockEndpoint mock4 = getMockEndpoint("mock:assert4");
		mock4.expectedMessageCount(6);
		
		mock1.assertIsSatisfied();
		mock2.assertIsSatisfied();
		mock3.assertIsSatisfied();
		mock4.assertIsSatisfied();
    }

}
