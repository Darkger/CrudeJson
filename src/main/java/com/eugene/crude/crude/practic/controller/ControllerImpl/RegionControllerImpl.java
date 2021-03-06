package com.eugene.crude.crude.practic.controller.ControllerImpl;


import com.eugene.crude.crude.practic.controller.RegionController;
import com.eugene.crude.crude.practic.model.*;
import com.eugene.crude.crude.practic.repository.RegionRepository;
import com.eugene.crude.crude.practic.repository.repositoryIO.RegionRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class RegionControllerImpl implements RegionController {
    RegionRepository regionPostRepository = new RegionRepositoryImpl();


    public Region save(Region region) throws IOException {

       Region region1= regionPostRepository.save(region);
        if (region == null)
            return null;
        else
            return region1;
    }

    public void deleteById(String str) throws IOException {

        regionPostRepository.deleteById(Long.parseLong(str));
    }

    public Region getElementById(String str) throws IOException {

       Region region = regionPostRepository.getById(Long.parseLong(str));
        if (region == null)
            return null;
        else {
            return region;
        }
    }


    @Override
    public Region update(Region region) throws IOException {

        region = regionPostRepository.update(region);
        if (region != null) {
            return region;
        } else return null;


    }

    public List<Region> getAll() throws IOException {

        List<Region> postList = regionPostRepository.getAll();
        if (postList==null)
            return null;
        else
            return postList;
    }

}
