package reflect.field;

import lombok.Data;

@Data
public class Son extends Father {
	
	
	public String secondName;
	
	private String dogName;
	
	public void say(String friendName){
		System.out.println("say hello to " +  friendName);
	}

}
