package parkManagement;

import java.util.List;
import com.amazonaws.services.rekognition.model.Instance;
import com.amazonaws.services.rekognition.model.Label;

public class InstanceManager {
	
	private boolean empty;
	private List<Instance> instances;
	
	public InstanceManager(Label label) {
		if(label == null) {
			this.empty = true;
		}
		else {
			this.empty = false;
			instances = label.getInstances();
		}	
	}
	
	/**Return amount of instances of the label **/
	public int getInstances() {
		if(empty) {
			return 0;
		}
		else {
			return instances.size();
		}
	}
}
