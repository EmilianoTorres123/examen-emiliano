package org.uv.alumnos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlumnosApplicationTests {

	@Test
	void contextLoads() {
             Assertions.assertEquals(2, 1 + 1);
	}
}
