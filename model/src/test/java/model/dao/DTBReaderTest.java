package model.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

//import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DTBReaderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReturnMap() {
		String expected = "CHHHHHHHHHHHHHHHHHHCV                VLVV  P             V VV                V VV                V VV                  VV                  VV                  VVHHHH              VVT  H        HHHHHHVVG    V           1VCHHHHHHHHHHHHHHHHHHC";
		String map = null;
		try {
			map = DTBReader.ReturnMap(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(expected, map);
	}

}
