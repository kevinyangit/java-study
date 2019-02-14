package ioc;

public class HelloWorld {

	  private String text;

	  public void say() {
	    System.out.println(text);
	  }

	  public String getText() {
	    return text;
	  }

	  public void setText(String text) {
	    this.text = text;
	  }
	}