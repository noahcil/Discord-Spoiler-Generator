
public class SpoilerMaker {

	static final String sus = "soos";
	static final int rows = 4;
	static final int numSusPerLine = 5; //good number for windowed discord clients
	static final int popLength = (sus.length()%2 == 0) ? sus.length()/2 : sus.length()/3; //if odd number length of sus, divide by 3, else divide by 2 and set to poplength
	static final int popsPerRow = (sus.length()*numSusPerLine)/popLength;
	
	public static void main(String[] args) {
		String spoiler = "";
		int susCounter = 0;
		
		for (int row = 0; row < rows; row++) {
			for (int pops = 0; pops < popsPerRow; pops++) {
				if (susCounter + popLength <= sus.length()) {
					spoiler += "||" + sus.substring(susCounter, susCounter+popLength) + "||";
					susCounter += popLength;
				}
				else if (susCounter == sus.length()) {
					spoiler += "||" + sus.substring(0, popLength) + "||";
					susCounter = popLength;
				}
				else {
					int susCounterOverflow = (susCounter+popLength)-sus.length();
					spoiler += "||" + sus.substring(susCounter, sus.length()) + sus.substring(0, susCounterOverflow) + "||";
					susCounter = susCounterOverflow;
				}
			}
			
			if (row < rows-1)
				spoiler += "\n";
		}
		
		System.out.print(spoiler);
	}
	
}
