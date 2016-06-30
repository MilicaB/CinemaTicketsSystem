package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Hall;

public class HallDAO extends AbstractDAO implements IHallDAO {
	
	private static final String SELECT_HALL_BY_NAME = "SELECT * FROM hall WHERE name = ?";
	private static final String DELETE_HALL_BY_NAME = "DELETE FROM hall WHERE name = ?";
	private static final String ADD_HALL_QUERY = "INSERT INTO hall VALUES (?, ?,?)";

	/* (non-Javadoc)
	 * @see model.IHallDAO#addHall(pojo.Hall)
	 */
	@Override
	public void addHall(Hall hall) throws SQLException {
		if (hall != null) {
			
				PreparedStatement ps = getCon().prepareStatement(ADD_HALL_QUERY);
				ps.setString(1, hall.getName());
				ps.setInt(2, hall.getRows());
				ps.setInt(3, hall.getCols());
				ps.setInt(4, hall.getFreeSeats());
				
				ps.executeUpdate();

		}
		
	}

	/* (non-Javadoc)
	 * @see model.IHallDAO#removeHall(java.lang.String)
	 */
	@Override
	public void removeHall(String hall) throws SQLException  {

			PreparedStatement ps = getCon().prepareStatement(DELETE_HALL_BY_NAME);
			ps.setString(1, hall);
			ps.executeUpdate();
		
	}

	/* (non-Javadoc)
	 * @see model.IHallDAO#getHallByName(java.lang.String)
	 */
	@Override
	public Hall getHallByName(String hall) throws SQLException  {

		
			PreparedStatement ps = getCon().prepareStatement(SELECT_HALL_BY_NAME);
			ps.setString(1, hall);
			ResultSet result = ps.executeQuery();
			result.next();
			String name = result.getString(1);
			int row=result.getInt(2);
			int col=result.getInt(3);

			return new Hall(name,row,col);

}
}
