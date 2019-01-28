package lombok;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

@Data()
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private String age;
	private String name;
}
