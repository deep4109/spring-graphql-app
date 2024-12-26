package com.example.resolver;

import com.example.entity.Subject;
import com.example.response.StudentResponse;
import com.example.response.SubjectResponse;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentResponseResolver {

    @SchemaMapping(typeName = "StudentResponse", field = "learningSubjects")
    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse) {
        List<SubjectResponse> learningSubjects = null;
        if (studentResponse.getStudent().getLearningSubjects() != null) {
            learningSubjects = new ArrayList<SubjectResponse>();
            for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }
        }
        return learningSubjects;
    }

    @SchemaMapping(typeName = "StudentResponse", field = "fullName")
    public String getFullName(StudentResponse studentResponse) {

        return studentResponse.getFirstName() + " " +studentResponse.getLastName();
    }

}
