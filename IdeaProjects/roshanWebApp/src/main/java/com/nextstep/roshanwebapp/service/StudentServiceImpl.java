package com.nextstep.roshanwebapp.service;

        import com.nextstep.roshanwebapp.model.Student;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;

@Transactional
public class StudentServiceImpl implements  StudentService {
    @Autowired //create obj of session factory
            SessionFactory sessionFactory;
    @Override
    public void saveStudent(Student student) {
        Session session=sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public List<Student> viewStudent() {
        Session session=sessionFactory.getCurrentSession();
        List<Student> studentList=session.createCriteria(Student.class).list();
        return studentList;
    }
}
