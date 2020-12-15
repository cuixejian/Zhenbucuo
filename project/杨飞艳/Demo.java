package aa;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {

	@Test
	public void test1(){
		AssertJUnit.assertEquals(1, 1);
	}
	
	@Test
	public void test2(){
		AssertJUnit.assertEquals(2, 2);
	}
	
	@Test
	public void test3(){
		AssertJUnit.assertEquals(false, true);
	}
	
	@Test
	public void test4(){
		AssertJUnit.assertEquals(1, 2);
	}
	
	@Test
	public void test5(){
		AssertJUnit.assertEquals(2, 3);
	}
	

}
