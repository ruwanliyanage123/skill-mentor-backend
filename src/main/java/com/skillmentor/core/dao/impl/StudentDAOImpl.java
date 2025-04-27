package com.skillmentor.core.dao.impl;

import com.skillmentor.core.dao.StudentDAO;
import com.skillmentor.core.dto.StudentDTO;
import com.skillmentor.core.util.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    DatabaseConnection databaseConnection;
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            String sql = "INSERT INTO student (first_name, last_name, email, phone_number, address, age) VALUES (?, ?, ?, ?, ?, ?)";
            connection = databaseConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentDTO.getFirstName());
            preparedStatement.setString(2, studentDTO.getLastName());
            preparedStatement.setString(3, studentDTO.getEmail());
            preparedStatement.setString(4, studentDTO.getPhoneNumber());
            preparedStatement.setString(5, studentDTO.getAddress());
            preparedStatement.setInt(6, studentDTO.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null)connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentDTO;
    }

    @Override
    public StudentDTO getStudentById(Integer studentId) {
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentList = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM student";
            connection = databaseConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                StudentDTO studentDTO = new StudentDTO(
                        resultSet.getInt("student_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                        resultSet.getInt("age")
                );
                studentList.add(studentDTO);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                studentList = new ArrayList<>();
            }
        }
        return studentList;
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        try{
            String sql = "UPDATE student SET first_name = ?, last_name = ?, email = ?, phone_number = ?, address = ?, age = ? WHERE student_id = ?";
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentDTO.getFirstName());
            preparedStatement.setString(2, studentDTO.getLastName());
            preparedStatement.setString(3, studentDTO.getEmail());
            preparedStatement.setString(4, studentDTO.getPhoneNumber());
            preparedStatement.setString(5, studentDTO.getAddress());
            preparedStatement.setInt(6, studentDTO.getAge());
            preparedStatement.setInt(7, studentDTO.getStudentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentDTO;
    }

    @Override
    public StudentDTO deleteStudent(Integer studentId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM student WHERE student_id = ?";
            connection = databaseConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return new StudentDTO(studentId, null, null, null, null, null, 0); // Return a DTO with the deleted ID
            } else {
                return null; // No student found with the given ID
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
