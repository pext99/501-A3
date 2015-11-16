import java.util.*;

public class ObjectCreation {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		boolean hasInput = false;
		
		while(hasInput != true){
			System.out.println("Please enter 'simple', 'reference', 'arrayPrim', 'arrayRef', 'instance': ");
			String input = scanner.nextLine();
			
			if(input.equals("simple")){
				System.out.println("enter an integer to be the instance variable: ");
				int fieldNumber = scanner.nextInt();//set field
				SimpleObject simple = new SimpleObject(fieldNumber);
				Serialization simpleSerial = new Serialization(simple);
				hasInput = true;
			}else if(input.equals("reference")){
				System.out.println("enter an integer to be the instance variable: ");
				int fieldNumber = scanner.nextInt();//set field
				ReferenceObject reference = new ReferenceObject(fieldNumber);
				Serialization referenceSerial = new Serialization(reference);
				hasInput = true;
			}else if(input.equals("arrayPrim")){
				System.out.println("enter 2 integers: ");
				int fieldNumber1 = scanner.nextInt();//set field
				int fieldNumber2 = scanner.nextInt();//set field
				arrayPrim primitiveArr = new arrayPrim(fieldNumber1, fieldNumber2);
				Serialization arrayPrimitiveSerial = new Serialization(primitiveArr);
				hasInput = true;
			}else if(input.equals("arrayRef")){
				System.out.println("enter 2 integers: ");
				int fieldNumber1 = scanner.nextInt();//set field
				int fieldNumber2 = scanner.nextInt();//set field
				arrayRef referenceArr = new arrayRef(fieldNumber1, fieldNumber2);
				Serialization arrayReferenceSerial = new Serialization(referenceArr);
				hasInput = true;
			}else if(input.equals("instance")){
				System.out.println("enter a word");
				String inputWord = scanner.nextLine();
				Instance instance = new Instance();
				instance.word = inputWord;
				Serialization instanceWord = new Serialization(instance);
				hasInput = true;
			}else{
				System.out.println("The input you have entered does not exist. Please try again.");
			}
		}
	}
}