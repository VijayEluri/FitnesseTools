package fitnesse.tools;

import static fitnesse.tools.FitnesseUtils.escapeFitnesse;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QueryResultBuilderTest {

	@SuppressWarnings("unchecked")
	@Test
	public void toQuery() {
		QueryResultBuilder qb = new QueryResultBuilder("col1", "col2");
		qb.addRow("v1", "v2");
		qb.addRow("v3", "v4");
		qb.addRow("v5", ">v6<");

		List<List<String>> row = new ArrayList<List<String>>();
		row.add(asList("col1", "v1"));
		row.add(asList("col2", "v2"));
		List<List<String>> row2 = new ArrayList<List<String>>();
		row2.add(asList("col1", "v3"));
		row2.add(asList("col2", "v4"));
		List<List<String>> row3 = new ArrayList<List<String>>();
		row3.add(asList("col1", "v5"));
		row3.add(asList("col2", escapeFitnesse(">v6<")));

		assertEquals(asList(row, row2, row3), qb.toQuery());
	}
}
