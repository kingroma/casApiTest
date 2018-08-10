import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		TEST t1 = new TEST();
		TEST t2 = new TEST();
		List<TEST> list = new ArrayList<TEST>();
		list.add(t1);
		list.add(t2);
		JsonUtil<TEST> au = new JsonUtil<TEST>(TEST.class);
		
		t1.setA("A");
		t1.setB("B");
		t2.setA("C");
		t2.setB("D");
		
		
		String json1 = au.objectToJson(t1);
		String jsonList = au.listToJson(list);
		
		System.out.println(au.jsonToObject(json1));
		System.out.println(au.jsonToList(jsonList).get(0).getA());
	}

}
