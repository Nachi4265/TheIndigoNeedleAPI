package org.yearup.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.ProfileDao;
import org.yearup.data.UserDao;
import org.yearup.data.mysql.MySqlCategoryDao;
import org.yearup.data.mysql.MySqlProfileDao;
import org.yearup.models.Category;
import org.yearup.models.Product;
import org.yearup.models.Profile;

@RestController
@RequestMapping("profile")
@CrossOrigin
public class ProfileController {


    MySqlProfileDao mySqlProfileDao;

    public ProfileController(MySqlProfileDao mySqlProfileDao) {
        this.mySqlProfileDao = mySqlProfileDao;
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Profile getProfile(@PathVariable int id)
    {

        Profile profile = mySqlProfileDao.getProfile(id);

        if (profile == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return profile;

    }

    @PutMapping
    @PreAuthorize("'ROLE_USER'")
    public Profile createProfile(Profile profile){

        try
        {
            mySqlProfileDao.create(profile);

        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }

        return null;

    }


}
