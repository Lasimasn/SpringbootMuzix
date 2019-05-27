package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Muzix;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.service.MuzixService;
import io.swagger.annotations.Api;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="api/v1")
@Api(value="Music Management System")
public class MuzixController {
    @Autowired
    MuzixService muzixService;

    public MuzixService getMuzixService()
    {
        return muzixService;
    }
    public MuzixController(MuzixService muzixService)
    {
        this.muzixService=muzixService;
    }

    //Using @Value annotations

    @Value("${msg}")
    private String msg;
    @GetMapping("user/msg")
    public String getMsg() {
        return msg;
    }
    @Value("${som.key:1,2,3}")
    private int[] intArr;
    @GetMapping("user/asr")
    public int[] getIntArr() {
        return intArr;
    }



    //End of value annotations
    @PostMapping("user/add")
    public ResponseEntity<?> addMuzix(@RequestBody Muzix muzix) throws TrackAlreadyExistException
    {
        ResponseEntity responseEntity;
        try {
            muzixService.addMuzix(muzix);
            responseEntity = new ResponseEntity("Success", HttpStatus.OK);
        } catch (TrackAlreadyExistException ex)
        {
            //responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
            throw ex;
        }
        return responseEntity;
    }
    //@ApiOperation(value="View a list of music tracks",response=Muzix.class)
    @GetMapping("user/display")
    public ResponseEntity<?> displayAll()
    {
        return new ResponseEntity<List<Muzix>>(muzixService.displayAll(),HttpStatus.OK);
    }
    @PutMapping("user/update")
    public ResponseEntity updateList( @RequestBody Muzix muzix)throws TrackNotFoundException
    {
        try {
            return new ResponseEntity(muzixService.updateList(muzix), HttpStatus.CREATED);
        }
        catch (TrackNotFoundException ex)
        {
            //return new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
            throw ex;
        }
    }
    @DeleteMapping ("user/remove/{trackId}")
    public ResponseEntity<?> remove(@PathVariable int trackId)throws TrackNotFoundException
    {
        try {
            return new ResponseEntity<List<Muzix>>(muzixService.remove(trackId), HttpStatus.ACCEPTED);
        }
        catch(TrackNotFoundException e)
        {
            //return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
            throw e;
        }
    }
//    @RequestMapping(value = "user/search/{name}", method=RequestMethod.GET)
//    @ResponseBody
    @GetMapping("user/search/{trackName}")
    public ResponseEntity<List<Muzix>> searchByName(@PathVariable  String trackName)throws  TrackNotFoundException
    {
        try {
            //List<Muzix> muzixList = muzixService;
            return new ResponseEntity<List<Muzix>>(muzixService.searchByName(trackName), HttpStatus.OK);
        }
        catch (TrackNotFoundException e)
        {
            //return new ResponseEntity (e.getMessage(),HttpStatus.OK);
            throw e;
        }
    }

}
