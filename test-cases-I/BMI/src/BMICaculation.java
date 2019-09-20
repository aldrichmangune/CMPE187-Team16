public class BMICaculation {
	
	// generate person
	public static Person [] personGenerator(String[] weight, String[] height) {
		Person[] people = new Person[9];
		for (int i = 0; i<weight.length; i++) {
			try {
				double newWeight = Double.parseDouble(weight[i]);
				double newHeight = Double.parseDouble(height[i]);
				Person person = new Person (newWeight, newHeight);
				people[i] = person;
			}catch (Exception e) {
				people[i] = null;
			}
						
		}
		return people;
	}
	
	// calculate mean value of BMI
	public static double getMeanBMI (Person[] people) {
		double totalBMI = 0;
		int count = 0;
		for (int i = 0; i<people.length; i++) {
			if (people[i] == null) 
				continue;
			else {
				totalBMI += people[i].BMI;
				count++;
			}
		}
		return totalBMI/count;
	}
	
	// Generate the result of BMI check
	public static String [] BMICheckTest(Person[] people) {
		String [] result = new String [9];
		for (int i=0; i<people.length;i++) {
			if (people[i] == null) {
				result[i] = "Not valid";
			}else
				result[i] = people[i].BMICheck(people[i].height, people[i].BMI);
		}
		return result;
	}
	
	// Generate the result of comparison of individual BMI value and mean BMI value
	public static String[] meanComparisonTest (Person[] people) {
		double meanBMI = getMeanBMI(people);
		String [] result = new String [9];
		for (int i = 0; i<people.length; i++) 
			if (people[i] == null) {
				result[i] = "Not valid";
			}else
				result[i] = people[i].compareWithMean(people[i].BMI, meanBMI);
		return result;
	}
	
	// Check if the test passes or not
	public static String isPassed (String [] result, String[] expected) {
		for (int i=0;i<result.length;i++) {
			if (!result[i].equals(expected[i])) {
				System.out.println(i);
				return "failed";
			}
				
		}
		return "passed";
	}
	
	public static void main(String[] args) {
		
		// test case 1: all the inputs are correct
		String weight[] = {"100.0", "90.1", "72.4", "75.9", "88.5", "92.0", "100.4", "55.1", "68.9"};
		String height[] = {"1.832", "1.801", "1.753", "1.770", "1.799", "1.881", "1.825", "1.703", "1.781"};
		Person people[] = new Person[9];
		String BMICheckResult[] = new String[9];
		String expectedBMICheckResult1[] = new String[] {"Overweight", "Overweight", "Normal", "Normal", "Overweight", "Overweight", "Obese", "Normal", "Normal"};
		String meanResult[] = new String[9];
		String meanExpected1[] = {"above", "above", "below", "below", "above", "above", "above", "below", "below"};
		
		people = personGenerator(weight, height);
		BMICheckResult = BMICheckTest(people);
		meanResult = meanComparisonTest(people);
		
		//System.out.println(meanBMI);
		System.out.println("Test case 1 with correct value as an input");
		System.out.println("BMI check test is " + isPassed(BMICheckResult, expectedBMICheckResult1));
		System.out.println("BMI mean comparison test is " + isPassed(meanResult, meanExpected1) + "\n");
		
		// test case 2: negative number as an input
		height[2] = "-1.753";
		
		// user who puts negative number or zero will see "Incorrect input" message.
		String expectedBMICheckResult2[] = new String[] {"Overweight", "Overweight", "Incorrect input", "Normal", "Overweight", "Overweight", "Obese", "Normal", "Normal"};
		String meanExpected2[] = {"above", "above", "Incorrect input", "above", "above", "above", "above", "below", "below"};
		
		people = personGenerator(weight, height);
		BMICheckResult = BMICheckTest(people);
		meanResult = meanComparisonTest(people);
		System.out.println("Test case 2 with negative value as an input");
		System.out.println("BMI check test is " + isPassed(BMICheckResult, expectedBMICheckResult2));
		System.out.println("BMI mean comparison test is " + isPassed(meanResult, meanExpected2) + "\n");
		
		// test case 3: zero as an input
		weight[3] = "0";
		height[2] = "1.753";
		String expectedBMICheckResult3[] = new String[] {"Overweight", "Overweight", "Normal", "Incorrect input", "Overweight", "Overweight", "Obese", "Normal", "Normal"};
		String meanExpected3[] = {"above", "above", "above", "Incorrect input", "above", "above", "above", "below", "below"};
		
		people = personGenerator(weight, height);
		BMICheckResult = BMICheckTest(people);
		meanResult = meanComparisonTest(people);
		System.out.println("Test case 3 with zero as an input");
		System.out.println("BMI check test is " + isPassed(BMICheckResult, expectedBMICheckResult3));
		System.out.println("BMI mean comparison test is " + isPassed(meanResult, meanExpected3) + "\n");
		
		// test case 4: string value as an input
		weight[3] = "asdf";
		// should print out "Please put only number"
		String expectedBMICheckResult4[] = new String[] {"Overweight", "Overweight", "Normal", "Not valid", "Overweight", "Overweight", "Obese", "Normal", "Normal"};
		String meanExpected4[] = {"above", "above", "below", "Not valid", "above", "above", "above", "below", "below"};
		System.out.println("Test case 4 with string value as an input");
		people = personGenerator(weight, height);
		BMICheckResult = BMICheckTest(people);
		meanResult = meanComparisonTest(people);
		System.out.println("BMI check test is " + isPassed(BMICheckResult, expectedBMICheckResult4));
		System.out.println("BMI mean comparison test is " + isPassed(meanResult, meanExpected4) + "\n");
		
		
	}
	
}
