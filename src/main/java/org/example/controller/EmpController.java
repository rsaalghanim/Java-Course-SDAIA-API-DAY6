package org.example.controller;
import jakarta.ws.rs.*;
import org.example.dao.EmployeeDAO;
import org.example.models.Employee;

import java.util.ArrayList;

@Path("/employees")
public class EmpController {





        EmployeeDAO dao = new EmployeeDAO();

        @GET
        public ArrayList<Employee> getAllEmployee() {

            try {
                return dao.selectAllEmps();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @GET
        @Path("{employee_id}")
        public Employee getEmployee(@PathParam("employee_id") int employee_id) {

            try {
                return dao.selectEmp(employee_id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @DELETE
        @Path("{employee_id}")
        public void deleteEmployee(@PathParam("employee_id") int employee_id) {

            try {
                dao.deleteEmp(employee_id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @POST
        public void insertEmployee(Employee emps) {

            try {
                dao.insertEmp(emps);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @PUT
        @Path("{employee_id}")
        public void updateEmployee(@PathParam("employee_id") int employee_id, Employee emps) {

            try {
                emps.setEmployee_id(employee_id);
                dao.updateEmp(emps);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }



}
