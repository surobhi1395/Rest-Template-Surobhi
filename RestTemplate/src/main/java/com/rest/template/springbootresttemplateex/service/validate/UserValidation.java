package com.rest.template.springbootresttemplateex.service.validate;

import com.rest.template.springbootresttemplateex.exception.JobNotFoundException;
import com.rest.template.springbootresttemplateex.exception.NameNotFoundException;
import com.rest.template.springbootresttemplateex.exception.UserNotFoundException;
import org.springframework.util.StringUtils;

public class UserValidation {

    public boolean validateUserName(String name){
        if(name.equals("morpheus")){
            return true;
        }
       else{
            throw new UserNotFoundException("Not a valid name");
        }
    }

    public boolean validateUserJob(String job){
        if(job.equals("leader")){
            return true;
        }
       else{
            throw new UserNotFoundException("Not a valid job");
        }
    }

}
