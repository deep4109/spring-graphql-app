package com.example.query;

import com.example.query.request.SampleRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Controller
@AllArgsConstructor
public class Query  {
    StudentService studentService;

    @QueryMapping
    public String firstQuery() {
        return "First Query";
    }

    @QueryMapping
    public String secondQuery() {
        return "Second Query";
    }


    //query{
    //  fullName(sampleRequest:{
    //    firstName:"John",
    //    lastName:"Singh"
    //  })
    //}
    @QueryMapping
    public String fullName(@Argument("sampleRequest") SampleRequest sampleRequest) {
        return sampleRequest.getFirstName() + " " + sampleRequest.getLastName();
    }

    //query{
    //
    //student(id :1){
    //  id
    //  firstName
    //  lastName
    //  email
    //  street
    //  city
    //  learningSubjects{
    //    subjectName
    //    marksObtained
    //
    //  }
    //}
    //
    //} ctrl+shift+enter --> to list all field in altair graphql
    @QueryMapping
    public StudentResponse student(@Argument("id") long id) {
        return new StudentResponse(studentService.getStudent(id));
    }
}
