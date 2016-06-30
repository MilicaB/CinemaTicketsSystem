package model;

import java.sql.SQLException;
import java.util.List;

import pojo.Ticket;

public interface ITicketDAO {

	void addTicket(Ticket ticket) throws SQLException;

	void removeTicket(Ticket t) throws SQLException;

	List<Ticket> getAllTicketsByUser(String userName) throws SQLException;

	List<Ticket> getAllTicketsByMovie(String movieName) throws SQLException;

}