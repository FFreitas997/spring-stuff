package com.example.springhibernate.instructor;

import com.example.springhibernate.course.Course;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "email", length = 45)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    @OneToMany(mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Course> courses = new ArrayList<>();

    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addCourse(Course... courses) {
        if (this.courses == null)
            this.courses = new ArrayList<Course>();
        this.courses.addAll(List.of(courses));
        // BI Directional Link
        Instructor instructor = this;
        List.of(courses).forEach(course -> {
            course.setInstructor(instructor);
        });
    }

    @Override
    public String toString() {
        StringBuilder coursesBuild = new StringBuilder();
        for (Course course : courses) {
            coursesBuild.append(course.toString()).append("\n");
        }
        return String.format("Instructor -> First Name: %s || Last Name: %s || Email: %s\n%s\n%s", firstName,
                lastName, email, instructorDetail.toString(), coursesBuild);
    }
}