public class Ticketing {

    public static void main(String[] args) {
        //Test "on" and "off" points on each boundary for each gender
        int[] ages = {-1, 0, 5, 6, 10, 11, 15, 16};                                 //on and off points on each predicate
        boolean[] boys = {true, true , true, true, true, true, true, true};         //boy inputs
        boolean[] girls = {false, false , false, false, false, false, false, false};//girl inputs

        String[] outputs = {"Invalid age Input", "Invalid age Input",               //expected outputs
        "Rhymes Competition","Rhymes Competition",
        "Rhymes Competition","Rhymes Competition",
        "Storytelling","Drawing Competition",
        "Storytelling","Drawing Competition",
        "Quiz","Essay writing","Quiz","Essay writing",
        "Poetry competition","Poetry competition"};

        int numnerOfTests = 16;                                                     //number of test cases
        TestObject[] tests = new TestObject[numnerOfTests];
        int testCounter = 0;
        int boundaryCount = 0;
        while(testCounter < numnerOfTests){                                         //create test object for each test cases
            tests[testCounter] = new TestObject(ages[boundaryCount], boys[boundaryCount], outputs[testCounter]);
            testCounter++;
            tests[testCounter] = new TestObject(ages[boundaryCount], girls[boundaryCount], outputs[testCounter]);
            testCounter++;
            boundaryCount++;
        }
        testFunction(tests, numnerOfTests);                                         //testing function

        //Invalid user input cases
        //test 17: Invalid age input
        String ageInput = "asd";
        String genderInput = "B";
        String expected = "Age must be an integer";
        String actual = inputHandling(ageInput, genderInput);
        System.out.println("Test: 17\n"
                + "Age: "+ageInput+", genderInput: "+genderInput+"\n"
                + "Expected output: "+expected+"\n"
                + "Actual output: "+actual+"\n"
                + "Test Result: "+checkEqual(actual, expected)+"\n");

        //test 18: Invalid gender input
        ageInput = "12";
        genderInput = "asd";
        expected = "Gender input must be (B) for boy or (G) for girl";
        actual = inputHandling(ageInput, genderInput);
        System.out.println("Test: 18\n"
                + "Age: "+ageInput+", genderInput: "+genderInput+"\n"
                + "Expected output: "+expected+"\n"
                + "Actual output: "+actual+"\n"
                + "Test Result: "+checkEqual(actual, expected));
    }

    public static String inputHandling(String ageInput, String genderInput){
        String result;
        try{
            int age = Integer.parseInt(ageInput);
            boolean isBoy;
            if(genderInput.compareToIgnoreCase("b") == 0){
                isBoy = true;
            }else if(genderInput.compareToIgnoreCase("g") == 0){
                isBoy = false;
            }else {
                return "Gender input must be (B) for boy or (G) for girl";
            }
            result = getTicket(age, isBoy);
        }catch(NumberFormatException ex){
            return "Age must be an integer";
        }
        return result;
    }

    public static String getTicket(int age, boolean isBoy){
        if(age > 15){
             return "Poetry competition";
        }
        if (age > 10 && age <= 15){
            if(isBoy){
                return "Quiz";
            }
            return "Essay writing";
        }
        if (age > 5 && age <= 10){
            if(isBoy){
                return "Storytelling";
            }
            return "Drawing Competition";
        }
        if (age >=0 && age <= 5){
             return "Rhymes Competition";
        }
        return "Invalid age Input";
    }

    //Receive array of test object with inputs and expected outputs
    //Loop through each object and compare acutual output with respective expected output
    public static void testFunction(TestObject[] testCases, int numberOfTests){
        for(int i = 0; i < numberOfTests; i++){
            TestObject testObj = testCases[i];
            int ageInput = testObj.getAge();
            boolean isBoy = testObj.getGender();
            String expected = testObj.getOutput();
            String actual = getTicket(ageInput, isBoy);
            System.out.println("Test: "+(i+1)+"\n"
                    + "Age: "+ageInput+", isBoy: "+isBoy+"\n"
                    + "Expected output: "+expected+"\n"
                    + "Actual output: "+actual+"\n"
                    + "Test Result: "+checkEqual(actual, expected)+"\n");
        }
    }

    public static String checkEqual(String actual, String expected){
        return actual.compareTo(expected) == 0 ? "Passed" : "Failed";
    }

    public static class TestObject{
        private int ageInput;
        private boolean genderInput;
        private String expectedOutut;

        public TestObject(int age, boolean gender, String expected){
            this.ageInput = age;
            this.genderInput = gender;
            this.expectedOutut = expected;
        };

        public int getAge(){
            return this.ageInput;
        }

        public boolean getGender(){
            return this.genderInput;
        }

        public String getOutput(){
            return this.expectedOutut;
        }
    }
}
