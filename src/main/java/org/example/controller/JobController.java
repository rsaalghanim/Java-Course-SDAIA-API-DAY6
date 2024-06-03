package org.example.controller;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.dao.JobDAO;
import org.example.models.job;

import java.sql.SQLException;
import java.util.ArrayList;
@Path("/jobs")
public class JobController {





        JobDAO dao = new JobDAO();

        @GET
        public ArrayList<job> getAllJobs() {

            try {
                return dao.selectAllJobs();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @GET
        @Path("{job_id}")
        public job getJob(@PathParam("job_id") int job_id) {

            try {
                return dao.selectJob(job_id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @DELETE
        @Path("{job_id}")
        public void deleteJob(@PathParam("job_id") int job_id) {

            try {
                dao.deleteJob(job_id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @POST
        public void insertJob(job jobs) {

            try {
                dao.insertJob(jobs);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @PUT
        @Path("{job_id}")
        public void updateJob(@PathParam("job_id") int job_id, job jobs) {

            try {
                jobs.setJob_id(job_id);
                dao.updateJob(jobs);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }



}
