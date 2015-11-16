
public class ReferenceObject {
	public static int number;
	//public static SimpleObject simpleNumber = new SimpleObject(5);
		
		public ReferenceObject(int fieldNumber) {
			this.number = fieldNumber;
			SimpleObject simpleNumber = new SimpleObject(number);
			System.out.println(simpleNumber);
			//System.out.println(simpleNumber);
		}
	
		public void referenceNumber(int number){
			
			SimpleObject simpleNumber = new SimpleObject(number);
			System.out.println(simpleNumber);
		}


}
