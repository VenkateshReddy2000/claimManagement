import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.expensemanagement.exceptions.InvalidEmployeeIdException;
import com.expensemanagement.utility.EmployeeUtilities;

class SampleTests {

	@Test
	public void testSomething() {
	
		int a=4;
		int b=8;
		int total = a + b;
		
		assertEquals(12, total);
	}
        @Test	
		public void testEmployeeIdNumberIsConvertedCorrectly() throws InvalidEmployeeIdException {
			EmployeeUtilities employeeUtilities = new EmployeeUtilities();
			int result = employeeUtilities.validateEmployeeId("416");
		
			assertEquals(416, result);
			//fail();
        }
			@Test
			public void testThatExceptionIsThrownIfEmployeeIdIsNotAValidNumber() {
				EmployeeUtilities employeeUtilities = new EmployeeUtilities();
				}
			
				
//				assertThrows(InvalidEmployeeIdException.class, () -> {
//					int result = employeeUtilities.validateEmployeeId("123")
//				});
				//fail();
			}
	


