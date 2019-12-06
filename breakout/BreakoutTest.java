import static org.junit.Assert.*;

import org.junit.Test;

public class BreakoutTest {

	@Test
	public void test_Environment_constructor() {
		Environment en = new Environment();
		assertEquals("created default environment", 14, en.height());
		assertEquals("created default environment", 39, en.length());
	}
	
	@Test
	public void test_Environment_constructorWithParameter() {
		Environment en = new Environment(20,40);
		assertEquals("created custom environment", 20, en.height());
		assertEquals("created custom environment", 40, en.length());
	}
	
	@Test
	public void test_Environment_constructorWithInvalidParameter() {
		Environment en = new Environment(-20,40);
		assertEquals("created custom environment", 14, en.height());
		assertEquals("created custom environment", 39, en.length());
	}
	
	@Test
	public void test_Environment_setContent() {
		Environment en = new Environment();
		en.setContent(4, 4, 6); 
		assertEquals("Testing content in row 4, column 4", "6", en.getContent(4,4));
	}
	
	@Test
	public void test_DestroyableE_constructor4args() {
		DestroyableElements de = new DestroyableElements(1,2,3,4);
		assertEquals("Testing brick type", 1, de.getBrickType());
		assertEquals("Testing brick length", 2, de.getBrickLength());
		assertEquals("Testing brick row", 3, de.getRowBrick());
		assertEquals("Testing brick column", 4, de.getColumnBrick());
	}
	
	@Test
	public void test_DestroyableE_constructorOutOfBoundRow() {
		try {
			DestroyableElements de = new DestroyableElements(1,2,300,4);
		} catch(IndexOutOfBoundsException e) {}
	}
	
	@Test
	public void test_DestroyableE_constructorNegRow() {
		try {
			DestroyableElements de = new DestroyableElements(1,2,-1,4);
		} catch(IndexOutOfBoundsException e) {}
	}
	
	@Test
	public void test_DestroyableE_constructorOutOfBoundColumn() {
		try {
			DestroyableElements de = new DestroyableElements(1,2,3,400);
		} catch(IndexOutOfBoundsException e) {}
	}
	
	@Test
	public void test_DestroyableE_setType() {
		DestroyableElements de = new DestroyableElements(1,2,3,4);
		de.setBrickType(9);
		assertEquals("Testing setBrickType", 9, de.getBrickType());
	}
	
	@Test 
	public void test_movebar() {
		BarPlayerCharacter bar = new BarPlayerCharacter();
		bar.initiateBar();
		int xco = bar.getXcoord();
		bar.moveLeft();
		assertEquals("Move bar to the left", xco-1, bar.getXcoord());		
	}
	
	@Test
	public void test_barOutOfBounds() {
		BarPlayerCharacter bar = new BarPlayerCharacter();
		bar.initiateBar();
		bar.setXcoord(1);
		try {
		 bar.moveLeft();
		} catch (Exception e) {}			
	}
	
	@Test
	public void test_barOutOfBoundsUp() {
		BarPlayerCharacter bar = new BarPlayerCharacter();
		bar.initiateBar();
		try {
			bar.setYcoord(400);
			bar.moveRight();
		} catch (Exception e) {}	
	}
	
}
