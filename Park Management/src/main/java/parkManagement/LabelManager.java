package parkManagement;

import java.util.List;
import com.amazonaws.services.rekognition.model.Label;

public class LabelManager {
	
	private List<Label> labels;
	public LabelManager(List<Label> labels) {
		this.labels = labels;
	}
	
	/**Return label with input name and returns null if no label is found **/
	public Label getLabel(String input) {
		int i = 0;
		int j = 0;
		for (Label label : labels) {
			if(label.getName().toLowerCase().equals(input.toLowerCase())) {
				j = i; 
				return labels.get(j);
			}
			else {
				i++;
			}
		}
		return null; 
	}
	
	/**Prints all labels and confidence **/	
	public void printLabels() {
		for (Label label : labels) {
			System.out.println(label.getName() + " " + label.getConfidence());				 
		}
	}
}
