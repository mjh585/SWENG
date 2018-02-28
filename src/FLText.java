//TODO Implement support for BOLD and ITALIC formatting
//NOTE May have to be achieved via CSS

import javafx.scene.text.*;
import java.awt.Point;
import javafx.scene.paint.*;

public class FLText {

	private Text text;
	private Position position;
	private Colors color;
	private Fonts font;
	private Transitions transition;

	public FLText(String textContent) {
		this.text = new Text(textContent);
	}

	public FLText(String textContent, Position position) {
		this.position = position;
		this.text = new Text(this.position.getPos1().getX(), this.position.getPos1().getY(), textContent);
	}

	public FLText(String textContent, double xPos, double yPos) {
		this.text = new Text(xPos, yPos, textContent);
	}

	public FLText(String textContent, Position pos, Colors color, Fonts font) {
		this.position = pos;
		this.text = new Text(this.position.getPos1().getX(), this.position.getPos1().getY(), textContent);
		this.color = color;
		this.font = font;
		this.propertiesToText();
	}

	public FLText(String textContent, Position pos, Colors color, Fonts font, Transitions transition) {
		this.position = position;
		this.text = new Text(this.position.getPos1().getX(), this.position.getPos1().getY(), textContent);
		this.color = color;
		this.font = font;
		this.transition = transition;
		this.propertiesToText();
	}

	public void propertiesToText() {
		if(this.font != null) {
			this.setFont(this.font.getFontFamily(), this.font.getSize());
			this.text.setUnderline(this.font.getUnderlined());
			if(this.font.getBold() && this.font.getItalic()) { this.text.setStyle("-fx-font-weight: bold; -fx-font-style: italic;"); }
			else if(this.font.getBold()) { this.text.setStyle("-fx-font-weight: bold;"); }
			else if(this.font.getItalic()) { this.text.setStyle("-fx-font-style: italic;"); }
		}
		if(this.color != null) {
			this.setColor(this.color.getColor());
		}
		if(this.position.getWidth() != 0) {
			this.text.setWrappingWidth(this.position.getWidth());
		}
	}

	public Text getText() {
		return this.text;
	}

	public void setFont(String typeface, int size) {
		this.text.setFont(new Font(typeface, size));
	}

	public void setColor(String color) {
		this.text.setFill(Color.valueOf(color));
	}

	public void setColor(Color color) {
		this.text.setFill(color);
	}

}
