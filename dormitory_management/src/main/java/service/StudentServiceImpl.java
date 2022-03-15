package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.StudentDao;
import entity.Student;
import entity.StudentSearch;
import util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
    private StudentDao studentDao;
    @Override
    public ResultUtil getAllStudentList(Integer page, Integer limit, StudentSearch search) {
        PageHelper.startPage(page,limit);
        List<Student> students=studentDao.getAllStudentList(search);
        PageInfo<Student> pageInfo=new PageInfo<>(students);
     //   System.out.println(pageInfo.getList());
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public Student selStudentByStudentname(String username) {
        return studentDao.selStudentByStudentname(username);
    }

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

    @Override
    public ResultUtil deleteStudentById(int id) {
        studentDao.deleteStudentById(id);
        return ResultUtil.ok();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public ResultUtil updateStudent(Student student) {
        studentDao.updateStudent(student);
        return ResultUtil.ok();
    }
}
