package de.wbbcoder.jsuba.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Includes DB operations
 * 
 * @author Sven Lueckenbach, Mathias Krause
 */
public class DBUtil {

    /**
     * Loads the JDBC-Driver for SQLite and returns a connection to the database
     * 
     * @return a <code>java.sql.Connection</code>
     * @throws ClassNotFoundException
     *             in the case that the driver is not found
     * @throws SQLException
     *             in cases where the DB is offline or not found
     */
    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        return DriverManager.getConnection("jdbc:derby://localhost:1527/jSuBA");
    }

    /**
     * @see #getSQLResult(String tableName, String[] cols, int limit, String
     *      where)
     * @param tableName
     * @return a ResultSet object
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ResultSet getSQLResult(String tableName, String[] cols) throws ClassNotFoundException, SQLException {
        return getSQLResult(tableName, cols, -1, null);
    }

    /**
     * @see #getSQLResult(String tableName, String[] cols, int limit, String
     *      where)
     * @param tableName
     * @param limit
     * @return a ResultSet object
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ResultSet getSQLResult(String tableName, String[] cols, int limit) throws ClassNotFoundException,
            SQLException {
        return getSQLResult(tableName, cols, limit, null);
    }

    /**
     * @see #getSQLResult(String tableName, String[] cols, int limit, String
     *      where)
     * @param tableName
     * @param where
     * @return a ResultSet object
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ResultSet getSQLResult(String tableName, String[] cols, String where) throws ClassNotFoundException,
            SQLException {
        return getSQLResult(tableName, cols, 0, where);
    }

    /**
     * This method returns a ResultSet Object that contains the data produced by
     * the query. The Query will create assistance the parameter. tableName and
     * rows must be defined the other are free to use.
     * 
     * @param tableName
     * @param cols
     * @param limit
     * @param where
     * @return a ResultSet object
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ResultSet getSQLResult(String tableName, String[] cols, int limit, String where)
            throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        StringBuilder sqlQuery = new StringBuilder("SELECT ");

        boolean addComma = false;
        for (String str :
                cols) {
            if (addComma) {
                sqlQuery.append(",");
            } else {
                addComma = true;
            }
            sqlQuery.append(str);
        }

        sqlQuery.append(" FROM " + tableName);

        if (!StringUtil.isEmpty(where)) {
            sqlQuery.append(" WHERE " + where);
        }
        if (limit > 0) {
            sqlQuery.append(" LIMIT " + limit);
        }

        preparedStatement = connection.prepareStatement(sqlQuery.toString());

        resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    /**
     * This method inserts data into a database. It makes use of SQL's INSERT
     * INTO. You can insert multiple rows of data at once by making use of the
     * List<> data. Inside this list you need to create a HashMap where the key
     * is the columns name.
     * 
     * <pre>
     * <code>
     * 	List&lt;HashMap&lt;String, Object&gt;&gt; data = new ArrayList&lt;HashMap&lt;String, Object&gt;&gt;();
     * 	String tableName = &quot;abteilungen&quot;;
     * 
     * 	HashMap&lt;String, Object&gt; testData = new HashMap&lt;String, Object&gt;();
     * 	testData.put(&quot;abteilungsleiter&quot;, 1);
     * 	testData.put(&quot;name&quot;, &quot;Logistik&quot;);
     * 
     * 	data.add(testData);
     * 
     * 	testData = new HashMap&lt;String, Object&gt;();
     * 	testData.put(&quot;abteilungsleiter&quot;, 2);
     * 	testData.put(&quot;name&quot;, &quot;Finanzen&quot;);
     * 
     * 	data.add(testData);
     * 
     * 	DBUtil.insertData(tableName, data);
     * </code>
     * </pre>
     * 
     * @param tableName
     * @param data
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void insertData(String tableName, List<HashMap<String, Object>> data) throws ClassNotFoundException,
            SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement;

        List<StringBuilder> sqlQueries = new ArrayList<StringBuilder>();
        for (HashMap<String, Object> map :
                data) {
            StringBuilder sqlQuery = new StringBuilder();
            sqlQuery.append("INSERT INTO ");
            sqlQuery.append(tableName);
            sqlQuery.append(" (");

            Set<String> set = map.keySet();

            boolean firstOne = true;
            for (String str :
                    set) {
                if (!firstOne) {
                    sqlQuery.append(",");
                } else {
                    firstOne = false;
                }
                sqlQuery.append(str);
            }

            sqlQuery.append(") VALUES (");

            firstOne = true;
            for (String str :
                    set) {
                if (null != map.get(str)) {
                    if (!firstOne) {
                        sqlQuery.append(",");
                    } else {
                        firstOne = false;
                    }
                    sqlQuery.append(parseToSQL(map.get(str)));
                }
            }

            sqlQuery.append(");");
            sqlQueries.add(sqlQuery);
        }

        for (StringBuilder sb :
                sqlQueries) {
            preparedStatement = connection.prepareStatement(sb.toString());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * This method updates data in a database. It makes use of SQL's UPDATE.
     * 
     * <pre>
     * <code>
     * String tableName = "abteilungen";
     * 
     * HashMap<String, Object> testData = new HashMap<String, Object>();
     * testData.put("abteilungsleiter", 2);
     * testData.put("name", "PR");
     * 
     * DBUtil.updateData(tableName, testData, "id", 1);
     * </code>
     * </pre>
     * 
     * @param tableName
     *            The table you want to update
     * @param data
     *            The data you want to update
     * @param whereCol
     *            The column to compare in the where-clause
     * @param whereHasToBe
     *            The data that has to equal in the where-clause
     * @throws ClassNotFoundException
     * @throws SQLException
     *             If updating failed
     */
    public static void updateData(String tableName, HashMap<String, Object> data, String whereCol, Object whereHasToBe)
            throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement;

        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("UPDATE ");
        sqlQuery.append(tableName);
        sqlQuery.append(" SET ");

        Set<String> set = data.keySet();

        boolean firstOne = true;
        for (String str :
                set) {
            if (null != data.get(str)) {
                if (!firstOne) {
                    sqlQuery.append(",");
                } else {
                    firstOne = false;
                }
                sqlQuery.append(str + " = ");
                sqlQuery.append(parseToSQL(data.get(str)));
            }
        }

        sqlQuery.append(" WHERE ");
        sqlQuery.append(whereCol);
        sqlQuery.append(" = ");
        sqlQuery.append(whereHasToBe);
        sqlQuery.append(";");

        preparedStatement = connection.prepareStatement(sqlQuery.toString());
        preparedStatement.executeUpdate();
    }

    /**
     * Parses a given object into a valid SQL-string. E.g a string is surrounded
     * with 'string'
     * 
     * @param o
     * @return the formatted string
     */
    public static String parseToSQL(Object o) {
        String sqlFormat = null;

        if (String.class.equals(o.getClass())) {
            sqlFormat = "'" + o.toString() + "'";
        } else if (Date.class.equals(o.getClass())) {
            //sqlFormat = DateUtil.parseDate((Date) o, DatabaseConstants.DATE_FORMAT);
        } else {
            sqlFormat = o.toString();
        }

        return sqlFormat;
    }
}
