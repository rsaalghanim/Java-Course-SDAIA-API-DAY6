package org.example.dao;

import java.sql.*;
import java.util.ArrayList;
import org.example.models.job;


public class JobDAO {

    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\HrApiDay5\\hr.db";
    private static final String SELECT_ALL_JOBS = "select * from jobs";
    private static final String SELECT_ONE_JOB = "select * from jobs where job_id = ?";
    private static final String INSERT_JOB = "insert into jobs values (?, ?, ?)";
    private static final String UPDATE_JOB = "update jobs set job_title = ?, min_salary = ?, max_salary = ? where job_id = ?";
    private static final String DELETE_JOB = "delete from jobs where job_id = ?";

    public void insertJob(job j) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_JOB);
        st.setInt(1, j.getJob_id());
        st.setString(2, j.getJob_title());
        st.setDouble(3, j.getMin_salary());
        st.setDouble(4, j.getMax_salary());

        st.executeUpdate();
    }

    public void updateJob(job j) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_JOB);
        st.setInt(1, j.getJob_id());
        st.setString(2, j.getJob_title());
        st.setDouble(3, j.getMin_salary());
        st.setDouble(4, j.getMax_salary());
        st.executeUpdate();
    }

    public void deleteJob(int job_id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_JOB);
        st.setInt(1, job_id);
        st.executeUpdate();
    }

    public job selectJob(int job_id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_JOB);
        st.setInt(1, job_id);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new job(rs);
        }
        else {
            return null;//
        }
    }

    public ArrayList<job> selectAllJobs() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ALL_JOBS);
        ResultSet rs = st.executeQuery();
        ArrayList<job> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(new job(rs));
        }

        return jobs;
    }

}
