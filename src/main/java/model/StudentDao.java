package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;


public class StudentDao {

	private JdbcTemplate jdbc;

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public Boolean save(final Student s) {
		String str = "insert into student values(?,?,?,?,?,?,?,?,?,?,?,?)";
		return jdbc.execute(str, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, s.getEnrollment_id());
				ps.setString(2, s.getFirst_name());
				ps.setString(3, s.getLast_name());
				ps.setString(4, s.getGender());
				ps.setString(5, s.getDob());
				ps.setString(6, s.getDoa());
				ps.setString(7, s.getState());
				ps.setString(8, s.getCity());
				ps.setLong(9, s.getMobile());
				ps.setInt(10, s.getSsc_percentage());
				ps.setInt(11, s.getHsc_percentage());
				ps.setString(12, s.getCategory());

				return ps.execute();
			}

		});
	}

	public List display() {
		final List list = new ArrayList();
		String str = "select * from student";
		jdbc.query(str, new ResultSetExtractor<Student>() {

			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next())

				{
					Student obj = new Student();
					obj.setEnrollment_id(rs.getInt(1));
					obj.setFirst_name(rs.getString(2));
					obj.setLast_name(rs.getString(3));
					obj.setGender(rs.getString(4));
					obj.setDob(rs.getString(5));
					obj.setDoa(rs.getString(6));
					obj.setState(rs.getString(7));
					obj.setCity(rs.getString(8));
					obj.setMobile(rs.getLong(9));
					obj.setSsc_percentage(rs.getInt(10));
					obj.setHsc_percentage(rs.getInt(11));
					obj.setCategory(rs.getString(12));
					
					list.add(obj);
				}
				return null;
			}

		});
		return list;
	}

	public int delete(int id) {
		String sql="delete from student where enrollment_id="+id+"";  
	    return jdbc.update(sql);
	}

	public Student getEmpById(int id) {
		String sql="select * from student where enrollment_id=?";  
	    return jdbc.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));
	}
	
	public int update(Student s){  
	    String sql="UPDATE student SET first_name='"+s.getFirst_name()+"',last_name='"+s.getLast_name()+"',gender='"+s.getGender()+"',date_of_birth='"+s.getDob()+"',date_of_admission='"+s.getDoa()+"',state='"+s.getState()+"',city='"+s.getCity()+"',mobile='"+s.getMobile()+"',ssc_percent='"+s.getSsc_percentage()+"',hsc_percent='"+s.getHsc_percentage()+"',category='"+s.getCategory()+"' WHERE enrollment_id='"+s.getEnrollment_id()+"'";  
	    return jdbc.update(sql);  
	}
}
