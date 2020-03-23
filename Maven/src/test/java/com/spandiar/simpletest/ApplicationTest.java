package com.spandiar.simpletest;

import org.junit.Test;
import junit.framework.Assert;

public class ApplicationTest {
@Test
@SuppressWarnings("deprecation")
public void test() {
	Assert.assertEquals("Hello Maven", new String("Hello Maven"));
}

}
