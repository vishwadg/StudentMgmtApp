package edu.mum.cs.cs425.studentmgmt.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * studentId : long (Primary key)
 * studentNumber : (required) (e.g. Data values: 000-61-0001, 000-61-0002, etc.)
 * firstName : (required) (e.g.  Data values: "Anna", "Bob" etc.)
 * <p>
 * middleName : (is optional) (e.g.  Data values: "Lynn", "" etc.)
 * <p>
 * lastName: (required) (e.g.  Data values: "Smith", "Galverston" etc.)
 * cgpa : (is optional) (e.g. Data values: 3.45, 2.87, etc)
 * dateOfEnrollment (This field contains date values; representing the date of enrollment of the student)
 */

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false, unique = true)
    private String studentNumber;
    @Column(nullable = false)
    private String firstName;

    private String middleName;
    @Column(nullable = false)
    private String lastName;
    private Double cgpa;
    private String dateOFEnrollment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transcriptId")
    private Transcript transcript;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroomId")
    private Classroom classroom;

    public Student(String studentNumber, String firstName, String middleName, String lastName, Double cgpa, String dateOFEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOFEnrollment = dateOFEnrollment;
    }
}
