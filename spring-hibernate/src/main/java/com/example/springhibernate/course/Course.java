package com.example.springhibernate.course;

import com.example.springhibernate.instructor.Instructor;
import com.example.springhibernate.student.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 128, unique = true)
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "course_students",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "students_id"))
    private List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean addReview(Review... auxReviews) {
        if (auxReviews == null)
            return false;
        List<Review> listOfReview = List.of(auxReviews);
        return reviews.addAll(listOfReview);
    }

    public boolean addStudents(Student... auxStudents){
        if (auxStudents == null)
            return false;
        List<Student> listOfStudents = List.of(auxStudents);
        return  students.addAll(listOfStudents);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Review review : reviews) {
            builder.append(review.toString()).append("\n");
        }
        return String.format("Course -> Title: %s\n%s", title, builder);
    }
}