package com.jobapp.jobapplicatio.reviews.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapp.jobapplicatio.company.Company;
import com.jobapp.jobapplicatio.company.CompanyService;
import com.jobapp.jobapplicatio.reviews.Reviews;
import com.jobapp.jobapplicatio.reviews.ReviewsRepository;
import com.jobapp.jobapplicatio.reviews.ReviewsService;

@Service
public class ReviewsServiceImplementation implements ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private CompanyService companyService;

    @Override
    public List<Reviews> getallreviews(Long companyId) {
        List<Reviews> reviews = reviewsRepository.findByCompanyId(companyId);
        return reviews;

    }

    @Override
    public boolean addReview(Long companyId, Reviews reviews) {
        Company company = companyService.getCompanyById(companyId);

        if (company != null) {
            reviews.setCompany(company);
            reviewsRepository.save(reviews);
            return true;
        } else {

            return false;
        }
    }

    @Override
    public Reviews getReview(Long companyId, Long reviewId) {
        List<Reviews> reviews = reviewsRepository.findByCompanyId(companyId);

        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Reviews updatedReviews) {
        if (companyService.getCompanyById(companyId) != null) {
            updatedReviews.setCompany(companyService.getCompanyById(companyId));
            updatedReviews.setId(reviewId);
            reviewsRepository.save(updatedReviews);
            return true;
        } else {
            return false;
        }
    }

    @Override
public boolean deleteReview(Long companyId, Long reviewId) {
    Optional<Company> companyOpt = Optional.ofNullable(companyService.getCompanyById(companyId));
    Optional<Reviews> reviewOpt = reviewsRepository.findById(reviewId);

    if (companyOpt.isPresent() && reviewOpt.isPresent()) {
        Company company = companyOpt.get();
        Reviews review = reviewOpt.get();

        // Ensure that the review belongs to this company
        if (review.getCompany().getId().equals(companyId)) {
            company.getReviews().remove(review);

            // Delete review explicitly (unless orphanRemoval is enabled)
            reviewsRepository.delete(review);

            // Update company (optional if cascade is set properly)
            companyService.updateCompany(company, companyId);

            return true;
        }
    }
    return false;
}


}
