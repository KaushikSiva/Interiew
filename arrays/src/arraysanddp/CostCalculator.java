package arraysanddp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CostCalculator
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));                
        int numTestCases = Integer.parseInt(in.readLine().trim());
                
        for (int i=0; i<numTestCases; i++)
        {            
            int basePrice = Integer.parseInt(in.readLine().trim());
            String addressString = in.readLine();
            Address addr = new Address(addressString);
            
            int taxAmount = TaxCalculator.calculateTax(basePrice, addr.getState());
            int shippingAmount = ShippingCalculator.calculateShipping(addr.getZipCode());
            
            System.out.println (basePrice + taxAmount + shippingAmount);
        }
    }
}

class Address
{    
    public String addressLine;
    String[] split;
    public Address (String addressLine)
    {
        this.addressLine = addressLine;

    	split=addressLine.split(",");
    }
    
    public String getStreetAddress()
    {
        //take everything before the last comma
    	if(split.length == 5)
        return split[0]+","+split[1];
    	else
    	return split[0];
    }
    
    public String getCityName()
    {
        //the city appears before the last comma
        return split[split.length-2];
    }
    
    public String getState()
    {
       
        return split[split.length-1].trim().split(" ")[0];
    }
    
    public int getZipCode()
    {
    	   return Integer.parseInt(split[split.length-1].trim().split(" ")[1]);
    }
}
    
class TaxCalculator
{
    public static int calculateTax(int orderAmount, String state)
    {
        if (state.equalsIgnoreCase("Arizona")||state.equalsIgnoreCase("AZ"))
        {
            return orderAmount / 100 * 5;
        }
        if (state.equalsIgnoreCase("Washington")||state.equalsIgnoreCase("WA"))
        {
            return orderAmount / 100 * 9;
        }
        if (state.equalsIgnoreCase("California")||state.equalsIgnoreCase("CA"))
        {
            return orderAmount / 100 * 6;
        }
        if (state.equalsIgnoreCase("Delaware")||state.equalsIgnoreCase("DE"))
        {
            return 0;
        }
        return orderAmount / 100 * 7;            
    }
}

class ShippingCalculator
{
    public static int calculateShipping(int zipCode)
    {
        if (zipCode > 75000)
        {
            return 10;
        }
        else if (zipCode >= 25000)
        {
            return 20;
        }
        else
        {
            return 30;
        }
    }
}