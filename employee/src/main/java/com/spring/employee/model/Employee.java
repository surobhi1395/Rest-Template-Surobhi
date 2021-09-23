
package com.spring.employee.model;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "data",
    "message"
})
@Generated("jsonschema2pojo")
public class Employee {

    @JsonProperty("status")
    public String status;
    @JsonProperty("data")
    public List<Datum> data = null;
    @JsonProperty("message")
    public String message;

}
