package ShopServer.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	void testDecreaseItemQuantity() {
		Item testItem = new Item(0, "Test", 0, 0, new Supplier(0,"Test", "Test", "Test"));
		assertEquals(false, testItem.decreaseItemQuantity());
	}

	@Test
	void testGetItemId() {
		Item testItem = new Item(0, "Test", 0, 0, new Supplier(0,"Test", "Test", "Test"));
		assertEquals(0, testItem.getItemId());
	}

	@Test
	void testGetItemName() {
		Item testItem = new Item(0, "Test", 0, 0, new Supplier(0,"Test", "Test", "Test"));
		assertEquals("Test", testItem.getItemName());
	}

	@Test
	void testGetItemQuantity() {
		Item testItem = new Item(0, "Test", 0, 0, new Supplier(0,"Test", "Test", "Test"));
		assertEquals(0, testItem.getItemQuantity());
	}

	@Test
	void testGetItemPrice() {
		Item testItem = new Item(0, "Test", 0, 0, new Supplier(0,"Test", "Test", "Test"));
		assertEquals(0, testItem.getItemPrice());
	}
}
