package com.loyola473.project4;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

public abstract class HouseComponent {
	
	private boolean isTerminal;
	
	
	public void build() {
		throw new UnsupportedOperationException();
	}
	
	public void addComponent(HouseComponent component) {
		throw new UnsupportedOperationException();
	}
	
	
	public void getComponent() {
		throw new UnsupportedOperationException();
	}

	public void setTerminal(boolean isTerminal) {
		this.isTerminal = isTerminal;
	}
	
	public boolean isTerminal() {
		return isTerminal;
	}
	
}
