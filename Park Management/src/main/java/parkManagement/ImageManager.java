package parkManagement;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.model.DetectLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectLabelsResult;
import com.amazonaws.services.rekognition.model.DetectTextRequest;
import com.amazonaws.services.rekognition.model.DetectTextResult;
import com.amazonaws.services.rekognition.model.Image;

public class ImageManager {
	
	private static float confidence = 80f;
	private AmazonRekognition rekognitionClient;
	private Image image;
	private LabelManager labelManager;
	private TextManager textManager;
	
	public ImageManager(AmazonRekognition rekognitionClient,  Image img){
		this.image = img;
		this.rekognitionClient = rekognitionClient;
	}
	
	/**Creates a LabelManager for the image **/
	public void createLabelManager(){
		DetectLabelsRequest request = new DetectLabelsRequest().withImage(image).withMinConfidence(75F).withMaxLabels(10);
		DetectLabelsResult result = rekognitionClient.detectLabels(request);
		 labelManager = new LabelManager(result.getLabels());
	}
	
	/**Creates a TextManager for the image **/
	public void createTextManager(){
		DetectTextRequest request = new DetectTextRequest().withImage(image);
		DetectTextResult result = rekognitionClient.detectText(request);
		textManager = new TextManager(result.getTextDetections());		
	}
	
	/**Returns a LabelManager for the image **/
	public LabelManager getLabelManager() {
		return labelManager;
	}
	
	/**Returns a TextManager for the image **/
	public TextManager getTextManager() {
		return textManager;
	}

	
}
