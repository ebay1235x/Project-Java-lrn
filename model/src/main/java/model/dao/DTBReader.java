package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h1>The DTBReader class.</h1>
 * 
Rayan
Rayan
 *
 */
public class DTBReader extends AbstractDAO {
	private static final String PROCEDURE_CALL = "{CALL findMapByID(?)}";

	/**
	 * 
	 * @param id
	 *            The unique ID for the map
	 * @return map The map for the current level
	 * @throws SQLException
	 *             The SQL exception
	 */
	public static String ReturnMap(int id) throws SQLException {
		// Call stored procedure in SQL
		final CallableStatement callStatement = prepareCall(PROCEDURE_CALL);
		String map = null;
		callStatement.setInt(1, id);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				map = result.getString(1);
			}
			result.close();
		}
		// Return the map
		return map;
	}
}
