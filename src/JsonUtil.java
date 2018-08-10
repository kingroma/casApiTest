import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JsonUtil<T> {
	private static ObjectMapper om = new ObjectMapper();
	private Class<T> type;
	public JsonUtil() {
		//this.type = type;
	}
	public JsonUtil(Class<T> type) {
		this.type = type;
	}
	
	//List 
	public T jsonToObject(String json) {
		try {
			return om.readValue(json, type);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<T> jsonToList(String json) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			List<T> list = objectMapper.readValue(json, typeFactory.constructCollectionType(List.class, type));
			
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String objectToJson(T obj) {
		try {
			return om.writeValueAsString(obj);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String listToJson(List<T> list) {
		try {
			return om.writeValueAsString(list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
