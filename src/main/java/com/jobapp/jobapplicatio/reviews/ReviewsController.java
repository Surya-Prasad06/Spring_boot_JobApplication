package com.jobapp.jobapplicatio.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;


}
