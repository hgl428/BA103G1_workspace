

package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_petView {

	public static String get_aCondition_For_Oracle(String columnName, String value) {

		String aCondition = null;

		if ("speciesNo".equals(columnName))
			aCondition = columnName + "=" + value;   //放Integer
		else if ("petPosition".equals(columnName) || "petAge".equals(columnName) || "petSex".equals(columnName))
			aCondition = columnName + " like '%" + value + "%'";   //放文字查詢
//	

		return aCondition + " ";
	}

	public static String get_WhereCondition(Map<String, String[]> map) {
		Set<String> keys = map.keySet();
		StringBuffer whereCondition = new StringBuffer();
		int count = 0;
		for (String key : keys) {
			String value = map.get(key)[0];
			if (value != null && value.trim().length() != 0	&& !"action".equals(key)) {
				count++;
				String aCondition = get_aCondition_For_Oracle(key, value.trim());

				if (count == 1)
					whereCondition.append(" where " + aCondition);
				else
					whereCondition.append(" and " + aCondition);

				System.out.println("count = " + count);
			}
		}
		
		return whereCondition.toString();
	}

	public static void main(String argv[]) {

		Map<String, String[]> map = new TreeMap<String, String[]>();
	
		map.put("speciesNo", new String[] { "10" });
		map.put("petPosition", new String[] { "桃園市" });
		map.put("petAge", new String[] { "幼" });
		map.put("petSex", new String[] { "公" });
		

		String finalSQL = "select * from PETALLINFORMATION "
				          + jdbcUtil_CompositeQuery_petView.get_WhereCondition(map)
				          + "order by petDate";
		System.out.println("finalSQL = " + finalSQL);

	}
}
