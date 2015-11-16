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
				//System.out.println(simple.squareNumber(fieldNumber));
				Serialization simpleSerial = new Serialization(simple);
				hasInput = true;
			}else if(input.equals("reference")){
				System.out.println("enter an integer to be the instance variable: ");
				int fieldNumber = scanner.nextInt();//set field
				ReferenceObject reference = new ReferenceObject(fieldNumber);
				Serialization referenceSerial = new Serialization(reference);
				hasInput = true;
			}else if(input.equals("arrayPrim")){
				System.out.println("arrayPrim");
				hasInput = true;
			}else if(input.equals("arrayRef")){
				System.out.println("arrayRef");
				hasInput = true;
			}else if(input.equals("instance")){
				System.out.println("instance");
				hasInput = true;
			}else{
				System.out.println("The input you have entered does not exist. Please try again.");
			}
		}
	}
}