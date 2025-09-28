package com.jobapp.jobapplicatio.reviews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Reviews>> getallreviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewsService.getallreviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Reviews reviews) {
        boolean isReviewSaved = reviewsService.addReview(companyId, reviews);
        if (isReviewSaved) {

            return new ResponseEntity<>("review added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("review not saved", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Reviews> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewsService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
            @RequestBody Reviews reviews) {
        boolean isReviewedUpdated = reviewsService.updateReview(companyId, reviewId, reviews);
        if (isReviewedUpdated) {

            return new ResponseEntity<>("Review Updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("review not updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean isDeleted = reviewsService.deleteReview(companyId, reviewId);
        if (isDeleted) {

            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("review not deleted", HttpStatus.NOT_FOUND);
        }
    }

}
