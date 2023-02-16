package com.react.restApi.Service;

import com.react.restApi.Repository.CourseRepository;
import com.react.restApi.entities.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Courses> findAll(){
        List<Courses> allCourses= (List<Courses>) courseRepository.findAll();
        return allCourses;

    }

    public Courses findById(Long id){
        return courseRepository.findById(id).get();
    }

    public Courses saveCourses(Courses courses){
        return courseRepository.save(courses);
    }


    public void deleteCourse(Long courseId){
        Courses entity=courseRepository.findById(courseId).get();
        courseRepository.delete(entity);
    }
   public Courses updateCourse(Courses course){
        return courseRepository.save(course);
   }

}
