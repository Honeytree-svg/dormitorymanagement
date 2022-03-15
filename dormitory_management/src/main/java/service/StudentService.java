package service;

import entity.Student;
import entity.StudentSearch;
import util.ResultUtil;

public interface StudentService {
    ResultUtil getAllStudentList(Integer page, Integer limit, StudentSearch search);

    Student selStudentByStudentname(String username);

    void insertStudent(Student student);

    ResultUtil deleteStudentById(int id);

    Student getStudentById(int id);

    ResultUtil updateStudent(Student student);
}
