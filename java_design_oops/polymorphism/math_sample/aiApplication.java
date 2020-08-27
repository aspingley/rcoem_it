// aiApplication class uses mathLibrary
// example of dynamic polymorphism
public class aiApplication{
		public static void main(String args[]){

				mathLibrary m = null;
				if(args.length < 1) {
						m = new mathLibrary();
				}
				else if(args[0].equals("1")){
						m = new thirdPartyMathLibrary();		
				}
				else{
						m = new mathLibrary();
				}
				
				m.inverseMatrix();
				m.fourierTransform();
				m.getEigenValues();
		}
}