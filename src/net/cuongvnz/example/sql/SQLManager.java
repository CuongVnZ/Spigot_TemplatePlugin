package net.cuongvnz.example.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.cuongvnz.example.AbstractManager;
import net.cuongvnz.example.ExamplePlugin;

public class SQLManager extends AbstractManager {

    private static int count1 = (int) (Math.random() * 10);
    private static int count2 = (int) (Math.random() * 10);

    public static ConnectionPoolManager manager;

    public SQLManager(ExamplePlugin plugin) {
        super(plugin);
    }

    @Override
    public void initialize() {
        if (!ExamplePlugin.MYSQL_ENABLE)
            manager = new ConnectionPoolManager();
    }

    public static void close(AutoCloseable... toClose) {
        if (manager != null)
            manager.close(toClose);
    }

    public static void disconnect() {
        if (manager != null)
            manager.disconnect();
    }

    /**
     * Returns a prepared statement. Values must be manually set after retrieved from this method.
     * @return an array of [PreparedStatement, Connection], which MUST be closed at some point
     */
    public static AutoCloseable[] prepare(String statement) {
        try {
            Connection conn = manager.getConnection();
            PreparedStatement ps = conn.prepareStatement(statement);
            return new AutoCloseable[] { ps, conn };
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Execute any SQL query and cleans up the connection afterwards.
     * @param ac - an array of [PreparedStatement, Connection]
     * @return true if statement was successfully run, false if an error occurred
     */
    public static boolean execute(AutoCloseable[] ac) {
        if (ac == null || ac.length != 2 || !(ac[0] instanceof PreparedStatement) || !(ac[1] instanceof Connection)) {
            try {
                throw new Exception("Invalid SQL execute() input");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        long start = System.currentTimeMillis();
        try {
            ((PreparedStatement) ac[0]).execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            close(ac);
        }
        if (count1++ % 10 == 0) {
        	int tick = (int) (System.currentTimeMillis() - start);
            System.out.println("Ran statement in " + tick + "ms");
            if(tick > 500) {
            	System.out.println(ac.toString());
            }
        }
        return true;
    }

    /**
     * Execute an SQL query that returns a ResultSet
     * @return array of [ResultSet, PreparedStatement, Connection], which MUST be closed at some point
     */
    public static AutoCloseable[] executeQuery(PreparedStatement statement) {
        long start = System.currentTimeMillis();
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = manager.getConnection();
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count2++ % 10 == 0)
            System.out.println("Ran query in " + (System.currentTimeMillis() - start) + "ms");
        return new AutoCloseable[] { rs, statement, conn };
    }
    
    /**
     * Execute an SQL query that returns a ResultSet
     * @return array of [ResultSet, PreparedStatement, Connection], which MUST be closed at some point
     * Don't show debug
     */
    public static AutoCloseable[] executeQueryWithoutLog(PreparedStatement statement) {
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = manager.getConnection();
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new AutoCloseable[] { rs, statement, conn };
    }

}
