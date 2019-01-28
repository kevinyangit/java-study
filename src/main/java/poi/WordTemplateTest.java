package poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import com.deepoove.poi.XWPFTemplate;

public class WordTemplateTest {
	public static void main(String[] args) throws IOException {
		XWPFTemplate template = XWPFTemplate.compile("/Git repository/std/study/src/main/java/info/kevin/study/template.docx").render(new HashMap<String, Object>() {
			{
				put("title", "Poi-tl 模板引擎");
			}
		});
		FileOutputStream out = new FileOutputStream("/Git repository/std/study/src/main/java/info/kevin/study/out_template.docx");
		template.write(out);
		out.flush();
		out.close();
		template.close();
	}

}
