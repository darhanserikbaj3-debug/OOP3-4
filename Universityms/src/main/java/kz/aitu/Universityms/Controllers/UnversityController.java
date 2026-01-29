package kz.aitu.Universityms.Controllers;

import kz.aitu.Universityms.databasecon.*;
import kz.aitu.Universityms.entities.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/universities")
public class UnversityController {


    @GetMapping
    public String getUniInfo() {
        return dbuni.getUniversityInfo();
    }


    @PostMapping
    public String addUni(@RequestBody Univer univer) {
        dbuni.addUni(univer.getName(), univer.getLocation(), univer.getRating());
        return "University added" + "\n" + dbuni.getUniversityInfo();
    }


    @PutMapping("/{name}")
    public String changeRating(@PathVariable String name, @RequestBody Univer univer) {

        dbuni.updateUniRating(name, univer.getRating());
        return name + "rating changed" + dbuni.getUniversityInfo();
    }


    @DeleteMapping("/{name}")
    public String dropUni(@PathVariable String name) {
        dbuni.dropUni(name);
        return "University" + name + "deleted" + dbuni.getUniversityInfo();
    }

    @GetMapping("/search")
    public String getUniByRating(@RequestParam Integer rating) {
        return dbuni.getUniversityByRating(rating);
    }
}