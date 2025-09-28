package com.jobapp.jobapplicatio.reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getallreviews(Long companyId);
    boolean addReview(Long companyId, Reviews reviews);
    Reviews getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Reviews reviews);
    boolean deleteReview(Long companyId, Long reviewId);
}
