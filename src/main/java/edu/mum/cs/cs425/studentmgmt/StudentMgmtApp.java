package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentMgmtApp {


    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("StudentMgmtApp");
        EntityManager  entityManager = entityManagerFactory.createEntityManager();
        Transcript transcript = new Transcript( "BS Computer Science");
        Classroom classroom = new Classroom("McLaughlin building", "M105");

        Student student = new Student(
                "000-61-0001",
                "Anna",
                "Lynn",
                "Smith",
                3.45,
                "2019/5/24"
        );

        student.setTranscript(transcript);
        student.setClassroom(classroom);
        saveStudent(entityManager, student);

        entityManager.close();
        entityManagerFactory.close();

    }

    public static void saveStudent(EntityManager entityManager, Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }
}
