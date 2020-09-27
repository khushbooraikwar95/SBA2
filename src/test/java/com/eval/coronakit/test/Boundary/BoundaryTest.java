package com.eval.coronakit.test.Boundary;

import java.io.IOException;
import java.util.Set;

import static com.eval.coronakit.test.utils.TestUtils.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.test.utils.MasterData;

public class BoundaryTest {
	 private Validator validator;
	 
	 @Before
    public void setUp() throws IOException
    {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	 
	@Test
    public void testProductNameBoundary() throws IOException
    {
    	ProductMaster product = MasterData.getProduct();
    	product.setProductName(null);
        Set<ConstraintViolation<ProductMaster>> violations = validator.validate(product);
        
	    yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);

        
    } 
	
	@Test
    public void testProductDescriptionBoundary() throws IOException
    {
    	ProductMaster product = MasterData.getProduct();
    	product.setProductDescription(null);
        Set<ConstraintViolation<ProductMaster>> violations = validator.validate(product);
        
	    yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
       
    } 
	
	@Test
    public void testProductCostBoundary() throws IOException
    {
    	ProductMaster product = MasterData.getProduct();
    	product.setCost(0);
        Set<ConstraintViolation<ProductMaster>> violations = validator.validate(product);
        
	    yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
       
    } 
}
