package kz.aitu.Universityms.Controllers;

import kz.aitu.Universityms.databasecon.*;
import kz.aitu.Universityms.entities.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/courses")
public class CourseController {


    @GetMapping
    public String getAllCourses() {
        return dbcourse.getCourseInfo();
    }


    @PostMapping
    public String addCourse(@RequestBody Course course) {
        dbcourse.addCourse(course.getCourseName(), course.getCourseCode(), course.getCredits());
        return "Course added successfully" + "\n" + dbcourse.getCourseInfo();
    }


    @PutMapping("/{name}")
    public String updateCourse(@PathVariable String name, @RequestBody Course course) {
        dbcourse.updateCourseCredits(name, course.getCredits());
        return "Course " + name + " updated" + "\n" + dbcourse.getCourseInfo();
    }


    @DeleteMapping("/{name}")
    public String deleteCourse(@PathVariable String name) {
        dbcourse.dropCourse(name);
        return "Course " + name + " deleted" + "\n" + dbcourse.getCourseInfo();
    }

    @GetMapping("/search")
    public String getCoursesByCredits(@RequestParam Integer credits) {
        return dbcourse.getCourseByCredits(credits);
    }
}