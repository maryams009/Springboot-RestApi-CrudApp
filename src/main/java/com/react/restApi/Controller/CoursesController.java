package com.react.restApi.Controller;

import com.react.restApi.Repository.CourseRepository;
import com.react.restApi.Service.CourseService;
import com.react.restApi.entities.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin // This is for the smooth communication between localhost 8080 and react's url 3000.Otherwise it ll give errors
public class CoursesController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

    // get the courses
    @GetMapping("/courses")
    public List<Courses> AllCourses() {

        return courseService.findAll();
    }

    @GetMapping("/courses/{courseId}")
    public Courses getId(@PathVariable Long courseId) {

        return courseService.findById(courseId);
    }

    @PostMapping("/courses")
    public Courses addCourse(@RequestBody Courses course) {
        return courseService.saveCourses(course);
    }

    @PutMapping("/courses/{courseId}")
    public Courses updateCourses(@PathVariable Long courseId,@RequestBody Courses course) {
        Courses course2=courseRepository.findById(courseId).get();

        course2.setTitle(course.getTitle());
        course2.setDescription(course.getDescription());


return courseService.updateCourse(course2);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourses(@PathVariable Long courseId) {
        try {
            courseService.deleteCourse(courseId);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
