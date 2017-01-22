package util;

import domain.Waffle;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class WafflesResponse {
	
	private List<Waffle> waffles;

	public List<Waffle> getWaffles() {
		return waffles;
	}

	public void setWaffles(List<Waffle> waffles) {
		this.waffles = waffles;
	}

}
