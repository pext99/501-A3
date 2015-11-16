
public class arrayRef {
	SimpleObject arrayRefObj[] = new SimpleObject[2];
	int firstNumber;
	int secondNumber;
	
	arrayRef(int firstNumber, int secondNumber){
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		
		arrayRefObj[0] = new SimpleObject(firstNumber);
		arrayRefObj[1] = new SimpleObject(secondNumber);
	}
}
