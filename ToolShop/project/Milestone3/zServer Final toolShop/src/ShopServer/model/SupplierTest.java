package ShopServer.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SupplierTest {

	@Test
	void testGetSupId() {
		Supplier testSupplier = new Supplier(0,"Test", "Test", "Test");
		assertEquals(0,testSupplier.getSupId());
	}

	@Test
	void testGetSupName() {
		Supplier testSupplier = new Supplier(0,"Test", "Test", "Test");
		assertEquals("Test",testSupplier.getSupName());
	}

	@Test
	void testGetSupAddress() {
		Supplier testSupplier = new Supplier(0,"Test", "Test", "Test");
		assertEquals("Test",testSupplier.getSupAddress());
	}

	@Test
	void testGetSupContactName() {
		Supplier testSupplier = new Supplier(0,"Test", "Test", "Test");
		assertEquals("Test",testSupplier.getSupContactName());
	}
}
