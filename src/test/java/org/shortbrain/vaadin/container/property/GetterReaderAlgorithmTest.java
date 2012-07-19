package org.shortbrain.vaadin.container.property;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.shortbrain.vaadin.container.AbstractContainerUtilsTest;

/**
 * Test class for {@link AttributeReaderAlgorithm}.
 * 
 * @author Vincent Demeester <vincent@demeester.fr>
 * 
 */
@SuppressWarnings("unused")
@RunWith(BlockJUnit4ClassRunner.class)
public class GetterReaderAlgorithmTest extends AbstractContainerUtilsTest {

	@Test
	public void getPropertiesNull() {
		GetterReaderAlgorithm g = new GetterReaderAlgorithm();
		try {
			g.getProperties(null);
			fail("should throw a IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void getProperties() {
		GetterReaderAlgorithm g = new GetterReaderAlgorithm();
		List<PropertyMetadata> metadatas = g.getProperties(TestBean.class);
		assertNotNull(metadatas);
		assertEquals(2, metadatas.size());
		assertMetadata("Integer", Integer.class, null, "Integer",
				metadatas.get(0));
		assertMetadata("String", String.class, null, "String", metadatas.get(1));
	}

	private static class SuperTestBean {
		private Date date;

	}

	private static class TestBean extends SuperTestBean {

		private String string;
		private Integer integer;

		public String getString() {
			return string;
		}

		public Integer getInteger() {
			return integer;
		}

	}
}