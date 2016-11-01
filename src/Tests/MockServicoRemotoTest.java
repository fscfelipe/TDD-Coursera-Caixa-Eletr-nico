package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Classes.MockServicoRemoto;

public class MockServicoRemotoTest {

	MockServicoRemoto mock;

	@Before
	public void setUp() throws Exception {
		mock = new MockServicoRemoto();
	}

	@Test
	public void testRecuperarConta() {
		
	}

}
