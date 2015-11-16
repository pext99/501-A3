
public class arrayPrim {
	SimpleObject arrayPrimObj[] = new SimpleObject[2];
	int firstNumber;
	int secondNumber;
	
	arrayPrim(int firstNumber, int secondNumber){
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		
		arrayPrimObj[0] = new SimpleObject(firstNumber);
		arrayPrimObj[1] = new SimpleObject(secondNumber);
	}
}
