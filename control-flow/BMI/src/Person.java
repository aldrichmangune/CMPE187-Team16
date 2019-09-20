
public class Person {
	double weight;
	double height;
	double BMI;
	
	public Person (double weight, double height) {
		this.weight = weight;
		this.height = height;
		if (weight<=0 || height<=0)
			BMI = 0;
		else
			BMI = this.weight/(this.height*this.height);
	}
	
	public String BMICheck(double height , double BMI) {
		if(BMI == 0)
			return "Incorrect input";
		else if(0<BMI && BMI < 18.5)
			return "Underweight";
		else if(18.5<= BMI && BMI <= 24.9) 
			return "Normal";
		else if(25 <= BMI && BMI <= 29.9)
			return "Overweight";
		else
			return "Obese";
	}
	
	public String compareWithMean (double BMI, double mean) {
		if (BMI == 0)
			return "Incorrect input";
		
		if (BMI > mean) 
			return "above";
		else 
			return "below";
	}
}
