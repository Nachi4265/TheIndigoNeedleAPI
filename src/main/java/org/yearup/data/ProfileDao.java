package org.yearup.data;


import org.yearup.models.Profile;

public interface ProfileDao
{
    Profile create(Profile profile);
    Profile getProfile();

    Profile getProfileByID(int id);

    Profile update(Profile profile);



}
