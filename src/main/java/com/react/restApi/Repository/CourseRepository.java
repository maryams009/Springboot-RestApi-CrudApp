package com.react.restApi.Repository;

import com.react.restApi.entities.Courses;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Courses,Long> {
}
