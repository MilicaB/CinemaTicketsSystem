package model;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Ticket;

public class TicketDAO extends AbstractDAO implements ITicketDAO {

	private static final String SELECT_TICKETS_BY_USER = "SELECT * FROM sold_ticket WHERE user_name = ?";
	private static final String SELECT_TICKETS_BY_MOVIE = "SELECT * FROM sold_ticket WHERE show_id = ?";
	private static final String DELETE_HALL_BY_SEAT_AND_MOVIE = "DELETE FROM ticket WHERE row = ? and col = ? and show_id=?";
	private static final String ADD_HALL_QUERY = "INSERT INTO hall VALUES (?, ?,?,?,?)";

	/* (non-Javadoc)
	 * @see model.ITicketDAO#addTicket(pojo.Ticket)
	 */
	@Override
	public void addTicket(Ticket ticket) throws SQLException {

		if (ticket != null) {

			PreparedStatement ps = getCon().prepareStatement(ADD_HALL_QUERY);
			ps.setString(1, ticket.getMovieName());
			ps.setDouble(2, ticket.getPrice());
			ps.setString(3, ticket.getUserName());
			ps.setInt(4, ticket.getRow());
			ps.setInt(5, ticket.getCol());

			ps.executeUpdate();
		}

	}

	/* (non-Javadoc)
	 * @see model.ITicketDAO#removeTicket(pojo.Ticket)
	 */
	@Override
	public void removeTicket(Ticket t) throws SQLException {

		if (t != null) {
			PreparedStatement ps = getCon().prepareStatement(DELETE_HALL_BY_SEAT_AND_MOVIE);
			ps.setInt(1, t.getRow());
			ps.setInt(2, t.getCol());
			ps.setString(3, t.getMovieName());
			ps.executeUpdate();
		}

	}

	/* (non-Javadoc)
	 * @see model.ITicketDAO#getAllTicketsByUser(java.lang.String)
	 */
	@Override
	public List<Ticket> getAllTicketsByUser(String userName) throws SQLException {
		List<Ticket> newsList = new ArrayList<Ticket>();

		if (userName != null) {

			PreparedStatement ps = getCon().prepareStatement(SELECT_TICKETS_BY_USER);
			ps.setString(1, userName);
			ResultSet result = ps.executeQuery();

			while (result.next()) {

				Ticket t = new Ticket(result.getString(1), result.getDouble(2), result.getString(3), result.getInt(4),
						result.getInt(5));
				newsList.add(t);
			}
		}

			return newsList;

		
	}

	/* (non-Javadoc)
	 * @see model.ITicketDAO#getAllTicketsByMovie(java.lang.String)
	 */
	@Override
	public List<Ticket> getAllTicketsByMovie(String movieName) throws SQLException {
		List<Ticket> newsList = new ArrayList<Ticket>();

		if (movieName != null) {

			PreparedStatement ps = getCon().prepareStatement(SELECT_TICKETS_BY_MOVIE);
			ps.setString(1, movieName);
			ResultSet result = ps.executeQuery();

			while (result.next()) {

				Ticket t = new Ticket(result.getString(1), result.getDouble(2), result.getString(3), result.getInt(4),
						result.getInt(5));
				newsList.add(t);
			}
		}

			return newsList;

		}

	}

