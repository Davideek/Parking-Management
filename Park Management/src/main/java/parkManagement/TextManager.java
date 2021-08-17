package parkManagement;

import java.util.List;
import com.amazonaws.services.rekognition.model.TextDetection;

public class TextManager {
	
	private List<TextDetection> textDetections;
	
	public TextManager(List<TextDetection> textDetections) {
		this.textDetections = textDetections;
	}
	
	/**Prints detected text **/
	public void printDetectedText() {
		for (TextDetection text : textDetections) {
            System.out.println("Detected: " + text.getDetectedText() );
            System.out.println("Confidence: " + text.getConfidence().toString());
		}
	
	}
}
