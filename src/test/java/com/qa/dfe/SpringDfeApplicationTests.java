package com.qa.dfe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest // spring test - loads the context
@ActiveProfiles("test") // sets the profile to Test for this test
class SpringDfeApplicationTests {

	@Test
	void contextLoads() {
	}

}
