
public class Temperature {

	public double ftemp;
	
	public Temperature(double fahrenheit)
	{
		ftemp = fahrenheit;
	}
	
	public void setFahrenheit(double fahrenheit)
	{
		ftemp = fahrenheit;
	}
	
	public double getFahrenheit()
	{
		return ftemp;
		
	}
	
	public double celsius()
	{
		
		double celsius = (5*(ftemp-32)/9);
		
		return celsius;
		
	}

	
	public double kelvin()
	{
		
		double kelvin = (5*(ftemp-32)/9)+273;
		
		return kelvin;
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
